package com.alon.pruebasGDX.minigame.proyectiles;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;

public abstract class ProyectilMinigame {
    protected TextureAtlas textureAtlas;
    protected Animation<TextureAtlas.AtlasRegion> animation;
    protected Sprite sprite;
    protected Rectangle hitbox;
    protected Sound sound;
    protected float animationTime = 0f;

    public ProyectilMinigame() {
    }

    public Sprite getProyectilSprite() {
        return sprite;
    }

    public Rectangle getProyectilHitbox() {
        return hitbox;
    }

    public Sound getProyectilSound() {
        return sound;
    }

    public float getAnimationTime() {
        return animationTime;
    }

    public void updateAnimationTime(float deltaTime) {
        animationTime += deltaTime;
    }
}
