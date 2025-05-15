package com.alon.pruebasGDX.girarrodillos.model;

import com.alon.pruebasGDX.girarrodillos.view.GameRenderer;

public interface GameState {
    void update(float delta);
    void handleInput();
    void render(GameRenderer renderer);
}
