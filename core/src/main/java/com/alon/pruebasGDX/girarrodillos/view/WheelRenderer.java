package com.alon.pruebasGDX.girarrodillos.view;

import com.alon.pruebasGDX.assets.Assets;
import com.alon.pruebasGDX.girarrodillos.model.wheel.Wheel;
import com.alon.pruebasGDX.girarrodillos.model.wheel.WheelSet;
import com.alon.pruebasGDX.girarrodillos.model.wheel.WheelSymbol;
import com.alon.pruebasGDX.girarrodillos.utils.Constants;
import com.alon.pruebasGDX.girarrodillos.utils.events.EventData;
import com.alon.pruebasGDX.girarrodillos.utils.events.EventListener;
import com.alon.pruebasGDX.girarrodillos.utils.events.EventManager;
import com.alon.pruebasGDX.girarrodillos.utils.events.EventType;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.HashMap;

public class WheelRenderer {
    private Texture wheelBackground;
    private HashMap<WheelSymbol, Texture> symbolTextures;
    private Texture lockIcon;

    // Para animación de giro
    private float spinTime = 0;
    private boolean isSpinning = false;

    public WheelRenderer() {
        // Cargar texturas
        wheelBackground = Assets.getInstance().getTexture("wheel_bg");
        lockIcon = Assets.getInstance().getTexture("lock_icon");

        // Cargar símbolos
        symbolTextures = new HashMap<>();
        symbolTextures.put(WheelSymbol.CUADRADO_ENERGIA_1, Assets.getInstance().getTexture("cuadrado_energia_1"));
        symbolTextures.put(WheelSymbol.CUADRADO_ENERGIA_2, Assets.getInstance().getTexture("cuadrado_energia_2"));
        symbolTextures.put(WheelSymbol.CUADRADO_ENERGIA_3, Assets.getInstance().getTexture("cuadrado_energia_3"));
        symbolTextures.put(WheelSymbol.ROMBO_ENERGIA_1, Assets.getInstance().getTexture("rombo_energia_1"));
        symbolTextures.put(WheelSymbol.ROMBO_ENERGIA_2, Assets.getInstance().getTexture("rombo_energia_2"));
        symbolTextures.put(WheelSymbol.ROMBO_ENERGIA_3, Assets.getInstance().getTexture("rombo_energia_3"));
        symbolTextures.put(WheelSymbol.CUADRADO_NIVEL_1, Assets.getInstance().getTexture("cuadrado_nivel_1"));
        symbolTextures.put(WheelSymbol.CUADRADO_NIVEL_2, Assets.getInstance().getTexture("cuadrado_nivel_2"));
        symbolTextures.put(WheelSymbol.CUADRADO_NIVEL_3, Assets.getInstance().getTexture("cuadrado_nivel_3"));
        symbolTextures.put(WheelSymbol.ROMBO_NIVEL_1, Assets.getInstance().getTexture("rombo_nivel_1"));
        symbolTextures.put(WheelSymbol.ROMBO_NIVEL_2, Assets.getInstance().getTexture("rombo_nivel_2"));
        symbolTextures.put(WheelSymbol.ROMBO_NIVEL_3, Assets.getInstance().getTexture("rombo_nivel_3"));
        symbolTextures.put(WheelSymbol.BASTION_1, Assets.getInstance().getTexture("bastion_1"));
        symbolTextures.put(WheelSymbol.BASTION_2, Assets.getInstance().getTexture("bastion_2"));
        symbolTextures.put(WheelSymbol.BASTION_3, Assets.getInstance().getTexture("bastion_3"));
        symbolTextures.put(WheelSymbol.ROTO, Assets.getInstance().getTexture("roto"));
        // ... otros símbolos

        // Suscribirse a eventos
        EventManager.subscribe(EventType.WHEELS_SPIN_START, new EventListener() {
            @Override
            public void onEvent(EventData data) {
                isSpinning = true;
                spinTime = 0;
            }
        });

        EventManager.subscribe(EventType.WHEELS_SPIN_END, new EventListener() {
            @Override
            public void onEvent (EventData data){
                isSpinning = false;
            }
        });
    }

    public void render(SpriteBatch batch, WheelSet wheelSet, boolean isPlayer) {
        if (wheelSet == null) return;

        // Calcular posición base según si es jugador/oponente
        float baseY = isPlayer ? Constants.COORDENADAS.PLAYER_WHEELS_Y : Constants.COORDENADAS.OPPONENT_WHEELS_Y;

        // Renderizar cada rodillo
        for (int i = 0; i < wheelSet.getWheelsCount(); i++) {
            Wheel wheel = wheelSet.getWheel(i);
            float x = Constants.COORDENADAS.WHEELS_START_X + i * Constants.COORDENADAS.WHEEL_SPACING;
            float y = baseY;

            // Dibujar fondo del rodillo
            batch.draw(wheelBackground, x, y, Constants.COORDENADAS.WHEEL_WIDTH, Constants.COORDENADAS.WHEEL_HEIGHT);

            // Dibujar símbolo actual del rodillo
            WheelSymbol symbol = wheel.getCurrentSymbol();
            if (symbol != null && symbolTextures.containsKey(symbol)) {
                // Si está girando, aplicar efecto visual
                if (isSpinning && !wheel.isLocked()) {
                    // Por simplicidad, mostramos un símbolo aleatorio durante la animación
                    int symbolIndex = (int) (spinTime * 10) % WheelSymbol.values().length;
                    symbol = WheelSymbol.values()[symbolIndex];
                }

                batch.draw(symbolTextures.get(symbol),
                    x + Constants.COORDENADAS.WHEEL_WIDTH / 2 - Constants.COORDENADAS.SYMBOL_SIZE / 2,
                    y + Constants.COORDENADAS.WHEEL_HEIGHT / 2 - Constants.COORDENADAS.SYMBOL_SIZE / 2,
                    Constants.COORDENADAS.SYMBOL_SIZE,
                    Constants.COORDENADAS.SYMBOL_SIZE);
            }

            // Si el rodillo está bloqueado, mostrar icono de candado
            if (wheel.isLocked()) {
                batch.draw(lockIcon,
                    x + Constants.COORDENADAS.WHEEL_WIDTH - 15,
                    y + Constants.COORDENADAS.WHEEL_HEIGHT - 15,
                    15, 15);
            }
        }
    }

    public void update(float delta) {
        if (isSpinning) {
            spinTime += delta;
        }
    }

    public void dispose() {
        // No necesitamos disposar estas texturas ya que son manejadas por Assets
    }
}
