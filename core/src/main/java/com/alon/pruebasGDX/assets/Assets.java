package com.alon.pruebasGDX.assets;

import com.alon.pruebasGDX.utils.Settings;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Assets {
    public static Texture logo;

    public static Texture backgroundTexture;
    public static Sprite backgroundSprite;

    public static Texture figureTexture;
    public static Sprite figureSprite;

    public static Music mainMusic;

    public static Sound fireballSound1;
    public static Sound fireballSound2;
    public static Sound levelUpSound;

    public static Texture loadTexture (String file) {
        return new Texture(Gdx.files.internal(file));
    }

    public static void load() {
        logo = new Texture(Gdx.files.internal("background/tienda.png"));

        backgroundTexture = loadTexture("background/tienda.png");
        backgroundSprite = new Sprite(backgroundTexture);

        figureTexture = loadTexture("sprites/mago/mago_lvl3.png");
        figureSprite = new Sprite(figureTexture);

        mainMusic = Gdx.audio.newMusic(Gdx.files.internal("music/DanceOf1000Suns.wav"));
        fireballSound1 = Gdx.audio.newSound(Gdx.files.internal("sounds/fireballSound1.mp3"));
        fireballSound2 = Gdx.audio.newSound(Gdx.files.internal("sounds/fireballSound2.mp3"));
        levelUpSound = Gdx.audio.newSound(Gdx.files.internal("sounds/levelUpSound.mp3"));
    }

    public static void playSound (Sound sound) {
        if (Settings.soundEnabled) sound.play(1);
    }

}
