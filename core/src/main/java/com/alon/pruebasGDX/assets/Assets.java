package com.alon.pruebasGDX.assets;

import com.alon.pruebasGDX.utils.Settings;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class Assets {

    public static final AssetManager assetManager = new AssetManager();

    public static final String
        LOGO = "sprites/arquero/arquero_lvl3.png",
        BACKGROUND = "background/tienda.png",
        FIGURA_MAGO_3 = "sprites/mago/mago_lvl3.png",
        MUSIC = "music/DanceOf1000Suns.wav",
        FIRBALL_SOUND_1 = "sounds/fireballSound1.mp3",
        FIRBALL_SOUND_2 = "sounds/fireballSound2.mp3",
        LEVEL_UP_SOUND = "sounds/levelUpSound2.mp3",
        BUTTON_LABEL_JSON = "buttons/uiskin_label/uiskin_label.json",
        FIREBALL_ATLAS = "sprites/fireball/fireball.atlas";


    //public static Texture logo;
    //public static Texture backgroundTexture;
    //public static Texture figureTexture;

    //public static Music mainMusic;

    //public static Sound fireballSound1;
    //public static Sound fireballSound2;
    //public static Sound levelUpSound;

    public static Texture loadTexture (String file) {
        return new Texture(Gdx.files.internal(file));
    }

    public static void load() {

        // logo = new Texture(Gdx.files.internal("icons/LogoSeaOfStars_Black.png"));
        assetManager.load(LOGO, Texture.class);

        // backgroundTexture = loadTexture("background/tienda.png");
        assetManager.load(BACKGROUND, Texture.class);

        // figureTexture = loadTexture("sprites/mago/mago_lvl3.png");
        assetManager.load(FIGURA_MAGO_3, Texture.class);

        // mainMusic = Gdx.audio.newMusic(Gdx.files.internal("music/DanceOf1000Suns.wav"));
        assetManager.load(MUSIC, Music.class);
        // fireballSound1 = Gdx.audio.newSound(Gdx.files.internal("sounds/fireballSound1.mp3"));
        assetManager.load(FIRBALL_SOUND_1, Sound.class);
        // fireballSound2 = Gdx.audio.newSound(Gdx.files.internal("sounds/fireballSound2.mp3"));
        assetManager.load(FIRBALL_SOUND_2, Sound.class);
        // levelUpSound = Gdx.audio.newSound(Gdx.files.internal("sounds/levelUpSound.mp3"));
        assetManager.load(LEVEL_UP_SOUND, Sound.class);
        // … más assets
    }

    public static void finishLoading() {
        assetManager.finishLoading(); // bloqueante
        Gdx.app.log("Assets", "Cargados " + assetManager.getLoadedAssets() + " assets");
    }

    public static Texture getTexture(String name) {
        return assetManager.get(name, Texture.class);
    }

    public static Sound getSound(String name) {
        return assetManager.get(name, Sound.class);
    }

    public static Music getMusic(String name) {
        return assetManager.get(name, Music.class);
    }

    public static void dispose() {
        assetManager.dispose();
    }

    public static void playSound (Sound sound) {
        if (Settings.soundEnabled) sound.play(1);
    }

}
