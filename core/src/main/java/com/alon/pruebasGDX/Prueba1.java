package com.alon.pruebasGDX;

import com.alon.pruebasGDX.assets.AssetCatalog;
import com.alon.pruebasGDX.assets.Assets;
import com.alon.pruebasGDX.screens.MainMenuScreen;
import com.alon.pruebasGDX.utils.Settings;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class Prueba1 extends Game {

    public static final String TITLE = "pruebasGDX";
    public static final String VERSION = "v.0.0.0.0";

    public final int V_WIDTH = 800;
    public final int V_HEIGHT = 500;

    public static BitmapFont font;

    public SpriteBatch batcher;

    @Override
    public void create() {

        Gdx.graphics.setTitle(TITLE + " " + VERSION);

        // Inicializar componentes básicos
        batcher = new SpriteBatch();

        // Cargar configuraciones
        Settings.load();

        // Iniciar carga de recursos
        Assets.create();

        // Cargar recursos
        Assets.finishLoading();

        if (Assets.isLoaded(AssetCatalog.FUENTE_PIXEL_PNG)) {
            Texture fuentePixel = Assets.get(AssetCatalog.FUENTE_PIXEL_PNG);
            fuentePixel.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        } else {
            Gdx.app.error("Prueba1", "No se pudo cargar el activo: " + AssetCatalog.FUENTE_PIXEL_PNG);
            // Usar una textura alternativa o continuar sin ella
        }
        font = Assets.get(AssetCatalog.FUENTE_PIXEL_TTF);
        font.getData().setScale(1f);

        setScreen(new MainMenuScreen(this));

        // Se puede hacer una pantalla de carga si hay muchos assets de la siguiente manera:
        // if (Assets.assetManager.update()) {
        //     setScreen(new MainMenuScreen(this));
        // }
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void dispose() {
        super.dispose();
        Assets.dispose();
    }
}
