package com.alon.pruebasGDX.minigame.proyectiles;

import com.alon.pruebasGDX.assets.AssetCatalog;
import com.alon.pruebasGDX.assets.Assets;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

public class Fireball extends ProyectilMinigame {

    public Fireball(float x, float y) {
        textureAtlas = Assets.get(AssetCatalog.FIREBALL_ATLAS);
        animation = new Animation<>(0.1f, textureAtlas.getRegions(), Animation.PlayMode.LOOP);
        sprite = new Sprite(animation.getKeyFrame(0));
        sprite.scale(1f);
        sprite.setPosition(x, y);
        hitbox = new Rectangle(x, y, sprite.getWidth(), sprite.getHeight());
        sound = Assets.getSound(MathUtils.randomBoolean() ? Assets.get(AssetCatalog.FIREBALL_SOUND_1) : Assets.get(AssetCatalog.FIREBALL_SOUND_2));
    }
}
