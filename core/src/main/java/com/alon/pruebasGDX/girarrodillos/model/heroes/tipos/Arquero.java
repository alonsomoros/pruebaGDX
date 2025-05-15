package com.alon.pruebasGDX.girarrodillos.model.heroes.tipos;

import com.alon.pruebasGDX.girarrodillos.model.actions.Action;
import com.alon.pruebasGDX.girarrodillos.model.heroes.Heroe;
import com.alon.pruebasGDX.girarrodillos.utils.Constants;

public class Arquero extends Heroe {
    @Override
    public boolean canAct() {
        return false;
    }

    @Override
    public Action createAction() {
        return null;
    }

    @Override
    public int getEnergiaNecesaria() {
        switch (nivel) {
            case 1:
                return Constants.ENERGIA.ENERGIA_ARQUERO_LVL1;
            case 2:
                return Constants.ENERGIA.ENERGIA_ARQUERO_LVL2;
            case 3:
                return Constants.ENERGIA.ENERGIA_ARQUERO_LVL3;
        }
        return -1;
    }

    @Override
    public int getDanyoVida() {
        switch (nivel) {
            case 1:
                return Constants.STATS.DANYO_VIDA_ARQUERO_LVL1;
            case 2:
                return Constants.STATS.DANYO_VIDA_ARQUERO_LVL2;
            case 3:
                return Constants.STATS.DANYO_VIDA_ARQUERO_LVL3;
        }
        return -1;
    }

    @Override
    public int getDanyoBastion() {
        switch (nivel) {
            case 1:
                return Constants.STATS.DANYO_BASTION_ARQUERO_LVL1;
            case 2:
                return Constants.STATS.DANYO_BASTION_ARQUERO_LVL2;
            case 3:
                return Constants.STATS.DANYO_BASTION_ARQUERO_LVL3;
        }
        return -1;
    }
}
