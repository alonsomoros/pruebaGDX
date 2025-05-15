package com.alon.pruebasGDX.girarrodillos.model.actions.data;

import com.alon.pruebasGDX.girarrodillos.model.Player;
import com.alon.pruebasGDX.girarrodillos.model.actions.Action;
import com.alon.pruebasGDX.girarrodillos.utils.events.EventData;

public class ActionExecutedData implements EventData {
    private final Player target;
    private final Action action;
    private final Player source;

    public ActionExecutedData(Action action, Player source, Player target) {
        this.action = action;
        this.source = source;
        this.target = target;
    }

    // Getters
    public Action getAction() {
        return action;
    }

    public Player getSource() {
        return source;
    }

    public Player getTarget() {
        return target;
    }
}
