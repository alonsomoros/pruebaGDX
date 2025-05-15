package com.alon.pruebasGDX.girarrodillos.model.actions.data;

import com.alon.pruebasGDX.girarrodillos.model.heroes.Heroe;
import com.alon.pruebasGDX.girarrodillos.utils.events.EventData;

public class HeroExperienceData implements EventData {
    private final int energiaNecesaria;
    private final int experiencia;
    private final Heroe heroe;

    public HeroExperienceData(Heroe heroe, int experiencia, int energiaNecesaria) {
        this.heroe = heroe;
        this.experiencia = experiencia;
        this.energiaNecesaria = energiaNecesaria;
    }

    // Getters
    public int getEnergiaNecesaria() {
        return energiaNecesaria;
    }
    public int getExperiencia() {
        return experiencia;
    }
    public Heroe getHeroe() {
        return heroe;
    }
}
