package com.alon.pruebasGDX.girarrodillos.model.actions;

import com.alon.pruebasGDX.girarrodillos.controller.CombatController;
import com.alon.pruebasGDX.girarrodillos.model.Player;
import com.alon.pruebasGDX.girarrodillos.model.actions.data.BastionBoostData;
import com.alon.pruebasGDX.girarrodillos.model.heroes.Heroe;
import com.alon.pruebasGDX.girarrodillos.utils.events.EventManager;
import com.alon.pruebasGDX.girarrodillos.utils.events.EventType;

public class BastionRaise implements Action {
    private Heroe source;
    private int boostAmount;

    public BastionRaise(Heroe source, int boostAmount) {
        this.source = source;
        this.boostAmount = boostAmount;
    }

    @Override
    public void execute(CombatController combatController, Player sourcePlayer, Player targetPlayer) {
        sourcePlayer.getBastion().aumentaAltura(boostAmount);

        EventManager.notify(EventType.BASTION_BOOST,
            new BastionBoostData(source, boostAmount));
    }

    @Override
    public String getDescription() {
        return source.getClass().getName() + " fortalece el bastión en " + boostAmount + " niveles";
    }

    @Override
    public ActionType getType() {
        return ActionType.BASTION_RAISE;
    }
}
