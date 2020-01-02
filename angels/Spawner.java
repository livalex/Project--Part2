package angels;

import admin.GreatMagician;
import constants.Constants;
import main.InputLoader;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public final class Spawner extends Angel implements Subject, AngelVisitor {

    public Spawner(final int abscissa, final int ordinate) {
        setMyAbscissa(abscissa);
        setMyOrdinate(ordinate);
        setAngelType(Constants.SPAWNER_ANGEL);
        super.updateAngelAbs(abscissa);
        super.updateAngelOrd(ordinate);
    }

    @Override
    public void angelVisit(final Knight knight, final InputLoader inputLoader) {

        // Make sure the player is dead
        if (knight.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            // Set the player status as alive and set his hp
            knight.setDead(false);
            knight.setHp(Constants.SPAWNER_KNIGHT_LIFE_SET);

            // If the player is not killed by Doomer,
            // Set his XP to the player's XP at the
            // Beginning of the round
            if (!knight.isKilledByDoomer()) {
                knight.setXp(knight.getPlayerStartRoundXp());
            }

            // Display angel helped player message
            inputLoader.displayGoodAngel(this, knight);

            // Display player brought to life by an angel message
            inputLoader.bringToLife(knight);

            // Notify the Great Magician
            greatMagician.attachHelpedPlayers(knight);
            greatMagician.attachReanimatedPlayers(knight);
        }
    }

    @Override
    public void angelVisit(final Wizard wizard, final InputLoader inputLoader) {

        // Same as above
        if (wizard.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            wizard.setDead(false);
            wizard.setHp(Constants.SPAWNER_WIZARD_LIFE_SET);
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
    public void angelVisit(final Rogue rogue, final InputLoader inputLoader) {

        // Same as above
        if (rogue.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            rogue.setDead(false);
            rogue.setHp(Constants.SPAWNER_ROGUE_LIFE_SET);
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
    public void angelVisit(final Pyromancer pyro, final InputLoader inputLoader) {

        // Same as above
        if (pyro.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            pyro.setDead(false);
            pyro.setHp(Constants.SPAWNER_PYRO_LIFE_SET);
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
