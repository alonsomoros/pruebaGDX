package com.alon.pruebasGDX.girarrodillos.model.actions.data;

import com.alon.pruebasGDX.girarrodillos.model.Player;
import com.alon.pruebasGDX.girarrodillos.utils.events.EventData;

public class BastionDamagedData implements EventData {
    private final Player defender;
    private final int absorbed;

    public BastionDamagedData(Player defender, int absorbed) {
        this.defender = defender;
        this.absorbed = absorbed;
    }

    // Getters
    public Player getDefender() {
        return defender;
    }
    public int getAbsorbed() {
        return absorbed;
    }
}
