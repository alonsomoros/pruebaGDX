package com.alon.pruebasGDX.girarrodillos.view;

import com.alon.pruebasGDX.assets.Assets;
import com.alon.pruebasGDX.girarrodillos.model.actions.data.HeroActionData;
import com.alon.pruebasGDX.girarrodillos.model.heroes.Heroe;
import com.alon.pruebasGDX.girarrodillos.model.heroes.tipos.*;
import com.alon.pruebasGDX.girarrodillos.utils.Constants;
import com.alon.pruebasGDX.girarrodillos.utils.events.EventData;
import com.alon.pruebasGDX.girarrodillos.utils.events.EventListener;
import com.alon.pruebasGDX.girarrodillos.utils.events.EventManager;
import com.alon.pruebasGDX.girarrodillos.utils.events.EventType;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

import java.util.HashMap;
import java.util.Map;

import static com.badlogic.gdx.graphics.Color.GOLD;

public class HeroRenderer {
    // Animaciones por tipo de héroe
    private Map<Class<? extends Heroe>, Animation<TextureRegion>> idleAnimations;
    private Map<Class<? extends Heroe>, Animation<TextureRegion>> attackAnimations;

    public HeroRenderer() {
        // Inicializar mapas de animaciones
        idleAnimations = new HashMap<>();
        attackAnimations = new HashMap<>();

        // Cargar animaciones
        loadAnimations();

        // Suscribirse a eventos de acción de héroes para animaciones
        EventManager.subscribe(EventType.HERO_ACTION, new EventListener() {
            @Override
            public void onEvent(EventData data) {
                if (data instanceof HeroActionData) {
                    // Aquí podríamos activar una animación especial
                }
            }
        });
    }

    private void loadAnimations() {
        // Cargar animaciones para cada tipo de héroe
        loadHeroAnimations(Caballero.class, "caballero");
        loadHeroAnimations(Mago.class, "mago");
        loadHeroAnimations(Arquero.class, "arquero");
        loadHeroAnimations(Ingeniero.class, "ingeniero");
        loadHeroAnimations(Asesino.class, "asesino");
        loadHeroAnimations(Sacerdote.class, "sacerdote");
    }

    private void loadHeroAnimations(Class<? extends Heroe> heroClass, String prefix) {
        // Cargar animación idle
        TextureAtlas atlas = Assets.getInstance().getTextureAtlas("heroes.atlas");
        Array<TextureAtlas.AtlasRegion> idleFrames = atlas.findRegions(prefix + "_idle");
        Animation<TextureRegion> idleAnimation = new Animation<>(0.1f, idleFrames, Animation.PlayMode.LOOP);
        idleAnimations.put(heroClass, idleAnimation);

        // Cargar animación de ataque
        Array<TextureAtlas.AtlasRegion> attackFrames = atlas.findRegions(prefix + "_attack");
        Animation<TextureRegion> attackAnimation = new Animation<>(0.1f, attackFrames, Animation.PlayMode.NORMAL);
        attackAnimations.put(heroClass, attackAnimation);
    }

    public void render(SpriteBatch batch, Heroe hero, boolean isPlayer, boolean isLeft) {
        if (hero == null) return;

        // Calcular posición según si es jugador/oponente y héroe izquierdo/derecho
        float x, y;
        if (isPlayer) {
            y = Constants.COORDENADAS.PLAYER_HEROES_Y;
            x = isLeft ? Constants.COORDENADAS.LEFT_HERO_X : Constants.COORDENADAS.RIGHT_HERO_X;
        } else {
            y = Constants.COORDENADAS.OPPONENT_HEROES_Y;
            x = isLeft ? Constants.COORDENADAS.LEFT_HERO_X : Constants.COORDENADAS.RIGHT_HERO_X;
        }

        // Determinar qué animación mostrar
        Animation<TextureRegion> animation = idleAnimations.get(hero.getClass());

        // Si el héroe está en animación de ataque, mostrar esa en su lugar
        if (hero.isAttacking()) {
            animation = attackAnimations.get(hero.getClass());
        }

        if (animation != null) {
            // Obtener frame actual según el stateTime del héroe
            TextureRegion currentFrame = animation.getKeyFrame(hero.getStateTime());

            // Dibujar héroe
            batch.draw(currentFrame, x, y);

            // Renderizar indicadores de evolución
//            renderEvolutionIndicator(batch, hero, x, y);

            // Renderizar barra de energía
//            renderEnergyBar(batch, hero, x, y);
        }
    }

//    private void renderEvolutionIndicator(SpriteBatch batch, Heroe hero, float x, float y) {
//        // Renderizar un indicador según el nivel de evolución (bronce, plata, oro)
//        Texture evolutionIndicator;
//        switch (hero.getNivel()) {
//            case SILVER:
//                evolutionIndicator = Assets.getInstance().getTexture("evolution_silver");
//                break;
//            case GOLD:
//                evolutionIndicator = Assets.getInstance().getTexture("evolution_gold");
//                break;
//            default: // BRONZE
//                evolutionIndicator = Assets.getInstance().getTexture("evolution_bronze");
//                break;
//        }
//
//        batch.draw(evolutionIndicator, x + 30, y + 50, 20, 20);
//    }

//    private void renderEnergyBar(SpriteBatch batch, Heroe hero, float x, float y) {
//        // Renderizar barra de energía
//        Texture barBg = Assets.getInstance().getTexture("energy_bar_bg");
//        Texture barFill = Assets.getInstance().getTexture("energy_bar_fill");
//
//        float barWidth = 50;
//        float barHeight = 10;
//        batch.draw(barBg, x, y - 15, barWidth, barHeight);
//
//        // Calcular porcentaje de llenado
//        float fillPercentage = (float) hero.getEnergia() / hero.getRequiredEnergy();
//        batch.draw(barFill, x, y - 15, barWidth * fillPercentage, barHeight);
//    }

    public void dispose() {
        // Disposar recursos si es necesario
    }
}
