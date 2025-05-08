package com.alon.pruebasGDX;

import com.alon.pruebasGDX.assets.Assets;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Figura {
    private Sprite sprite;
    private int nivel;

    public Figura() {
        this.nivel = 1;
        this.sprite = new Sprite(Assets.loadTexture(Assets.FIGURA_MAGO_1));
        this.sprite.setSize(125f, 145f);
    }
    public Sprite getSprite() {
        return sprite;
    }
    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }
    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public void subirNivel() {
        float oldX = 0;
        float oldY = 0;

        // Guardar posición actual si el sprite existe
        if (sprite != null) {
            oldX = sprite.getX();
            oldY = sprite.getY();
        }

        this.nivel++;
        Gdx.app.log("Nivel", nivel + "!!");

        if (nivel > 3) {
            nivel = 1;
        }

        if (sprite == null) {
            sprite = new Sprite(Assets.loadTexture(Assets.FIGURA_MAGO_1));
        } else {
            switch (nivel) {
                case 1:
                    this.sprite = new Sprite(Assets.loadTexture(Assets.FIGURA_MAGO_1));
                    break;
                case 2:
                    this.sprite = new Sprite(Assets.loadTexture(Assets.FIGURA_MAGO_2));
                    break;
                case 3:
                    this.sprite = new Sprite(Assets.loadTexture(Assets.FIGURA_MAGO_3));
                    break;
            }
        }

        // Restaurar posición y establecer tamaño constante
        this.sprite.setPosition(oldX, oldY);
        this.sprite.setSize(125f, 145f);
    }

    public void bajarNivel() {
        float oldX = 0;
        float oldY = 0;

        // Guardar posición actual si el sprite existe
        if (sprite != null) {
            oldX = sprite.getX();
            oldY = sprite.getY();
        }

        this.nivel--;
        Gdx.app.log("Nivel", nivel + " :(");

        if (nivel < 1) {
            nivel = 1;
        }

        if (sprite == null) {
            sprite = new Sprite(Assets.loadTexture(Assets.FIGURA_MAGO_1));
        } else {
            switch (nivel) {
                case 1:
                    this.sprite = new Sprite(Assets.loadTexture(Assets.FIGURA_MAGO_1));
                    break;
                case 2:
                    this.sprite = new Sprite(Assets.loadTexture(Assets.FIGURA_MAGO_2));
                    break;
                case 3:
                    this.sprite = new Sprite(Assets.loadTexture(Assets.FIGURA_MAGO_3));
                    break;
            }
        }

        // Restaurar posición y establecer tamaño constante
        this.sprite.setPosition(oldX, oldY);
        this.sprite.setSize(125f, 145f);
    }
}
