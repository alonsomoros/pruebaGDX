package com.alon.pruebasGDX.girarrodillos.model.wheel;

import com.alon.pruebasGDX.girarrodillos.utils.Constants;

import java.util.HashMap;
import java.util.Map;

public class WheelSet {

    private Wheel[] wheels;
    private int wheelIndex;

    public WheelSet() {
        wheelIndex = 0;
        // Crear una rueda para el jugador
        Wheel playerWheel = new Wheel(Constants.WHEEL_SYMBOLS);
        // Crear wheelSets con las ruedas
        this.wheels = new Wheel[]{
            playerWheel,
            playerWheel,
            playerWheel,
            playerWheel,
            playerWheel
        };
    }

    public void spin() {
        for (Wheel wheel : wheels) {
            wheel.spin();
        }
    }

    public Map<WheelSymbol, Integer> countResultSymbols() {
        Map<WheelSymbol, Integer> symbolResult = new HashMap<>();
        for (Wheel wheel : wheels) {
            symbolResult.put(wheel.getCurrentSymbol(), symbolResult.getOrDefault(wheel.getCurrentSymbol(), 0) + 1); // Si hay repetidos los suma
        }
        return symbolResult;
    }

    public int getWheelsCount() {
        return this.wheels.length;
    }

    public Wheel[] getWheels() {
        return this.wheels;
    }

    public Wheel getWheel(int index) {
        return wheels[index];
    }

    public void resetLocks() {
        for (Wheel wheel : wheels) {
            if (wheel.isLocked()) {
                wheel.toggleLocked();
            }
        }
    }

    public int getWheelIndex() {
        return wheelIndex;
    }

    public void moveWheelIndex(int index) {
        if (index == -1 || index == 1) {
            wheelIndex += index;
            if (wheelIndex < 0) {
                wheelIndex = wheels.length - 1;
            } else if (wheelIndex >= wheels.length) {
                wheelIndex = 0;
            }
        }
    }
}
