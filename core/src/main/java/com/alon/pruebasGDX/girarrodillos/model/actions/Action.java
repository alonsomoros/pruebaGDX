package com.alon.pruebasGDX.girarrodillos.model.actions;

import com.alon.pruebasGDX.girarrodillos.controller.CombatController;
import com.alon.pruebasGDX.girarrodillos.model.Player;

public interface Action {
    void execute(CombatController combatController, Player source, Player target);
    String getDescription();
    ActionType getType();
}
