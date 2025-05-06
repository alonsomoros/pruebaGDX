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
        GAME_BOARD = "background/tablero.png",
        FIGURA_MAGO_3 = "sprites/mago/mago_lvl3.png",
        MAIN_MENU_MUSIC = "music/DanceOf1000Suns.wav",
        GAME_MUSIC = "music/TheFrozenPeak.wav",
        FIREBALL_SOUND_1 = "sounds/fireballSound1.mp3",
        FIREBALL_SOUND_2 = "sounds/fireballSound2.mp3",
        LEVEL_UP_SOUND = "sounds/levelUpSound2.mp3",
        BUTTON_LABEL_JSON = "buttons/uiskin_label/uiskin_label.json",
        FIREBALL_ATLAS = "sprites/fireball/fireball.atlas",
        TITLE_LABEL = "icons/logoWhite.png";

    public static Texture loadTexture(String file) {
        return new Texture(Gdx.files.internal(file));
    }

    public static void load() {

        assetManager.load(LOGO, Texture.class);
        assetManager.load(TITLE_LABEL, Texture.class);
        assetManager.load(BACKGROUND, Texture.class);
        assetManager.load(GAME_BOARD, Texture.class);
        assetManager.load(FIGURA_MAGO_3, Texture.class);
        assetManager.load(MAIN_MENU_MUSIC, Music.class);
        assetManager.load(GAME_MUSIC, Music.class);
        assetManager.load(FIREBALL_SOUND_1, Sound.class);
        assetManager.load(FIREBALL_SOUND_2, Sound.class);
        assetManager.load(LEVEL_UP_SOUND, Sound.class);
        assetManager.load(BUTTON_LABEL_JSON, com.badlogic.gdx.scenes.scene2d.ui.Skin.class);
        assetManager.load(FIREBALL_ATLAS, com.badlogic.gdx.graphics.g2d.TextureAtlas.class);

        // … más assets
        assetManager.finishLoading();
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

    public static void playSound(Sound sound) {
        if (Settings.soundEnabled) sound.play(1);
    }

}
