package com.alon.pruebasGDX;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {

    private static final String TITLE = "pruebasGDX";
    private static final String VERSION = "v.0.0.0.0";

    public SpriteBatch batcher;

    @Override
    public void create () {
        batcher = new SpriteBatch();
        Settings.load();
        Assets.load();
        setScreen(new MainMenuScreen(this));
    }

    @Override
    public void resize (int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void render () {
        super.render();
    }

    @Override
    public void pause () {
        super.pause();
    }

    @Override
    public void resume () {
        super.resume();
    }

    @Override
    public void dispose () {
        super.dispose();
    }
}
