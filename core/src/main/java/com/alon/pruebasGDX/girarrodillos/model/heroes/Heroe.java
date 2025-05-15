package com.alon.pruebasGDX.girarrodillos.model.heroes;

import com.alon.pruebasGDX.girarrodillos.model.actions.Action;
import com.alon.pruebasGDX.girarrodillos.model.actions.data.BombCreatedData;
import com.alon.pruebasGDX.girarrodillos.model.actions.data.HeroEnergyData;
import com.alon.pruebasGDX.girarrodillos.model.actions.data.HeroEvolvedData;
import com.alon.pruebasGDX.girarrodillos.model.actions.data.HeroExperienceData;
import com.alon.pruebasGDX.girarrodillos.utils.Constants;
import com.alon.pruebasGDX.girarrodillos.utils.events.EventManager;
import com.alon.pruebasGDX.girarrodillos.utils.events.EventType;

public abstract class Heroe {
    protected int nivel;
    protected int experiencia;
    protected int energia;
    protected float stateTime;
    protected boolean isAttacking;

    public Heroe() {
        this.nivel = 1;
        this.experiencia = 0;
        this.energia = 0;
    }

    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public int getExperiencia() {
        return experiencia;
    }
    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }
    public int getEnergia() {
        return energia;
    }
    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public void sumaEnergia(int energiaGanada) {
        this.energia += Math.min(this.energia + energiaGanada, getEnergiaNecesaria());

        EventManager.notify(EventType.HERO_ENERGY_CHANGED,
            new HeroEnergyData(this, energia, getEnergiaNecesaria()));
    }

    public void restaEnergia(int energiaPerdida) {
        this.energia = Math.max(0, this.energia - energiaPerdida);

        EventManager.notify(EventType.HERO_ENERGY_CHANGED,
            new HeroEnergyData(this, energia, getEnergiaNecesaria()));
    }

    public void resetEnergia() {
        this.energia = 0;

        EventManager.notify(EventType.HERO_ENERGY_CHANGED,
            new HeroEnergyData(this, energia, getEnergiaNecesaria()));
    }

    public void sumaExperiencia(int experienciaGanada) {
        this.experiencia += experienciaGanada;

        checkEvolution();

        EventManager.notify(EventType.HERO_EXPERIENCE_CHANGED,
            new HeroExperienceData(this, experiencia, getEnergiaNecesaria()));
    }

    public void resetExperiencia() {
        this.experiencia = 0;

        EventManager.notify(EventType.HERO_EXPERIENCE_CHANGED,
            new HeroExperienceData(this, experiencia, getEnergiaNecesaria()));
    }

    private void checkEvolution() {
        if (experiencia >= Constants.EXP_NECESARIA_EVOLUCION) {
            // Evolucionar al siguiente nivel
            if (nivel == 1) {
                nivel++;

                // Notificar evolución
                EventManager.notify(EventType.HERO_EVOLVED,
                    new HeroEvolvedData(this, 2));

            } else if (nivel == 2) {
                nivel++;

                // Notificar evolución
                EventManager.notify(EventType.HERO_EVOLVED,
                    new HeroEvolvedData(this, 3));

            } else if (nivel == 3 && experiencia >= getEnergiaNecesaria()) {
                // Si ya es oro y alcanza el límite de EXP, crear bomba
                resetExperiencia();

                // Notificar bomba
                EventManager.notify(EventType.BOMB_CREATED, new BombCreatedData(this));
            }
        }
    }

    public abstract boolean canAct();

    public abstract Action createAction();

    public abstract int getEnergiaNecesaria();

    public abstract int getDanyoVida();
    public abstract int getDanyoBastion();

    public float getStateTime() {
        return stateTime;
    }
    public boolean isAttacking() {
        return isAttacking;
    }

    public void update(float delta) {
        stateTime += delta;

        // Resetear flag de ataque si ha pasado suficiente tiempo
        if (isAttacking && stateTime > 0.5f) { // 0.5 segundos de animación de ataque
            isAttacking = false;
            stateTime = 0;
        }
    }

    public void startAttackAnimation() {
        isAttacking = true;
        stateTime = 0;
    }
}
