package com.alon.pruebasGDX.minigame;

import com.alon.pruebasGDX.assets.Assets;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class FiguraMinigame implements GameElement {
    private Sprite sprite;
    private int nivel;

    private final Rectangle hitbox;

    private float hitboxOffsetX;
    private float hitboxOffsetY;
    private float hitboxWidth;
    private float hitboxHeight;

    public FiguraMinigame() {
        this.nivel = 1;
        this.sprite = new Sprite(Assets.loadTexture(Assets.FIGURA_MAGO_1_PATH));
        this.sprite.setSize(125f, 145f);
        // Valores predeterminados para el hitbox (más pequeño que el sprite)
        this.hitboxOffsetX = 35f; // Ajusta según necesites
        this.hitboxOffsetY = 20f; // Ajusta según necesites
        this.hitboxWidth = 55f;   // Ancho del hitbox
        this.hitboxHeight = 105f; // Alto del hitbox

        // Inicializa el hitbox con estos valores
        this.hitbox = new Rectangle(
            sprite.getX() + hitboxOffsetX,
            sprite.getY() + hitboxOffsetY,
            hitboxWidth,
            hitboxHeight
        );
    }

    @Override
    public void update(float deltaTime) {
        actualizarHitbox();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(sprite, sprite.getX(), 0, 125, 145);
    }

    public Sprite getSprite() {
        return sprite;
    }
    public int getNivel() {
        return nivel;
    }
    public void actualizarHitbox() {
        if (sprite != null && hitbox != null) {
            hitbox.x = sprite.getX() + hitboxOffsetX;
            hitbox.y = sprite.getY() + hitboxOffsetY;
        }
    }

    public void configurarHitbox(float offsetX, float offsetY, float width, float height) {
        this.hitboxOffsetX = offsetX;
        this.hitboxOffsetY = offsetY;
        this.hitboxWidth = width;
        this.hitboxHeight = height;

        // Actualiza el hitbox con los nuevos valores
        actualizarHitbox();
    }

    public void setPosition(float x, float y) {
        if (sprite != null) {
            sprite.setPosition(x, y);
            actualizarHitbox();
        }
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
            sprite = new Sprite(Assets.loadTexture(Assets.FIGURA_MAGO_1_PATH));
        } else {
            switch (nivel) {
                case 1:
                    this.sprite = new Sprite(Assets.loadTexture(Assets.FIGURA_MAGO_1_PATH));
                    break;
                case 2:
                    this.sprite = new Sprite(Assets.loadTexture(Assets.FIGURA_MAGO_2_PATH));
                    break;
                case 3:
                    this.sprite = new Sprite(Assets.loadTexture(Assets.FIGURA_MAGO_3_PATH));
                    break;
            }
        }

        // Restaurar posición y establecer tamaño constante
        this.sprite.setPosition(oldX, oldY);
        this.sprite.setSize(125f, 145f);
        Assets.getSound(Assets.LEVEL_UP_SOUND_PATH).play(0.2f);
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
            sprite = new Sprite(Assets.loadTexture(Assets.FIGURA_MAGO_1_PATH));
        } else {
            switch (nivel) {
                case 1:
                    this.sprite = new Sprite(Assets.loadTexture(Assets.FIGURA_MAGO_1_PATH));
                    break;
                case 2:
                    this.sprite = new Sprite(Assets.loadTexture(Assets.FIGURA_MAGO_2_PATH));
                    break;
            }
        }

        // Restaurar posición y establecer tamaño constante
        this.sprite.setPosition(oldX, oldY);
        this.sprite.setSize(125f, 145f);
        Assets.getSound(Assets.LEVEL_DOWN_SOUND_PATH).play(0.2f);
    }

    public Rectangle getHitbox() {
        return hitbox;
    }
}
