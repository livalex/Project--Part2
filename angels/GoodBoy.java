package angels;

import GameAdmin.GreatMagician;
import constants.Constants;
import main.Input;
import main.InputLoader;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public class GoodBoy extends Angel implements Subject, AngelVisitor {
    public GoodBoy(final int abscissa, final int ordinate) {
        setMyAbscissa(abscissa);
        setMyOrdinate(ordinate);
        setAngelType(Constants.GOOD_BOY_ANGEL);
        super.updateAngelAbs(abscissa);
        super.updateAngelOrd(ordinate);
    }

    @Override
    public void angelVisit(Knight knight, InputLoader inputLoader) {
        if (!knight.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayBadAngel(this, knight);

            knight.setHp(knight.getHp() + 20);

            knight.setKnightBsMod(knight.getKnightBsMod() + 0.4f);
            knight.setKnightParMod(knight.getKnightParMod() + 0.4f);
            knight.setKnightDrainMod(knight.getKnightDrainMod() + 0.4f);
            knight.setKnightDeflectMod(knight.getKnightDeflectMod() + 0.4f);
            if (knight.getKnightExecuteMod() != 0.0f) {
                knight.setKnightExecuteMod(knight.getKnightExecuteMod() + 0.4f);
            }
            knight.setKnightSlamMod(knight.getKnightSlamMod() + 0.4f);
            knight.setKnightFbMod(knight.getKnightFbMod() + 0.4f);
            knight.setKnightIgniteMod(knight.getKnightIgniteMod() + 0.4f);

            greatMagician.attachHelpedPlayers(knight);
        }
    }

    @Override
    public void angelVisit(Wizard wizard, InputLoader inputLoader) {
        if (!wizard.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayBadAngel(this, wizard);

            wizard.setHp(wizard.getHp() + 50);

            wizard.setWizardBsMod(wizard.getWizardBsMod() + 0.3f);
            wizard.setWizardParMod(wizard.getWizardParMod() + 0.3f);
            wizard.setWizardDrainMod(wizard.getWizardDrainMod() + 0.3f);
            wizard.setWizardDeflectMod(wizard.getWizardDeflectMod() + 0.3f);
            wizard.setWizardExecuteMod(wizard.getWizardExecuteMod() + 0.3f);
            wizard.setWizardSlamMod(wizard.getWizardSlamMod() + 0.3f);
            wizard.setWizardFbMod(wizard.getWizardFbMod() + 0.3f);
            wizard.setWizardIgniteMod(wizard.getWizardIgniteMod() + 0.3f);

            greatMagician.attachHelpedPlayers(wizard);
        }

    }

    @Override
    public void angelVisit(Rogue rogue, InputLoader inputLoader) {
        if (!rogue.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayBadAngel(this, rogue);

            rogue.setHp(rogue.getHp() + 40);

            rogue.setRogueBsMod(rogue.getRogueBsMod() + 0.4f);
            rogue.setRogueParMod(rogue.getRogueParMod() + 0.4f);
            rogue.setRogueDrainMod(rogue.getRogueDrainMod() + 0.4f);
            rogue.setRogueDeflectMod(rogue.getRogueDeflectMod() + 0.4f);
            rogue.setRogueExecuteMod(rogue.getRogueExecuteMod() + 0.4f);
            rogue.setRogueSlamMod(rogue.getRogueSlamMod() + 0.4f);
            rogue.setRogueFbMod(rogue.getRogueFbMod() + 0.4f);
            rogue.setRogueIgniteMod(rogue.getRogueIgniteMod() + 0.4f);

            greatMagician.attachHelpedPlayers(rogue);
        }
    }

    @Override
    public void angelVisit(Pyromancer pyro, InputLoader inputLoader) {
        if (!pyro.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayBadAngel(this, pyro);

            pyro.setHp(pyro.getHp() + 30);

            pyro.setPyroBsMod(pyro.getPyroBsMod() + 0.5f);
            pyro.setPyroParMod(pyro.getPyroParMod() + 0.5f);
            pyro.setPyroDrainMod(pyro.getPyroDrainMod() + 0.5f);
            pyro.setPyroDeflectMod(pyro.getPyroDeflectMod() + 0.5f);
            pyro.setPyroExecuteMod(pyro.getPyroExecuteMod() + 0.5f);
            pyro.setPyroSlamMod(pyro.getPyroSlamMod() + 0.5f);
            pyro.setPyroFbMod(pyro.getPyroFbMod() + 0.5f);
            pyro.setPyroIgniteMod(pyro.getPyroIgniteMod() + 0.5f);

            greatMagician.attachHelpedPlayers(pyro);
        }
    }
}
