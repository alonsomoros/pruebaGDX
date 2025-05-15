package com.alon.pruebasGDX.girarrodillos.controller.commands;

import com.alon.pruebasGDX.girarrodillos.model.wheel.Wheel;

public class SpinWheelsCommand implements Command {

    private Wheel wheel;

    public SpinWheelsCommand(Wheel wheel) {
        this.wheel = wheel;
    }

    @Override
    public void execute() {
        wheel.spin();
    }
}
