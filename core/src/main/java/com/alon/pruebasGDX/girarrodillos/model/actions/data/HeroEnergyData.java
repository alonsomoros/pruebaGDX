package com.alon.pruebasGDX.girarrodillos.model.actions.data;

import com.alon.pruebasGDX.girarrodillos.model.heroes.Heroe;
import com.alon.pruebasGDX.girarrodillos.utils.events.EventData;

public class HeroEnergyData implements EventData {
    private final int energiaNecesaria;
    private final int energia;
    private final Heroe heroe;

    public HeroEnergyData(Heroe heroe, int energia, int energiaNecesaria) {
        this.heroe = heroe;
        this.energia = energia;
        this.energiaNecesaria = energiaNecesaria;
    }

    // Getters
    public int getEnergiaNecesaria() {
        return energiaNecesaria;
    }
    public int getEnergia() {
        return energia;
    }
    public Heroe getHeroe() {
        return heroe;
    }
}
