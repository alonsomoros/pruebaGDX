package com.alon.pruebasGDX.screens;

import com.alon.pruebasGDX.assets.Assets;
import com.alon.pruebasGDX.Prueba1;
import com.alon.pruebasGDX.utils.Settings;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
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
        stage.addActor(mainTable);

//        Skin skin = new Skin(Gdx.files.internal("uiskin.json"));
//
//        final Label link = new Label("Haz clic aquí", skin);
//        link.setColor(Color.WHITE);
//        link.setPosition(100, 200);
//
//        // Añade un listener que intercambie el color al entrar/salir y gestione el clic
//        link.addListener(new ClickListener() {
//            @Override
//            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
//                link.setColor(Color.CYAN);  // color on hover
//                Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Hand); // opcional: cursor mano
//            }
//            @Override
//            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
//                link.setColor(Color.WHITE); // vuelve al color normal
//                Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Arrow); // opcional: cursor flecha
//            }
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//                Gdx.app.exit();
//            }
//        });

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
        game.batcher.draw(Assets.backgroundTexture,0,0, game.V_WIDTH, game.V_HEIGHT);
//        game.batcher.draw(Assets.backgroundTexture, (float) game.V_WIDTH /2 - 150, (float) game.V_HEIGHT /2 - 200, 300, 400);
        game.batcher.end();

        game.batcher.enableBlending();
        game.batcher.begin();
//        game.batcher.draw(Assets.logo, 160 - 274 / 2, 480 - 10 - 142, 274, 142);
//        game.batcher.draw(Assets.mainMenu, 10, 200 - 110 / 2, 300, 110);
//        game.batcher.draw(Settings.soundEnabled ? Assets.soundOn : Assets.soundOff, 0, 0, 64, 64);
        game.batcher.end();
    }

    @Override
    public void show() {
        Assets.mainMusic.setLooping(true);
        Assets.mainMusic.setVolume(0.05f);
        Assets.mainMusic.play();
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
