package com.alon.pruebasGDX.screens;

import com.alon.pruebasGDX.Figura;
import com.alon.pruebasGDX.Fireball;
import com.alon.pruebasGDX.Prueba1;
import com.alon.pruebasGDX.Waterball;
import com.alon.pruebasGDX.assets.Assets;
import com.alon.pruebasGDX.utils.Settings;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class MinigameScreen extends BaseScreen {

    private final Music minigameMusic;

    private Vector2 touchPos = new Vector2();
    private final float VELOCIDAD_MAGO = 400; // píxeles por segundo

    private Array<Fireball> fireballs;
    private Array<Waterball> waterballs;
    private Animation<TextureAtlas.AtlasRegion> fireballAnimation;
    private Animation<TextureAtlas.AtlasRegion> waterballAnimation;
    private Figura magoFigura;

    private int puntuacion;

    public MinigameScreen(Prueba1 game) {
        super(game);
        this.minigameMusic = Assets.assetManager.get(Assets.GAME_MUSIC);
    }

    @Override
    protected void buildUI() {
        fireballAnimation = new Animation<>(0.1f, Assets.assetManager.get(Assets.FIREBALL_ATLAS, TextureAtlas.class).getRegions());
        waterballAnimation = new Animation<>(0.1f, Assets.assetManager.get(Assets.WATERBALL_ATLAS, TextureAtlas.class).getRegions());
        fireballs = new Array<>();
        waterballs = new Array<>();
        this.magoFigura = new Figura();
        InputMultiplexer multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(this);     // Después la pantalla (para teclas)
        Gdx.input.setInputProcessor(multiplexer);
    }

    public void update() {
        float deltaTime = Gdx.graphics.getDeltaTime();

        for (Fireball fireball : fireballs) {
            fireball.updateAnimationTime(deltaTime);
        }

        for (Waterball waterball : waterballs) {
            waterball.updateAnimationTime(deltaTime);
        }

        fireballTimer += deltaTime;
        if (fireballTimer > 1f) {
            fireballTimer = 0;
            createFireballs();
        }

        waterballTimer += deltaTime;
        if (waterballTimer > 1f) {
            waterballTimer = 0;
            createWaterballs();
        }

        if (puntuacion == 5 && magoFigura.getNivel() == 1) {
            this.magoFigura.subirNivel();
        } else if (puntuacion == 10 && magoFigura.getNivel() == 2) {
            this.magoFigura.subirNivel();
        }

        if (puntuacion == 4 && magoFigura.getNivel() == 2) {
            this.magoFigura.bajarNivel();
        } else if (puntuacion == 9 && magoFigura.getNivel() == 3) {
            this.magoFigura.bajarNivel();
        }

        // Movimiento con teclas A y D
        if (Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            magoFigura.getSprite().setX(magoFigura.getSprite().getX() - VELOCIDAD_MAGO * deltaTime);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            magoFigura.getSprite().setX(magoFigura.getSprite().getX() + VELOCIDAD_MAGO * deltaTime);
        }

        if (Gdx.input.isTouched()) { // Detectar si la pantalla ha sido tocada.
            touchPos.set(Gdx.input.getX(), Gdx.input.getY()); // Obtener la posición del toque en la pantalla.
            viewport.unproject(touchPos); // Convertir las coordenadas de la pantalla a coordenadas del mundo.
            magoFigura.getSprite().setCenterX(touchPos.x); // Limita el desplazamiento al eje X del Sprite.
        }

        // Opcional: Limitar el movimiento dentro de la pantalla
        magoFigura.getSprite().setX(Math.max(0, Math.min(magoFigura.getSprite().getX(), game.V_WIDTH - 125)));
    }

    float stateTime = 0f;

    public void draw(float delta) {
        GL20 gl = Gdx.gl;
        gl.glClearColor(0.88235f, 0.91765f, 0.90588f, 1f);
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        game.batcher.setProjectionMatrix(camera.combined);

        game.batcher.disableBlending(); // Quita el canal alfa para dibujar el fondo
        game.batcher.begin();
        game.batcher.draw(Assets.getTexture(Assets.MINIGAME), 0, 0, game.V_WIDTH, game.V_HEIGHT);
        game.batcher.end();

        game.batcher.enableBlending(); // Vuelve a activar el canal alfa para dibujar la animación
        game.batcher.begin();
        stateTime += Gdx.graphics.getDeltaTime();
        for (Fireball fireball : fireballs) {
            drawFireballAnimation(delta, fireball);
        }
        for (Waterball waterball : waterballs) {
            drawWaterballAnimation(delta, waterball);
        }
        game.batcher.draw(magoFigura.getSprite(), magoFigura.getSprite().getX(), 0, 125, 145);
        game.batcher.end();

        stage.act();
        stage.draw();
    }

    @Override
    public void show() {
        minigameMusic.setLooping(true);
        minigameMusic.setVolume(0.05f);
        minigameMusic.play();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update();
        draw(delta);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void pause() {
        Settings.save();
        if (minigameMusic.isPlaying()) {
            minigameMusic.pause();
        }
        Gdx.app.log("Pausa", "Juego pausado");
    }

    @Override
    public void resume() {
        Settings.load();
        if (Settings.soundEnabled) {
            minigameMusic.play();
        }
    }

    @Override
    public void hide() {
        if (minigameMusic.isPlaying()) {
            minigameMusic.stop();
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        minigameMusic.stop();
        minigameMusic.dispose();
        fireballAnimation.getKeyFrame(0).getTexture().dispose();
        waterballAnimation.getKeyFrame(0).getTexture().dispose();
        stage.dispose();
        fireballs.clear();
        waterballs.clear();
    }

    // Métodos de InputProcessor

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.ESCAPE:
                game.setScreen(new MainMenuScreen(game));
                return true;
        }
        return false;
    }

    // Metodos Extra

    // Métodos de animación

    private void createFireballs() {
        float fireballWidth = fireballAnimation.getKeyFrame(0).getRegionWidth();
        Fireball fireball = new Fireball(MathUtils.random(0, game.V_WIDTH - fireballWidth), game.V_HEIGHT);
        fireballs.add(fireball);
    }

    private void createWaterballs() {
        float waterballWidth = waterballAnimation.getKeyFrame(0).getRegionWidth();
        Waterball waterball = new Waterball(MathUtils.random(0, game.V_WIDTH - waterballWidth), game.V_HEIGHT);
        waterballs.add(waterball);
    }


    float fireballTimer = 0;
    private void drawFireballAnimation(float stateTime, Fireball fireball) {
        TextureRegion fireballRegion = fireballAnimation.getKeyFrame(fireball.getAnimationTime(), true); // Pilla el sprite que toque por delta
//        Gdx.app.log("Fireball", "Sprite " + fireballs.indexOf(fireball, true) + ": " + fireballRegion.toString());

        float fireballHeight = fireball.getFireballSprite().getHeight();
        float fireballWidth = fireball.getFireballSprite().getWidth();

        fireball.getFireballSprite().translateY(-200f * stateTime);
        fireball.getFireballHitbox().set(fireball.getFireballSprite().getX(), fireball.getFireballSprite().getY(), fireballWidth, fireballHeight);

        if (fireball.getFireballSprite().getY() < -fireball.getFireballSprite().getHeight()) {
            fireballs.removeValue(fireball, true);
        }

        Rectangle magoHitbox = magoFigura.getSprite().getBoundingRectangle();
        Rectangle fireballHitbox = fireball.getFireballHitbox();
        if (magoHitbox.overlaps(fireballHitbox)) {
            fireballs.removeValue(fireball, true);
            puntuacion--;
            Gdx.app.log("Puntuación", String.valueOf(puntuacion));
        }

        fireball.getFireballSprite().setTexture(fireballAnimation.getKeyFrame(stateTime).getTexture());
        fireball.getFireballSprite().setRegion(fireballRegion);
        fireball.getFireballSprite().draw(game.batcher);
    }

    float waterballTimer = 0;
    private void drawWaterballAnimation(float stateTime, Waterball waterball) {
        TextureRegion waterRegion = waterballAnimation.getKeyFrame(waterball.getAnimationTime(), true); // Pilla el sprite que toque por delta

        float waterballHeigh = waterball.getWaterballSprite().getHeight();
        float waterballWidth = waterball.getWaterballSprite().getWidth();

        waterball.getWaterballSprite().translateY(-200f * stateTime);
        waterball.getWaterballHitbox().set(waterball.getWaterballSprite().getX(), waterball.getWaterballSprite().getY(), waterballWidth, waterballHeigh);

        if (waterball.getWaterballSprite().getY() < -waterball.getWaterballSprite().getHeight()) {
            waterballs.removeValue(waterball, true);
        }

        Rectangle magoHitbox = magoFigura.getSprite().getBoundingRectangle();
        Rectangle waterballHitbox = waterball.getWaterballHitbox();
        if (magoHitbox.overlaps(waterballHitbox)) {
            waterballs.removeValue(waterball, true);
            puntuacion++;
            Gdx.app.log("Puntuación", String.valueOf(puntuacion));
        }

        waterball.getWaterballSprite().setTexture(waterballAnimation.getKeyFrame(stateTime).getTexture());
        waterball.getWaterballSprite().setRegion(waterRegion);
        waterball.getWaterballSprite().draw(game.batcher);
    }
}
