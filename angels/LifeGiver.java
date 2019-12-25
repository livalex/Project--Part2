package angels;

import GameAdmin.GreatMagician;
import constants.Constants;
import main.InputLoader;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public class LifeGiver extends Angel implements Subject, AngelVisitor {
    public LifeGiver(final int abscissa, final int ordinate) {
        setMyAbscissa(abscissa);
        setMyOrdinate(ordinate);
        setAngelType(Constants.LIFE_GIVER_ANGEL);
        super.updateAngelAbs(abscissa);
        super.updateAngelOrd(ordinate);
    }

    @Override
    public void angelVisit(Knight knight, InputLoader inputLoader) {
        if (!knight.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayGoodAngel(this, knight);

            knight.setHp(knight.getHp() + 100);

            if (knight.getHp() > knight.getMaxHp()) {
                knight.setHp(knight.getMaxHp());
            }

            greatMagician.attachHelpedPlayers(knight);
        }
    }

    @Override
    public void angelVisit(Wizard wizard, InputLoader inputLoader) {
        if (!wizard.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayGoodAngel(this, wizard);

            wizard.setHp(wizard.getHp() + 120);

            if (wizard.getHp() > wizard.getMaxHp()) {
                wizard.setHp(wizard.getMaxHp());
            }

            greatMagician.attachHelpedPlayers(wizard);
        }
    }

    @Override
    public void angelVisit(Rogue rogue, InputLoader inputLoader) {
        if (!rogue.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayGoodAngel(this, rogue);

            rogue.setHp(rogue.getHp() + 90);

            if (rogue.getHp() > rogue.getMaxHp()) {
                rogue.setHp(rogue.getMaxHp());
            }

            greatMagician.attachHelpedPlayers(rogue);
        }
    }

    @Override
    public void angelVisit(Pyromancer pyro, InputLoader inputLoader) {
        if (!pyro.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayGoodAngel(this, pyro);

            pyro.setHp(pyro.getHp() + 80);

            if (pyro.getHp() > pyro.getMaxHp()) {
                pyro.setHp(pyro.getMaxHp());
            }

            greatMagician.attachHelpedPlayers(pyro);
        }
    }
}
