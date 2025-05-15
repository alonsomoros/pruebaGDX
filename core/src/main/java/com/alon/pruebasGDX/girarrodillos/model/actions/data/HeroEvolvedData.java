package com.alon.pruebasGDX.girarrodillos.model.actions.data;

import com.alon.pruebasGDX.girarrodillos.model.heroes.Heroe;
import com.alon.pruebasGDX.girarrodillos.utils.events.EventData;

public class HeroEvolvedData implements EventData {
    private final int nivel;
    private final Heroe heroe;

    public HeroEvolvedData(Heroe heroe, int i) {
        this.heroe = heroe;
        this.nivel = i;
    }

    // Getters
    public int getNivel() {
        return nivel;
    }
    public Heroe getHeroe() {
        return heroe;
    }
}
