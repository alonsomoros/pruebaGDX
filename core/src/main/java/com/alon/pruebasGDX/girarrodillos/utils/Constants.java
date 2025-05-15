package com.alon.pruebasGDX.girarrodillos.utils;

import com.alon.pruebasGDX.girarrodillos.model.wheel.WheelSymbol;

public class Constants {
    public static int SCREEN_WIDTH = 800;
    public static int SCREEN_HEIGHT = 600;
    public static int VIEWPORT_WIDTH = 800;
    public static int VIEWPORT_HEIGHT = 600;
    public static int VIDA_MAXIMA = 20;
    public static int VIDA_INICIAL = 10;
    public static int VIDA_MINIMA = 0;
    public static int TURNOS_MAXIMO = 3;
    public static final int EXP_NECESARIA_EVOLUCION = 6;
    public static final int MAXIMA_ALTURA_BASTION = 5;
    public static WheelSymbol[] WHEEL_SYMBOLS = {
        WheelSymbol.CUADRADO_ENERGIA_1,
        WheelSymbol.CUADRADO_ENERGIA_2,
        WheelSymbol.CUADRADO_ENERGIA_3,
        WheelSymbol.CUADRADO_NIVEL_1,
        WheelSymbol.CUADRADO_NIVEL_2,
        WheelSymbol.CUADRADO_NIVEL_3,
        WheelSymbol.ROMBO_ENERGIA_1,
        WheelSymbol.ROMBO_ENERGIA_2,
        WheelSymbol.ROMBO_ENERGIA_3,
        WheelSymbol.ROMBO_NIVEL_1,
        WheelSymbol.ROMBO_NIVEL_2,
        WheelSymbol.ROMBO_NIVEL_3,
        WheelSymbol.BASTION_1,
        WheelSymbol.BASTION_2,
        WheelSymbol.BASTION_3,
        WheelSymbol.ROTO
    };
    public static class ENERGIA {
        public static final int
        ENERGIA_CABALLERO_LVL1 = 3,
        ENERGIA_CABALLERO_LVL2 = 3,
        ENERGIA_CABALLERO_LVL3 = 3;
        public static final int
        ENERGIA_SACERDOTE_LVL1 = 4,
        ENERGIA_SACERDOTE_LVL2 = 3,
        ENERGIA_SACERDOTE_LVL3 = 3;
        public static final int
        ENERGIA_INGENIERO_LVL1 = 4,
        ENERGIA_INGENIERO_LVL2 = 4,
        ENERGIA_INGENIERO_LVL3 = 3;
        public static final int
        ENERGIA_ASESINO_LVL1 = 3,
        ENERGIA_ASESINO_LVL2 = 3,
        ENERGIA_ASESINO_LVL3 = 3;
        public static final int
        ENERGIA_ARQUERO_LVL1 = 4,
        ENERGIA_ARQUERO_LVL2 = 3,
        ENERGIA_ARQUERO_LVL3 = 3;
        public static final int
        ENERGIA_MAGO_LVL1 = 5,
        ENERGIA_MAGO_LVL2 = 4,
        ENERGIA_MAGO_LVL3 = 4;
    }
    public static class STATS {

        public static final int
        DANYO_VIDA_CABALLERO_LVL1 = 3,
        DANYO_VIDA_CABALLERO_LVL2 = 5,
        DANYO_VIDA_CABALLERO_LVL3 = 7;
        public static final int
        DANYO_BASTION_CABALLERO_LVL1 = 1,
        DANYO_BASTION_CABALLERO_LVL2 = 2,
        DANYO_BASTION_CABALLERO_LVL3 = 3;
        public static final int
        CURACION_VIDA_SACERDOTE_LVL1 = 1,
        CURACION_VIDA_SACERDOTE_LVL2 = 2,
        CURACION_VIDA_SACERDOTE_LVL3 = 2;
        public static final int
        AYUDA_ENERGIA_SACERDOTE_LVL1 = 2,
        AYUDA_ENERGIA_SACERDOTE_LVL2 = 2,
        AYUDA_ENERGIA_SACERDOTE_LVL3 = 3;
        public static final int
        DANYO_VIDA_INGENIERO_LVL1 = 1,
        DANYO_VIDA_INGENIERO_LVL2 = 2,
        DANYO_VIDA_INGENIERO_LVL3 = 4;
        public static final int
        DANYO_BASTION_INGENIERO_LVL1 = 3,
        DANYO_BASTION_INGENIERO_LVL2 = 5,
        DANYO_BASTION_INGENIERO_LVL3 = 5;
        public static final int
        DANYO_VIDA_ASESINO_LVL1 = 1,
        DANYO_VIDA_ASESINO_LVL2 = 2,
        DANYO_VIDA_ASESINO_LVL3 = 2;
        public static final int
        DELAY_ENERGIA_ASESINO_LVL1 = 1,
        DELAY_ENERGIA_ASESINO_LVL2 = 1,
        DELAY_ENERGIA_ASESINO_LVL3 = 2;
        public static final int
        DANYO_VIDA_ARQUERO_LVL1 = 3,
        DANYO_VIDA_ARQUERO_LVL2 = 4,
        DANYO_VIDA_ARQUERO_LVL3 = 6;
        public static final int
        DANYO_BASTION_ARQUERO_LVL1 = 1,
        DANYO_BASTION_ARQUERO_LVL2 = 2,
        DANYO_BASTION_ARQUERO_LVL3 = 3;
        public static final int
        DANYO_VIDA_MAGO_LVL1 = 2,
        DANYO_VIDA_MAGO_LVL2 = 3,
        DANYO_VIDA_MAGO_LVL3 = 3;
        public static final int
        DANYO_BASTION_MAGO_LVL1 = 2,
        DANYO_BASTION_MAGO_LVL2 = 3,
        DANYO_BASTION_MAGO_LVL3 = 5;
    }
    public static class COORDENADAS {

        public static final float PLAYER_HEROES_Y = 100;
        public static final float OPPONENT_HEROES_Y = 500;
        public static final float LEFT_HERO_X = 100;
        public static final float RIGHT_HERO_X = 600;
        public static final float PLAYER_WHEELS_Y = 50;
        public static final float OPPONENT_WHEELS_Y = 650;
        public static final float PLAYER_WHEELS_X = 300;
        public static final float OPPONENT_WHEELS_X = 300;
        public static final float WHEELS_START_X = 300;
        public static final int WHEEL_SPACING = 60;
        public static final float WHEEL_WIDTH = 55;
        public static final float WHEEL_HEIGHT = 55;
        public static final float SYMBOL_SIZE = 55;
    }
}
