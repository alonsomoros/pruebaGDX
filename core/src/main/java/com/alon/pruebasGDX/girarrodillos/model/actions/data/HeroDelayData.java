package com.alon.pruebasGDX.girarrodillos.model.actions.data;

import com.alon.pruebasGDX.girarrodillos.model.heroes.Heroe;
import com.alon.pruebasGDX.girarrodillos.utils.events.EventData;

public class HeroDelayData implements EventData {
    private Heroe source;
    private Heroe target;
    private int amount;

    public HeroDelayData(Heroe source, Heroe target, int amount) {
        this.source = source;
        this.target = target;
        this.amount = amount;
    }

    // Getters
    public Heroe getSource() {
        return source;
    }
    public Heroe getTarget() {
        return target;
    }
    public int getAmount() {
        return amount;
    }
}

