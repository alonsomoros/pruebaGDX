package com.alon.pruebasGDX.screens;

import com.alon.pruebasGDX.assets.AssetCategory;
import com.alon.pruebasGDX.assets.Assets;
import com.alon.pruebasGDX.Prueba1;
import com.alon.pruebasGDX.utils.Settings;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MainMenuScreen extends BaseScreen {

    private Sprite titleSprite;

    public MainMenuScreen(Prueba1 game) {
        super(game);
//        Assets.loadCategory(AssetCategory.MAIN_MENU);
        this.music = Assets.getMusic(Assets.MAIN_MENU_MUSIC_PATH);
    }

    @Override
    protected void buildUI() {
        Table mainTable = new Table();
        mainTable.setFillParent(true);

        createTitle(mainTable);
        createStartWheelsButton(mainTable);
        mainTable.row();
        createStartMiniGameButton(mainTable);

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
        game.batcher.draw(Assets.getTexture(Assets.BACKGROUND_MAIN_MENU_PATH), 0, 0, game.V_WIDTH, game.V_HEIGHT);
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

    // Métodos de Screen

//    @Override
//    public void show() {
//    }

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

    private void createTitle(Table mainTable) {
        Texture title_label = Assets.getTexture(Assets.MAIN_MENU_TITLE_LABEL_PATH);
        titleSprite = new Sprite(title_label);
    }

    private void createStartWheelsButton(Table mainTable) {
        Skin skinButtonLabel = Assets.assetManager.get(Assets.BUTTON_NUEVAPARTIDA_JSON_PATH);
        Button buttonStart = new Button(skinButtonLabel);
        mainTable.add(buttonStart).center().height(70).width(220).padBottom(-10); // Centrar y añadir margen superior

        // Añade un listener que intercambie el color al entrar/salir y gestione el clic
        buttonStart.addListener(new ClickListener() {
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
                Gdx.app.log("Nueva partida", "Click en Nueva partida");
                game.showWheels();
                Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Arrow);
            }
        });
    }

    private void createStartMiniGameButton(Table mainTable) {
        Skin skinButtonLabel = Assets.assetManager.get(Assets.BUTTON_MINIGAME_JSON_PATH);
        Button buttonMinigame = new Button(skinButtonLabel);
        mainTable.add(buttonMinigame).center().height(70).width(290).padBottom(10).padLeft(15); // Centrar y añadir margen superior

        // Añade un listener que intercambie el color al entrar/salir y gestione el clic
        buttonMinigame.addListener(new ClickListener() {
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
                Gdx.app.log("Minigame", "Click en Minigame");
                game.showMinigame();
                Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Arrow);
            }
        });
    }
}
