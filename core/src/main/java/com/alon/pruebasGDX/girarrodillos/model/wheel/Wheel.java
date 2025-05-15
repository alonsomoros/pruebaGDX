package com.alon.pruebasGDX.girarrodillos.model.wheel;

public class Wheel {

    private WheelSymbol[] symbols;
    private WheelSymbol currentSymbol;
    private boolean locked;

    public Wheel(WheelSymbol[] symbols) {
        this.symbols = symbols;
        currentSymbol = WheelSymbol.ROTO;
    }

    public void spin() {
        int randomIndex = (int) (Math.random() * symbols.length);
        currentSymbol = symbols[randomIndex];
    }

    public WheelSymbol getCurrentSymbol() {
        return currentSymbol;
    }

    public WheelSymbol[] getSymbols() {
        return symbols;
    }

    public boolean isLocked() {
        return this.locked == true;
    }

    public void toggleLocked() {
        this.locked = !locked;
    }
}
