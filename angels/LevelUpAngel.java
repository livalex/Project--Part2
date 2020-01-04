package angels;

import admin.GreatMagician;
import constants.Constants;
import main.InputLoader;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public final class LevelUpAngel extends Angel implements Subject, AngelVisitor {

    public LevelUpAngel(final int abscissa, final int ordinate) {
        setMyAbscissa(abscissa);
        setMyOrdinate(ordinate);
        setAngelType(Constants.LEVEL_UP_ANGEL);
        super.updateAngelAbs(abscissa);
        super.updateAngelOrd(ordinate);
    }

    @Override
    public void angelVisit(final Knight knight, final InputLoader inputLoader) {
        if (!knight.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            // Update the player's level according to his XP
            int level = knight.getLevel();
            knight.setXp(Constants.XP_FORMULA_FIRST_FACTOR
                    + level * Constants.XP_FORMULA_SECOND_FACTOR);
            ++level;
            knight.setLevel(level);

            // Update the player's HP according to his level
            int maxHp = knight.getMaxHp();
            knight.setHp(maxHp + Constants.LV_ANGEL_KNIGHT_INCREASE);
            knight.setMaxHp(maxHp + Constants.LV_ANGEL_KNIGHT_INCREASE);

            // Display player was helped by an angel message
            inputLoader.displayGoodAngel(this, knight);

            // Display level evolution
            inputLoader.displayLvlEvolution(knight);

            // Update the race modifiers of the player
            knight.setWizardExecuteMod(knight.getWizardExecuteMod()
                    + Constants.LV_ANGEL_KNIGHT_MOD);
            knight.setWizardSlamMod(knight.getWizardSlamMod() + Constants.LV_ANGEL_KNIGHT_MOD);
            knight.setRogueExecuteMod(knight.getRogueExecuteMod() + Constants.LV_ANGEL_KNIGHT_MOD);
            knight.setRogueSlamMod(knight.getRogueSlamMod() + Constants.LV_ANGEL_KNIGHT_MOD);
            if (knight.getKnightExecuteMod() != Constants.UNCHANGEABLE_VALUE) {
                knight.setKnightExecuteMod(knight.getKnightExecuteMod()
                        + Constants.LV_ANGEL_KNIGHT_MOD);
            }
            knight.setKnightSlamMod(knight.getKnightSlamMod() + Constants.LV_ANGEL_KNIGHT_MOD);
            knight.setPyroExecuteMod(knight.getPyroExecuteMod() + Constants.LV_ANGEL_KNIGHT_MOD);
            knight.setPyroSlamMod(knight.getPyroSlamMod() + Constants.LV_ANGEL_KNIGHT_MOD);

            // Notify the magician
            greatMagician.attachHelpedPlayers(knight);
        }
    }

    @Override
    public void angelVisit(final Wizard wizard, final InputLoader inputLoader) {

        // Same as above
        if (!wizard.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            int level = wizard.getLevel();
            wizard.setXp(Constants.XP_FORMULA_FIRST_FACTOR
                    + level * Constants.XP_FORMULA_SECOND_FACTOR);
            ++level;
            wizard.setLevel(level);

            int maxHp = wizard.getMaxHp();
            wizard.setHp(maxHp + Constants.LV_ANGEL_WIZARD_INCREASE);
            wizard.setMaxHp(maxHp + Constants.LV_ANGEL_WIZARD_INCREASE);

            inputLoader.displayGoodAngel(this, wizard);
            inputLoader.displayLvlEvolution(wizard);

            wizard.setRogueDrainMod(wizard.getRogueDrainMod() + Constants.LV_ANGEL_WIZARD_MOD);
            wizard.setRogueDeflectMod(wizard.getRogueDeflectMod() + Constants.LV_ANGEL_WIZARD_MOD);
            wizard.setWizardDrainMod(wizard.getWizardDrainMod() + Constants.LV_ANGEL_WIZARD_MOD);
            wizard.setWizardDeflectMod(wizard.getWizardDeflectMod()
                    + Constants.LV_ANGEL_WIZARD_MOD);
            wizard.setPyroDrainMod(wizard.getPyroDrainMod() + Constants.LV_ANGEL_WIZARD_MOD);
            wizard.setPyroDeflectMod(wizard.getPyroDeflectMod() + Constants.LV_ANGEL_WIZARD_MOD);
            wizard.setKnightDrainMod(wizard.getKnightDrainMod() + Constants.LV_ANGEL_WIZARD_MOD);
            wizard.setKnightDeflectMod(wizard.getKnightDeflectMod()
                    + Constants.LV_ANGEL_WIZARD_MOD);

            greatMagician.attachHelpedPlayers(wizard);
        }
    }

    @Override
    public void angelVisit(final Rogue rogue, final InputLoader inputLoader) {

        // Same as above
        if (!rogue.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            int level = rogue.getLevel();
            rogue.setXp(Constants.XP_FORMULA_FIRST_FACTOR
                    + level * Constants.XP_FORMULA_SECOND_FACTOR);
            ++level;
            rogue.setLevel(level);

            int maxHp = rogue.getMaxHp();
            rogue.setHp(maxHp + Constants.LV_ANGEL_ROGUE_INCREASE);
            rogue.setMaxHp(maxHp + Constants.LV_ANGEL_ROGUE_INCREASE);

            inputLoader.displayGoodAngel(this, rogue);
            inputLoader.displayLvlEvolution(rogue);

            rogue.setRogueBsMod(rogue.getRogueBsMod() + Constants.LV_ANGEL_ROGUE_MOD);
            rogue.setRogueParMod(rogue.getRogueParMod() + Constants.LV_ANGEL_ROGUE_MOD);
            rogue.setWizardBsMod(rogue.getWizardBsMod() + Constants.LV_ANGEL_ROGUE_MOD);
            rogue.setWizardParMod(rogue.getWizardParMod() + Constants.LV_ANGEL_ROGUE_MOD);
            rogue.setKnightBsMod(rogue.getKnightBsMod() + Constants.LV_ANGEL_ROGUE_MOD);
            rogue.setKnightParMod(rogue.getKnightParMod() + Constants.LV_ANGEL_ROGUE_MOD);
            rogue.setPyroBsMod(rogue.getPyroBsMod() + Constants.LV_ANGEL_ROGUE_MOD);
            rogue.setPyroParMod(rogue.getPyroParMod() + Constants.LV_ANGEL_ROGUE_MOD);

            greatMagician.attachHelpedPlayers(rogue);
        }
    }

    @Override
    public void angelVisit(final Pyromancer pyro, final InputLoader inputLoader) {

        // Same as above
        if (!pyro.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            int level = pyro.getLevel();
            pyro.setXp(Constants.XP_FORMULA_FIRST_FACTOR
                    + level * Constants.XP_FORMULA_SECOND_FACTOR);
            ++level;
            pyro.setLevel(level);

            int maxHp = pyro.getMaxHp();
            pyro.setHp(maxHp + Constants.LV_ANGEL_PYRO_INCREASE);
            pyro.setMaxHp(maxHp + Constants.LV_ANGEL_PYRO_INCREASE);

            inputLoader.displayGoodAngel(this, pyro);
            inputLoader.displayLvlEvolution(pyro);

            pyro.setWizardFbMod(pyro.getPyroFbMod() + Constants.LV_ANGEL_PYRO_MOD);
            pyro.setWizardIgniteMod(pyro.getPyroIgniteMod() + Constants.LV_ANGEL_PYRO_MOD);
            pyro.setKnightFbMod(pyro.getPyroFbMod() + Constants.LV_ANGEL_PYRO_MOD);
            pyro.setKnightIgniteMod(pyro.getPyroIgniteMod() + Constants.LV_ANGEL_PYRO_MOD);
            pyro.setRogueFbMod(pyro.getRogueFbMod() + Constants.LV_ANGEL_PYRO_MOD);
            pyro.setRogueIgniteMod(pyro.getRogueIgniteMod() + Constants.LV_ANGEL_PYRO_MOD);
            pyro.setPyroFbMod(pyro.getPyroFbMod() + Constants.LV_ANGEL_PYRO_MOD);
            pyro.setPyroIgniteMod(pyro.getPyroIgniteMod() + Constants.LV_ANGEL_PYRO_MOD);

            greatMagician.attachHelpedPlayers(pyro);
        }
    }
}
