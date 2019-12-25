package angels;

import GameAdmin.GreatMagician;
import constants.Constants;
import main.InputLoader;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public class SmallAngel extends Angel implements Subject, AngelVisitor {

    public SmallAngel(final int abscissa, final int ordinate) {
        setMyAbscissa(abscissa);
        setMyOrdinate(ordinate);
        setAngelType(Constants.SMALL_ANGEL);
        super.updateAngelAbs(abscissa);
        super.updateAngelOrd(ordinate);
    }

    @Override
    public void angelVisit(Knight knight, InputLoader inputLoader) {
        if (!knight.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayGoodAngel(this, knight);

            knight.setHp(knight.getHp() + 10);

            if (knight.getHp() > knight.getMaxHp()) {
                knight.setHp(knight.getMaxHp());
            }

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

            inputLoader.displayGoodAngel(this, wizard);

            wizard.setHp(wizard.getHp() + 25);

            if (wizard.getHp() > wizard.getMaxHp()) {
                wizard.setHp(wizard.getMaxHp());
            }

            wizard.setRogueDrainMod(wizard.getRogueDrainMod() + 0.1f);
            wizard.setRogueDeflectMod(wizard.getRogueDeflectMod() + 0.1f);
            wizard.setWizardDrainMod(wizard.getWizardDrainMod() + 0.1f);
            wizard.setWizardDeflectMod(wizard.getWizardDeflectMod() + 0.1f);
            wizard.setPyroDrainMod(wizard.getPyroDrainMod() + 0.1f);
            wizard.setPyroDeflectMod(wizard.getPyroDeflectMod() + 0.1f);
            wizard.setKnightDrainMod(wizard.getKnightDrainMod() + 0.1f);
            wizard.setKnightDeflectMod(wizard.getKnightDeflectMod()+ 0.1f);

            greatMagician.attachHelpedPlayers(wizard);
        }
    }

    @Override
    public void angelVisit(Rogue rogue, InputLoader inputLoader) {
        if (!rogue.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayGoodAngel(this, rogue);

            rogue.setHp(rogue.getHp() + 20);

            if (rogue.getHp() > rogue.getMaxHp()) {
                rogue.setHp(rogue.getMaxHp());
            }

            rogue.setRogueBsMod(rogue.getRogueBsMod() + 0.05f);
            rogue.setRogueParMod(rogue.getRogueParMod() + 0.05f);
            rogue.setWizardBsMod(rogue.getWizardBsMod() + 0.05f);
            rogue.setWizardParMod(rogue.getWizardParMod() + 0.05f);
            rogue.setKnightBsMod(rogue.getKnightBsMod() + 0.05f);
            rogue.setKnightParMod(rogue.getKnightParMod() + 0.05f);
            rogue.setPyroBsMod(rogue.getPyroBsMod() + 0.05f);
            rogue.setPyroParMod(rogue.getPyroParMod()+ 0.05f);

            greatMagician.attachHelpedPlayers(rogue);
        }
    }

    @Override
    public void angelVisit(Pyromancer pyro, InputLoader inputLoader) {
        if (!pyro.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayGoodAngel(this, pyro);

            pyro.setHp(pyro.getHp() + 15);

            if (pyro.getHp() > pyro.getMaxHp()) {
                pyro.setHp(pyro.getMaxHp());
            }

            pyro.setWizardFbMod(pyro.getPyroFbMod() + 0.15f);
            pyro.setWizardIgniteMod(pyro.getPyroIgniteMod() + 0.15f);
            pyro.setKnightFbMod(pyro.getPyroFbMod() + 0.15f);
            pyro.setKnightIgniteMod(pyro.getPyroIgniteMod() + 0.15f);
            pyro.setRogueFbMod(pyro.getRogueFbMod() + 0.15f);
            pyro.setRogueIgniteMod(pyro.getRogueIgniteMod() + 0.15f);
            pyro.setPyroFbMod(pyro.getPyroFbMod() + 0.15f);
            pyro.setPyroIgniteMod(pyro.getPyroIgniteMod()+ 0.15f);

            greatMagician.attachHelpedPlayers(pyro);
        }
    }
}
