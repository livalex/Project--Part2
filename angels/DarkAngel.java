package angels;

import admin.GreatMagician;
import constants.Constants;
import main.InputLoader;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public final class DarkAngel extends Angel implements Subject, AngelVisitor {

    public DarkAngel(final int abscissa, final int ordinate) {
        setMyAbscissa(abscissa);
        setMyOrdinate(ordinate);
        setAngelType(Constants.DARK_ANGEL);
        super.updateAngelAbs(abscissa);
        super.updateAngelOrd(ordinate);
    }

    @Override
    public void angelVisit(final Knight knight, final InputLoader inputLoader) {
        if (!knight.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            // Display the fact that the angel hit the player
            inputLoader.displayBadAngel(this, knight);

            // Update hp
            knight.setHp(knight.getHp() - Constants.DARK_ANGEL_KNGIHT_HP_DEC);

            if (knight.getHp() <= Constants.DEFAULT_STARTING_VALUE) {

                // Declare death
                knight.setDead(true);

                // Player killed by an angel message
                inputLoader.deathByAngel(knight);

                // Notify the magician
                greatMagician.attachKilledPlayers(knight);
            }

            // Notify the magician
            greatMagician.attachHitPlayers(knight);
        }
    }

    @Override
    public void angelVisit(final Wizard wizard, final InputLoader inputLoader) {

        // Same as above
        if (!wizard.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayBadAngel(this, wizard);

            wizard.setHp(wizard.getHp() - Constants.DARK_ANGEL_WIZARD_HP_DEC);

            if (wizard.getHp() <= Constants.DEFAULT_STARTING_VALUE) {
                wizard.setDead(true);
                inputLoader.deathByAngel(wizard);
                greatMagician.attachKilledPlayers(wizard);
            }

            greatMagician.attachHitPlayers(wizard);
        }
    }

    @Override
    public void angelVisit(final Rogue rogue, final InputLoader inputLoader) {

        // Same as above
        if (!rogue.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayBadAngel(this, rogue);

            rogue.setHp(rogue.getHp() - Constants.DARK_ANGEL_ROGUE_HP_DEC);

            if (rogue.getHp() <= Constants.DEFAULT_STARTING_VALUE) {
                rogue.setDead(true);
                inputLoader.deathByAngel(rogue);
                greatMagician.attachKilledPlayers(rogue);
            }

            greatMagician.attachHitPlayers(rogue);
        }
    }

    @Override
    public void angelVisit(final Pyromancer pyro, final InputLoader inputLoader) {

        // Same as above
        if (!pyro.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayBadAngel(this, pyro);

            pyro.setHp(pyro.getHp() - Constants.DARK_ANGEL_PYRO_HP_DEC);

            if (pyro.getHp() <= Constants.DEFAULT_STARTING_VALUE) {
                pyro.setDead(true);
                inputLoader.deathByAngel(pyro);
                greatMagician.attachKilledPlayers(pyro);
            }

            greatMagician.attachHitPlayers(pyro);
        }
    }
}
