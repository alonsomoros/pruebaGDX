package com.alon.pruebasGDX;

import com.alon.pruebasGDX.assets.Assets;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

public class Fireball {
    private TextureAtlas fireballTextureAtlas;
    private Animation<TextureAtlas.AtlasRegion> fireballAnimation;
    private Sprite fireballSprite;
    private Rectangle fireballHitbox;
    private Sound fireballSound;

    public Fireball(float x, float y) {
        this.fireballTextureAtlas = new TextureAtlas(Gdx.files.internal(Assets.FIREBALL_ATLAS));
        this.fireballAnimation = new Animation<>(0.1f, fireballTextureAtlas.getRegions(), Animation.PlayMode.LOOP);
        fireballSprite = new Sprite(fireballAnimation.getKeyFrame(0));
        fireballSprite.scale(1f);
        this.fireballSprite.setPosition(x,y);
        this.fireballHitbox = new Rectangle();
        this.fireballSound = Assets.getSound(MathUtils.randomBoolean() ? Assets.FIREBALL_SOUND_1 : Assets.FIREBALL_SOUND_2);
        fireballSound.play();
    }

    public Sprite getFireballSprite() {
        return fireballSprite;
    }

    public Rectangle getFireballHitbox() {
        return fireballHitbox;
    }

    public Sound getFireballSound() {
        return fireballSound;
    }
}
