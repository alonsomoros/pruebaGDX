package com.alon.pruebasGDX.girarrodillos.view;

import com.alon.pruebasGDX.assets.Assets;
import com.alon.pruebasGDX.girarrodillos.controller.GameController;
import com.alon.pruebasGDX.girarrodillos.model.actions.Action;
import com.alon.pruebasGDX.girarrodillos.model.actions.data.HeroActionData;
import com.alon.pruebasGDX.girarrodillos.model.heroes.Heroe;
import com.alon.pruebasGDX.girarrodillos.utils.events.EventData;
import com.alon.pruebasGDX.girarrodillos.utils.events.EventListener;
import com.alon.pruebasGDX.girarrodillos.utils.events.EventManager;
import com.alon.pruebasGDX.girarrodillos.utils.events.EventType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.alon.pruebasGDX.girarrodillos.utils.Constants;

import java.util.ArrayList;

public class GameRenderer {
    private SpriteBatch batch;
    private GameController gameController;
    private OrthographicCamera camera;

    private HeroRenderer heroRenderer;
    private WheelRenderer wheelRenderer;
    private UIRenderer uiRenderer;

    // Para efectos visuales
    private ArrayList<VisualEffect> activeEffects;

    public GameRenderer(GameController gameController) {
        this.gameController = gameController;
        this.batch = new SpriteBatch();
        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(false, Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);

        // Inicializar renderers específicos
        this.heroRenderer = new HeroRenderer();
        this.wheelRenderer = new WheelRenderer();
        this.uiRenderer = new UIRenderer();

        this.activeEffects = new ArrayList<>();

        // Suscribirse a eventos para efectos visuales
        EventManager.subscribe(EventType.HERO_ACTION, new EventListener() {
            @Override
            public void onEvent(EventData data) {
                if (data instanceof HeroActionData) {
                    HeroActionData actionData = (HeroActionData) data;
                    addActionEffect(actionData);
                }
            }
        });
    }

    public void render() {
        // Limpiar pantalla
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Actualizar cámara
        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();

        // Renderizar fondo
        renderBackground();

        // Renderizar rodillos
        wheelRenderer.render(batch, gameController.getPlayerWheelSet(), true); // Rodillos del jugador
        wheelRenderer.render(batch, gameController.getOpponentWheelSet(), false); // Rodillos del oponente

        // Renderizar héroes
        heroRenderer.render(batch, gameController.getPlayer().getHeroeIzquierda(), true, true); // Héroe izquierdo jugador
        heroRenderer.render(batch, gameController.getPlayer().getHeroeDerecha(), true, false); // Héroe derecho jugador
        heroRenderer.render(batch, gameController.getOpponent().getHeroeIzquierda(), false, true); // Héroe izquierdo oponente
        heroRenderer.render(batch, gameController.getOpponent().getHeroeDerecha(), false, false); // Héroe derecho oponente

        // Renderizar UI (coronas, bastiones, indicadores de energía, etc)
        uiRenderer.render(batch,
            gameController.getPlayer(),
            gameController.getOpponent(),
            gameController.isPlayerTurn());

        // Renderizar efectos visuales activos
        renderVisualEffects(Gdx.graphics.getDeltaTime());

        batch.end();
    }

    private void renderBackground() {
        Texture backgroundTexture = Assets.getInstance().getTexture(Assets.BACKGROUND_WHEELS_PATH);
        batch.draw(backgroundTexture, 0, 0, Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);
    }

    private void renderVisualEffects(float delta) {
        // Actualizar y renderizar efectos, eliminando los completados
        Iterator<VisualEffect> iterator = activeEffects.iterator();
        while (iterator.hasNext()) {
            VisualEffect effect = iterator.next();
            effect.update(delta);
            effect.render(batch);

            if (effect.isFinished()) {
                iterator.remove();
            }
        }
    }

    private void addActionEffect(HeroActionData actionData) {
        Heroe hero = actionData.getHero();
        Action action = actionData.getAction();

        // Crear efecto visual según el tipo de acción
        VisualEffect effect = VisualEffectFactory.createEffect(hero, action);
        if (effect != null) {
            activeEffects.add(effect);
        }
    }

    public void dispose() {
        batch.dispose();
        heroRenderer.dispose();
        wheelRenderer.dispose();
        uiRenderer.dispose();
    }

    // Métodos para redimensionar, etc.
    public void resize(int width, int height) {
        // Ajustar viewport...
    }
}
