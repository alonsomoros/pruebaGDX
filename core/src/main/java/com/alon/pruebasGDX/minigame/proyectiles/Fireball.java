package com.alon.pruebasGDX.minigame.proyectiles;

import com.alon.pruebasGDX.assets.Assets;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

public class Fireball extends ProyectilMinigame {

    public Fireball(float x, float y) {
        textureAtlas = Assets.getInstance().getTextureAtlas(Assets.FIREBALL_ATLAS_PATH);
        animation = new Animation<>(0.1f, textureAtlas.getRegions(), Animation.PlayMode.LOOP);
        sprite = new Sprite(animation.getKeyFrame(0));
        sprite.scale(1f);
        sprite.setPosition(x, y);
        hitbox = new Rectangle(x, y, sprite.getWidth(), sprite.getHeight());
        sound = Assets.getInstance().getSound(MathUtils.randomBoolean() ? Assets.FIREBALL_SOUND_1_PATH : Assets.FIREBALL_SOUND_2_PATH);
    }
}
