package com.alon.pruebasGDX.screens;

import com.alon.pruebasGDX.assets.Assets;
import com.alon.pruebasGDX.Prueba1;
import com.alon.pruebasGDX.utils.Settings;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MainMenuScreen extends BaseScreen {
    private final Prueba1 game;

    private Music music;
    private Sprite titleSprite;
    private Animation<TextureAtlas.AtlasRegion> fireballAnimation;
    private Sprite fireballSprite;

    public MainMenuScreen(Prueba1 game) {
        super(game);
        this.game = game;
        this.music = Assets.assetManager.get(Assets.MUSIC);
    }

    @Override
    protected void buildUI() {
        Table mainTable = new Table();
        mainTable.setFillParent(true);

        createTitle(mainTable);
        createFireAnimation();
        createStartButton(mainTable);

        stage.addActor(mainTable);

        Gdx.input.setInputProcessor(stage);
    }

    public void update() {

    }

    float stateTime = 0f;

    public void draw() {
        GL20 gl = Gdx.gl;
        gl.glClearColor(0, 0, 0, 1);
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        game.batcher.setProjectionMatrix(camera.combined);

        game.batcher.disableBlending(); // Quita el canal alfa para dibujar el fondo
        game.batcher.begin();
        game.batcher.draw(Assets.getTexture(Assets.BACKGROUND), 0, 0, game.V_WIDTH, game.V_HEIGHT);
        game.batcher.end();

        game.batcher.enableBlending(); // Vuelve a activar el canal alfa para dibujar la animación
        game.batcher.begin();
        game.batcher.draw(titleSprite, 250, 369, 300, 80);
        stateTime += Gdx.graphics.getDeltaTime();
//        drawFireballAnimation(stateTime);
        game.batcher.end();

        stage.act();
        stage.draw();
    }

    @Override
    public void show() {
        music = Assets.getMusic(Assets.MUSIC);
        music.setLooping(true);
        music.setVolume(0.05f);
        music.play();
    }

    @Override
    public void render(float delta) {
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
        music = Assets.getMusic(Assets.MUSIC);
        if (music.isPlaying()) {
            music.pause();
        }
        Gdx.app.log("Pausa", "Juego pausado");
    }

    @Override
    public void resume() {
        Settings.load();
        music = Assets.getMusic(Assets.MUSIC);
        if (Settings.soundEnabled) {
            music.play();
        }
    }

    @Override
    public void hide() {
        music = Assets.getMusic(Assets.MUSIC);
        if (music.isPlaying()) {
            music.stop();
        }
    }

    @Override
    public void dispose() {
        stage.dispose();
        fireballAnimation.getKeyFrame(0).getTexture().dispose();
        fireballSprite.getTexture().dispose();
        titleSprite.getTexture().dispose();
    }


    private void createTitle(Table mainTable) {
        Assets.assetManager.get(Assets.LOGO);
        Texture title_label = Assets.getTexture(Assets.TITLE_LABEL);
        titleSprite = new Sprite(title_label);
    }

    private void createStartButton(Table mainTable) {
        Skin skinButtonLabel = Assets.assetManager.get(Assets.BUTTON_LABEL_JSON);
        Button buttonStart = new Button(skinButtonLabel);
        mainTable.add(buttonStart).center().padBottom(100).height(40).width(220); // Centrar y añadir margen superior

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
                Sound level_up_sound = Assets.assetManager.get(Assets.LEVEL_UP_SOUND);
                Assets.playSound(level_up_sound);
                Gdx.app.log("Nueva partida", "Click en Nueva partida");
            }
        });
    }

    private void createFireAnimation() {
        TextureAtlas fireballAtlas = new TextureAtlas(Gdx.files.internal(Assets.FIREBALL_ATLAS));

        fireballAnimation = new Animation<>(0.10f, fireballAtlas.findRegions("fireball"));
        fireballAnimation.setPlayMode(Animation.PlayMode.LOOP);

        fireballSprite = new Sprite(fireballAnimation.getKeyFrame(0));
        fireballSprite.scale(1f);
        fireballSprite.setPosition(350, 233);
    }

    private void drawFireballAnimation(float stateTime) {
        TextureRegion fireballRegion = fireballAnimation.getKeyFrame(stateTime, true);
        fireballSprite.setRegion(fireballRegion);
        fireballSprite.draw(game.batcher);
    }
}
