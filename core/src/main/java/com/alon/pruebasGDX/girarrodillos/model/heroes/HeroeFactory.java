package com.alon.pruebasGDX.girarrodillos.model.heroes;

import com.alon.pruebasGDX.girarrodillos.model.heroes.tipos.*;

public class HeroeFactory {
    public static Heroe createHero(HeroType type) {
        switch (type) {
            case CABALLERO:
                return new Caballero();
            case MAGO:
                return new Mago();
            case ARQUERO:
                return new Arquero();
            case SACERDOTE:
                return new Sacerdote();
            case ASESINO:
                return new Asesino();
            case INGENIERO:
                return new Ingeniero();
            default:
                return null;
        }
    }
}
