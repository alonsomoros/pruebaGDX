package com.alon.pruebasGDX.screens;

import com.alon.pruebasGDX.Figura;
import com.alon.pruebasGDX.proyectiles.Fireball;
import com.alon.pruebasGDX.Prueba1;
import com.alon.pruebasGDX.proyectiles.ProyectilMinigame;
import com.alon.pruebasGDX.proyectiles.Waterball;
import com.alon.pruebasGDX.assets.Assets;
import com.alon.pruebasGDX.utils.Settings;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;

import static com.alon.pruebasGDX.Prueba1.font;

public class MinigameScreen extends BaseScreen {

    private final Music minigameMusic;

    private static final float VELOCIDAD_MAGO = 400; // píxeles por segundo
    private static final float BASE_PROJECTILE_SPEED = 200f;
    private static final float FIREBALL_SPAWN_RATE = 1f;
    private static final float WATERBALL_SPAWN_RATE = 1f;
    private static final int LEVEL_1_THRESHOLD = 10;
    private static final int LEVEL_2_THRESHOLD = 20;

    private Vector2 touchPos = new Vector2();
    private Array<Fireball> fireballs;
    private Array<Waterball> waterballs;
    private Animation<TextureAtlas.AtlasRegion> fireballAnimation;
    private Animation<TextureAtlas.AtlasRegion> waterballAnimation;
    private Figura magoFigura;
    private float dificultad;
    private int puntuacion;
    private float fireballTimer;
    private float waterballTimer;

    public MinigameScreen(Prueba1 game) {
        super(game);
        this.minigameMusic = Assets.assetManager.get(Assets.GAME_MUSIC);
        create();
    }

    public void create() {
        this.fireballs = new Array<>();
        this.waterballs = new Array<>();
        this.fireballAnimation = new Animation<>(0.1f, Assets.assetManager.get(Assets.FIREBALL_ATLAS, TextureAtlas.class).getRegions());
        this.waterballAnimation = new Animation<>(0.1f, Assets.assetManager.get(Assets.WATERBALL_ATLAS, TextureAtlas.class).getRegions());
        this.puntuacion = 0;
        this.dificultad = 0;
        this.fireballTimer = 0;
        this.waterballTimer = 0;
        this.magoFigura = new Figura();
    }

    @Override
    protected void buildUI() {
        Table mainTable = new Table();
        mainTable.setFillParent(true);
        stage.addActor(mainTable);
        InputMultiplexer multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(this);     // Después la pantalla (para teclas)
        multiplexer.addProcessor(stage);    // Primero el stage (para los botones)
        Gdx.input.setInputProcessor(multiplexer);
    }

    public void update() {
        float deltaTime = Gdx.graphics.getDeltaTime();
        updateProjectiles(deltaTime);
        checkNivelFigura();

        // Movimiento con teclas A y D
        if (Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            magoFigura.setPosition(magoFigura.getSprite().getX() - VELOCIDAD_MAGO * deltaTime, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            magoFigura.setPosition(magoFigura.getSprite().getX() + VELOCIDAD_MAGO * deltaTime, 0);
        }

        if (Gdx.input.isTouched()) { // Detectar si la pantalla ha sido tocada.
            touchPos.set(Gdx.input.getX(), Gdx.input.getY()); // Obtener la posición del toque en la pantalla.
            viewport.unproject(touchPos); // Convertir las coordenadas de la pantalla a coordenadas del mundo.
            magoFigura.getSprite().setCenterX(touchPos.x); // Limita el desplazamiento al eje X del Sprite.
        }

        // Opcional: Limitar el movimiento dentro de la pantalla
        magoFigura.setPosition(Math.max(0, Math.min(magoFigura.getSprite().getX(), game.V_WIDTH - 125)), 0);
        magoFigura.actualizarHitbox();
    }

    float stateTime = 0f;

    public void draw(float delta) {
        GL20 gl = Gdx.gl;
        gl.glClearColor(0.88235f, 0.91765f, 0.90588f, 1f);
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        game.batcher.setProjectionMatrix(camera.combined);

        drawBackground();

        game.batcher.enableBlending(); // Vuelve a activar el canal alfa para dibujar la animación
        game.batcher.begin();
        stateTime += Gdx.graphics.getDeltaTime();

        for (Fireball fireball : fireballs) {
            processProjectile(delta, fireball, fireballAnimation);
        }
        for (Waterball waterball : waterballs) {
            processProjectile(delta, waterball, waterballAnimation);
        }
        game.batcher.draw(magoFigura.getSprite(), magoFigura.getSprite().getX(), 0, 125, 145);
        game.batcher.end();

        stage.act();
        stage.draw();
    }

    private void drawBackground() {
        game.batcher.disableBlending();
        game.batcher.begin();
        game.batcher.draw(Assets.getTexture(Assets.MINIGAME), 0, 0, game.V_WIDTH, game.V_HEIGHT);
        game.batcher.draw(Assets.getTexture(Assets.SUELO), 0, 0, game.V_WIDTH,
                Assets.getTexture(Assets.SUELO).getHeight());
        font.draw(game.batcher, "Puntuacion: " + puntuacion, 10, game.V_HEIGHT - 10);
        game.batcher.end();
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

    public void updateProjectiles(float deltaTime) {
        updateFireball(deltaTime);
        updateWaterball(deltaTime);
    }

    public void updateFireball(float deltaTime) {
        for (Fireball fireball : fireballs) {
            fireball.updateAnimationTime(deltaTime);
        }

        fireballTimer += deltaTime * MathUtils.random(0,3f + dificultad);
        if (fireballTimer > FIREBALL_SPAWN_RATE) {
            fireballTimer = 0;
            createFireballs();
        }
    }

    public void updateWaterball(float deltaTime) {
        for (Waterball waterball : waterballs) {
            waterball.updateAnimationTime(deltaTime);
        }

        waterballTimer += deltaTime * MathUtils.random(0,1f);
        if (waterballTimer > WATERBALL_SPAWN_RATE) {
            waterballTimer = 0;
            createWaterballs();
        }
    }

    public void checkNivelFigura() {
        if (puntuacion == LEVEL_1_THRESHOLD && magoFigura.getNivel() == 1) {
            this.magoFigura.subirNivel();
        } else if (puntuacion == LEVEL_2_THRESHOLD && magoFigura.getNivel() == 2) {
            this.magoFigura.subirNivel();
        }

        if (puntuacion == (LEVEL_1_THRESHOLD - 1) && magoFigura.getNivel() == 2) {
            this.magoFigura.bajarNivel();
        } else if (puntuacion == (LEVEL_2_THRESHOLD -1) && magoFigura.getNivel() == 3) {
            this.magoFigura.bajarNivel();
        }
    }

    private void processProjectile(float delta, ProyectilMinigame proyectil, Animation<TextureAtlas.AtlasRegion> animation) {
        TextureRegion region = animation.getKeyFrame(proyectil.getAnimationTime(), true);

        // Actualiza posición
        proyectil.getProyectilSprite().translateY(-BASE_PROJECTILE_SPEED * delta);
        proyectil.getProyectilHitbox().setPosition(
                proyectil.getProyectilSprite().getX(),
                proyectil.getProyectilSprite().getY()
        );

        // Comprueba si está fuera de pantalla
        if (proyectil.getProyectilSprite().getY() < -proyectil.getProyectilSprite().getHeight()) {
            removeProjectile(proyectil);
            return;
        }

        // Comprueba colisión
        if (magoFigura.getHitbox().overlaps(proyectil.getProyectilHitbox())) {
            handleCollision(proyectil);
        }

        // Dibuja
        proyectil.getProyectilSprite().setTexture(region.getTexture());
        proyectil.getProyectilSprite().setRegion(region);
        proyectil.getProyectilSprite().draw(game.batcher);
    }

    private void handleCollision(ProyectilMinigame proyectil) {
        if (proyectil instanceof Fireball) {
            fireballs.removeValue((Fireball)proyectil, true);
            puntuacion--;
            dificultad -= 0.1f;
        } else if (proyectil instanceof Waterball) {
            waterballs.removeValue((Waterball)proyectil, true);
            puntuacion++;
            dificultad += 0.2f;
        }

        proyectil.getProyectilSound().play(0.2f);
        Gdx.app.log("Puntuación", String.valueOf(puntuacion));
    }

    private void removeProjectile(ProyectilMinigame proyectil) {
        if (proyectil instanceof Fireball) {
            fireballs.removeValue((Fireball)proyectil, true);
        } else if (proyectil instanceof Waterball) {
            waterballs.removeValue((Waterball)proyectil, true);
        }
    }
}
