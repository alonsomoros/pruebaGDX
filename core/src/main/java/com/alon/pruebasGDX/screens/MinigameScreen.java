package com.alon.pruebasGDX.screens;

import com.alon.pruebasGDX.Prueba1;
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

public class MinigameScreen extends BaseScreen {
    private final Prueba1 game;

    private final Music minigameMusic;

    private float magoX = 0;
    private final float VELOCIDAD_MAGO = 400; // píxeles por segundo

    private Animation<TextureAtlas.AtlasRegion> fireballAnimation;
    private Sprite fireballSprite;

    public MinigameScreen(Prueba1 game) {
        super(game);
        this.game = game;
        this.minigameMusic = Assets.assetManager.get(Assets.GAME_MUSIC);
    }

    @Override
    protected void buildUI() {
        createFireAnimation();
        InputMultiplexer multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(this);     // Después la pantalla (para teclas)
        Gdx.input.setInputProcessor(multiplexer);
    }

    public void update() {
        float deltaTime = Gdx.graphics.getDeltaTime();

        // Movimiento con teclas A y D
        if (Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            magoX -= VELOCIDAD_MAGO * deltaTime;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            magoX += VELOCIDAD_MAGO * deltaTime;
        }

        // Opcional: Limitar el movimiento dentro de la pantalla
        magoX = Math.max(0, Math.min(magoX, game.V_WIDTH - 125));
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
        drawFireballAnimation(stateTime);
        game.batcher.draw(Assets.loadTexture(Assets.FIGURA_MAGO_3), magoX, 0, 125, 145);
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
        fireballSprite.getTexture().dispose();
        stage.dispose();
    }

    // Métodos de InputProcessor

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.ESCAPE:
                game.setScreen(new MainMenuScreen(game));
                return true;
            case Input.Keys.ENTER:
                Gdx.app.log("Enter", "Enter key pressed");
                return true;
        }
        return false;
    }

    // Metodos Extra

    // Métodos de animación

    private void createFireAnimation() {
        TextureAtlas fireballAtlas = new TextureAtlas(Gdx.files.internal(Assets.FIREBALL_ATLAS));

        fireballAnimation = new Animation<TextureAtlas.AtlasRegion>(0.10f, fireballAtlas.findRegions("fireball"));
        fireballAnimation.setPlayMode(Animation.PlayMode.LOOP);

        fireballSprite = new Sprite(fireballAnimation.getKeyFrame(0));
        fireballSprite.scale(1f);
        fireballSprite.setPosition(350, 233);
    }

    private void drawFireballAnimation(float stateTime) {
        TextureRegion fireballRegion = fireballAnimation.getKeyFrame(stateTime, true);
        fireballSprite.setRegion(fireballRegion);
        fireballSprite.draw(game.batcher);
    }
}
