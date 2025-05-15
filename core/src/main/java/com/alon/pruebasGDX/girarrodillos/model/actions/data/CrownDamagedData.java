package com.alon.pruebasGDX.girarrodillos.model.actions.data;

import com.alon.pruebasGDX.girarrodillos.model.Player;
import com.alon.pruebasGDX.girarrodillos.utils.events.EventData;

public class CrownDamagedData implements EventData {
    private final int damage;
    private final Player defender;

    public CrownDamagedData(Player defender, int damage) {
        this.defender = defender;
        this.damage = damage;
    }

    // Getters
    public int getDamage() {
        return damage;
    }

    public Player getDefender() {
        return defender;
    }

}
