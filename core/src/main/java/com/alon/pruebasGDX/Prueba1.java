package com.alon.pruebasGDX;

import com.alon.pruebasGDX.assets.Assets;
import com.alon.pruebasGDX.screens.MainMenuScreen;
import com.alon.pruebasGDX.utils.Settings;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Prueba1 extends Game {

    public static final String TITLE = "pruebasGDX";
    public static final String VERSION = "v.0.0.0.0";

    public final int V_WIDTH = 800;
    public final int V_HEIGHT = 500;

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
