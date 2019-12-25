package angels;

import GameAdmin.GreatMagician;
import constants.Constants;
import main.InputLoader;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public class TheDoomer extends Angel implements Subject,AngelVisitor {

    public TheDoomer(final int abscissa, final int ordinate) {
        setMyAbscissa(abscissa);
        setMyOrdinate(ordinate);
        setAngelType(Constants.THE_DOOMER_ANGEL);
        super.updateAngelAbs(abscissa);
        super.updateAngelOrd(ordinate);
    }

    @Override
    public void angelVisit(Knight knight, InputLoader inputLoader) {
        if (!knight.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            knight.setDead(true);
            knight.setHp(-1);
            knight.setKilledByDoomer(true);

            inputLoader.displayBadAngel(this, knight);
            inputLoader.deathByAngel(knight);

            greatMagician.attachHitPlayers(knight);
            greatMagician.attachKilledPlayers(knight);
        }
    }

    @Override
    public void angelVisit(Wizard wizard, InputLoader inputLoader) {
        if (!wizard.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            wizard.setDead(true);
            wizard.setHp(-2);
            wizard.setKilledByDoomer(true);

            inputLoader.displayBadAngel(this, wizard);
            inputLoader.deathByAngel(wizard);

            greatMagician.attachHitPlayers(wizard);
            greatMagician.attachKilledPlayers(wizard);
        }
    }

    @Override
    public void angelVisit(Rogue rogue, InputLoader inputLoader) {
        if (!rogue.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            rogue.setDead(true);
            rogue.setHp(-3);
            rogue.setKilledByDoomer(true);

            inputLoader.displayBadAngel(this, rogue);
            inputLoader.deathByAngel(rogue);

            greatMagician.attachHitPlayers(rogue);
            greatMagician.attachKilledPlayers(rogue);
        }
    }

    @Override
    public void angelVisit(Pyromancer pyro, InputLoader inputLoader) {
        if (!pyro.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            pyro.setDead(true);
            pyro.setHp(-4);
            pyro.setKilledByDoomer(true);

            inputLoader.displayBadAngel(this, pyro);
            inputLoader.deathByAngel(pyro);

            greatMagician.attachHitPlayers(pyro);
            greatMagician.attachKilledPlayers(pyro);
        }
    }
}
