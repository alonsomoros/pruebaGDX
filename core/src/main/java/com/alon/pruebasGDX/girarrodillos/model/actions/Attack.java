package com.alon.pruebasGDX.girarrodillos.model.actions;

import com.alon.pruebasGDX.girarrodillos.controller.CombatController;
import com.alon.pruebasGDX.girarrodillos.model.Player;
import com.alon.pruebasGDX.girarrodillos.model.heroes.Heroe;

public class Attack implements Action {
    private int danyo;
    private int altura; // Altura del ataque (para determinar si pasa por encima del bastión)
    private Heroe heroOrigen;

    public Attack(Heroe heroeOrigen, int danyo, int altura) {
        this.heroOrigen = heroeOrigen;
        this.danyo = danyo;
        this.altura = altura;
    }

    @Override
    public void execute(CombatController combatController, Player source, Player target) {
        combatController.processAttack(source, target, danyo, altura);
    }

    @Override
    public String getDescription() {
        return heroOrigen.getClass().getName() + " ataca por " + danyo + " de daño a altura " + altura;
    }

    @Override
    public ActionType getType() {
        return ActionType.ATTACK;
    }

    // Getters
    public int getDanyo() {
        return danyo;
    }

    public int getAltura() {
        return altura;
    }

    public Heroe getHeroOrigen() {
        return heroOrigen;
    }
}
