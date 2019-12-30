package angels;

import admin.GreatMagician;
import constants.Constants;
import main.InputLoader;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public final class DamageAngel extends Angel implements Subject, AngelVisitor {

    public DamageAngel(final int abscissa, final int ordinate) {
        setMyAbscissa(abscissa);
        setMyOrdinate(ordinate);
        setAngelType(Constants.DAMAGE_ANGEL);
        super.updateAngelAbs(abscissa);
        super.updateAngelOrd(ordinate);
    }

    @Override
    public void angelVisit(final Knight knight, final InputLoader inputLoader) {
        // Make sure the player is not dead
        if (!knight.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            // Display the fact that the players was helped by an angel
            inputLoader.displayGoodAngel(this, knight);

            // Update the race modifiers
            knight.setWizardExecuteMod(knight.getWizardExecuteMod()
                    + Constants.DAMAGE_ANGEL_KNIGHT_MOD);
            knight.setWizardSlamMod(knight.getWizardSlamMod() + Constants.DAMAGE_ANGEL_KNIGHT_MOD);
            knight.setRogueExecuteMod(knight.getRogueExecuteMod()
                    + Constants.DAMAGE_ANGEL_KNIGHT_MOD);
            knight.setRogueSlamMod(knight.getRogueSlamMod() + Constants.DAMAGE_ANGEL_KNIGHT_MOD);
            if (knight.getKnightExecuteMod() != Constants.UNCHANGEABLE_VALUE) {
                knight.setKnightExecuteMod(knight.getKnightExecuteMod()
                        + Constants.DAMAGE_ANGEL_KNIGHT_MOD);
            }
            knight.setKnightSlamMod(knight.getKnightSlamMod() + Constants.DAMAGE_ANGEL_KNIGHT_MOD);
            knight.setPyroExecuteMod(knight.getPyroExecuteMod()
                    + Constants.DAMAGE_ANGEL_KNIGHT_MOD);
            knight.setPyroSlamMod(knight.getPyroSlamMod() + Constants.DAMAGE_ANGEL_KNIGHT_MOD);

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

            wizard.setRogueDrainMod(wizard.getRogueDrainMod() + Constants.DAMAGE_ANGEL_WIZARD_MOD);
            wizard.setRogueDeflectMod(wizard.getRogueDeflectMod()
                    + Constants.DAMAGE_ANGEL_WIZARD_MOD);
            wizard.setWizardDrainMod(wizard.getWizardDrainMod()
                    + Constants.DAMAGE_ANGEL_WIZARD_MOD);
            wizard.setWizardDeflectMod(wizard.getWizardDeflectMod()
                    + Constants.DAMAGE_ANGEL_WIZARD_MOD);
            wizard.setPyroDrainMod(wizard.getPyroDrainMod() + Constants.DAMAGE_ANGEL_WIZARD_MOD);
            wizard.setPyroDeflectMod(wizard.getPyroDeflectMod()
                    + Constants.DAMAGE_ANGEL_WIZARD_MOD);
            wizard.setKnightDrainMod(wizard.getKnightDrainMod()
                    + Constants.DAMAGE_ANGEL_WIZARD_MOD);
            wizard.setKnightDeflectMod(wizard.getKnightDeflectMod()
                    + Constants.DAMAGE_ANGEL_WIZARD_MOD);

            greatMagician.attachHelpedPlayers(wizard);
        }

    }

    @Override
    public void angelVisit(final Rogue rogue, final InputLoader inputLoader) {

        // Same as above
        if (!rogue.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayGoodAngel(this, rogue);

            rogue.setRogueBsMod(rogue.getRogueBsMod() + Constants.DAMAGE_ANGEL_ROGUE_MOD);
            rogue.setRogueParMod(rogue.getRogueParMod() + Constants.DAMAGE_ANGEL_ROGUE_MOD);
            rogue.setWizardBsMod(rogue.getWizardBsMod() + Constants.DAMAGE_ANGEL_ROGUE_MOD);
            rogue.setWizardParMod(rogue.getWizardParMod() + Constants.DAMAGE_ANGEL_ROGUE_MOD);
            rogue.setKnightBsMod(rogue.getKnightBsMod() + Constants.DAMAGE_ANGEL_ROGUE_MOD);
            rogue.setKnightParMod(rogue.getKnightParMod() + Constants.DAMAGE_ANGEL_ROGUE_MOD);
            rogue.setPyroBsMod(rogue.getPyroBsMod() + Constants.DAMAGE_ANGEL_ROGUE_MOD);
            rogue.setPyroParMod(rogue.getPyroParMod() + Constants.DAMAGE_ANGEL_ROGUE_MOD);

            greatMagician.attachHelpedPlayers(rogue);
        }
    }

    @Override
    public void angelVisit(final Pyromancer pyro, final InputLoader inputLoader) {

        // Same as above
        if (!pyro.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayGoodAngel(this, pyro);

            pyro.setWizardFbMod(pyro.getPyroFbMod() + Constants.DAMAGE_ANGEL_PYRO_MOD);
            pyro.setWizardIgniteMod(pyro.getPyroIgniteMod() + Constants.DAMAGE_ANGEL_PYRO_MOD);
            pyro.setKnightFbMod(pyro.getPyroFbMod() + Constants.DAMAGE_ANGEL_PYRO_MOD);
            pyro.setKnightIgniteMod(pyro.getPyroIgniteMod() + Constants.DAMAGE_ANGEL_PYRO_MOD);
            pyro.setRogueFbMod(pyro.getRogueFbMod() + Constants.DAMAGE_ANGEL_PYRO_MOD);
            pyro.setRogueIgniteMod(pyro.getRogueIgniteMod() + Constants.DAMAGE_ANGEL_PYRO_MOD);
            pyro.setPyroFbMod(pyro.getPyroFbMod() + Constants.DAMAGE_ANGEL_PYRO_MOD);
            pyro.setPyroIgniteMod(pyro.getPyroIgniteMod() + Constants.DAMAGE_ANGEL_PYRO_MOD);

            greatMagician.attachHelpedPlayers(pyro);
        }
    }
}
