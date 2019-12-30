package angels;

import admin.GreatMagician;
import constants.Constants;
import main.InputLoader;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public final class TheDoomer extends Angel implements Subject, AngelVisitor {

    public TheDoomer(final int abscissa, final int ordinate) {
        setMyAbscissa(abscissa);
        setMyOrdinate(ordinate);
        setAngelType(Constants.THE_DOOMER_ANGEL);
        super.updateAngelAbs(abscissa);
        super.updateAngelOrd(ordinate);
    }

    @Override
    public void angelVisit(final Knight knight, final InputLoader inputLoader) {
        if (!knight.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            // Set the player to be dead and set
            // Killed by Doomer flag
            knight.setDead(true);
            knight.setHp(Constants.DOOMER_LIFE_SET);
            knight.setKilledByDoomer(true);

            // Display angel hit player message
            inputLoader.displayBadAngel(this, knight);

            // Display player killed by angel message
            inputLoader.deathByAngel(knight);

            // Notify the magician
            greatMagician.attachHitPlayers(knight);
            greatMagician.attachKilledPlayers(knight);
        }
    }

    @Override
    public void angelVisit(final Wizard wizard, final InputLoader inputLoader) {

        // Same as above
        if (!wizard.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            wizard.setDead(true);
            wizard.setHp(Constants.DOOMER_LIFE_SET);
            wizard.setKilledByDoomer(true);

            inputLoader.displayBadAngel(this, wizard);
            inputLoader.deathByAngel(wizard);

            greatMagician.attachHitPlayers(wizard);
            greatMagician.attachKilledPlayers(wizard);
        }
    }

    @Override
    public void angelVisit(final Rogue rogue, final InputLoader inputLoader) {

        // Same as above
        if (!rogue.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            rogue.setDead(true);
            rogue.setHp(Constants.DOOMER_LIFE_SET);
            rogue.setKilledByDoomer(true);

            inputLoader.displayBadAngel(this, rogue);
            inputLoader.deathByAngel(rogue);

            greatMagician.attachHitPlayers(rogue);
            greatMagician.attachKilledPlayers(rogue);
        }
    }

    @Override
    public void angelVisit(final Pyromancer pyro, final InputLoader inputLoader) {

        // Same as above
        if (!pyro.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            pyro.setDead(true);
            pyro.setHp(Constants.DOOMER_LIFE_SET);
            pyro.setKilledByDoomer(true);

            inputLoader.displayBadAngel(this, pyro);
            inputLoader.deathByAngel(pyro);

            greatMagician.attachHitPlayers(pyro);
            greatMagician.attachKilledPlayers(pyro);
        }
    }
}
