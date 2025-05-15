package com.alon.pruebasGDX.girarrodillos.model.states;

import com.alon.pruebasGDX.girarrodillos.controller.GameController;
import com.alon.pruebasGDX.girarrodillos.input.InputHandler;
import com.alon.pruebasGDX.girarrodillos.model.GameState;
import com.alon.pruebasGDX.girarrodillos.utils.events.EventManager;
import com.alon.pruebasGDX.girarrodillos.utils.events.EventType;
import com.alon.pruebasGDX.girarrodillos.view.GameRenderer;

public class PlayerTurnState implements GameState {

    @Override
    public void enter(GameController controller) {
        // Resetear el número de tiradas disponibles
        controller.getPlayer().resetTiradas();
        // Desbloquear todos los rodillos para el nuevo turno
        controller.getPlayerWheelSet().resetLocks();

        // Notificar que es turno del jugador
        EventManager.notify(EventType.PLAYER_TURN_START, null);
    }

    @Override
    public void update(float delta, GameController controller) {
        // Cualquier lógica de actualización específica del turno del jugador
    }

    @Override
    public void handleInput(InputHandler inputHandler, GameController controller) {
        // La entrada se maneja a través de los comandos configurados en InputHandler
    }

    @Override
    public void exit(GameController controller) {
        // Notificar que termina el turno del jugador
        EventManager.notify(EventType.PLAYER_TURN_END, null);
    }

    @Override
    public void render(GameRenderer renderer, GameController controller) {

    }
}
