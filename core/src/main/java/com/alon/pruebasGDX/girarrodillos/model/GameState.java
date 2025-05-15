package com.alon.pruebasGDX.girarrodillos.model;

import com.alon.pruebasGDX.girarrodillos.controller.GameController;
import com.alon.pruebasGDX.girarrodillos.input.InputHandler;
import com.alon.pruebasGDX.girarrodillos.view.GameRenderer;

public interface GameState {
    void enter(GameController controller); // Se llama al entrar al estado
    void exit(GameController controller); // Se llama al salir del estado
    void update(float delta, GameController controller);
    void handleInput(InputHandler inputHandler, GameController controller);
    void render(GameRenderer renderer, GameController controller);
}
