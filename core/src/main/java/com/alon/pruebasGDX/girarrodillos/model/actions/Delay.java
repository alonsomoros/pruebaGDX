package com.alon.pruebasGDX.girarrodillos.model.actions;

import com.alon.pruebasGDX.girarrodillos.controller.CombatController;
import com.alon.pruebasGDX.girarrodillos.model.Player;
import com.alon.pruebasGDX.girarrodillos.model.actions.data.HeroDelayData;
import com.alon.pruebasGDX.girarrodillos.model.heroes.Heroe;
import com.alon.pruebasGDX.girarrodillos.utils.events.EventManager;
import com.alon.pruebasGDX.girarrodillos.utils.events.EventType;

public class Delay implements Action {
    private Heroe source;
    private int delayAmount;

    public Delay(Heroe source, int delayAmount) {
        this.source = source;
        this.delayAmount = delayAmount;
    }

    @Override
    public void execute(CombatController combatController, Player sourcePlayer, Player targetPlayer) {
        // Encontrar el héroe con menos energía para actuar
        Heroe leftHero = targetPlayer.getHeroeIzquierda();
        Heroe rightHero = targetPlayer.getHeroeDerecha();

        // Comparar energía restante para actuar
        int leftEnergy = leftHero.getEnergiaNecesaria() - leftHero.getEnergia();
        int rightEnergy = rightHero.getEnergiaNecesaria() - rightHero.getEnergia();

        Heroe targetHero = (leftEnergy <= rightEnergy) ? leftHero : rightHero;

        // Retrasar al héroe objetivo
        targetHero.restaEnergia(delayAmount);

        EventManager.notify(EventType.HERO_DELAYED,
            new HeroDelayData(source, targetHero, delayAmount));
    }

    @Override
    public String getDescription() {
        return source.getClass().getName() + " retrasa al héroe enemigo más cercano a actuar";
    }

    @Override
    public ActionType getType() {
        return ActionType.DELAY;
    }
}
