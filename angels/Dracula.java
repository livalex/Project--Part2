package angels;

import admin.GreatMagician;
import constants.Constants;
import main.InputLoader;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public final class Dracula extends Angel implements Subject, AngelVisitor {

    public Dracula(final int abscissa, final int ordinate) {
        setMyAbscissa(abscissa);
        setMyOrdinate(ordinate);
        setAngelType(Constants.DRACULA_ANGEL);
        super.updateAngelAbs(abscissa);
        super.updateAngelOrd(ordinate);
    }

    @Override
    public void angelVisit(final Knight knight, final InputLoader inputLoader) {
        if (!knight.isDead()) {

            GreatMagician greatMagician = GreatMagician.getInstance();

            // Display angel hit player message
            inputLoader.displayBadAngel(this, knight);

            // Update health
            knight.setHp(knight.getHp() - Constants.DRACULA_ANGEL_KNIGHT_INCREASE);

            if (knight.getHp() <= Constants.DEFAULT_STARTING_VALUE) {

                // Declare death
                knight.setDead(true);

                // Player killed by an angel message
                inputLoader.deathByAngel(knight);

                // Notify the magician
                greatMagician.attachKilledPlayers(knight);
            }

            // Update the race modifiers according to the angel abilities
            knight.setWizardExecuteMod(knight.getWizardExecuteMod()
                    - Constants.DRACULA_ANGEL_KNIGHT_MOD);
            knight.setWizardSlamMod(knight.getWizardSlamMod() - Constants.DRACULA_ANGEL_KNIGHT_MOD);
            knight.setRogueExecuteMod(knight.getRogueExecuteMod()
                    - Constants.DRACULA_ANGEL_KNIGHT_MOD);
            knight.setRogueSlamMod(knight.getRogueSlamMod() - Constants.DRACULA_ANGEL_KNIGHT_MOD);
            if (knight.getKnightExecuteMod() != Constants.DEFAULT_STARTING_VALUE) {
                knight.setKnightExecuteMod(knight.getKnightExecuteMod()
                        - Constants.DRACULA_ANGEL_KNIGHT_MOD);
            }
            knight.setKnightSlamMod(knight.getKnightSlamMod() - Constants.DRACULA_ANGEL_KNIGHT_MOD);
            knight.setPyroExecuteMod(knight.getPyroExecuteMod()
                    - Constants.DRACULA_ANGEL_KNIGHT_MOD);
            knight.setPyroSlamMod(knight.getPyroSlamMod() - Constants.DRACULA_ANGEL_KNIGHT_MOD);

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

            wizard.setHp(wizard.getHp() - Constants.DRACULA_ANGEL_WIZARD_INCREASE);

            if (wizard.getHp() <= Constants.DEFAULT_STARTING_VALUE) {
                wizard.setDead(true);
                inputLoader.deathByAngel(wizard);
                greatMagician.attachKilledPlayers(wizard);
            }

            wizard.setRogueDrainMod(wizard.getRogueDrainMod() - Constants.DRACULA_ANGEL_WIZARD_MOD);
            wizard.setRogueDeflectMod(wizard.getRogueDeflectMod()
                    - Constants.DRACULA_ANGEL_WIZARD_MOD);
            wizard.setWizardDrainMod(wizard.getWizardDrainMod()
                    - Constants.DRACULA_ANGEL_WIZARD_MOD);
            wizard.setWizardDeflectMod(wizard.getWizardDeflectMod()
                    - Constants.DRACULA_ANGEL_WIZARD_MOD);
            wizard.setPyroDrainMod(wizard.getPyroDrainMod() - Constants.DRACULA_ANGEL_WIZARD_MOD);
            wizard.setPyroDeflectMod(wizard.getPyroDeflectMod()
                    - Constants.DRACULA_ANGEL_WIZARD_MOD);
            wizard.setKnightDrainMod(wizard.getKnightDrainMod()
                    - Constants.DRACULA_ANGEL_WIZARD_MOD);
            wizard.setKnightDeflectMod(wizard.getKnightDeflectMod()
                    - Constants.DRACULA_ANGEL_WIZARD_MOD);

            greatMagician.attachHitPlayers(wizard);
        }
    }

    @Override
    public void angelVisit(final Rogue rogue, final InputLoader inputLoader) {

        // Same as above
        if (!rogue.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayBadAngel(this, rogue);

            rogue.setHp(rogue.getHp() - Constants.DRACULA_ANGEL_ROGUE_INCREASE);

            if (rogue.getHp() <= Constants.DEFAULT_STARTING_VALUE) {
                rogue.setDead(true);
                inputLoader.deathByAngel(rogue);
                greatMagician.attachKilledPlayers(rogue);
            }

            rogue.setRogueBsMod(rogue.getRogueBsMod() - Constants.DRACULA_ANGEL_ROGUE_MOD);
            rogue.setRogueParMod(rogue.getRogueParMod() - Constants.DRACULA_ANGEL_ROGUE_MOD);
            rogue.setWizardBsMod(rogue.getWizardBsMod() - Constants.DRACULA_ANGEL_ROGUE_MOD);
            rogue.setWizardParMod(rogue.getWizardParMod() - Constants.DRACULA_ANGEL_ROGUE_MOD);
            rogue.setKnightBsMod(rogue.getKnightBsMod() - Constants.DRACULA_ANGEL_ROGUE_MOD);
            rogue.setKnightParMod(rogue.getKnightParMod() - Constants.DRACULA_ANGEL_ROGUE_MOD);
            rogue.setPyroBsMod(rogue.getPyroBsMod() - Constants.DRACULA_ANGEL_ROGUE_MOD);
            rogue.setPyroParMod(rogue.getPyroParMod() - Constants.DRACULA_ANGEL_ROGUE_MOD);

            greatMagician.attachHitPlayers(rogue);
        }
    }

    @Override
    public void angelVisit(final Pyromancer pyro, final InputLoader inputLoader) {

        // Same as above
        if (!pyro.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayBadAngel(this, pyro);

            pyro.setHp(pyro.getHp() - Constants.DRACULA_ANGEL_PYRO_INCREASE);

            if (pyro.getHp() <= Constants.DEFAULT_STARTING_VALUE) {
                pyro.setDead(true);
                inputLoader.deathByAngel(pyro);
                greatMagician.attachKilledPlayers(pyro);
            }

            pyro.setWizardFbMod(pyro.getPyroFbMod() - Constants.DRACULA_ANGEL_PYRO_MOD);
            pyro.setWizardIgniteMod(pyro.getPyroIgniteMod() - Constants.DRACULA_ANGEL_PYRO_MOD);
            pyro.setKnightFbMod(pyro.getPyroFbMod() - Constants.DRACULA_ANGEL_PYRO_MOD);
            pyro.setKnightIgniteMod(pyro.getPyroIgniteMod() - Constants.DRACULA_ANGEL_PYRO_MOD);
            pyro.setRogueFbMod(pyro.getRogueFbMod() - Constants.DRACULA_ANGEL_PYRO_MOD);
            pyro.setRogueIgniteMod(pyro.getRogueIgniteMod() - Constants.DRACULA_ANGEL_PYRO_MOD);
            pyro.setPyroFbMod(pyro.getPyroFbMod() - Constants.DRACULA_ANGEL_PYRO_MOD);
            pyro.setPyroIgniteMod(pyro.getPyroIgniteMod() - Constants.DRACULA_ANGEL_PYRO_MOD);

            greatMagician.attachHitPlayers(pyro);
        }
    }
}
