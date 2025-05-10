package com.alon.pruebasGDX.minigame;

public class ScoreManagerMinigame {
    private int puntuacion;
    private float dificultad;
    private FiguraMinigame magoFigura;

    private static final int LEVEL_1_THRESHOLD = 10;
    private static final int LEVEL_2_THRESHOLD = 20;

    public ScoreManagerMinigame(FiguraMinigame magoFigura) {
        this.magoFigura = magoFigura;
        this.puntuacion = 0;
        this.dificultad = 0;
    }

    public void addScore(int points) {
        puntuacion += points;
        dificultad += (points > 0) ? 0.2f : -0.1f;
        checkNivelFigura();
    }

    private void checkNivelFigura() {
        if (puntuacion == LEVEL_1_THRESHOLD && magoFigura.getNivel() == 1) {
            this.magoFigura.subirNivel();
        } else if (puntuacion == LEVEL_2_THRESHOLD && magoFigura.getNivel() == 2) {
            this.magoFigura.subirNivel();
        }

        if (puntuacion == (LEVEL_1_THRESHOLD - 1) && magoFigura.getNivel() == 2) {
            this.magoFigura.bajarNivel();
        } else if (puntuacion == (LEVEL_2_THRESHOLD -1) && magoFigura.getNivel() == 3) {
            this.magoFigura.bajarNivel();
        }
    }

    // Getters y otros métodos...


    public float getDificultad() {
        return dificultad;
    }

    public int getPuntuacion() {
        return puntuacion;
    }
}
