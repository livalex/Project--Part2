package angels;

import GameAdmin.GreatMagician;
import constants.Constants;
import main.InputLoader;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public class Dracula extends Angel implements Subject, AngelVisitor {

    public Dracula(final int abscissa, final int ordinate) {
        setMyAbscissa(abscissa);
        setMyOrdinate(ordinate);
        setAngelType(Constants.DRACULA_ANGEL);
        super.updateAngelAbs(abscissa);
        super.updateAngelOrd(ordinate);
    }

    @Override
    public void angelVisit(Knight knight, InputLoader inputLoader) {
        if (!knight.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayBadAngel(this, knight);

            knight.setHp(knight.getHp() - 60);

            if (knight.getHp() <= 0) {
                knight.setDead(true);
                inputLoader.deathByAngel(knight);
                greatMagician.attachKilledPlayers(knight);
            }

            knight.setKnightBsMod(knight.getKnightBsMod() - 0.2f);
            knight.setKnightParMod(knight.getKnightParMod() - 0.2f);
            knight.setKnightDrainMod(knight.getKnightDrainMod() - 0.2f);
            knight.setKnightDeflectMod(knight.getKnightDeflectMod() - 0.2f);
            if (knight.getKnightExecuteMod() != 0.0f) {
                knight.setKnightExecuteMod(knight.getKnightExecuteMod() - 0.2f);
            }
            knight.setKnightSlamMod(knight.getKnightSlamMod() - 0.2f);
            knight.setKnightFbMod(knight.getKnightFbMod() - 0.2f);
            knight.setKnightIgniteMod(knight.getKnightIgniteMod() - 0.2f);

            greatMagician.attachHitPlayers(knight);
        }
    }

    @Override
    public void angelVisit(Wizard wizard, InputLoader inputLoader) {
        if (!wizard.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayBadAngel(this, wizard);

            wizard.setHp(wizard.getHp() - 20);

            if (wizard.getHp() <= 0) {
                wizard.setDead(true);
                inputLoader.deathByAngel(wizard);
                greatMagician.attachKilledPlayers(wizard);
            }

            wizard.setWizardBsMod(wizard.getWizardBsMod() - 0.4f);
            wizard.setWizardParMod(wizard.getWizardParMod() - 0.4f);
            wizard.setWizardDrainMod(wizard.getWizardDrainMod() - 0.4f);
            wizard.setWizardDeflectMod(wizard.getWizardDeflectMod() - 0.4f);
            wizard.setWizardExecuteMod(wizard.getWizardExecuteMod() - 0.4f);
            wizard.setWizardSlamMod(wizard.getWizardSlamMod() - 0.4f);
            wizard.setWizardFbMod(wizard.getWizardFbMod() - 0.4f);
            wizard.setWizardIgniteMod(wizard.getWizardIgniteMod() - 0.4f);

            greatMagician.attachHitPlayers(wizard);
        }
    }

    @Override
    public void angelVisit(Rogue rogue, InputLoader inputLoader) {
        if (!rogue.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayBadAngel(this, rogue);

            rogue.setHp(rogue.getHp() - 35);

            if (rogue.getHp() <= 0) {
                rogue.setDead(true);
                inputLoader.deathByAngel(rogue);
                greatMagician.attachKilledPlayers(rogue);
            }

            rogue.setRogueBsMod(rogue.getRogueBsMod() - 0.1f);
            rogue.setRogueParMod(rogue.getRogueParMod() - 0.1f);
            rogue.setRogueDrainMod(rogue.getRogueDrainMod() - 0.1f);
            rogue.setRogueDeflectMod(rogue.getRogueDeflectMod() - 0.1f);
            rogue.setRogueExecuteMod(rogue.getRogueExecuteMod() - 0.1f);
            rogue.setRogueSlamMod(rogue.getRogueSlamMod() - 0.1f);
            rogue.setRogueFbMod(rogue.getRogueFbMod() - 0.1f);
            rogue.setRogueIgniteMod(rogue.getRogueIgniteMod() - 0.1f);

            greatMagician.attachHitPlayers(rogue);
        }
    }

    @Override
    public void angelVisit(Pyromancer pyro, InputLoader inputLoader) {
        if (!pyro.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayBadAngel(this, pyro);

            pyro.setHp(pyro.getHp() - 40);

            if (pyro.getHp() <= 0) {
                pyro.setDead(true);
                inputLoader.deathByAngel(pyro);
                greatMagician.attachKilledPlayers(pyro);
            }

            pyro.setPyroBsMod(pyro.getPyroBsMod() - 0.1f);
            pyro.setPyroParMod(pyro.getPyroParMod() - 0.1f);
            pyro.setPyroDrainMod(pyro.getPyroDrainMod() - 0.1f);
            pyro.setPyroDeflectMod(pyro.getPyroDeflectMod() - 0.1f);
            pyro.setPyroExecuteMod(pyro.getPyroExecuteMod() - 0.1f);
            pyro.setPyroSlamMod(pyro.getPyroSlamMod() - 0.1f);
            pyro.setPyroFbMod(pyro.getPyroFbMod() - 0.1f);
            pyro.setPyroIgniteMod(pyro.getPyroIgniteMod() - 0.1f);

            greatMagician.attachHitPlayers(pyro);
        }
    }
}
