package com.alon.pruebasGDX.girarrodillos.utils.events;

import com.badlogic.gdx.scenes.scene2d.ui.List;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


// Ejemplo simplificado de un sistema de eventos
public class EventManager {
    private static Map<EventType, ArrayList<EventListener>> listeners = new HashMap<>();

    public static void subscribe(EventType type, EventListener listener) {
        if (!listeners.containsKey(type)) {
            listeners.put(type, new ArrayList<>());
        }
        listeners.get(type).add(listener);
    }

    public static void notify(EventType type, EventData data) {
        if (listeners.containsKey(type)) {
            for (EventListener listener : listeners.get(type)) {
                listener.onEvent(data);
            }
        }
    }
}
