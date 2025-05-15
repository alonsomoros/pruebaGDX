package com.alon.pruebasGDX.girarrodillos.controller.commands;

import com.alon.pruebasGDX.girarrodillos.model.wheel.Wheel;
import com.alon.pruebasGDX.girarrodillos.model.wheel.WheelSet;

public class SpinWheelsCommand implements Command {

    private WheelSet wheelSet;

    public SpinWheelsCommand(WheelSet wheelSet) {
        this.wheelSet = wheelSet;
    }

    @Override
    public void execute() {
        wheelSet.spin();
    }
}
