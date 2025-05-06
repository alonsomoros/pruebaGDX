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
    Prueba1 game;
//    Rectangle soundBounds;
//    Rectangle playBounds;
//    Rectangle highscoresBounds;
//    Rectangle helpBounds;
//    Vector3 touchPoint;
    private Texture background;
    private Music music;

    private TextureAtlas fireballAtlas;
    private Animation<TextureAtlas.AtlasRegion> fireballAnimation;
    private Sprite fireballSprite;

    public MainMenuScreen (Prueba1 game) {
        super(game);
        this.game = game;

//        soundBounds = new Rectangle(0, 0, 64, 64);
//        playBounds = new Rectangle(160 - 150, 200 + 18, 300, 36);
//        highscoresBounds = new Rectangle(160 - 150, 200 - 18, 300, 36);
//        helpBounds = new Rectangle(160 - 150, 200 - 18 - 36, 300, 36);
//        touchPoint = new Vector3();
    }

    @Override
    protected void buildUI() {
        Table mainTable = new Table();
        mainTable.setFillParent(true);

        Skin skin = new Skin(Gdx.files.internal("buttons/uiskin_label/uiskin_label.json"));
        createFireAnimation();

        Button buttonStart = new Button(skin);
        buttonStart.setSize(500, 500); // Cambiar tamaño
        mainTable.add(buttonStart).center().padBottom(200).height(40).width(170); // Centrar y añadir margen superior

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

        stage.addActor(mainTable);

        Gdx.input.setInputProcessor(stage);

    }

    private void createFireAnimation() {
        fireballAtlas = new TextureAtlas(Gdx.files.internal("sprites/fireball/fireball.atlas"));
        fireballAnimation = new Animation<TextureAtlas.AtlasRegion>(0.10f, fireballAtlas.findRegions("fireball"));
        fireballAnimation.setPlayMode(Animation.PlayMode.LOOP);

        fireballSprite = new Sprite(fireballAnimation.getKeyFrame(0));
        fireballSprite.scale(1f);
        fireballSprite.setPosition(350, 233);
    }

    public void update () {
        if (Gdx.input.justTouched()) {

        }
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
        background = Assets.getTexture(Assets.BACKGROUND);
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
        music = Assets.getMusic(Assets.MUSIC);
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
    }
}
