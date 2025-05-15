package com.alon.pruebasGDX.girarrodillos.controller;

import com.alon.pruebasGDX.girarrodillos.input.InputHandler;
import com.alon.pruebasGDX.girarrodillos.model.GameState;
import com.alon.pruebasGDX.girarrodillos.model.Player;
import com.alon.pruebasGDX.girarrodillos.model.actions.Action;
import com.alon.pruebasGDX.girarrodillos.model.actions.data.HeroActionData;
import com.alon.pruebasGDX.girarrodillos.model.heroes.Heroe;
import com.alon.pruebasGDX.girarrodillos.model.states.GameOverState;
import com.alon.pruebasGDX.girarrodillos.model.states.OpponentTurnState;
import com.alon.pruebasGDX.girarrodillos.model.states.PlayerTurnState;
import com.alon.pruebasGDX.girarrodillos.model.wheel.WheelSet;
import com.alon.pruebasGDX.girarrodillos.model.wheel.WheelSymbol;
import com.alon.pruebasGDX.girarrodillos.utils.events.EventManager;
import com.alon.pruebasGDX.girarrodillos.utils.events.EventType;

import java.util.Map;

public class GameController {

    // Estados del juego
    private GameState currentState;

    // Modelo
    private Player player;
    private Player opponent;
    private WheelSet playerWheelSet;
    private WheelSet opponentWheelSet;

    // Controladores subordinados
    private WheelController wheelController;
    private CombatController combatController;
    private AIController aiController;


    // Constructor
    public GameController() {

        // Inicializar controladores subordinados
        wheelController = new WheelController();
        combatController = new CombatController();
        aiController = new AIController();

        // Inicializar modelo
        initializeGame();

        // Configurar el primer estado
        changeState(new PlayerTurnState());
    }

    // Inicializa un nuevo juego
    public void initializeGame() {
        // Crear jugadores con PV de corona iniciales
        player = new Player(); // Vida inicial de la corona
        opponent = new Player();

        // Crear rodillos de jugador y oponente
        createWheels();

        // Notificar que el juego está listo
        EventManager.notify(EventType.GAME_INITIALIZED, null);
    }

    private void createWheels() {
        // Crear y configurar los rodillos
        playerWheelSet = new WheelSet();
        opponentWheelSet = new WheelSet();
    }

    // Cambiar el estado actual del juego
    public void changeState(GameState newState) {
        if (currentState != null) {
            currentState.exit(this);
        }
        currentState = newState;
        currentState.enter(this);
    }

    // Actualizar la lógica del juego
    public void update(float delta) {
        // Actualizar el estado actual
        if (currentState != null) {
            currentState.update(delta, this);
        }

        // Comprobar condiciones de victoria/derrota
        checkGameEndConditions();
    }

    // Manejar la entrada del usuario
    public void handleInput(InputHandler inputHandler) {
        if (currentState != null) {
            currentState.handleInput(inputHandler, this);
        }
    }

    // Procesar una tirada de rodillos del jugador
    public void processPlayerSpin() {
        wheelController.spinWheels(playerWheelSet);

        // Comprobar combinaciones después de la tirada
        checkCombinations(player, playerWheelSet);

        // Reducir el contador de tiradas
        player.disminuirTiradas();

        // Si no quedan tiradas, pasar al turno del oponente
        if (player.getTiradasRestantes() <= 0) {
            changeState(new OpponentTurnState());
        }
    }

    // Comprobar combinaciones en los rodillos
    private void checkCombinations(Player currentPlayer, WheelSet wheels) {
        // Contar símbolos por tipo
        Map<WheelSymbol, Integer> symbolCounts = wheels.countResultSymbols(); // Un Map con los simbolos q salieron y cuanto

        // Procesar energía para héroe izquierdo (cuadrado)
        if (symbolCounts.containsKey(WheelSymbol.CUADRADO_ENERGIA_1)) {
            int squareCount = symbolCounts.get(WheelSymbol.CUADRADO_ENERGIA_1);
            int energyGained = calculateEnergyGain(squareCount);
            currentPlayer.getHeroeIzquierda().sumaEnergia(energyGained);
        }

        // Procesar energía para héroe derecho (rombo)
        if (symbolCounts.containsKey(WheelSymbol.ROMBO_ENERGIA_1)) {
            int diamondCount = symbolCounts.get(WheelSymbol.ROMBO_ENERGIA_1);
            int energyGained = calculateEnergyGain(diamondCount);
            currentPlayer.getHeroeDerecha().sumaEnergia(energyGained);
        }

        // Procesar refuerzo de bastión (martillo)
        if (symbolCounts.containsKey(WheelSymbol.BASTION_1)) {
            int hammerCount = symbolCounts.get(WheelSymbol.BASTION_1);
            int bastionGain = calculateEnergyGain(hammerCount);
            currentPlayer.getBastion().aumentaAltura(bastionGain);
        }

        // Activar héroes si tienen suficiente energía
        checkHeroActivation(currentPlayer);
    }

    // Calcular ganancia de energía según la regla "3 del mismo tipo + 1"
    private int calculateEnergyGain(int count) {
        if (count < 3) return 0;
        return count - 2; // 3=1, 4=2, 5=3, etc.
    }

    // Verificar si los héroes pueden activarse
    private void checkHeroActivation(Player player) {
        Heroe leftHero = player.getHeroeIzquierda();
        Heroe rightHero = player.getHeroeDerecha();

        // Activar héroe izquierdo si tiene energía completa
        if (leftHero.canAct()) {
            // Ejecutar acción del héroe
            Action leftAction = leftHero.createAction();
            combatController.executeAction(leftAction, player, getOppositePlayer(player));

            // Reiniciar energía del héroe
            leftHero.resetEnergia();

            // Dar EXP al héroe
            leftHero.sumaExperiencia(2);

            // Notificar que el héroe actuó
            EventManager.notify(EventType.HERO_ACTION, new HeroActionData(leftHero, leftAction));
        }

        // Activar héroe derecho si tiene energía completa
        if (rightHero.canAct()) {
            // Similar al héroe izquierdo
            Action rightAction = rightHero.createAction();
            combatController.executeAction(rightAction, player, getOppositePlayer(player));
            rightHero.resetEnergia();
            rightHero.sumaExperiencia(2);
            EventManager.notify(EventType.HERO_ACTION, new HeroActionData(rightHero, rightAction));
        }
    }

    // Obtener el jugador opuesto
    private Player getOppositePlayer(Player currentPlayer) {
        return currentPlayer == player ? opponent : player;
    }

    // Comprobar condiciones de fin de juego
    private void checkGameEndConditions() {
        if (player.getVida() <= 0) {
            // El jugador ha perdido
            changeState(new GameOverState(false));
        } else if (opponent.getVida() <= 0) {
            // El jugador ha ganado
            changeState(new GameOverState(true));
        }
    }

    // Getters y setters
    public Player getPlayer() {
        return player;
    }

    public Player getOpponent() {
        return opponent;
    }

    public WheelSet getPlayerWheelSet() {
        return playerWheelSet;
    }

    public WheelController getWheelController() {
        return wheelController;
    }

    public CombatController getCombatController() {
        return combatController;
    }

    public boolean isPlayerTurn() {
        return currentState instanceof PlayerTurnState;
    }

    // Funcion para bloquear/desbloquear un rodillo específico
    public void toggleWheelLock(int wheelIndex) {
        if (isPlayerTurn() && wheelIndex >= 0 && wheelIndex < playerWheelSet.getWheelsCount()) {
            playerWheelSet.getWheel(wheelIndex).toggleLocked();
        }
    }

    public WheelSet getOpponentWheelSet() {
        return opponentWheelSet;
    }
}
