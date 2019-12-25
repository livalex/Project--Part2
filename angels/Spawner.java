package angels;

import GameAdmin.GreatMagician;
import constants.Constants;
import main.InputLoader;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public class Spawner extends Angel implements Subject, AngelVisitor {

    public Spawner(final int abscissa, final int ordinate) {
        setMyAbscissa(abscissa);
        setMyOrdinate(ordinate);
        setAngelType(Constants.SPAWNER_ANGEL);
        super.updateAngelAbs(abscissa);
        super.updateAngelOrd(ordinate);
    }

    @Override
    public void angelVisit(Knight knight, InputLoader inputLoader) {
        if (knight.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            knight.setDead(false);
            knight.setHp(200);
            if (!knight.isKilledByDoomer()) {
                knight.setXp(knight.getPlayerStartRoundXp());
            }

            inputLoader.displayGoodAngel(this, knight);
            inputLoader.bringToLife(knight);

            greatMagician.attachHelpedPlayers(knight);
            greatMagician.attachReanimatedPlayers(knight);
        }
    }

    @Override
    public void angelVisit(Wizard wizard, InputLoader inputLoader) {
        if (wizard.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            wizard.setDead(false);
            wizard.setHp(120);
            if (!wizard.isKilledByDoomer()) {
                wizard.setXp(wizard.getPlayerStartRoundXp());
            }

            inputLoader.displayGoodAngel(this, wizard);
            inputLoader.bringToLife(wizard);

            greatMagician.attachHelpedPlayers(wizard);
            greatMagician.attachReanimatedPlayers(wizard);
        }
    }

    @Override
    public void angelVisit(Rogue rogue, InputLoader inputLoader) {
        if (rogue.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            rogue.setDead(false);
            rogue.setHp(180);
            if (!rogue.isKilledByDoomer()) {
                rogue.setXp(rogue.getPlayerStartRoundXp());
            }

            inputLoader.displayGoodAngel(this, rogue);
            inputLoader.bringToLife(rogue);

            greatMagician.attachHelpedPlayers(rogue);
            greatMagician.attachReanimatedPlayers(rogue);
        }
    }

    @Override
    public void angelVisit(Pyromancer pyro, InputLoader inputLoader) {
        if (pyro.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            pyro.setDead(false);
            pyro.setHp(150);
            if (!pyro.isKilledByDoomer()) {
                pyro.setXp(pyro.getPlayerStartRoundXp());
            }

            inputLoader.displayGoodAngel(this, pyro);
            inputLoader.bringToLife(pyro);

            greatMagician.attachHelpedPlayers(pyro);
            greatMagician.attachReanimatedPlayers(pyro);
        }
    }
}
