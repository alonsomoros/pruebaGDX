package com.alon.pruebasGDX.screens;

import com.alon.pruebasGDX.Prueba1;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public abstract class BaseScreen implements Screen, InputProcessor {
    protected final Prueba1 game;

    protected OrthographicCamera camera;
    protected Viewport viewport;
    protected Stage stage;

    public BaseScreen(Prueba1 game) {
        this.game = game;

        // Cámara ortográfica para mundo 2D
        camera = new OrthographicCamera();

        // FitViewport mantiene relación de aspecto
        viewport = new FitViewport(game.V_WIDTH, game.V_HEIGHT, camera);

        // Ajusta la cámara a la vista
        stage = new Stage(viewport, game.batcher);
        Gdx.input.setInputProcessor(stage);

        buildUI();
    }

    /** Construye la UI o sprites, botones, etc. */
    protected abstract void buildUI();


    // Métodos de Screen

    @Override
    public void show() {

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

    @Override public void resume() { }

    @Override public void hide() { }

    @Override public void dispose() {
        stage.dispose();
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
