package angels;

import admin.GreatMagician;
import constants.Constants;
import main.InputLoader;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public final class SmallAngel extends Angel implements Subject, AngelVisitor {

    public SmallAngel(final int abscissa, final int ordinate) {
        setMyAbscissa(abscissa);
        setMyOrdinate(ordinate);
        setAngelType(Constants.SMALL_ANGEL);
        super.updateAngelAbs(abscissa);
        super.updateAngelOrd(ordinate);
    }

    @Override
    public void angelVisit(final Knight knight, final InputLoader inputLoader) {
        if (!knight.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            // Display angel helped player message
            inputLoader.displayGoodAngel(this, knight);

            // Update the player's HP
            knight.setHp(knight.getHp() + Constants.SMALL_ANGEL_KNIGHT_INCREASE);

            // Make sure the player's hp is not bigger
            // Than his maxHp
            if (knight.getHp() > knight.getMaxHp()) {
                knight.setHp(knight.getMaxHp());
            }

            // Update the race modifiers of the player
            knight.setWizardExecuteMod(knight.getWizardExecuteMod()
                    + Constants.SMALL_ANGEL_KNIGHT_MOD);
            knight.setWizardSlamMod(knight.getWizardSlamMod() + Constants.SMALL_ANGEL_KNIGHT_MOD);
            knight.setRogueExecuteMod(knight.getRogueExecuteMod()
                    + Constants.SMALL_ANGEL_KNIGHT_MOD);
            knight.setRogueSlamMod(knight.getRogueSlamMod() + Constants.SMALL_ANGEL_KNIGHT_MOD);
            if (knight.getKnightExecuteMod() != Constants.UNCHANGEABLE_VALUE) {
                knight.setKnightExecuteMod(knight.getKnightExecuteMod()
                        + Constants.SMALL_ANGEL_KNIGHT_MOD);
            }
            knight.setKnightSlamMod(knight.getKnightSlamMod() + Constants.SMALL_ANGEL_KNIGHT_MOD);
            knight.setPyroExecuteMod(knight.getPyroExecuteMod() + Constants.SMALL_ANGEL_KNIGHT_MOD);
            knight.setPyroSlamMod(knight.getPyroSlamMod() + Constants.SMALL_ANGEL_KNIGHT_MOD);

            // Notify the Great Magician
            greatMagician.attachHelpedPlayers(knight);
        }
    }

    @Override
    public void angelVisit(final Wizard wizard, final InputLoader inputLoader) {

        // Same as above
        if (!wizard.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayGoodAngel(this, wizard);

            wizard.setHp(wizard.getHp() + Constants.SMALL_ANGEL_WIZARD_INCREASE);

            if (wizard.getHp() > wizard.getMaxHp()) {
                wizard.setHp(wizard.getMaxHp());
            }

            wizard.setRogueDrainMod(wizard.getRogueDrainMod() + Constants.SMALL_ANGEL_WIZARD_MOD);
            wizard.setRogueDeflectMod(wizard.getRogueDeflectMod()
                    + Constants.SMALL_ANGEL_WIZARD_MOD);
            wizard.setWizardDrainMod(wizard.getWizardDrainMod() + Constants.SMALL_ANGEL_WIZARD_MOD);
            wizard.setWizardDeflectMod(wizard.getWizardDeflectMod()
                    + Constants.SMALL_ANGEL_WIZARD_MOD);
            wizard.setPyroDrainMod(wizard.getPyroDrainMod() + Constants.SMALL_ANGEL_WIZARD_MOD);
            wizard.setPyroDeflectMod(wizard.getPyroDeflectMod() + Constants.SMALL_ANGEL_WIZARD_MOD);
            wizard.setKnightDrainMod(wizard.getKnightDrainMod() + Constants.SMALL_ANGEL_WIZARD_MOD);
            wizard.setKnightDeflectMod(wizard.getKnightDeflectMod()
                    + Constants.SMALL_ANGEL_WIZARD_MOD);

            greatMagician.attachHelpedPlayers(wizard);
        }
    }

    @Override
    public void angelVisit(final Rogue rogue, final InputLoader inputLoader) {

        // Same as above
        if (!rogue.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayGoodAngel(this, rogue);

            rogue.setHp(rogue.getHp() + Constants.SMALL_ANGEL_ROGUE_INCREASE);

            if (rogue.getHp() > rogue.getMaxHp()) {
                rogue.setHp(rogue.getMaxHp());
            }

            rogue.setRogueBsMod(rogue.getRogueBsMod() + Constants.SMALL_ANGEL_ROGUE_MOD);
            rogue.setRogueParMod(rogue.getRogueParMod() + Constants.SMALL_ANGEL_ROGUE_MOD);
            rogue.setWizardBsMod(rogue.getWizardBsMod() + Constants.SMALL_ANGEL_ROGUE_MOD);
            rogue.setWizardParMod(rogue.getWizardParMod() + Constants.SMALL_ANGEL_ROGUE_MOD);
            rogue.setKnightBsMod(rogue.getKnightBsMod() + Constants.SMALL_ANGEL_ROGUE_MOD);
            rogue.setKnightParMod(rogue.getKnightParMod() + Constants.SMALL_ANGEL_ROGUE_MOD);
            rogue.setPyroBsMod(rogue.getPyroBsMod() + Constants.SMALL_ANGEL_ROGUE_MOD);
            rogue.setPyroParMod(rogue.getPyroParMod() + Constants.SMALL_ANGEL_ROGUE_MOD);

            greatMagician.attachHelpedPlayers(rogue);
        }
    }

    @Override
    public void angelVisit(final Pyromancer pyro, final InputLoader inputLoader) {

        // Same as above
        if (!pyro.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayGoodAngel(this, pyro);

            pyro.setHp(pyro.getHp() + Constants.SMALL_ANGEL_PYRO_INCREASE);

            if (pyro.getHp() > pyro.getMaxHp()) {
                pyro.setHp(pyro.getMaxHp());
            }

            pyro.setWizardFbMod(pyro.getPyroFbMod() + Constants.SMALL_ANGEL_PYRO_MOD);
            pyro.setWizardIgniteMod(pyro.getPyroIgniteMod() + Constants.SMALL_ANGEL_PYRO_MOD);
            pyro.setKnightFbMod(pyro.getPyroFbMod() + Constants.SMALL_ANGEL_PYRO_MOD);
            pyro.setKnightIgniteMod(pyro.getPyroIgniteMod() + Constants.SMALL_ANGEL_PYRO_MOD);
            pyro.setRogueFbMod(pyro.getRogueFbMod() + Constants.SMALL_ANGEL_PYRO_MOD);
            pyro.setRogueIgniteMod(pyro.getRogueIgniteMod() + Constants.SMALL_ANGEL_PYRO_MOD);
            pyro.setPyroFbMod(pyro.getPyroFbMod() + Constants.SMALL_ANGEL_PYRO_MOD);
            pyro.setPyroIgniteMod(pyro.getPyroIgniteMod() + Constants.SMALL_ANGEL_PYRO_MOD);

            greatMagician.attachHelpedPlayers(pyro);
        }
    }
}
