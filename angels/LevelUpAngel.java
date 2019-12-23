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

            int maxHp = knight.getMaxHp();
            knight.setHp(maxHp + 80);
            knight.setMaxHp(maxHp + 80);

            inputLoader.displayGoodAngel(this, knight);
            inputLoader.displayLvlEvolution(knight);

            knight.setWizardExecuteMod(knight.getWizardExecuteMod() + 0.1f);
            knight.setWizardSlamMod(knight.getWizardSlamMod() + 0.1f);
            knight.setRogueExecuteMod(knight.getRogueExecuteMod() + 0.1f);
            knight.setRogueSlamMod(knight.getRogueSlamMod() + 0.1f);
            if (knight.getKnightExecuteMod() != 0.0f) {
                knight.setKnightExecuteMod(knight.getKnightExecuteMod() + 0.1f);
            }
            knight.setKnightSlamMod(knight.getKnightSlamMod() + 0.1f);
            knight.setPyroExecuteMod(knight.getPyroExecuteMod() + 0.1f);
            knight.setPyroSlamMod(knight.getPyroSlamMod() + 0.1f);

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

            int maxHp = wizard.getMaxHp();
            wizard.setHp(maxHp + 30);
            wizard.setMaxHp(maxHp + 30);

            inputLoader.displayGoodAngel(this, wizard);
            inputLoader.displayLvlEvolution(wizard);

            wizard.setRogueDrainMod(wizard.getRogueDrainMod() + 0.25f);
            wizard.setRogueDeflectMod(wizard.getRogueDeflectMod() + 0.25f);
            wizard.setWizardDrainMod(wizard.getWizardDrainMod() + 0.25f);
            wizard.setWizardDeflectMod(wizard.getWizardDeflectMod() + 0.25f);
            wizard.setPyroDrainMod(wizard.getPyroDrainMod() + 0.25f);
            wizard.setPyroDeflectMod(wizard.getPyroDeflectMod() + 0.25f);
            wizard.setKnightDrainMod(wizard.getKnightDrainMod() + 0.25f);
            wizard.setKnightDeflectMod(wizard.getKnightDeflectMod()+ 0.25f);

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

            int maxHp = rogue.getMaxHp();
            System.out.println("MaxHp " + maxHp);
            rogue.setHp(maxHp + 40);
            System.out.println(rogue.getHp());
            rogue.setMaxHp(maxHp + 40);
            System.out.println(rogue.getMaxHp());

            inputLoader.displayGoodAngel(this, rogue);
            inputLoader.displayLvlEvolution(rogue);

            rogue.setRogueBsMod(rogue.getRogueBsMod() + 0.15f);
            rogue.setRogueParMod(rogue.getRogueParMod() + 0.15f);
            rogue.setWizardBsMod(rogue.getWizardBsMod() + 0.15f);
            rogue.setWizardParMod(rogue.getWizardParMod() + 0.15f);
            rogue.setKnightBsMod(rogue.getKnightBsMod() + 0.15f);
            rogue.setKnightParMod(rogue.getKnightParMod() + 0.15f);
            rogue.setPyroBsMod(rogue.getPyroBsMod() + 0.15f);
            rogue.setPyroParMod(rogue.getPyroParMod()+ 0.15f);

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

            int maxHp = pyro.getMaxHp();
            pyro.setHp(maxHp + 50);
            pyro.setMaxHp(maxHp + 50);

            inputLoader.displayGoodAngel(this, pyro);
            inputLoader.displayLvlEvolution(pyro);

            pyro.setWizardFbMod(pyro.getPyroFbMod() + 0.2f);
            pyro.setWizardIgniteMod(pyro.getPyroIgniteMod() + 0.2f);
            pyro.setKnightFbMod(pyro.getPyroFbMod() + 0.2f);
            pyro.setKnightIgniteMod(pyro.getPyroIgniteMod() + 0.2f);
            pyro.setRogueFbMod(pyro.getRogueFbMod() + 0.2f);
            pyro.setRogueIgniteMod(pyro.getRogueIgniteMod() + 0.2f);
            pyro.setPyroFbMod(pyro.getPyroFbMod() + 0.2f);
            pyro.setPyroIgniteMod(pyro.getPyroIgniteMod()+ 0.2f);

            greatMagician.attachHelpedPlayers(pyro);
        }
    }
}
