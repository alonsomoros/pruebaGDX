package com.alon.pruebasGDX.screens;

import com.alon.pruebasGDX.assets.Assets;
import com.alon.pruebasGDX.Prueba1;
import com.alon.pruebasGDX.utils.Settings;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MainMenuScreen extends BaseScreen {

    private Sprite titleSprite;
    private int contadorBackground = 0;

    public MainMenuScreen(Prueba1 game) {
        super(game);
        this.music = Assets.getMusic(Assets.MAIN_MENU_MUSIC_PATH);
    }

    @Override
    protected void buildUI() {
        Table mainTable = new Table();
        mainTable.setFillParent(true);

        createTitle();

        createButton(mainTable, Assets.assetManager.get(Assets.BUTTON_NUEVAPARTIDA_JSON_PATH, Skin.class), "Wheels");
        createButton(mainTable, Assets.assetManager.get(Assets.BUTTON_REANUDAR_JSON_PATH, Skin.class), "Wheels");
        createButton(mainTable, Assets.assetManager.get(Assets.BUTTON_MINIGAME_JSON_PATH, Skin.class), "Minigame");

        stage.addActor(mainTable);// Después la pantalla (para teclas)
    }

    public void update() {

    }

    float stateTime = 0f;

    public void draw(float delta) {
        GL20 gl = Gdx.gl;
        gl.glClearColor(0, 0, 0, 1);
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        game.batcher.setProjectionMatrix(camera.combined);

        game.batcher.disableBlending(); // Quita el canal alfa para dibujar el fondo
        game.batcher.begin();
        // Dibuja el fondo
        game.batcher.draw(getTextureByContador(contadorBackground), 0, 0, game.V_WIDTH, game.V_HEIGHT);
        game.batcher.end();

        game.batcher.enableBlending(); // Vuelve a activar el canal alfa para dibujar la animación
        game.batcher.begin();
        // Dibuja el titulo
        game.batcher.draw(titleSprite, 250, 369, 300, 80);
        stateTime += Gdx.graphics.getDeltaTime();
        game.batcher.end();

        stage.act();
        stage.draw();
    }

    private Texture getTextureByContador(int contadorBackground) {
        switch (contadorBackground) {
            case 1:
                return Assets.getTexture(Assets.BACKGROUND_ACANTILADO_PNG_PATH);
            case 2:
                return Assets.getTexture(Assets.BACKGROUND_ARBOL_PNG_PATH);
            case 3:
                return Assets.getTexture(Assets.BACKGROUND_CASCADA_PNG_PATH);
            case 4:
                return Assets.getTexture(Assets.BACKGROUND_CUEVA_PNG_PATH);
            case 5:
                return Assets.getTexture(Assets.BACKGROUND_ECLIPSE_PNG_PATH);
            case 6:
                return Assets.getTexture(Assets.BACKGROUND_LUCHA_PNG_PATH);
            case 7:
                return Assets.getTexture(Assets.BACKGROUND_PANTANO_PNG_PATH);
            case 8:
                return Assets.getTexture(Assets.BACKGROUND_RAMA_PNG_PATH);
            case 9:
                return Assets.getTexture(Assets.BACKGROUND_RUINAS_PNG_PATH);
            default:
                Gdx.app.log("Error", "No se ha encontrado el fondo: " + contadorBackground);
                return Assets.getTexture(Assets.BACKGROUND_ARBOL_PNG_PATH);
        }
    }

    // Métodos de Screen

    @Override
    public void show() {
        super.show();
        contadorBackground = MathUtils.random(1,9);
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
        if (music.isPlaying()) {
            music.pause();
        }
        Gdx.app.log("Pausa", "Juego pausado");
    }

    @Override
    public void dispose() {
        super.dispose();
        stage.dispose();
        titleSprite.getTexture().dispose();
        Assets.pruebaUnloadCategory(this);
    }

    // Métodos de InputProcessor

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.ESCAPE:
                Gdx.app.exit();
                return true;
            case Input.Keys.ENTER:
                Gdx.app.log("Enter", "Enter key pressed");
                return true;
        }
        return false;
    }

    // Métodos de creación de UI

    private void createTitle() {
        Texture title_label = Assets.getTexture(Assets.MAIN_MENU_TITLE_LABEL_PATH);
        titleSprite = new Sprite(title_label);
    }

    public void createButton(Table table, Skin skin, String name) {
        Button button = new Button(skin);
        table.padTop(70).add(button).center().row(); // Añade 20px entre botones // Botón más pequeño y centrado // Centrar y añadir margen superior
        table.defaults().spaceTop(30);

        // Añade un listener que intercambie el color al entrar/salir y gestione el clic
        button.addListener(new ClickListener() {
            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Hand); // opcional: cursor mano
            }

            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Arrow); // opcional: cursor flecha
            }

            @Override
            public void clicked(InputEvent event, float x, float y) {
                Sound level_up_sound = Assets.assetManager.get(Assets.BUTTON_EFFECT_PATH);
                Assets.playSound(level_up_sound);
                cambioPantalla(name);
                Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Arrow);
            }
        });
    }

    private void cambioPantalla(String name) {
        switch (name) {
            case "Wheels":
                Gdx.app.log(name, "Click en " + name);
                game.showWheels();
                break;
            case "Minigame":
                Gdx.app.log(name, "Click en " + name);
                game.showMinigame();
                break;
            default:
                Gdx.app.log("Error", "No se ha encontrado el botón: " + name);
        }
    }
}
