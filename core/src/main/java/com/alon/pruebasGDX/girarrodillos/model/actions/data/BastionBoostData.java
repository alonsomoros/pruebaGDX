package com.alon.pruebasGDX.girarrodillos.model.actions.data;

import com.alon.pruebasGDX.girarrodillos.model.heroes.Heroe;
import com.alon.pruebasGDX.girarrodillos.utils.events.EventData;

public class BastionBoostData implements EventData {
    private Heroe source;
    private int amount;

    public BastionBoostData(Heroe source, int amount) {
        this.source = source;
        this.amount = amount;
    }

    public Heroe getSource() {
        return source;
    }

    public int getAmount() {
        return amount;
    }
}
