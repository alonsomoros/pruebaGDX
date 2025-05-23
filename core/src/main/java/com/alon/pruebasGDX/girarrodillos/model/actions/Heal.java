package com.alon.pruebasGDX.girarrodillos.model.actions;

import com.alon.pruebasGDX.girarrodillos.controller.CombatController;
import com.alon.pruebasGDX.girarrodillos.model.Player;
import com.alon.pruebasGDX.girarrodillos.model.actions.data.CrownHealData;
import com.alon.pruebasGDX.girarrodillos.model.heroes.Heroe;
import com.alon.pruebasGDX.girarrodillos.utils.events.EventManager;
import com.alon.pruebasGDX.girarrodillos.utils.events.EventType;

public class Heal implements Action {
    private int cantidad;
    private Heroe heroeOrigen;

    public Heal(Heroe heroeOrigen, int cantidad) {
        this.heroeOrigen = heroeOrigen;
        this.cantidad = cantidad;
    }

    @Override
    public void execute(CombatController combatController, Player sourcePlayer, Player targetPlayer) {
        // En este caso, el objetivo es el propio jugador
        sourcePlayer.curar(cantidad);
        EventManager.notify(EventType.CROWN_HEALED,
            new CrownHealData(sourcePlayer, cantidad));
    }

    @Override
    public String getDescription() {
        return heroeOrigen.getClass().getName() + " cura " + cantidad + " PV a la corona";
    }

    @Override
    public ActionType getType() {
        return ActionType.HEAL;
    }
}
