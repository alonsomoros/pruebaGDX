package com.alon.pruebasGDX.assets;

import com.alon.pruebasGDX.utils.Settings;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class Assets {

    public static final AssetManager assetManager = new AssetManager();

    // BACKGROUND
    public static final String
        BACKGROUND_MAIN_MENU_PATH = "background/tienda.png",
        BACKGROUND_MINIGAME_PATH = "background/cielo.png",
        BACKGROUND_WHEELS_PATH = "background/tablero.png",
        BACKGROUND_SUELO_PATH = "background/suelo.png";

    // BUTTONS
    public static final String
        BUTTON_MINIGAME_JSON_PATH = "buttons/uiskin_minigame/uiskin_minigame.json",
        BUTTON_NUEVAPARTIDA_JSON_PATH = "buttons/uiskin_nuevaPartida/uiskin_nuevaPartida.json";

    // FONTS
    public static final String
        FUENTE_PIXEL_TTF_PATH = "fonts/PixelifySans.fnt",
        FUENTE_PIXEL_PNG_PATH = "fonts/PixelifySans.png";

    // LABELS
    public static final String
        MAIN_TITLE_LABEL_PATH = "labels/logoWhite.png";

    // MUSIC
    public static final String
        MAIN_MENU_MUSIC_PATH = "music/DanceOf1000Suns.wav",
        WHEELS_MUSIC_PATH = "music/TheFrozenPeak.wav",
        MINIGAME_MUSIC_PATH = "music/PathOfAscension.wav";

    // SOUNDS
    public static final String
        BUTTON_EFFECT_PATH = "sounds/button_effect.mp3",
        LEVEL_UP_SOUND_PATH = "sounds/levelUp_Sound.mp3",
        LEVEL_DOWN_SOUND_PATH = "sounds/levelDown_Sound.mp3",
        FIREBALL_SOUND_1_PATH = "sounds/fireballSound1.mp3",
        FIREBALL_SOUND_2_PATH = "sounds/fireballSound2.mp3",
        WATERBALL_SOUND_1_PATH = "sounds/waterballSound1.mp3",
        WATERBALL_SOUND_2_PATH = "sounds/waterballSound2.mp3";

    // SPRITES -> ACTIVADORES
    public static final String
        ACTIVADOR_CUADRADO_0_PATH = "sprites/activadores/ActivadorCuadrado_0.png",
        ACTIVADOR_CUADRADO_1_PATH = "sprites/activadores/ActivadorCuadrado_1.png",
        ACTIVADOR_CUADRADO_2_PATH = "sprites/activadores/ActivadorCuadrado_2.png",
        ACTIVADOR_CUADRADO_3_PATH = "sprites/activadores/ActivadorCuadrado_3.png",
        ACTIVADOR_CUADRADO_4_PATH = "sprites/activadores/ActivadorCuadrado_4.png",
        ACTIVADOR_CUADRADO_5_PATH = "sprites/activadores/ActivadorCuadrado_5.png",
        ACTIVADOR_ROMBO_0_PATH = "sprites/activadores/ActivadorRombo_0.png",
        ACTIVADOR_ROMBO_1_PATH = "sprites/activadores/ActivadorRombo_1.png",
        ACTIVADOR_ROMBO_2_PATH = "sprites/activadores/ActivadorRombo_2.png",
        ACTIVADOR_ROMBO_3_PATH = "sprites/activadores/ActivadorRombo_3.png",
        ACTIVADOR_ROMBO_4_PATH = "sprites/activadores/ActivadorRombo_4.png",
        ACTIVADOR_ROMBO_5_PATH = "sprites/activadores/ActivadorRombo_5.png",

    // SPRITES -> ATAQUES
    ATAQUE_ARQUERO_PATH = "sprites/ataques/ataqueArquero.png",
        ATAQUE_ASESINO_PATH = "sprites/ataques/ataqueAsesino.png",
        ATAQUE_CABALLERO_PATH = "sprites/ataques/ataqueCaballero.png",
        ATAQUE_INGENIERO_PATH = "sprites/ataques/ataqueIngeniero.png",
        ATAQUE_MAGO_PATH = "sprites/ataques/ataqueMago.png",
        ATAQUE_SACERDOTE_PATH = "sprites/ataques/ataqueSacerdote.png",
        ATAQUE_ESPECIAL_PATH = "sprites/ataques/ataqueEspecial.png";

    // SPRITES -> BASES_FIGURAS
    public static final String
        BASE_FIGURA_CUADRADO_0_PATH = "sprites/baseFigura/BaseFiguraCuadrado_0.png",
        BASE_FIGURA_CUADRADO_1_PATH = "sprites/baseFigura/BaseFiguraCuadrado_1.png",
        BASE_FIGURA_CUADRADO_2_PATH = "sprites/baseFigura/BaseFiguraCuadrado_2.png",
        BASE_FIGURA_CUADRADO_3_PATH = "sprites/baseFigura/BaseFiguraCuadrado_3.png",
        BASE_FIGURA_CUADRADO_4_PATH = "sprites/baseFigura/BaseFiguraCuadrado_4.png",
        BASE_FIGURA_CUADRADO_5_PATH = "sprites/baseFigura/BaseFiguraCuadrado_5.png",
        BASE_FIGURA_CUADRADO_6_PATH = "sprites/baseFigura/BaseFiguraCuadrado_6.png",
        BASE_FIGURA_ROMBO_0_PATH = "sprites/baseFigura/BaseFiguraRombo_0.png",
        BASE_FIGURA_ROMBO_1_PATH = "sprites/baseFigura/BaseFiguraRombo_1.png",
        BASE_FIGURA_ROMBO_2_PATH = "sprites/baseFigura/BaseFiguraRombo_2.png",
        BASE_FIGURA_ROMBO_3_PATH = "sprites/baseFigura/BaseFiguraRombo_3.png",
        BASE_FIGURA_ROMBO_4_PATH = "sprites/baseFigura/BaseFiguraRombo_4.png",
        BASE_FIGURA_ROMBO_5_PATH = "sprites/baseFigura/BaseFiguraRombo_5.png",
        BASE_FIGURA_ROMBO_6_PATH = "sprites/baseFigura/BaseFiguraRombo_6.png";

    // SPRITES -> BASTION
    public static final String
        BASTION_1_PATH = "sprites/bastion/bastion_1.png",
        BASTION_2_PATH = "sprites/bastion/bastion_2.png",
        BASTION_3_PATH = "sprites/bastion/bastion_3.png",
        BASTION_4_PATH = "sprites/bastion/bastion_4.png",
        BASTION_5_PATH = "sprites/bastion/bastion_5.png";


    // SPRITES -> FIGURAS
    public static final String
        FIGURA_ARQUERO_1_PATH = "sprites/figuras/arquero/arquero_lvl1.png",
        FIGURA_ARQUERO_2_PATH = "sprites/figuras/arquero/arquero_lvl2.png",
        FIGURA_ARQUERO_3_PATH = "sprites/figuras/arquero/arquero_lvl3.png",

    FIGURA_ASESINO_1_PATH = "sprites/figuras/asesino/asesino_lvl1.png",
        FIGURA_ASESINO_2_PATH = "sprites/figuras/asesino/asesino_lvl2.png",
        FIGURA_ASESINO_3_PATH = "sprites/figuras/asesino/asesino_lvl3.png",

    FIGURA_CABALLERO_1_PATH = "sprites/figuras/caballero/caballero_lvl1.png",
        FIGURA_CABALLERO_2_PATH = "sprites/figuras/caballero/caballero_lvl2.png",
        FIGURA_CABALLERO_3_PATH = "sprites/figuras/caballero/caballero_lvl3.png",

    FIGURA_INGENIERO_1_PATH = "sprites/figuras/ingeniero/ingeniero_lvl1.png",
        FIGURA_INGENIERO_2_PATH = "sprites/figuras/ingeniero/ingeniero_lvl2.png",
        FIGURA_INGENIERO_3_PATH = "sprites/figuras/ingeniero/ingeniero_lvl3.png",

    FIGURA_MAGO_1_PATH = "sprites/figuras/mago/mago_lvl1.png",
        FIGURA_MAGO_2_PATH = "sprites/figuras/mago/mago_lvl2.png",
        FIGURA_MAGO_3_PATH = "sprites/figuras/mago/mago_lvl3.png",

    FIGURA_SACERDOTE_1_PATH = "sprites/figuras/sacerdote/sacerdote_lvl1.png",
        FIGURA_SACERDOTE_2_PATH = "sprites/figuras/sacerdote/sacerdote_lvl2.png",
        FIGURA_SACERDOTE_3_PATH = "sprites/figuras/sacerdote/sacerdote_lvl3.png";

    // SPRITES -> RODILLO
    public static final String
        CUADRADO_NORMAL_1_PATH = "sprites/rodillo/cuadrado1.png",
        CUADRADO_NORMAL_2_PATH = "sprites/rodillo/cuadrado2.png",
        CUADRADO_NORMAL_3_PATH = "sprites/rodillo/cuadrado3.png",
        CUADRADO_NORMAL_LATERAL_1_PATH = "sprites/rodillo/cuadrado1Lateral.png",
        CUADRADO_NORMAL_LATERAL_2_PATH = "sprites/rodillo/cuadrado2Lateral.png",
        CUADRADO_NORMAL_LATERAL_3_PATH = "sprites/rodillo/cuadrado3Lateral.png",
        CUADRADO_NIVEL_1_PATH = "sprites/rodillo/cuadradoNivel1.png",
        CUADRADO_NIVEL_2_PATH = "sprites/rodillo/cuadradoNivel2.png",
        CUADRADO_NIVEL_3_PATH = "sprites/rodillo/cuadradoNivel3.png",
        CUADRADO_NIVEL_LATERAL_1_PATH = "sprites/rodillo/cuadradoNivel1Lateral.png",
        CUADRADO_NIVEL_LATERAL_2_PATH = "sprites/rodillo/cuadradoNivel2Lateral.png",
        CUADRADO_NIVEL_LATERAL_3_PATH = "sprites/rodillo/cuadradoNivel3Lateral.png",

    ROMBO_NORMAL_1_PATH = "sprites/rodillo/rombo1.png",
        ROMBO_NORMAL_2_PATH = "sprites/rodillo/rombo2.png",
        ROMBO_NORMAL_3_PATH = "sprites/rodillo/rombo3.png",
        ROMBO_NORMAL_LATERAL_1_PATH = "sprites/rodillo/rombo1Lateral.png",
        ROMBO_NORMAL_LATERAL_2_PATH = "sprites/rodillo/rombo2Lateral.png",
        ROMBO_NORMAL_LATERAL_3_PATH = "sprites/rodillo/rombo3Lateral.png",
        ROMBO_NIVEL_1_PATH = "sprites/rodillo/romboNivel1.png",
        ROMBO_NIVEL_2_PATH = "sprites/rodillo/romboNivel2.png",
        ROMBO_NIVEL_3_PATH = "sprites/rodillo/romboNivel3.png",
        ROMBO_NIVEL_LATERAL_1_PATH = "sprites/rodillo/romboNivel1Lateral.png",
        ROMBO_NIVEL_LATERAL_2_PATH = "sprites/rodillo/romboNivel2Lateral.png",
        ROMBO_NIVEL_LATERAL_3_PATH = "sprites/rodillo/romboNivel3Lateral.png",

    MARTILLO_1_PATH = "sprites/rodillo/martillo1.png",
        MARTILLO_2_PATH = "sprites/rodillo/martillo2.png",
        MARTILLO_3_PATH = "sprites/rodillo/martillo3.png",
        MARTILLO_LATERAL_1_PATH = "sprites/rodillo/martillo1Lateral.png",
        MARTILLO_LATERAL_2_PATH = "sprites/rodillo/martillo2Lateral.png",
        MARTILLO_LATERAL_3_PATH = "sprites/rodillo/martillo3Lateral.png",

    ROTO_PATH = "sprites/rodillo/roto.png",
        ROTO_LATERAL_PATH = "sprites/rodillo/rotoLateral.png",

    GIRARRODILLO_PATH = "sprites/rodillo/girarrodillo.png",
        FIJADOR_PATH = "sprites/rodillo/fijador.png";

    // SPRITES -> STATS_FIGURA
    public static final String
        STATS_VACIO_PATH = "sprites/statsFigura/statsVacio.png",
        STATS_GUERRERROS_PATH = "sprites/statsFigura/statsGuerreros.png",
        STATS_SACERDOTE_PATH = "sprites/statsFigura/statsSacerdote.png",
        STATS_ASESINO_PATH = "sprites/statsFigura/statsAsesino.png";

    // SPRITES -> FIREBALL
    public static final String
        FIREBALL_1_PATH = "sprites/fireball/fireball_1.png",
        FIREBALL_2_PATH = "sprites/fireball/fireball_2.png",
        FIREBALL_3_PATH = "sprites/fireball/fireball_3.png",
        FIREBALL_ATLAS_PATH = "sprites/fireball/fireball.atlas",
        FIREBALL_SPRITESHEET_PATH = "sprites/fireball/fireball.png";

    // SPRITES -> WATERBALL
    public static final String
        WATERBALL_1_PATH = "sprites/waterball/waterball_1.png",
        WATERBALL_2_PATH = "sprites/waterball/waterball_2.png",
        WATERBALL_3_PATH = "sprites/waterball/waterball_3.png",
        WATERBALL_ATLAS_PATH = "sprites/waterball/waterball.atlas",
        WATERBALL_SPRITESHEET_PATH = "sprites/waterball/waterball.png";

    // TEXT
    public static final String
        INSTRUCCIONES_PATH = "text/instrucciones.txt",
        CREDITOS_PATH = "text/creditos.txt";

    public static void create() {

        AssetRegistry.registerScreenAssets("main_menu",
            AssetCatalog.MAIN_MENU_MUSIC,
            AssetCatalog.BACKGROUND_MAIN_MENU,
            AssetCatalog.BUTTON_NUEVAPARTIDA_JSON,
            AssetCatalog.BUTTON_MINIGAME_JSON,
            AssetCatalog.MAIN_TITLE_LABEL,
            AssetCatalog.BUTTON_CLICK_SOUND);

        AssetRegistry.registerScreenAssets("minigame",
            AssetCatalog.WHEELS_MUSIC,
            AssetCatalog.BACKGROUND_MINIGAME,
            AssetCatalog.BACKGROUND_SUELO,
            AssetCatalog.FIGURA_MAGO_1,
            AssetCatalog.FIGURA_MAGO_2,
            AssetCatalog.FIGURA_MAGO_3,
            AssetCatalog.FIREBALL_1,
            AssetCatalog.FIREBALL_2,
            AssetCatalog.FIREBALL_3,
            AssetCatalog.FIREBALL_ATLAS,
            AssetCatalog.FIREBALL_SPRITESHEET,
            AssetCatalog.WATERBALL_1,
            AssetCatalog.WATERBALL_2,
            AssetCatalog.WATERBALL_3,
            AssetCatalog.WATERBALL_ATLAS,
            AssetCatalog.WATERBALL_SPRITESHEET,
            AssetCatalog.LEVEL_UP_SOUND,
            AssetCatalog.LEVEL_DOWN_SOUND,
            AssetCatalog.FIREBALL_SOUND_1,
            AssetCatalog.FIREBALL_SOUND_2,
            AssetCatalog.WATERBALL_SOUND_1,
            AssetCatalog.WATERBALL_SOUND_2,
            AssetCatalog.FUENTE_PIXEL_PNG,
            AssetCatalog.FUENTE_PIXEL_TTF
        );

        AssetRegistry.registerScreenAssets("wheels",
            AssetCatalog.WHEELS_MUSIC,
            AssetCatalog.BACKGROUND_WHEELS,
            AssetCatalog.FIGURA_ARQUERO_1,
            AssetCatalog.FIGURA_ARQUERO_2,
            AssetCatalog.FIGURA_ARQUERO_3,
            AssetCatalog.FIGURA_ASESINO_1,
            AssetCatalog.FIGURA_ASESINO_2,
            AssetCatalog.FIGURA_ASESINO_3,
            AssetCatalog.FIGURA_CABALLERO_1,
            AssetCatalog.FIGURA_CABALLERO_2,
            AssetCatalog.FIGURA_CABALLERO_3,
            AssetCatalog.FIGURA_INGENIERO_1,
            AssetCatalog.FIGURA_INGENIERO_2,
            AssetCatalog.FIGURA_INGENIERO_3,
            AssetCatalog.FIGURA_MAGO_1,
            AssetCatalog.FIGURA_MAGO_2,
            AssetCatalog.FIGURA_MAGO_3,
            AssetCatalog.FIGURA_SACERDOTE_1,
            AssetCatalog.FIGURA_SACERDOTE_2,
            AssetCatalog.FIGURA_SACERDOTE_3,
            AssetCatalog.ACTIVADOR_CUADRADO_0,
            AssetCatalog.ACTIVADOR_CUADRADO_1,
            AssetCatalog.ACTIVADOR_CUADRADO_2,
            AssetCatalog.ACTIVADOR_CUADRADO_3,
            AssetCatalog.ACTIVADOR_CUADRADO_4,
            AssetCatalog.ACTIVADOR_CUADRADO_5,
            AssetCatalog.ACTIVADOR_ROMBO_0,
            AssetCatalog.ACTIVADOR_ROMBO_1,
            AssetCatalog.ACTIVADOR_ROMBO_2,
            AssetCatalog.ACTIVADOR_ROMBO_3,
            AssetCatalog.ACTIVADOR_ROMBO_4,
            AssetCatalog.ACTIVADOR_ROMBO_5,
            AssetCatalog.BASE_FIGURA_CUADRADO_0,
            AssetCatalog.BASE_FIGURA_CUADRADO_1,
            AssetCatalog.BASE_FIGURA_CUADRADO_2,
            AssetCatalog.BASE_FIGURA_CUADRADO_3,
            AssetCatalog.BASE_FIGURA_CUADRADO_4,
            AssetCatalog.BASE_FIGURA_CUADRADO_5,
            AssetCatalog.BASE_FIGURA_CUADRADO_6,
            AssetCatalog.BASE_FIGURA_ROMBO_0,
            AssetCatalog.BASE_FIGURA_ROMBO_1,
            AssetCatalog.BASE_FIGURA_ROMBO_2,
            AssetCatalog.BASE_FIGURA_ROMBO_3,
            AssetCatalog.BASE_FIGURA_ROMBO_4,
            AssetCatalog.BASE_FIGURA_ROMBO_5,
            AssetCatalog.BASE_FIGURA_ROMBO_6,
            AssetCatalog.ATAQUE_ARQUERO,
            AssetCatalog.ATAQUE_ASESINO,
            AssetCatalog.ATAQUE_CABALLERO,
            AssetCatalog.ATAQUE_INGENIERO,
            AssetCatalog.ATAQUE_MAGO,
            AssetCatalog.ATAQUE_SACERDOTE,
            AssetCatalog.ATAQUE_ESPECIAL,
            AssetCatalog.BASTION_1,
            AssetCatalog.BASTION_2,
            AssetCatalog.BASTION_3,
            AssetCatalog.BASTION_4,
            AssetCatalog.BASTION_5,
            AssetCatalog.CUADRADO_NORMAL_1,
            AssetCatalog.CUADRADO_NORMAL_2,
            AssetCatalog.CUADRADO_NORMAL_3,
            AssetCatalog.CUADRADO_NORMAL_LATERAL_1,
            AssetCatalog.CUADRADO_NORMAL_LATERAL_2,
            AssetCatalog.CUADRADO_NORMAL_LATERAL_3,
            AssetCatalog.CUADRADO_NIVEL_1,
            AssetCatalog.CUADRADO_NIVEL_2,
            AssetCatalog.CUADRADO_NIVEL_3,
            AssetCatalog.CUADRADO_NIVEL_LATERAL_1,
            AssetCatalog.CUADRADO_NIVEL_LATERAL_2,
            AssetCatalog.CUADRADO_NIVEL_LATERAL_3,
            AssetCatalog.ROMBO_NORMAL_1,
            AssetCatalog.ROMBO_NORMAL_2,
            AssetCatalog.ROMBO_NORMAL_3,
            AssetCatalog.ROMBO_NORMAL_LATERAL_1,
            AssetCatalog.ROMBO_NORMAL_LATERAL_2,
            AssetCatalog.ROMBO_NORMAL_LATERAL_3,
            AssetCatalog.ROMBO_NIVEL_1,
            AssetCatalog.ROMBO_NIVEL_2,
            AssetCatalog.ROMBO_NIVEL_3,
            AssetCatalog.ROMBO_NIVEL_LATERAL_1,
            AssetCatalog.ROMBO_NIVEL_LATERAL_2,
            AssetCatalog.ROMBO_NIVEL_LATERAL_3,
            AssetCatalog.MARTILLO_1,
            AssetCatalog.MARTILLO_2,
            AssetCatalog.MARTILLO_3,
            AssetCatalog.MARTILLO_LATERAL_1,
            AssetCatalog.MARTILLO_LATERAL_2,
            AssetCatalog.MARTILLO_LATERAL_3,
            AssetCatalog.ROTO,
            AssetCatalog.ROTO_LATERAL,
            AssetCatalog.STATS_VACIO,
            AssetCatalog.STATS_GUERRERROS,
            AssetCatalog.STATS_SACERDOTE,
            AssetCatalog.STATS_ASESINO,
            AssetCatalog.GIRARRODILLO,
            AssetCatalog.FIJADOR
        );

        // … más assets
        assetManager.finishLoading();
    }

    // En Assets.java
    public static <T> T get(GameAsset asset) {
        return (T) assetManager.get(asset.getPath(), asset.getAssetClass());
    }

    public static void finishLoading() {
        assetManager.finishLoading(); // bloqueante
        Gdx.app.log("Assets", "Cargados " + assetManager.getLoadedAssets() + " assets");
    }

    public static Texture loadTexture(String file) {
        return new Texture(Gdx.files.internal(file));
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

    public static boolean isLoaded(GameAsset fuentePixelPng) {
        return assetManager.isLoaded(fuentePixelPng.getPath());
    }
}
