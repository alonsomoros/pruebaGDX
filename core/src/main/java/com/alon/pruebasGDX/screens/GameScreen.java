package com.alon.pruebasGDX.screens;

import com.alon.pruebasGDX.Prueba1;
import com.alon.pruebasGDX.assets.Assets;
import com.alon.pruebasGDX.utils.Settings;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;

public class GameScreen extends BaseScreen {
    private final Prueba1 game;

    private Music gameMusic;

    public GameScreen(Prueba1 game) {
        super(game);
        this.game = game;
        this.gameMusic = Assets.assetManager.get(Assets.GAME_MUSIC);
    }

    @Override
    protected void buildUI() {

    }

    public void update() {
        // Si pulso la tecla ESC, vuelvo al menú principal
        if (Gdx.input.isKeyJustPressed(com.badlogic.gdx.Input.Keys.ESCAPE)) {
            game.setScreen(new MainMenuScreen(game));
            dispose();
        }
    }

    float stateTime = 0f;

    public void draw() {
        GL20 gl = Gdx.gl;
        gl.glClearColor(0.15f, 0.05f, 0.05f, 1f);
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        game.batcher.setProjectionMatrix(camera.combined);

        game.batcher.disableBlending(); // Quita el canal alfa para dibujar el fondo
        game.batcher.begin();
        game.batcher.end();

        game.batcher.enableBlending(); // Vuelve a activar el canal alfa para dibujar la animación
        game.batcher.begin();
        // Dibuja el fondo
        game.batcher.draw(Assets.getTexture(Assets.GAME_BOARD), 0, 0, game.V_WIDTH, game.V_HEIGHT);
        game.batcher.end();

        stage.act();
        stage.draw();
    }

    @Override
    public void show() {
        gameMusic.setLooping(true);
        gameMusic.setVolume(0.05f);
        gameMusic.play();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update();
        draw();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void pause() {
        Settings.save();
        if (gameMusic.isPlaying()) {
            gameMusic.pause();
        }
        Gdx.app.log("Pausa", "Juego pausado");
    }

    @Override
    public void resume() {
        Settings.load();
        if (Settings.soundEnabled) {
            gameMusic.play();
        }
    }

    @Override
    public void hide() {
        if (gameMusic.isPlaying()) {
            gameMusic.stop();
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        gameMusic.stop();
        gameMusic.dispose();
        stage.dispose();
    }
}
