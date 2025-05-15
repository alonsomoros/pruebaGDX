package com.alon.pruebasGDX.girarrodillos.model;

import com.alon.pruebasGDX.girarrodillos.utils.Constants;

public class Bastion {
    private int altura;

    public Bastion() {
        this.altura = 0;
    }
    public int getAltura() {
        return altura;
    }
    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void aumentaAltura(int alturaGanada) {
        altura = Math.min(altura + alturaGanada, Constants.MAXIMA_ALTURA_BASTION);
    }

    public void disminuirAltura(int absorbed) {
        altura = Math.max(0, altura - absorbed);
    }
}
