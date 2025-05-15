package com.alon.pruebasGDX.girarrodillos.view;

import com.alon.pruebasGDX.assets.Assets;
import com.alon.pruebasGDX.girarrodillos.model.Player;
import com.alon.pruebasGDX.girarrodillos.utils.Constants;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class UIRenderer {
    private BitmapFont font;
    private Texture crownTexture;
    private Texture bastionTexture;
    private Texture turnIndicator;

    public UIRenderer() {
        font = new BitmapFont();
        font.setColor(Color.WHITE);

        crownTexture = Assets.getInstance().getTexture("crown");
        bastionTexture = Assets.getInstance().getTexture("bastion");
        turnIndicator = Assets.getInstance().getTexture("turn_indicator");
    }

    public void render(SpriteBatch batch, Player player, Player opponent, boolean isPlayerTurn) {
        // Renderizar coronas y bastiones
        renderCrownAndBastion(batch, player, true);
        renderCrownAndBastion(batch, opponent, false);

        // Renderizar indicador de turno
        renderTurnIndicator(batch, isPlayerTurn);

        // Renderizar contador de tiradas restantes
        if (isPlayerTurn) {
            renderRollsLeft(batch, player.getTiradasRestantes());
        }
    }

    private void renderCrownAndBastion(SpriteBatch batch, Player player, boolean isPlayer) {
        float crownY = isPlayer ? 20 : Constants.VIEWPORT_HEIGHT - 60;

        // Renderizar corona y sus PV
        batch.draw(crownTexture, 20, crownY, 40, 40);
        font.draw(batch, "Corona: " + player.getVida() + " PV", 70, crownY + 25);

        // Renderizar bastión y su nivel
        batch.draw(bastionTexture, 200, crownY, 40, 40);
        font.draw(batch, "Bastión: " + player.getBastion().getAltura(), 250, crownY + 25);
    }

    private void renderTurnIndicator(SpriteBatch batch, boolean isPlayerTurn) {
        float y = isPlayerTurn ? 80 : Constants.VIEWPORT_HEIGHT - 120;
        batch.draw(turnIndicator, Constants.VIEWPORT_WIDTH - 60, y, 40, 40);
    }

    private void renderRollsLeft(SpriteBatch batch, int rollsLeft) {
        font.draw(batch, "Tiradas restantes: " + rollsLeft,
            Constants.VIEWPORT_WIDTH - 150, 20);
    }

    public void dispose() {
        font.dispose();
    }
}
