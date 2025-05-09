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
        MINIGAME = "background/cielo.png",
        SUELO = "background/suelo.png",
        TITLE_LABEL = "icons/logoWhite.png",
        FUENTE_PIXEL_TTF = "fuentes/PixelifySans.fnt",
        FUENTE_PIXEL_PNG = "fuentes/PixelifySans.png",
        FIGURA_MAGO_1 = "sprites/mago/mago_lvl1.png",
        FIGURA_MAGO_2 = "sprites/mago/mago_lvl2.png",
        FIGURA_MAGO_3 = "sprites/mago/mago_lvl3.png",
        MAIN_MENU_MUSIC = "music/DanceOf1000Suns.wav",
        GAME_MUSIC = "music/TheFrozenPeak.wav",
        BUTTON_EFFECT = "sounds/button_effect.mp3",
        LEVEL_UP_SOUND = "sounds/levelUp_Sound.mp3",
        LEVEL_DOWN_SOUND = "sounds/levelDown_Sound.mp3",
        BUTTON_LABEL_JSON = "buttons/uiskin_label/uiskin_label.json",
        BUTTON_MINIGAME_JSON = "buttons/uiskin_minigame/uiskin_minigame.json",
        FIREBALL_ATLAS = "sprites/fireball/fireball.atlas",
        FIREBALL_SPRITE_1 = "sprites/fireball/fireball_1.png",
        FIREBALL_SPRITE_2 = "sprites/fireball/fireball_2.png",
        FIREBALL_SPRITE_3 = "sprites/fireball/fireball_3.png",
        WATERBALL_ATLAS = "sprites/waterball/waterball.atlas",
        WATERBALL_SPRITE_1 = "sprites/waterball/waterball_1.png",
        WATERBALL_SPRITE_2 = "sprites/waterball/waterball_2.png",
        WATERBALL_SPRITE_3 = "sprites/waterball/waterball_3.png",
        FIREBALL_SOUND_1 = "sounds/fireballSound1.mp3",
        FIREBALL_SOUND_2 = "sounds/fireballSound2.mp3",
        WATERBALL_SOUND_1 = "sounds/waterballSound1.mp3",
        WATERBALL_SOUND_2 = "sounds/waterballSound2.mp3";

    public static Texture loadTexture(String file) {
        return new Texture(Gdx.files.internal(file));
    }

    public static void load() {

        assetManager.load(LOGO, Texture.class);
        assetManager.load(TITLE_LABEL, Texture.class);
        assetManager.load(FUENTE_PIXEL_TTF, com.badlogic.gdx.graphics.g2d.BitmapFont.class);
        assetManager.load(FUENTE_PIXEL_PNG, Texture.class);
        assetManager.load(BACKGROUND, Texture.class);
        assetManager.load(SUELO, Texture.class);
        assetManager.load(GAME_BOARD, Texture.class);
        assetManager.load(MINIGAME, Texture.class);
        assetManager.load(FIGURA_MAGO_1, Texture.class);
        assetManager.load(FIGURA_MAGO_2, Texture.class);
        assetManager.load(FIGURA_MAGO_3, Texture.class);
        assetManager.load(MAIN_MENU_MUSIC, Music.class);
        assetManager.load(GAME_MUSIC, Music.class);
        assetManager.load(FIREBALL_SOUND_1, Sound.class);
        assetManager.load(FIREBALL_SOUND_2, Sound.class);
        assetManager.load(WATERBALL_SOUND_1, Sound.class);
        assetManager.load(WATERBALL_SOUND_2, Sound.class);
        assetManager.load(BUTTON_EFFECT, Sound.class);
        assetManager.load(LEVEL_UP_SOUND, Sound.class);
        assetManager.load(LEVEL_DOWN_SOUND, Sound.class);
        assetManager.load(BUTTON_LABEL_JSON, com.badlogic.gdx.scenes.scene2d.ui.Skin.class);
        assetManager.load(BUTTON_MINIGAME_JSON, com.badlogic.gdx.scenes.scene2d.ui.Skin.class);
        assetManager.load(FIREBALL_ATLAS, com.badlogic.gdx.graphics.g2d.TextureAtlas.class);
        assetManager.load(FIREBALL_SPRITE_1, Texture.class);
        assetManager.load(FIREBALL_SPRITE_2, Texture.class);
        assetManager.load(FIREBALL_SPRITE_3, Texture.class);
        assetManager.load(WATERBALL_ATLAS, com.badlogic.gdx.graphics.g2d.TextureAtlas.class);
        assetManager.load(WATERBALL_SPRITE_1, Texture.class);
        assetManager.load(WATERBALL_SPRITE_2, Texture.class);
        assetManager.load(WATERBALL_SPRITE_3, Texture.class);

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
