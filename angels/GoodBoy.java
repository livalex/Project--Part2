package angels;

import admin.GreatMagician;
import constants.Constants;
import main.InputLoader;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public final class GoodBoy extends Angel implements Subject, AngelVisitor {

    public GoodBoy(final int abscissa, final int ordinate) {
        setMyAbscissa(abscissa);
        setMyOrdinate(ordinate);
        setAngelType(Constants.GOOD_BOY_ANGEL);
        super.updateAngelAbs(abscissa);
        super.updateAngelOrd(ordinate);
    }

    @Override
    public void angelVisit(final Knight knight, final InputLoader inputLoader) {
        if (!knight.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            // Angel helped player message
            inputLoader.displayGoodAngel(this, knight);

            // Update hp
            knight.setHp(knight.getHp() + Constants.GB_ANGEL_KNIGHT_INCREASE);

            // Make sure the life of the player isn't bigger the player's
            // maxHp
            if (knight.getHp() > knight.getMaxHp()) {
                knight.setHp(knight.getMaxHp());
            }

            // Update the race modifiers of the player
            knight.setWizardExecuteMod(knight.getWizardExecuteMod()
                    + Constants.GB_ANGEL_KNIGHT_MOD);
            knight.setWizardSlamMod(knight.getWizardSlamMod() + Constants.GB_ANGEL_KNIGHT_MOD);
            knight.setRogueExecuteMod(knight.getRogueExecuteMod() + Constants.GB_ANGEL_KNIGHT_MOD);
            knight.setRogueSlamMod(knight.getRogueSlamMod() + Constants.GB_ANGEL_KNIGHT_MOD);
            if (knight.getKnightExecuteMod() != Constants.DEFAULT_STARTING_VALUE) {
                knight.setKnightExecuteMod(knight.getKnightExecuteMod()
                        + Constants.GB_ANGEL_KNIGHT_MOD);
            }
            knight.setKnightSlamMod(knight.getKnightSlamMod() + Constants.GB_ANGEL_KNIGHT_MOD);
            knight.setPyroExecuteMod(knight.getPyroExecuteMod() + Constants.GB_ANGEL_KNIGHT_MOD);
            knight.setPyroSlamMod(knight.getPyroSlamMod() + Constants.GB_ANGEL_KNIGHT_MOD);

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

            wizard.setHp(wizard.getHp() + Constants.GB_ANGEL_WIZARD_INCREASE);

            if (wizard.getHp() > wizard.getMaxHp()) {
                wizard.setHp(wizard.getMaxHp());
            }

            wizard.setRogueDrainMod(wizard.getRogueDrainMod() + Constants.GB_ANGEL_WIZARD_MOD);
            wizard.setRogueDeflectMod(wizard.getRogueDeflectMod() + Constants.GB_ANGEL_WIZARD_MOD);
            wizard.setWizardDrainMod(wizard.getWizardDrainMod() + Constants.GB_ANGEL_WIZARD_MOD);
            wizard.setWizardDeflectMod(wizard.getWizardDeflectMod()
                    + Constants.GB_ANGEL_WIZARD_MOD);
            wizard.setPyroDrainMod(wizard.getPyroDrainMod() + Constants.GB_ANGEL_WIZARD_MOD);
            wizard.setPyroDeflectMod(wizard.getPyroDeflectMod() + Constants.GB_ANGEL_WIZARD_MOD);
            wizard.setKnightDrainMod(wizard.getKnightDrainMod() + Constants.GB_ANGEL_WIZARD_MOD);
            wizard.setKnightDeflectMod(wizard.getKnightDeflectMod()
                    + Constants.GB_ANGEL_WIZARD_MOD);

            greatMagician.attachHelpedPlayers(wizard);
        }
    }

    @Override
    public void angelVisit(final Rogue rogue, final InputLoader inputLoader) {

        // Same as above
        if (!rogue.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayGoodAngel(this, rogue);

            rogue.setHp(rogue.getHp() + Constants.GB_ANGEL_ROGUE_INCREASE);

            if (rogue.getHp() > rogue.getMaxHp()) {
                rogue.setHp(rogue.getMaxHp());
            }

            rogue.setRogueBsMod(rogue.getRogueBsMod() + Constants.GB_ANGEL_ROGUE_MOD);
            rogue.setRogueParMod(rogue.getRogueParMod() + Constants.GB_ANGEL_ROGUE_MOD);
            rogue.setWizardBsMod(rogue.getWizardBsMod() + Constants.GB_ANGEL_ROGUE_MOD);
            rogue.setWizardParMod(rogue.getWizardParMod() + Constants.GB_ANGEL_ROGUE_MOD);
            rogue.setKnightBsMod(rogue.getKnightBsMod() + Constants.GB_ANGEL_ROGUE_MOD);
            rogue.setKnightParMod(rogue.getKnightParMod() + Constants.GB_ANGEL_ROGUE_MOD);
            rogue.setPyroBsMod(rogue.getPyroBsMod() + Constants.GB_ANGEL_ROGUE_MOD);
            rogue.setPyroParMod(rogue.getPyroParMod() + Constants.GB_ANGEL_ROGUE_MOD);

            greatMagician.attachHelpedPlayers(rogue);
        }
    }

    @Override
    public void angelVisit(final Pyromancer pyro, final InputLoader inputLoader) {

        // Same as above
        if (!pyro.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayGoodAngel(this, pyro);

            pyro.setHp(pyro.getHp() + Constants.GB_ANGEL_PYRO_INCREASE);

            if (pyro.getHp() > pyro.getMaxHp()) {
                pyro.setHp(pyro.getMaxHp());
            }

            pyro.setWizardFbMod(pyro.getPyroFbMod() + Constants.GB_ANGEL_PYRO_MOD);
            pyro.setWizardIgniteMod(pyro.getPyroIgniteMod() + Constants.GB_ANGEL_PYRO_MOD);
            pyro.setKnightFbMod(pyro.getPyroFbMod() + Constants.GB_ANGEL_PYRO_MOD);
            pyro.setKnightIgniteMod(pyro.getPyroIgniteMod() + Constants.GB_ANGEL_PYRO_MOD);
            pyro.setRogueFbMod(pyro.getRogueFbMod() + Constants.GB_ANGEL_PYRO_MOD);
            pyro.setRogueIgniteMod(pyro.getRogueIgniteMod() + Constants.GB_ANGEL_PYRO_MOD);
            pyro.setPyroFbMod(pyro.getPyroFbMod() + Constants.GB_ANGEL_PYRO_MOD);
            pyro.setPyroIgniteMod(pyro.getPyroIgniteMod() + Constants.GB_ANGEL_PYRO_MOD);

            greatMagician.attachHelpedPlayers(pyro);
        }
    }
}
