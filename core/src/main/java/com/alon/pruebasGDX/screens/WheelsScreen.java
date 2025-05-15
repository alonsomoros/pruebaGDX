package com.alon.pruebasGDX.screens;

import com.alon.pruebasGDX.Prueba1;
import com.alon.pruebasGDX.assets.Assets;
import com.alon.pruebasGDX.girarrodillos.controller.GameController;
import com.alon.pruebasGDX.girarrodillos.controller.commands.Command;
import com.alon.pruebasGDX.girarrodillos.input.InputHandler;
import com.alon.pruebasGDX.girarrodillos.view.GameRenderer;
import com.alon.pruebasGDX.utils.Settings;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;

public class WheelsScreen extends BaseScreen {
    private GameController gameController;
    private GameRenderer gameRenderer;
    private InputHandler inputHandler;

    public WheelsScreen(Prueba1 game) {
        super(game);
        this.music = Assets.assetManager.get(Assets.WHEELS_MUSIC_PATH);

        // Inicializar el controlador y el renderizador
        gameController = new GameController();
        gameRenderer = new GameRenderer(gameController);

        // Inicializar el manejador de entrada
        setupInput();
    }

    private void setupInput() {
        inputHandler = new InputHandler();

        // Configurar comando para girar rodillos
        inputHandler.setCommand(Input.Keys.E, () -> {
            if (gameController.isPlayerTurn() &&
                gameController.getPlayer().getTiradasRestantes() > 0) {
                gameController.processPlayerSpin();
            }
        });

        inputHandler.setCommand(Input.Keys.A, () -> {
            gameController.getPlayerWheelSet().moveWheelIndex(-1);
        });

        inputHandler.setCommand(Input.Keys.D, () -> {
            gameController.getPlayerWheelSet().moveWheelIndex(1);
        });

        // Otros comandos como volver al menú, etc.
        inputHandler.setCommand(Input.Keys.ESCAPE, game::showMainMenu);
    }

    @Override
    protected void buildUI() { // Después la pantalla (para teclas)
    }

    float stateTime = 0f;
    public void draw(float delta) {
        clearScreen();

        game.batcher.disableBlending(); // Quita el canal alfa para dibujar el fondo
        game.batcher.begin();
        game.batcher.end();

        drawBackground();

        stage.act();
        stage.draw();
    }

    public void clearScreen() {
        GL20 gl = Gdx.gl;
        gl.glClearColor(0.2f, 0.05f, 0.0f, 1f);
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        game.batcher.setProjectionMatrix(camera.combined);
    }

    private void drawBackground() {
        game.batcher.enableBlending(); // Vuelve a activar el canal alfa para dibujar la animación
        game.batcher.begin();
        game.batcher.draw(Assets.getInstance().getTexture(Assets.BACKGROUND_WHEELS_PATH), 0, 0, game.V_WIDTH, game.V_HEIGHT);
        game.batcher.end();
    }

//    @Override
//    public void show() {
//    }

    @Override
    public void render(float delta) {
        super.render(delta);
        // Actualizar
        inputHandler.handleInput();
        gameController.update(delta);

        // Renderizar
        gameRenderer.render();
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
        Assets.unloadCategory(this);
    }

    // Métodos de InputProcessor

//    @Override
//    public boolean keyDown(int keycode) {
//        switch (keycode) {
//            case Input.Keys.ESCAPE:
//                game.showMainMenu();
//                return true;
//            case Input.Keys.ENTER:
//                Gdx.app.log("Enter", "Enter key pressed");
//                return true;
//        }
//        return false;
//    }

    // Métodos de animación

}
