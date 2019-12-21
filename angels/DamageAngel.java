package angels;

import GameAdmin.GreatMagician;
import constants.Constants;
import main.InputLoader;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public class DamageAngel extends Angel implements Subject, AngelVisitor {

    public DamageAngel(final int abscissa, final int ordinate) {
        setMyAbscissa(abscissa);
        setMyOrdinate(ordinate);
        setAngelType(Constants.DAMAGE_ANGEL);
        super.updateAngelAbs(abscissa);
        super.updateAngelOrd(ordinate);
    }

    @Override
    public void angelVisit(Knight knight, InputLoader inputLoader) {
        if (!knight.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayGoodAngel(this, knight);

            knight.setKnightBsMod(knight.getKnightBsMod() + 0.15f);
            knight.setKnightParMod(knight.getKnightParMod() + 0.15f);
            knight.setKnightDrainMod(knight.getKnightDrainMod() + 0.15f);
            knight.setKnightDeflectMod(knight.getKnightDeflectMod() + 0.15f);
            if (knight.getKnightExecuteMod() != 0.0f) {
                knight.setKnightExecuteMod(knight.getKnightExecuteMod() + 0.15f);
            }
            knight.setKnightSlamMod(knight.getKnightSlamMod() + 0.15f);
            knight.setKnightFbMod(knight.getKnightFbMod() + 0.15f);
            knight.setKnightIgniteMod(knight.getKnightIgniteMod() + 0.15f);

            greatMagician.attachHelpedPlayers(knight);
        }
    }

    @Override
    public void angelVisit(Wizard wizard, InputLoader inputLoader) {
        if (!wizard.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayGoodAngel(this, wizard);

            wizard.setWizardBsMod(wizard.getWizardBsMod() + 0.4f);
            wizard.setWizardParMod(wizard.getWizardParMod() + 0.4f);
            wizard.setWizardDrainMod(wizard.getWizardDrainMod() + 0.4f);
            wizard.setWizardDeflectMod(wizard.getWizardDeflectMod() + 0.4f);
            wizard.setWizardExecuteMod(wizard.getWizardExecuteMod() + 0.4f);
            wizard.setWizardSlamMod(wizard.getWizardSlamMod() + 0.4f);
            wizard.setWizardFbMod(wizard.getWizardFbMod() + 0.4f);
            wizard.setWizardIgniteMod(wizard.getWizardIgniteMod() + 0.4f);

            greatMagician.attachHelpedPlayers(wizard);
        }

    }

    @Override
    public void angelVisit(Rogue rogue, InputLoader inputLoader) {
        if (!rogue.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayGoodAngel(this, rogue);

            rogue.setRogueBsMod(rogue.getRogueBsMod() + 0.3f);
            rogue.setRogueParMod(rogue.getRogueParMod() + 0.3f);
            rogue.setRogueDrainMod(rogue.getRogueDrainMod() + 0.3f);
            rogue.setRogueDeflectMod(rogue.getRogueDeflectMod() + 0.3f);
            rogue.setRogueExecuteMod(rogue.getRogueExecuteMod() + 0.3f);
            rogue.setRogueSlamMod(rogue.getRogueSlamMod() + 0.3f);
            rogue.setRogueFbMod(rogue.getRogueFbMod() + 0.3f);
            rogue.setRogueBsMod(rogue.getRogueIgniteMod() + 0.3f);

            greatMagician.attachHelpedPlayers(rogue);
        }
    }

    @Override
    public void angelVisit(Pyromancer pyro, InputLoader inputLoader) {
        if (!pyro.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayGoodAngel(this, pyro);

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
