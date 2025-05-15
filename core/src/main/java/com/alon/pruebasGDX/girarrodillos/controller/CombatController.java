package com.alon.pruebasGDX.girarrodillos.controller;

import com.alon.pruebasGDX.girarrodillos.model.Player;
import com.alon.pruebasGDX.girarrodillos.model.actions.Action;
import com.alon.pruebasGDX.girarrodillos.model.actions.data.ActionExecutedData;
import com.alon.pruebasGDX.girarrodillos.model.actions.data.BastionDamagedData;
import com.alon.pruebasGDX.girarrodillos.model.actions.data.CrownDamagedData;
import com.alon.pruebasGDX.girarrodillos.utils.events.EventManager;
import com.alon.pruebasGDX.girarrodillos.utils.events.EventType;

public class CombatController {
    public void executeAction(Action action, Player source, Player target) {
        // Ejecutar la acción
        action.execute(this, source, target);

        // Notificar que se ejecutó una acción
        EventManager.notify(EventType.ACTION_EXECUTED,
            new ActionExecutedData(action, source, target));
    }

    public void processAttack(Player attacker, Player defender, int damage, int height) {
        // Obtener nivel del bastión
        int bastionLevel = defender.getBastion().getAltura();

        // Determinar si el ataque traspasa el bastión
        boolean bypassesBastion = height > bastionLevel;

        if (bypassesBastion) {
            // El ataque impacta directamente en la corona
            defender.danyar(damage);
            EventManager.notify(EventType.CROWN_DAMAGED,
                new CrownDamagedData(defender, damage));
        } else {
            // El bastión absorbe el daño
            int absorbed = Math.min(damage, bastionLevel);
            defender.getBastion().disminuirAltura(absorbed);

            EventManager.notify(EventType.BASTION_DAMAGED,
                new BastionDamagedData(defender, absorbed));
        }
    }

    // Otras funciones de procesamiento de combate...
}
