package com.alon.pruebasGDX.screens;

import com.alon.pruebasGDX.Prueba1;
import com.alon.pruebasGDX.assets.Assets;
import com.alon.pruebasGDX.utils.Settings;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public abstract class BaseScreen implements Screen, InputProcessor {
    protected final Prueba1 game;

    protected OrthographicCamera camera;
    protected Viewport viewport;
    protected Table table;
    protected Stage stage;
    protected Music music;

    public BaseScreen(Prueba1 game) {
        this.game = game;

        // Cámara ortográfica para mundo 2D
        camera = new OrthographicCamera();

        // FitViewport mantiene relación de aspecto
        viewport = new FitViewport(game.V_WIDTH, game.V_HEIGHT, camera);

        // Inicializa la tabla para organizar los elementos de la UI
        table = new Table();

        // Ajusta la cámara a la vista
        stage = new Stage(viewport, game.batcher);
        Assets.pruebaLoadCategory(this);

        buildUI();
    }

    /** Construye la UI o sprites, botones, etc. */
    protected abstract void buildUI();


    // Métodos de Screen

    @Override
    public void show() {
        music.setLooping(true);
        music.setVolume(0.05f);
        music.play();

        InputMultiplexer multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(stage);
        multiplexer.addProcessor(this);
        Gdx.input.setInputProcessor(multiplexer);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(0,0,0,0);

        viewport.apply();

        camera.update();

        stage.act(delta);
        stage.draw();
    }

    @Override public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override public void pause() { }

    @Override public void resume() {
        Settings.load();
        if (Settings.soundEnabled) {
            music.play();
        }
    }

    @Override public void hide() {
        if (Gdx.input.getInputProcessor() == stage) {
            Gdx.input.setInputProcessor(null);
        }
        if (music.isPlaying()) {
            music.stop();
        }
    }

    @Override public void dispose() {
        music.stop();
        music.dispose();
    }

//    // Métodos de InputProcessor

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
