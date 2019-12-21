package angels;

import GameAdmin.GreatMagician;
import constants.Constants;
import main.InputLoader;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public class LevelUpAngel extends Angel implements Subject, AngelVisitor {
    public LevelUpAngel(final int abscissa, final int ordinate) {
        setMyAbscissa(abscissa);
        setMyOrdinate(ordinate);
        setAngelType(Constants.LEVEL_UP_ANGEL);
        super.updateAngelAbs(abscissa);
        super.updateAngelOrd(ordinate);
    }

    @Override
    public void angelVisit(Knight knight, InputLoader inputLoader) {
        if (!knight.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            int level = knight.getLevel();
            knight.setXp(250 + level * 50);
            ++level;
            knight.setLevel(level);

            inputLoader.displayGoodAngel(this, knight);
            inputLoader.displayLvlEvolution(knight);

            knight.setKnightBsMod(knight.getKnightBsMod() + 0.1f);
            knight.setKnightParMod(knight.getKnightParMod() + 0.1f);
            knight.setKnightDrainMod(knight.getKnightDrainMod() + 0.1f);
            knight.setKnightDeflectMod(knight.getKnightDeflectMod() + 0.1f);
            if (knight.getKnightExecuteMod() != 0.0f) {
                knight.setKnightExecuteMod(knight.getKnightExecuteMod() + 0.1f);
            }
            knight.setKnightSlamMod(knight.getKnightSlamMod() + 0.1f);
            knight.setKnightFbMod(knight.getKnightFbMod() + 0.1f);
            knight.setKnightIgniteMod(knight.getKnightIgniteMod() + 0.1f);

            greatMagician.attachHelpedPlayers(knight);
        }
    }

    @Override
    public void angelVisit(Wizard wizard, InputLoader inputLoader) {
        if (!wizard.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            int level = wizard.getLevel();
            wizard.setXp(250 + level * 50);
            ++level;
            wizard.setLevel(level);

            inputLoader.displayGoodAngel(this, wizard);
            inputLoader.displayLvlEvolution(wizard);

            wizard.setWizardBsMod(wizard.getWizardBsMod() + 0.25f);
            wizard.setWizardParMod(wizard.getWizardParMod() + 0.25f);
            wizard.setWizardDrainMod(wizard.getWizardDrainMod() + 0.25f);
            wizard.setWizardDeflectMod(wizard.getWizardDeflectMod() + 0.25f);
            wizard.setWizardExecuteMod(wizard.getWizardExecuteMod() + 0.25f);
            wizard.setWizardSlamMod(wizard.getWizardSlamMod() + 0.25f);
            wizard.setWizardFbMod(wizard.getWizardFbMod() + 0.25f);
            wizard.setWizardIgniteMod(wizard.getWizardIgniteMod() + 0.25f);

            greatMagician.attachHelpedPlayers(wizard);
        }
    }

    @Override
    public void angelVisit(Rogue rogue, InputLoader inputLoader) {
        if (!rogue.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            int level = rogue.getLevel();
            rogue.setXp(250 + level * 50);
            ++level;
            rogue.setLevel(level);

            inputLoader.displayGoodAngel(this, rogue);
            inputLoader.displayLvlEvolution(rogue);

            rogue.setRogueBsMod(rogue.getRogueBsMod() + 0.15f);
            rogue.setRogueParMod(rogue.getRogueParMod() + 0.15f);
            rogue.setRogueDrainMod(rogue.getRogueDrainMod() + 0.15f);
            rogue.setRogueDeflectMod(rogue.getRogueDeflectMod() + 0.15f);
            rogue.setRogueExecuteMod(rogue.getRogueExecuteMod() + 0.15f);
            rogue.setRogueSlamMod(rogue.getRogueSlamMod() + 0.15f);
            rogue.setRogueFbMod(rogue.getRogueFbMod() + 0.15f);
            rogue.setRogueIgniteMod(rogue.getRogueIgniteMod() + 0.15f);

            greatMagician.attachHelpedPlayers(rogue);
        }
    }

    @Override
    public void angelVisit(Pyromancer pyro, InputLoader inputLoader) {
        if (!pyro.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            int level = pyro.getLevel();
            pyro.setXp(250 + level * 50);
            ++level;
            pyro.setLevel(level);

            inputLoader.displayGoodAngel(this, pyro);
            inputLoader.displayLvlEvolution(pyro);

            pyro.setPyroBsMod(pyro.getPyroBsMod() + 0.2f);
            pyro.setPyroParMod(pyro.getPyroParMod() + 0.2f);
            pyro.setPyroDrainMod(pyro.getPyroDrainMod() + 0.2f);
            pyro.setPyroDeflectMod(pyro.getPyroDeflectMod() + 0.2f);
            pyro.setPyroExecuteMod(pyro.getPyroExecuteMod() + 0.2f);
            pyro.setPyroSlamMod(pyro.getPyroSlamMod() + 0.2f);
            pyro.setPyroFbMod(pyro.getPyroFbMod() + 0.2f);
            pyro.setPyroIgniteMod(pyro.getPyroIgniteMod() + 0.2f);

            greatMagician.attachHelpedPlayers(pyro);
        }
    }
}
