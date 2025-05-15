package com.alon.pruebasGDX;

import com.alon.pruebasGDX.assets.AssetCategory;
import com.alon.pruebasGDX.assets.Assets;
import com.alon.pruebasGDX.girarrodillos.utils.Constants;
import com.alon.pruebasGDX.screens.MainMenuScreen;
import com.alon.pruebasGDX.screens.MinigameScreen;
import com.alon.pruebasGDX.screens.WheelsScreen;
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
    public static final String VERSION = "v.0.0.9";

    public final int V_WIDTH = Constants.SCREEN_WIDTH;
    public final int V_HEIGHT = Constants.SCREEN_HEIGHT;

    private MainMenuScreen mainMenuScreen;
    private MinigameScreen minigameScreen;
    private WheelsScreen wheelsScreen;

    public SpriteBatch batcher;

    @Override
    public void create() {

        Gdx.graphics.setTitle(TITLE + " " + VERSION);

        // Inicializar componentes básicos
        batcher = new SpriteBatch();

        // Cargar configuraciones
        Settings.load();

        // Iniciar carga de recursos
        Assets.loadCategory(AssetCategory.COMMON);

        // Cargar las pantallas
        minigameScreen = new MinigameScreen(this);
        wheelsScreen = new WheelsScreen(this);
        mainMenuScreen = new MainMenuScreen(this);

        setScreen(this.mainMenuScreen);

        // Se puede hacer una pantalla de carga si hay muchos assets de la siguiente manera:
        // if (Assets.assetManager.update()) {
        //     setScreen(new MainMenuScreen(this));
        // }
    }

    // Métodos para navegar entre pantallas
    public void showMainMenu() {
        setScreen(mainMenuScreen);
    }

    public void showMinigame() {
        setScreen(minigameScreen);
    }

    public void showWheels() {
        setScreen(wheelsScreen);
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
        batcher.dispose();
        mainMenuScreen.dispose();
        wheelsScreen.dispose();
        minigameScreen.dispose();
        Assets.getInstance().dispose();
    }
}
