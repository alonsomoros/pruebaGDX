package com.alon.pruebasGDX.screens;

import com.alon.pruebasGDX.assets.Assets;
import com.alon.pruebasGDX.Prueba1;
import com.alon.pruebasGDX.utils.Settings;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.*;
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

        Skin skin = new Skin(Gdx.files.internal("uiskin.json"));

        final Label link = new Label("< Nueva Partida >", skin);
        link.setColor(Color.WHITE);
        link.setFontScale(1.5f);
        link.setPosition(333, 250);

        // Añade un listener que intercambie el color al entrar/salir y gestione el clic
        link.addListener(new ClickListener() {
            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                link.setColor(Color.CYAN);  // color on hover
                Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Hand); // opcional: cursor mano
            }
            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                link.setColor(Color.WHITE); // vuelve al color normal
                Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Arrow); // opcional: cursor flecha
            }
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Assets.playSound(Assets.getSound(Assets.LEVEL_UP_SOUND));
//                Gdx.app.exit();
            }
        });

        stage.addActor(link);
        stage.addActor(mainTable);

//        Button b = new Button(skin);
//        mainTable.add(b).center().width(300).height(100);

        Gdx.input.setInputProcessor(stage);

    }

    public void update () {
        if (Gdx.input.justTouched()) {
//            guiCam.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));

//            if (playBounds.contains(touchPoint.x, touchPoint.y)) {
//                Assets.playSound(Assets.clickSound);
//                game.setScreen(new GameScreen(game));
//                return;
//            }
//            if (highscoresBounds.contains(touchPoint.x, touchPoint.y)) {
//                Assets.playSound(Assets.clickSound);
//                game.setScreen(new HighscoresScreen(game));
//                return;
//            }
//            if (helpBounds.contains(touchPoint.x, touchPoint.y)) {
//                Assets.playSound(Assets.clickSound);
//                game.setScreen(new HelpScreen(game));
//                return;
//            }
//            if (soundBounds.contains(touchPoint.x, touchPoint.y)) {
//                Assets.playSound(Assets.clickSound);
//                Settings.soundEnabled = !Settings.soundEnabled;
//                if (Settings.soundEnabled)
//                    Assets.mainMusic.play();
//                else
//                    Assets.mainMusic.pause();
//            }
        }
    }

    public void draw () {
        GL20 gl = Gdx.gl;
        gl.glClearColor(1, 0, 0, 1);
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        game.batcher.setProjectionMatrix(camera.combined);

        game.batcher.disableBlending();
        game.batcher.begin();
        background = Assets.getTexture(Assets.BACKGROUND);
        game.batcher.draw(background,0,0, game.V_WIDTH, game.V_HEIGHT);
        game.batcher.end();

        game.batcher.enableBlending();
        game.batcher.begin();
        game.batcher.end();

        stage.draw();
        stage.act();
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
