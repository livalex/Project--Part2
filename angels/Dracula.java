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
            // !!!
            System.out.println("Mod 1 before dracula " + knight.getKnightExecuteMod() + " for player " + knight.getPlayerNumber());
            System.out.println("Mod 2 before dracula " + knight.getKnightSlamMod() + " for player " + knight.getPlayerNumber());
            /// !!!

            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayBadAngel(this, knight);

            knight.setHp(knight.getHp() - 60);

            if (knight.getHp() <= 0) {
                knight.setDead(true);
                inputLoader.deathByAngel(knight);
                greatMagician.attachKilledPlayers(knight);
            }

            knight.setWizardExecuteMod(knight.getWizardExecuteMod() - 0.2f);
            knight.setWizardSlamMod(knight.getWizardSlamMod() - 0.2f);
            knight.setRogueExecuteMod(knight.getRogueExecuteMod() - 0.2f);
            knight.setRogueSlamMod(knight.getRogueSlamMod() - 0.2f);
            if (knight.getKnightExecuteMod() != 0.0f) {
                knight.setKnightExecuteMod(knight.getKnightExecuteMod() - 0.2f);
            }
            knight.setKnightSlamMod(knight.getKnightSlamMod() - 0.2f);
            knight.setPyroExecuteMod(knight.getPyroExecuteMod() - 0.2f);
            knight.setPyroSlamMod(knight.getPyroSlamMod() - 0.2f);

            greatMagician.attachHitPlayers(knight);

            // !!!
            System.out.println("Mod 1 after dracula " + knight.getKnightExecuteMod() + " for player " + knight.getPlayerNumber());
            System.out.println("Mod 2 after dracula " + knight.getKnightSlamMod() + " for player " + knight.getPlayerNumber());
            /// !!!
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

            wizard.setRogueDrainMod(wizard.getRogueDrainMod() - 0.4f);
            wizard.setRogueDeflectMod(wizard.getRogueDeflectMod() - 0.4f);
            wizard.setWizardDrainMod(wizard.getWizardDrainMod() - 0.4f);
            wizard.setWizardDeflectMod(wizard.getWizardDeflectMod() - 0.4f);
            wizard.setPyroDrainMod(wizard.getPyroDrainMod() - 0.4f);
            wizard.setPyroDeflectMod(wizard.getPyroDeflectMod() - 0.4f);
            wizard.setKnightDrainMod(wizard.getKnightDrainMod() - 0.4f);
            wizard.setKnightDeflectMod(wizard.getKnightDeflectMod()- 0.4f);

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
            rogue.setWizardBsMod(rogue.getWizardBsMod() - 0.1f);
            rogue.setWizardParMod(rogue.getWizardParMod() - 0.1f);
            rogue.setKnightBsMod(rogue.getKnightBsMod() - 0.1f);
            rogue.setKnightParMod(rogue.getKnightParMod() - 0.1f);
            rogue.setPyroBsMod(rogue.getPyroBsMod() - 0.1f);
            rogue.setPyroParMod(rogue.getPyroParMod()- 0.1f);

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

            pyro.setWizardFbMod(pyro.getPyroFbMod() - 0.1f);
            pyro.setWizardIgniteMod(pyro.getPyroIgniteMod() - 0.1f);
            pyro.setKnightFbMod(pyro.getPyroFbMod() - 0.1f);
            pyro.setKnightIgniteMod(pyro.getPyroIgniteMod() - 0.1f);
            pyro.setRogueFbMod(pyro.getRogueFbMod() - 0.1f);
            pyro.setRogueIgniteMod(pyro.getRogueIgniteMod() - 0.1f);
            pyro.setPyroFbMod(pyro.getPyroFbMod() - 0.1f);
            pyro.setPyroIgniteMod(pyro.getPyroIgniteMod() - 0.1f);

            greatMagician.attachHitPlayers(pyro);
        }
    }
}
