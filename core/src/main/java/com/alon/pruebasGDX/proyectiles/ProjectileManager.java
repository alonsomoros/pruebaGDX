package com.alon.pruebasGDX.proyectiles;

import com.alon.pruebasGDX.Prueba1;
import com.alon.pruebasGDX.ScoreManager;
import com.alon.pruebasGDX.assets.Assets;
import com.alon.pruebasGDX.utils.CollisionHandler;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

public class ProjectileManager {

    private static final float FIREBALL_SPAWN_RATE = 1f;
    private static final float WATERBALL_SPAWN_RATE = 1f;
    private static final float BASE_PROJECTILE_SPEED = 200f;

    private Array<Fireball> fireballs;
    private Array<Waterball> waterballs;
    private Animation<TextureAtlas.AtlasRegion> fireballAnimation;
    private Animation<TextureAtlas.AtlasRegion> waterballAnimation;
    private float fireballTimer;
    private float waterballTimer;
    private float dificultad;
    private final Prueba1 game;
    private final ScoreManager scoreManager;

    public ProjectileManager(Prueba1 game, ScoreManager scoreManager) {
        this.game = game;
        this.scoreManager = scoreManager;
        this.fireballs = new Array<>();
        this.waterballs = new Array<>();
        this.fireballAnimation = new Animation<>(0.1f, Assets.assetManager.get(Assets.FIREBALL_ATLAS, TextureAtlas.class).getRegions());
        this.waterballAnimation = new Animation<>(0.1f, Assets.assetManager.get(Assets.WATERBALL_ATLAS, TextureAtlas.class).getRegions());
        this.fireballTimer = 0;
        this.waterballTimer = 0;
    }

    public void update(float deltaTime, float dificultad) {
        this.dificultad = dificultad;
        updateProjectiles(deltaTime);
    }

    public void render(float delta, SpriteBatch batch, Rectangle playerHitbox, CollisionHandler collisionHandler) {
        for (Fireball fireball : fireballs) {
            processProjectile(delta, fireball, fireballAnimation, batch, playerHitbox, collisionHandler);
        }
        for (Waterball waterball : waterballs) {
            processProjectile(delta, waterball, waterballAnimation, batch, playerHitbox, collisionHandler);
        }
    }

    public void dispose() {
        fireballs.forEach(fireball -> fireball.getProyectilSprite().getTexture().dispose());
        waterballs.forEach(waterball -> waterball.getProyectilSprite().getTexture().dispose());
        fireballAnimation.getKeyFrame(0).getTexture().dispose();
        waterballAnimation.getKeyFrame(0).getTexture().dispose();
        fireballs.clear();
        waterballs.clear();
    }

    public void updateProjectiles(float deltaTime) {
        updateFireball(deltaTime);
        updateWaterball(deltaTime);
    }


    private void removeProjectile(ProyectilMinigame proyectil) {
        if (proyectil instanceof Fireball) {
            fireballs.removeValue((Fireball)proyectil, true);
        } else if (proyectil instanceof Waterball) {
            waterballs.removeValue((Waterball)proyectil, true);
        }
    }

    private void handleCollision(ProyectilMinigame proyectil) {
        if (proyectil instanceof Fireball) {
            fireballs.removeValue((Fireball)proyectil, true);
            dificultad -= 0.1f;
            scoreManager.addScore(-1);
        } else if (proyectil instanceof Waterball) {
            waterballs.removeValue((Waterball)proyectil, true);
            scoreManager.addScore(1);
            dificultad += 0.2f;
        }

        proyectil.getProyectilSound().play(0.2f);
    }

    public void updateFireball(float deltaTime) {
        for (Fireball fireball : fireballs) {
            fireball.updateAnimationTime(deltaTime);
        }

        fireballTimer += deltaTime * MathUtils.random(0,3f + dificultad);
        if (fireballTimer > FIREBALL_SPAWN_RATE) {
            fireballTimer = 0;
            createFireballs();
        }
    }

    public void updateWaterball(float deltaTime) {
        for (Waterball waterball : waterballs) {
            waterball.updateAnimationTime(deltaTime);
        }

        waterballTimer += deltaTime * MathUtils.random(0,1f);
        if (waterballTimer > WATERBALL_SPAWN_RATE) {
            waterballTimer = 0;
            createWaterballs();
        }
    }

    private void createFireballs() {
        float fireballWidth = fireballAnimation.getKeyFrame(0).getRegionWidth();
        Fireball fireball = new Fireball(MathUtils.random(0, game.V_WIDTH - fireballWidth), game.V_HEIGHT);
        fireballs.add(fireball);
    }

    private void createWaterballs() {
        float waterballWidth = waterballAnimation.getKeyFrame(0).getRegionWidth();
        Waterball waterball = new Waterball(MathUtils.random(0, game.V_WIDTH - waterballWidth), game.V_HEIGHT);
        waterballs.add(waterball);
    }

    private void processProjectile(float delta, ProyectilMinigame proyectil, Animation<TextureAtlas.AtlasRegion> animation,
                                   SpriteBatch batch, Rectangle playerHitbox, CollisionHandler collisionHandler) {
        TextureRegion region = animation.getKeyFrame(proyectil.getAnimationTime(), true);

        // Actualiza posición
        proyectil.getProyectilSprite().translateY(-BASE_PROJECTILE_SPEED * delta);
        proyectil.getProyectilHitbox().setPosition(
            proyectil.getProyectilSprite().getX(),
            proyectil.getProyectilSprite().getY()
        );

        // Comprueba si está fuera de pantalla
        if (proyectil.getProyectilSprite().getY() < -proyectil.getProyectilSprite().getHeight()) {
            removeProjectile(proyectil);
            return;
        }

        // Comprueba colisión con el hitbox del jugador pasado como parámetro
        if (playerHitbox.overlaps(proyectil.getProyectilHitbox())) {
            removeProjectile(proyectil);
            // Notifica la colisión al manejador
            collisionHandler.onCollision(proyectil);
        }

        // Dibuja
        proyectil.getProyectilSprite().setTexture(region.getTexture());
        proyectil.getProyectilSprite().setRegion(region);
        proyectil.getProyectilSprite().draw(batch);
    }
}
