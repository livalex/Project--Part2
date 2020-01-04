package angels;

import admin.GreatMagician;
import constants.Constants;
import main.InputLoader;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public final class LifeGiver extends Angel implements Subject, AngelVisitor {
    public LifeGiver(final int abscissa, final int ordinate) {
        setMyAbscissa(abscissa);
        setMyOrdinate(ordinate);
        setAngelType(Constants.LIFE_GIVER_ANGEL);
        super.updateAngelAbs(abscissa);
        super.updateAngelOrd(ordinate);
    }

    @Override
    public void angelVisit(final Knight knight, final InputLoader inputLoader) {
        if (!knight.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            // Display angel helped player message
            inputLoader.displayGoodAngel(this, knight);

            // Update the HP of the player
            knight.setHp(knight.getHp() + Constants.LG_ANGEL_KNIGHT_INCREASE);

            // Make sure the health of the player isn't bigger
            // Than his maxHp
            if (knight.getHp() > knight.getMaxHp()) {
                knight.setHp(knight.getMaxHp());
            }

            // Notify the magician
            greatMagician.attachHelpedPlayers(knight);
        }
    }

    @Override
    public void angelVisit(final Wizard wizard, final InputLoader inputLoader) {

        // Same as above
        if (!wizard.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayGoodAngel(this, wizard);

            wizard.setHp(wizard.getHp() + Constants.LG_ANGEL_WIZARD_INCREASE);

            if (wizard.getHp() > wizard.getMaxHp()) {
                wizard.setHp(wizard.getMaxHp());
            }

            greatMagician.attachHelpedPlayers(wizard);
        }
    }

    @Override
    public void angelVisit(final Rogue rogue, final InputLoader inputLoader) {

        // Same as above
        if (!rogue.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayGoodAngel(this, rogue);

            rogue.setHp(rogue.getHp() + Constants.LG_ANGEL_ROGUE_INCREASE);

            if (rogue.getHp() > rogue.getMaxHp()) {
                rogue.setHp(rogue.getMaxHp());
            }

            greatMagician.attachHelpedPlayers(rogue);
        }
    }

    @Override
    public void angelVisit(final Pyromancer pyro, final InputLoader inputLoader) {

        // Same as above
        if (!pyro.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayGoodAngel(this, pyro);

            pyro.setHp(pyro.getHp() + Constants.LG_ANGEL_PYRO_INCREASE);

            if (pyro.getHp() > pyro.getMaxHp()) {
                pyro.setHp(pyro.getMaxHp());
            }

            greatMagician.attachHelpedPlayers(pyro);
        }
    }
}
