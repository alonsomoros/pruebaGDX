package com.alon.pruebasGDX.screens;

import com.alon.pruebasGDX.assets.AssetCategory;
import com.alon.pruebasGDX.minigame.FiguraMinigame;
import com.alon.pruebasGDX.minigame.ScoreManagerMinigame;
import com.alon.pruebasGDX.minigame.proyectiles.Fireball;
import com.alon.pruebasGDX.Prueba1;
import com.alon.pruebasGDX.minigame.proyectiles.ProjectileManager;
import com.alon.pruebasGDX.minigame.proyectiles.ProyectilMinigame;
import com.alon.pruebasGDX.minigame.proyectiles.Waterball;
import com.alon.pruebasGDX.assets.Assets;
import com.alon.pruebasGDX.minigame.CollisionHandler;
import com.alon.pruebasGDX.utils.Settings;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class MinigameScreen extends BaseScreen implements CollisionHandler {

    private static final float VELOCIDAD_MAGO = 400; // píxeles por segundo

    private Vector2 touchPos = new Vector2();

    private ProjectileManager projectileManager;
    private ScoreManagerMinigame scoreManager;
    private FiguraMinigame magoFigura;

    public MinigameScreen(Prueba1 game) {
        super(game);
//        Assets.loadCategory(AssetCategory.MINIGAME);
        this.music = Assets.assetManager.get(Assets.MINIGAME_MUSIC_PATH);
        this.magoFigura = new FiguraMinigame();
        this.scoreManager = new ScoreManagerMinigame(magoFigura);
        this.projectileManager = new ProjectileManager(game);
    }

    @Override
    protected void buildUI() {
        Table mainTable = new Table();
        mainTable.setFillParent(true);
        stage.addActor(mainTable);// Primero el stage (para los botones)
    }

    public void update() {
        float deltaTime = Gdx.graphics.getDeltaTime();
        handlePlayerInput(deltaTime);
        projectileManager.update(deltaTime, scoreManager.getDificultad());
    }

    public void draw(float delta) {

        clearScreen();
        drawBackground();

        game.batcher.enableBlending(); // Vuelve a activar el canal alfa para dibujar la animación
        game.batcher.begin();

        projectileManager.render(delta, game.batcher, magoFigura.getHitbox(), this);
        magoFigura.render(game.batcher);

        game.batcher.end();

        stage.act();
        stage.draw();
    }

    public void clearScreen() {
        GL20 gl = Gdx.gl;
        gl.glClearColor(0.88235f, 0.91765f, 0.90588f, 1f);
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        game.batcher.setProjectionMatrix(camera.combined);
    }

    private void drawBackground() {
        game.batcher.disableBlending();
        game.batcher.begin();
        game.batcher.draw(Assets.getTexture(Assets.BACKGROUND_MINIGAME_PATH), 0, 0, game.V_WIDTH, game.V_HEIGHT);
        game.batcher.draw(Assets.getTexture(Assets.BACKGROUND_SUELO_PATH), 0, 0, game.V_WIDTH,
                Assets.getTexture(Assets.BACKGROUND_SUELO_PATH).getHeight());
        Texture fuentePixel = Assets.getTexture(Assets.FUENTE_PIXEL_PNG_PATH);
        fuentePixel.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        BitmapFont bf = Assets.getBitmapFont(Assets.FUENTE_PIXEL_TTF_PATH);
        bf.getData().setScale(1f);
        bf.draw(game.batcher, "Puntuacion: " + scoreManager.getPuntuacion(), 10, game.V_HEIGHT - 10);
        game.batcher.end();
    }

//    @Override
//    public void show() {
//
//    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update();
        draw(delta);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void pause() {
        Settings.save();
        if (music.isPlaying()) {
            music.pause();
        }
        Gdx.app.log("Pausa", "Juego pausado");
    }

    @Override
    public void dispose() {
        super.dispose();
        projectileManager.dispose();
        stage.dispose();
        Assets.pruebaUnloadCategory(this);
    }

    // Métodos de InputProcessor

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.ESCAPE:
                game.showMainMenu();
                return true;
        }
        return false;
    }

    @Override
    public void onCollision(ProyectilMinigame proyectil) {
        if (proyectil instanceof Fireball) {
            scoreManager.addScore(-1);
        } else if (proyectil instanceof Waterball) {
            scoreManager.addScore(1);
        }
        proyectil.getProyectilSound().play(0.2f);
    }

    public void handlePlayerInput(float deltaTime) {
        // Movimiento con teclas A y D
        if (Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            magoFigura.setPosition(magoFigura.getSprite().getX() - VELOCIDAD_MAGO * deltaTime, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            magoFigura.setPosition(magoFigura.getSprite().getX() + VELOCIDAD_MAGO * deltaTime, 0);
        }

        if (Gdx.input.isTouched()) { // Detectar si la pantalla ha sido tocada.
            touchPos.set(Gdx.input.getX(), Gdx.input.getY()); // Obtener la posición del toque en la pantalla.
            viewport.unproject(touchPos); // Convertir las coordenadas de la pantalla a coordenadas del mundo.
            magoFigura.getSprite().setCenterX(touchPos.x); // Limita el desplazamiento al eje X del Sprite.
        }

        // Opcional: Limitar el movimiento dentro de la pantalla
        magoFigura.setPosition(Math.max(0, Math.min(magoFigura.getSprite().getX(), game.V_WIDTH - 125)), 0);
        magoFigura.actualizarHitbox();
    }
}
