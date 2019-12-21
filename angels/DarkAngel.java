package angels;

import GameAdmin.GreatMagician;
import constants.Constants;
import main.InputLoader;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public class DarkAngel extends Angel implements Subject, AngelVisitor {

    public DarkAngel(final int abscissa, final int ordinate) {
        setMyAbscissa(abscissa);
        setMyOrdinate(ordinate);
        setAngelType(Constants.DARK_ANGEL);
        super.updateAngelAbs(abscissa);
        super.updateAngelOrd(ordinate);
    }

    @Override
    public void angelVisit(Knight knight, InputLoader inputLoader) {
        if (!knight.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayBadAngel(this, knight);

            knight.setHp(knight.getHp() - 40);

            if (knight.getHp() <= 0) {
                knight.setDead(true);
                inputLoader.deathByAngel(knight);
                greatMagician.attachKilledPlayers(knight);
            }

            greatMagician.attachHitPlayers(knight);
        }
    }

    @Override
    public void angelVisit(Wizard wizard, InputLoader inputLoader) {
        if (!wizard.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayBadAngel(this, wizard);

            wizard.setHp(wizard.getHp() - 20);

            if (wizard.getHp() <= 0) {
                wizard.setDead(true);
                inputLoader.deathByAngel(wizard);
                greatMagician.attachKilledPlayers(wizard);
            }

            greatMagician.attachHitPlayers(wizard);
        }
    }

    @Override
    public void angelVisit(Rogue rogue, InputLoader inputLoader) {
        if (!rogue.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayBadAngel(this, rogue);

            rogue.setHp(rogue.getHp() - 10);

            if (rogue.getHp() <= 0) {
                rogue.setDead(true);
                inputLoader.deathByAngel(rogue);
                greatMagician.attachKilledPlayers(rogue);
            }

            greatMagician.attachHitPlayers(rogue);
        }

    }

    @Override
    public void angelVisit(Pyromancer pyro, InputLoader inputLoader) {
        if (!pyro.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayBadAngel(this, pyro);

            pyro.setHp(pyro.getHp() - 30);

            if (pyro.getHp() <= 0) {
                pyro.setDead(true);
                inputLoader.deathByAngel(pyro);
                greatMagician.attachKilledPlayers(pyro);
            }

            greatMagician.attachHitPlayers(pyro);
        }

    }
}
