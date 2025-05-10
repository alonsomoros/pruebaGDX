package com.alon.pruebasGDX.assets;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

import java.io.File;

// En una clase nueva como AssetCatalog.java o dentro de Assets.java
public class AssetCatalog {

    // Backgrounds
    public static final GameAsset
        BACKGROUND_MAIN_MENU = new GameAsset(Assets.BACKGROUND_MAIN_MENU_PATH, Texture.class),
        BACKGROUND_MINIGAME =  new GameAsset(Assets.BACKGROUND_MINIGAME_PATH, Texture.class),
        BACKGROUND_WHEELS =    new GameAsset(Assets.BACKGROUND_WHEELS_PATH, Texture.class),
        BACKGROUND_SUELO =     new GameAsset(Assets.BACKGROUND_SUELO_PATH, Texture.class);

    // Buttons
    public static final GameAsset
        BUTTON_NUEVAPARTIDA_JSON = new GameAsset(Assets.BUTTON_NUEVAPARTIDA_JSON_PATH, com.badlogic.gdx.scenes.scene2d.ui.Skin.class),
        BUTTON_MINIGAME_JSON = new GameAsset(Assets.BUTTON_MINIGAME_JSON_PATH, com.badlogic.gdx.scenes.scene2d.ui.Skin.class),

    // Fonts
    FUENTE_PIXEL_PNG = new GameAsset(Assets.FUENTE_PIXEL_PNG_PATH, Texture.class),
        FUENTE_PIXEL_TTF = new GameAsset(Assets.FUENTE_PIXEL_TTF_PATH, com.badlogic.gdx.graphics.g2d.BitmapFont.class);

    // Labels
    public static final GameAsset
        MAIN_TITLE_LABEL = new GameAsset(Assets.MAIN_TITLE_LABEL_PATH, Texture.class);

    // Music
    public static final GameAsset
        MAIN_MENU_MUSIC =   new GameAsset(Assets.MAIN_MENU_MUSIC_PATH, Music.class),
        MINIGAME_MUSIC =    new GameAsset(Assets.MINIGAME_MUSIC_PATH, Music.class),
        WHEELS_MUSIC =      new GameAsset(Assets.WHEELS_MUSIC_PATH, Music.class);

    // Sounds
    public static final GameAsset
        BUTTON_CLICK_SOUND = new GameAsset(Assets.BUTTON_EFFECT_PATH, Sound.class),
        LEVEL_UP_SOUND =     new GameAsset(Assets.LEVEL_UP_SOUND_PATH, Sound.class),
        LEVEL_DOWN_SOUND =   new GameAsset(Assets.LEVEL_DOWN_SOUND_PATH, Sound.class),
        FIREBALL_SOUND_1 =   new GameAsset(Assets.FIREBALL_SOUND_1_PATH, Sound.class),
        FIREBALL_SOUND_2 =   new GameAsset(Assets.FIREBALL_SOUND_2_PATH, Sound.class),
        WATERBALL_SOUND_1 =  new GameAsset(Assets.WATERBALL_SOUND_1_PATH, Sound.class),
        WATERBALL_SOUND_2 =  new GameAsset(Assets.WATERBALL_SOUND_2_PATH, Sound.class);

    // Sprites -> Activadores
    public static final GameAsset
        ACTIVADOR_CUADRADO_0 = new GameAsset(Assets.ACTIVADOR_CUADRADO_0_PATH, Texture.class),
        ACTIVADOR_CUADRADO_1 = new GameAsset(Assets.ACTIVADOR_CUADRADO_1_PATH, Texture.class),
        ACTIVADOR_CUADRADO_2 = new GameAsset(Assets.ACTIVADOR_CUADRADO_2_PATH, Texture.class),
        ACTIVADOR_CUADRADO_3 = new GameAsset(Assets.ACTIVADOR_CUADRADO_3_PATH, Texture.class),
        ACTIVADOR_CUADRADO_4 = new GameAsset(Assets.ACTIVADOR_CUADRADO_4_PATH, Texture.class),
        ACTIVADOR_CUADRADO_5 = new GameAsset(Assets.ACTIVADOR_CUADRADO_5_PATH, Texture.class),

        ACTIVADOR_ROMBO_0 = new GameAsset(Assets.ACTIVADOR_ROMBO_0_PATH, Texture.class),
        ACTIVADOR_ROMBO_1 = new GameAsset(Assets.ACTIVADOR_ROMBO_1_PATH, Texture.class),
        ACTIVADOR_ROMBO_2 = new GameAsset(Assets.ACTIVADOR_ROMBO_2_PATH, Texture.class),
        ACTIVADOR_ROMBO_3 = new GameAsset(Assets.ACTIVADOR_ROMBO_3_PATH, Texture.class),
        ACTIVADOR_ROMBO_4 = new GameAsset(Assets.ACTIVADOR_ROMBO_4_PATH, Texture.class),
        ACTIVADOR_ROMBO_5 = new GameAsset(Assets.ACTIVADOR_ROMBO_5_PATH, Texture.class);

    // Sprites -> Ataques
    public static final GameAsset
        ATAQUE_ARQUERO  =  new GameAsset(Assets.ATAQUE_ARQUERO_PATH, Texture.class),
        ATAQUE_ASESINO =   new GameAsset(Assets.ATAQUE_ASESINO_PATH, Texture.class),
        ATAQUE_CABALLERO = new GameAsset(Assets.ATAQUE_CABALLERO_PATH, Texture.class),
        ATAQUE_INGENIERO = new GameAsset(Assets.ATAQUE_INGENIERO_PATH, Texture.class),
        ATAQUE_MAGO =      new GameAsset(Assets.ATAQUE_MAGO_PATH, Texture.class),
        ATAQUE_SACERDOTE = new GameAsset(Assets.ATAQUE_SACERDOTE_PATH, Texture.class),
        ATAQUE_ESPECIAL =  new GameAsset(Assets.ATAQUE_ESPECIAL_PATH, Texture.class);

    // Sprites -> BasesFiguras
    public static final GameAsset
        BASE_FIGURA_CUADRADO_0 = new GameAsset(Assets.BASE_FIGURA_CUADRADO_0_PATH, Texture.class),
        BASE_FIGURA_CUADRADO_1 = new GameAsset(Assets.BASE_FIGURA_CUADRADO_1_PATH, Texture.class),
        BASE_FIGURA_CUADRADO_2 = new GameAsset(Assets.BASE_FIGURA_CUADRADO_2_PATH, Texture.class),
        BASE_FIGURA_CUADRADO_3 = new GameAsset(Assets.BASE_FIGURA_CUADRADO_3_PATH, Texture.class),
        BASE_FIGURA_CUADRADO_4 = new GameAsset(Assets.BASE_FIGURA_CUADRADO_4_PATH, Texture.class),
        BASE_FIGURA_CUADRADO_5 = new GameAsset(Assets.BASE_FIGURA_CUADRADO_5_PATH, Texture.class),
        BASE_FIGURA_CUADRADO_6 = new GameAsset(Assets.BASE_FIGURA_CUADRADO_6_PATH, Texture.class),

        BASE_FIGURA_ROMBO_0 = new GameAsset(Assets.BASE_FIGURA_ROMBO_0_PATH, Texture.class),
        BASE_FIGURA_ROMBO_1 = new GameAsset(Assets.BASE_FIGURA_ROMBO_1_PATH, Texture.class),
        BASE_FIGURA_ROMBO_2 = new GameAsset(Assets.BASE_FIGURA_ROMBO_2_PATH, Texture.class),
        BASE_FIGURA_ROMBO_3 = new GameAsset(Assets.BASE_FIGURA_ROMBO_3_PATH, Texture.class),
        BASE_FIGURA_ROMBO_4 = new GameAsset(Assets.BASE_FIGURA_ROMBO_4_PATH, Texture.class),
        BASE_FIGURA_ROMBO_5 = new GameAsset(Assets.BASE_FIGURA_ROMBO_5_PATH, Texture.class),
        BASE_FIGURA_ROMBO_6 = new GameAsset(Assets.BASE_FIGURA_ROMBO_6_PATH, Texture.class);

    // Sprites -> Bastion
    public static final GameAsset
        BASTION_1 = new GameAsset(Assets.BASTION_1_PATH, Texture.class),
        BASTION_2 = new GameAsset(Assets.BASTION_2_PATH, Texture.class),
        BASTION_3 = new GameAsset(Assets.BASTION_3_PATH, Texture.class),
        BASTION_4 = new GameAsset(Assets.BASTION_4_PATH, Texture.class),
        BASTION_5 = new GameAsset(Assets.BASTION_5_PATH, Texture.class);

    // Sprites -> Figuras
    public static final GameAsset
        FIGURA_ARQUERO_1 = new GameAsset(Assets.FIGURA_ARQUERO_1_PATH, Texture.class),
        FIGURA_ARQUERO_2 = new GameAsset(Assets.FIGURA_ARQUERO_2_PATH, Texture.class),
        FIGURA_ARQUERO_3 = new GameAsset(Assets.FIGURA_ARQUERO_3_PATH, Texture.class),

        FIGURA_ASESINO_1 = new GameAsset(Assets.FIGURA_ASESINO_1_PATH, Texture.class),
        FIGURA_ASESINO_2 = new GameAsset(Assets.FIGURA_ASESINO_2_PATH, Texture.class),
        FIGURA_ASESINO_3 = new GameAsset(Assets.FIGURA_ASESINO_3_PATH, Texture.class),

        FIGURA_CABALLERO_1 = new GameAsset(Assets.FIGURA_CABALLERO_1_PATH, Texture.class),
        FIGURA_CABALLERO_2 = new GameAsset(Assets.FIGURA_CABALLERO_2_PATH, Texture.class),
        FIGURA_CABALLERO_3 = new GameAsset(Assets.FIGURA_CABALLERO_3_PATH, Texture.class),

        FIGURA_INGENIERO_1 = new GameAsset(Assets.FIGURA_INGENIERO_1_PATH, Texture.class),
        FIGURA_INGENIERO_2 = new GameAsset(Assets.FIGURA_INGENIERO_2_PATH, Texture.class),
        FIGURA_INGENIERO_3 = new GameAsset(Assets.FIGURA_INGENIERO_3_PATH, Texture.class),

        FIGURA_MAGO_1 = new GameAsset(Assets.FIGURA_MAGO_1_PATH, Texture.class),
        FIGURA_MAGO_2 = new GameAsset(Assets.FIGURA_MAGO_2_PATH, Texture.class),
        FIGURA_MAGO_3 = new GameAsset(Assets.FIGURA_MAGO_3_PATH, Texture.class),

        FIGURA_SACERDOTE_1 = new GameAsset(Assets.FIGURA_SACERDOTE_1_PATH, Texture.class),
        FIGURA_SACERDOTE_2 = new GameAsset(Assets.FIGURA_SACERDOTE_2_PATH, Texture.class),
        FIGURA_SACERDOTE_3 = new GameAsset(Assets.FIGURA_SACERDOTE_3_PATH, Texture.class);

    // Sprites -> Rodillo
    public static final GameAsset
        CUADRADO_NORMAL_1 =         new GameAsset(Assets.CUADRADO_NORMAL_1_PATH, Texture.class),
        CUADRADO_NORMAL_2 =         new GameAsset(Assets.CUADRADO_NORMAL_2_PATH, Texture.class),
        CUADRADO_NORMAL_3 =         new GameAsset(Assets.CUADRADO_NORMAL_3_PATH, Texture.class),
        CUADRADO_NORMAL_LATERAL_1 = new GameAsset(Assets.CUADRADO_NORMAL_LATERAL_1_PATH, Texture.class),
        CUADRADO_NORMAL_LATERAL_2 = new GameAsset(Assets.CUADRADO_NORMAL_LATERAL_2_PATH, Texture.class),
        CUADRADO_NORMAL_LATERAL_3 = new GameAsset(Assets.CUADRADO_NORMAL_LATERAL_3_PATH, Texture.class),
        CUADRADO_NIVEL_1 =          new GameAsset(Assets.CUADRADO_NIVEL_1_PATH, Texture.class),
        CUADRADO_NIVEL_2 =          new GameAsset(Assets.CUADRADO_NIVEL_2_PATH, Texture.class),
        CUADRADO_NIVEL_3 =          new GameAsset(Assets.CUADRADO_NIVEL_3_PATH, Texture.class),
        CUADRADO_NIVEL_LATERAL_1 =  new GameAsset(Assets.CUADRADO_NIVEL_LATERAL_1_PATH, Texture.class),
        CUADRADO_NIVEL_LATERAL_2 =  new GameAsset(Assets.CUADRADO_NIVEL_LATERAL_2_PATH, Texture.class),
        CUADRADO_NIVEL_LATERAL_3 =  new GameAsset(Assets.CUADRADO_NIVEL_LATERAL_3_PATH, Texture.class),
        ROMBO_NORMAL_1 =            new GameAsset(Assets.ROMBO_NORMAL_1_PATH, Texture.class),
        ROMBO_NORMAL_2 =            new GameAsset(Assets.ROMBO_NORMAL_2_PATH, Texture.class),
        ROMBO_NORMAL_3 =            new GameAsset(Assets.ROMBO_NORMAL_3_PATH, Texture.class),
        ROMBO_NORMAL_LATERAL_1 =    new GameAsset(Assets.ROMBO_NORMAL_LATERAL_1_PATH, Texture.class),
        ROMBO_NORMAL_LATERAL_2 =    new GameAsset(Assets.ROMBO_NORMAL_LATERAL_2_PATH, Texture.class),
        ROMBO_NORMAL_LATERAL_3 =    new GameAsset(Assets.ROMBO_NORMAL_LATERAL_3_PATH, Texture.class),
        ROMBO_NIVEL_1 =             new GameAsset(Assets.ROMBO_NIVEL_1_PATH, Texture.class),
        ROMBO_NIVEL_2 =             new GameAsset(Assets.ROMBO_NIVEL_2_PATH, Texture.class),
        ROMBO_NIVEL_3 =             new GameAsset(Assets.ROMBO_NIVEL_3_PATH, Texture.class),
        ROMBO_NIVEL_LATERAL_1 =     new GameAsset(Assets.ROMBO_NIVEL_LATERAL_1_PATH, Texture.class),
        ROMBO_NIVEL_LATERAL_2 =     new GameAsset(Assets.ROMBO_NIVEL_LATERAL_2_PATH, Texture.class),
        ROMBO_NIVEL_LATERAL_3 =     new GameAsset(Assets.ROMBO_NIVEL_LATERAL_3_PATH, Texture.class),
        MARTILLO_1 =                new GameAsset(Assets.MARTILLO_1_PATH, Texture.class),
        MARTILLO_2 =                new GameAsset(Assets.MARTILLO_2_PATH, Texture.class),
        MARTILLO_3 =                new GameAsset(Assets.MARTILLO_3_PATH, Texture.class),
        MARTILLO_LATERAL_1 =        new GameAsset(Assets.MARTILLO_LATERAL_1_PATH, Texture.class),
        MARTILLO_LATERAL_2 =        new GameAsset(Assets.MARTILLO_LATERAL_2_PATH, Texture.class),
        MARTILLO_LATERAL_3 =        new GameAsset(Assets.MARTILLO_LATERAL_3_PATH, Texture.class),
        ROTO =                      new GameAsset(Assets.ROTO_PATH, Texture.class),
        ROTO_LATERAL =              new GameAsset(Assets.ROTO_LATERAL_PATH, Texture.class),
        GIRARRODILLO =              new GameAsset(Assets.GIRARRODILLO_PATH, Texture.class),
        FIJADOR =                   new GameAsset(Assets.FIJADOR_PATH, Texture.class);

    // Sprites -> StatsFiguras
    public static final GameAsset
        STATS_VACIO =       new GameAsset(Assets.STATS_VACIO_PATH, Texture.class),
        STATS_GUERRERROS =  new GameAsset(Assets.STATS_GUERRERROS_PATH, Texture.class),
        STATS_SACERDOTE =   new GameAsset(Assets.STATS_SACERDOTE_PATH, Texture.class),
        STATS_ASESINO =     new GameAsset(Assets.STATS_ASESINO_PATH, Texture.class);

    // Sprites -> Fireball
    public static final GameAsset
        FIREBALL_1 = new GameAsset(Assets.FIREBALL_1_PATH, Texture.class),
        FIREBALL_2 = new GameAsset(Assets.FIREBALL_2_PATH, Texture.class),
        FIREBALL_3 = new GameAsset(Assets.FIREBALL_3_PATH, Texture.class),
        FIREBALL_ATLAS = new GameAsset(Assets.FIREBALL_ATLAS_PATH, com.badlogic.gdx.graphics.g2d.TextureAtlas.class),
        FIREBALL_SPRITESHEET = new GameAsset(Assets.FIREBALL_SPRITESHEET_PATH, Texture.class);

    // Sprites -> Waterball
    public static final GameAsset
        WATERBALL_1 = new GameAsset(Assets.WATERBALL_1_PATH, Texture.class),
        WATERBALL_2 = new GameAsset(Assets.WATERBALL_2_PATH, Texture.class),
        WATERBALL_3 = new GameAsset(Assets.WATERBALL_3_PATH, Texture.class),
        WATERBALL_ATLAS = new GameAsset(Assets.WATERBALL_ATLAS_PATH, com.badlogic.gdx.graphics.g2d.TextureAtlas.class),
        WATERBALL_SPRITESHEET = new GameAsset(Assets.WATERBALL_SPRITESHEET_PATH, Texture.class);

    // Text
    public static final GameAsset
        INSTRUCCIONES = new GameAsset(Assets.INSTRUCCIONES_PATH, File.class),
        CREDITOS =      new GameAsset(Assets.CREDITOS_PATH, File.class);
}
