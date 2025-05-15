package com.alon.pruebasGDX.girarrodillos.utils.events;


public interface EventListener {
    void onEvent(EventData event);

    boolean isListeningTo(EventType eventType);

    void setListeningTo(EventType eventType, boolean listening);
}
