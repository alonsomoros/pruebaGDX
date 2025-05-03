package com.alon.pruebasGDX.screens;

import com.alon.pruebasGDX.Prueba1;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public abstract class BaseScreen implements Screen {
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
}
