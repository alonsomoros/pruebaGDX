package com.alon.pruebasGDX.girarrodillos.input;

import com.alon.pruebasGDX.girarrodillos.controller.commands.Command;
import com.badlogic.gdx.Gdx;

import java.util.HashMap;
import java.util.Map;

public class InputHandler {
    private Map<Integer, Command> keyCommands;

    public InputHandler() {
        keyCommands = new HashMap<>();
    }

    public void setCommand(int keyCode, Command command) {
        keyCommands.put(keyCode, command);
    }

    public void handleInput() {
        for (Map.Entry<Integer, Command> entry : keyCommands.entrySet()) {
            if (Gdx.input.isKeyJustPressed(entry.getKey())) {
                entry.getValue().execute();
            }
        }
    }
}
