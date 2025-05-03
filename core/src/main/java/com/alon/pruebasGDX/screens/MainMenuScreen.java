package com.alon.pruebasGDX;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MainMenuScreen extends ScreenAdapter {
    Prueba1 game;
    ScreenViewport viewport;
    OrthographicCamera guiCamera;
//    Rectangle soundBounds;
//    Rectangle playBounds;
//    Rectangle highscoresBounds;
//    Rectangle helpBounds;
//    Vector3 touchPoint;

    public MainMenuScreen (Prueba1 game) {
        this.game = game;

        guiCamera = new OrthographicCamera(800, 500);
        viewport = new ScreenViewport(guiCamera);
        guiCamera.position.set((float) 320 / 2, (float) 480 / 2, 0);
//        soundBounds = new Rectangle(0, 0, 64, 64);
//        playBounds = new Rectangle(160 - 150, 200 + 18, 300, 36);
//        highscoresBounds = new Rectangle(160 - 150, 200 - 18, 300, 36);
//        helpBounds = new Rectangle(160 - 150, 200 - 18 - 36, 300, 36);
//        touchPoint = new Vector3();
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
        guiCamera.update();
        game.batcher.setProjectionMatrix(guiCamera.combined);

        game.batcher.disableBlending();
        game.batcher.begin();
        game.batcher.draw(Assets.backgroundTexture, 0, 0, 320, 480);
        game.batcher.end();

        game.batcher.enableBlending();
        game.batcher.begin();
        game.batcher.draw(Assets.logo, 160 - 274 / 2, 480 - 10 - 142, 274, 142);
//        game.batcher.draw(Assets.mainMenu, 10, 200 - 110 / 2, 300, 110);
//        game.batcher.draw(Settings.soundEnabled ? Assets.soundOn : Assets.soundOff, 0, 0, 64, 64);
        game.batcher.end();
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
