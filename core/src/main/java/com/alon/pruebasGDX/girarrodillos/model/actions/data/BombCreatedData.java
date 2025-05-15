package com.alon.pruebasGDX.girarrodillos.model.actions.data;

import com.alon.pruebasGDX.girarrodillos.model.heroes.Heroe;
import com.alon.pruebasGDX.girarrodillos.utils.events.EventData;

public class BombCreatedData implements EventData {

    private final Heroe heroe;

    public BombCreatedData(Heroe heroe) {
        this.heroe = heroe;
    }

    // Getters
    public Heroe getHeroe() {
        return heroe;
    }
}
