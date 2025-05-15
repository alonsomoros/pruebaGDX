package com.alon.pruebasGDX.girarrodillos.model;

import com.alon.pruebasGDX.girarrodillos.model.heroes.Heroe;
import com.alon.pruebasGDX.girarrodillos.model.wheel.WheelSet;
import com.alon.pruebasGDX.girarrodillos.utils.Constants;

public class Player {
    private int vida;
    private Heroe heroeIzquierda;
    private Heroe heroeDerecha;
    private Bastion bastion;
    private WheelSet wheelSet;
    private int tiradas;

    public Player() {
        this.vida = Constants.VIDA_INICIAL;
        this.tiradas = Constants.TURNOS_MAXIMO;
        this.wheelSet = new WheelSet();
        this.heroeIzquierda = null;
        this.heroeDerecha = null;
        this.bastion = new Bastion();
    }
    public int getVida() {
        return vida;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }
    public Heroe getHeroeIzquierda() {
        return heroeIzquierda;
    }
    public void setHeroeIzquierda(Heroe heroeIzquierda) {
        this.heroeIzquierda = heroeIzquierda;
    }
    public Heroe getHeroeDerecha() {
        return heroeDerecha;
    }
    public void setHeroeDerecha(Heroe heroeDerecha) {
        this.heroeDerecha = heroeDerecha;
    }
    public WheelSet getWheelSet() {
        return wheelSet;
    }
    public void setBastion(Bastion bastion) {
        this.bastion = bastion;
    }
    public Bastion getBastion() {
        return bastion;
    }

    public void disminuirTiradas() {
        this.tiradas--;
    }

    public void resetTiradas() {
        this.tiradas = Constants.TURNOS_MAXIMO;
    }

    public int getTiradasRestantes() {
        return this.tiradas;
    }

    public void curar(int cantidad) {
        this.vida += cantidad;
        if (this.vida > Constants.VIDA_MAXIMA) {
            this.vida = Constants.VIDA_MAXIMA;
        }
    }

    public void danyar(int cantidad) {
        this.vida -= cantidad;
        if (this.vida < Constants.VIDA_MINIMA) {
            this.vida = Constants.VIDA_MINIMA;
        }
    }
}
