package com.alon.pruebasGDX.girarrodillos.model.actions;

import com.alon.pruebasGDX.girarrodillos.controller.CombatController;
import com.alon.pruebasGDX.girarrodillos.model.Player;
import com.alon.pruebasGDX.girarrodillos.model.actions.data.EnergyBoostData;
import com.alon.pruebasGDX.girarrodillos.model.heroes.Heroe;
import com.alon.pruebasGDX.girarrodillos.utils.events.EventManager;
import com.alon.pruebasGDX.girarrodillos.utils.events.EventType;

public class Help implements Action {
    private int energyAmount;
    private Heroe source;
    private boolean targetLeftHero; // true = izquierdo, false = derecho

    public Help(Heroe source, int energyAmount, boolean targetLeftHero) {
        this.source = source;
        this.energyAmount = energyAmount;
        this.targetLeftHero = targetLeftHero;
    }

    @Override
    public void execute(CombatController combatController, Player sourcePlayer, Player targetPlayer) {
        // El objetivo es el compañero del héroe
        Heroe targetHero = targetLeftHero ? sourcePlayer.getHeroeIzquierda() : sourcePlayer.getHeroeDerecha();
        targetHero.sumaEnergia(energyAmount);

        EventManager.notify(EventType.HERO_HELP,
            new EnergyBoostData(source, targetHero, energyAmount));
    }

    @Override
    public String getDescription() {
        return source.getClass().getName() + " proporciona " + energyAmount + " de energía a su compañero";
    }

    @Override
    public ActionType getType() {
        return ActionType.HELP;
    }
}
