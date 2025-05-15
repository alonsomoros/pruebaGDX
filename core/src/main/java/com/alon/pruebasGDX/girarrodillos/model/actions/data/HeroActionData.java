package com.alon.pruebasGDX.girarrodillos.model.actions.data;

import com.alon.pruebasGDX.girarrodillos.model.actions.Action;
import com.alon.pruebasGDX.girarrodillos.model.heroes.Heroe;
import com.alon.pruebasGDX.girarrodillos.utils.events.EventData;

public class HeroActionData implements EventData {
    private Heroe hero;
    private Action action;

    public HeroActionData(Heroe hero, Action action) {
        this.hero = hero;
        this.action = action;
    }

    public Heroe getHero() {
        return hero;
    }

    public Action getAction() {
        return action;
    }
}

