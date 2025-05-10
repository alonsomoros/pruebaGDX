package com.alon.pruebasGDX.minigame;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public interface GameElement {
    void update(float deltaTime);
    void render(SpriteBatch batch);
    Rectangle getHitbox();
}
