package com.alon.pruebasGDX;

import com.alon.pruebasGDX.assets.Assets;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

public class Waterball {
    private TextureAtlas waterballTextureAtlas;
    private Animation<TextureAtlas.AtlasRegion> waterballAnimation;
    private Sprite waterballSprite;
    private Rectangle waterballHitbox;
    private Sound waterballSound;
    private float animationTime = 0f;

    public Waterball(float x, float y) {
        this.waterballTextureAtlas = new TextureAtlas(Gdx.files.internal(Assets.WATERBALL_ATLAS));
        this.waterballAnimation = new Animation<>(0.1f, waterballTextureAtlas.getRegions(), Animation.PlayMode.LOOP);
        waterballSprite = new Sprite(waterballAnimation.getKeyFrame(0));
        waterballSprite.scale(1f);
        this.waterballSprite.setPosition(x,y);
        this.waterballHitbox = new Rectangle();
        this.waterballSound = Assets.getSound(MathUtils.randomBoolean() ? Assets.WATERBALL_SOUND_1 : Assets.WATERBALL_SOUND_2);
    }

    public Sprite getWaterballSprite() {
        return waterballSprite;
    }

    public void setWaterballSprite(Sprite waterballSprite) {
        this.waterballSprite = waterballSprite;
    }

    public Rectangle getWaterballHitbox() {
        return waterballHitbox;
    }

    public Sound getWaterballSound() {
        return waterballSound;
    }

    public float getAnimationTime() {
        return animationTime;
    }

    public void updateAnimationTime(float deltaTime) {
        animationTime += deltaTime;
    }

}
