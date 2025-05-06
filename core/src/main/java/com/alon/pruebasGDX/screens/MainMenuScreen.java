package com.alon.pruebasGDX.screens;

import com.alon.pruebasGDX.assets.Assets;
import com.alon.pruebasGDX.Prueba1;
import com.alon.pruebasGDX.utils.Settings;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;
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

    private Animation<TextureAtlas.AtlasRegion> fireballAnimation;
    private Sprite fireballSprite;

    public MainMenuScreen (Prueba1 game) {
        super(game);
        this.game = game;
    }

    @Override
    protected void buildUI() {
        Table mainTable = new Table();
        mainTable.setFillParent(true);

        createFireAnimation();
        createStartButton(mainTable);

        stage.addActor(mainTable);

        Gdx.input.setInputProcessor(stage);

    }

    public void update () {

    }

    float stateTime = 0f;
    public void draw () {
        GL20 gl = Gdx.gl;
        gl.glClearColor(0, 0, 0, 1);
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        game.batcher.setProjectionMatrix(camera.combined);

        game.batcher.disableBlending(); // Quita el canal alfa para dibujar el fondo
        game.batcher.begin();
        Texture background = Assets.getTexture(Assets.BACKGROUND);
        game.batcher.draw(background,0,0, game.V_WIDTH, game.V_HEIGHT);
        game.batcher.end();

        game.batcher.enableBlending();
        game.batcher.begin();

        stateTime += Gdx.graphics.getDeltaTime();
        drawFireballAnimation(stateTime);

        game.batcher.end();

        stage.act();
        stage.draw();
    }

    private void drawFireballAnimation(float stateTime){
        TextureRegion fireballRegion = fireballAnimation.getKeyFrame(stateTime, true);
        fireballSprite.setRegion(fireballRegion);
        fireballSprite.draw(game.batcher);
    }

    @Override
    public void show() {
        Music music = Assets.getMusic(Assets.MUSIC);
        music.setLooping(true);
        music.setVolume(0.05f);
        music.play();
    }
    @Override
    public void render (float delta) {
        update();
        draw();
    }

    @Override
    public void pause () {
        Settings.save();
        Music music = Assets.getMusic(Assets.MUSIC);
        if (music.isPlaying()) {
            music.pause();
        }
    }

    @Override
    public void hide () {
        Music music = Assets.getMusic(Assets.MUSIC);
        if (music.isPlaying()) {
            music.stop();
        }
    }

    @Override
    public void dispose () {
        stage.dispose();
        fireballAnimation.getKeyFrame(0).getTexture().dispose();
        fireballSprite.getTexture().dispose();
    }

    private void createStartButton(Table mainTable) {
        Skin skin = new Skin(Gdx.files.internal(Assets.BUTTON_LABEL_JSON));
        Button buttonStart = new Button(skin);
        mainTable.add(buttonStart).center().padBottom(200).height(40).width(220); // Centrar y añadir margen superior

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
                Assets.playSound(Assets.getSound(Assets.LEVEL_UP_SOUND));
                Gdx.app.log("Nueva partida", "Clic en Nueva partida");
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
}
