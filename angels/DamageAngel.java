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

            knight.setWizardExecuteMod(knight.getWizardExecuteMod() + 0.15f);
            knight.setWizardSlamMod(knight.getWizardSlamMod() + 0.15f);
            knight.setRogueExecuteMod(knight.getRogueExecuteMod() + 0.15f);
            knight.setRogueSlamMod(knight.getRogueSlamMod() + 0.15f);
            if (knight.getKnightExecuteMod() != 0.0f) {
                knight.setKnightExecuteMod(knight.getKnightExecuteMod() + 0.15f);
            }
            knight.setKnightSlamMod(knight.getKnightSlamMod() + 0.15f);
            knight.setPyroExecuteMod(knight.getPyroExecuteMod() + 0.15f);
            knight.setPyroSlamMod(knight.getPyroSlamMod() + 0.15f);

            greatMagician.attachHelpedPlayers(knight);
        }
    }

    @Override
    public void angelVisit(Wizard wizard, InputLoader inputLoader) {
        if (!wizard.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayGoodAngel(this, wizard);

            wizard.setRogueDrainMod(wizard.getRogueDrainMod() + 0.4f);
            wizard.setRogueDeflectMod(wizard.getRogueDeflectMod() + 0.4f);
            wizard.setWizardDrainMod(wizard.getWizardDrainMod() + 0.4f);
            wizard.setWizardDeflectMod(wizard.getWizardDeflectMod() + 0.4f);
            wizard.setPyroDrainMod(wizard.getPyroDrainMod() + 0.4f);
            wizard.setPyroDeflectMod(wizard.getPyroDeflectMod() + 0.4f);
            wizard.setKnightDrainMod(wizard.getKnightDrainMod() + 0.4f);
            wizard.setKnightDeflectMod(wizard.getKnightDeflectMod()+ 0.4f);

            greatMagician.attachHelpedPlayers(wizard);
        }

    }

    @Override
    public void angelVisit(Rogue rogue, InputLoader inputLoader) {
        if (!rogue.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayGoodAngel(this, rogue);

            System.out.println("Mod 1 rogue of player" + rogue.getPlayerNumber() + " before " + rogue.getRogueBsMod());
            System.out.println("Mod 2 rogue of player " + rogue.getPlayerNumber() + "before " + rogue.getRogueParMod());
//            float a = rogue.getRogueBsMod();
//            System.out.println(a);
//            a = a + 0.3f;
//            System.out.println(a);
            rogue.setRogueBsMod(rogue.getRogueBsMod() + 0.3f);
            rogue.setRogueParMod(rogue.getRogueParMod() + 0.3f);
            rogue.setWizardBsMod(rogue.getWizardBsMod() + 0.3f);
            rogue.setWizardParMod(rogue.getWizardParMod() + 0.3f);
            rogue.setKnightBsMod(rogue.getKnightBsMod() + 0.3f);
            rogue.setKnightParMod(rogue.getKnightParMod() + 0.3f);
            rogue.setPyroBsMod(rogue.getPyroBsMod() + 0.3f);
            rogue.setPyroParMod(rogue.getPyroParMod()+ 0.3f);


            System.out.println("Mod 1 rogue of player" + rogue.getPlayerNumber() + " after " + rogue.getRogueBsMod());
            System.out.println("Mod 2 rogue of player " + rogue.getPlayerNumber() + " after " + rogue.getRogueParMod());

            greatMagician.attachHelpedPlayers(rogue);
        }
    }

    @Override
    public void angelVisit(Pyromancer pyro, InputLoader inputLoader) {
        if (!pyro.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayGoodAngel(this, pyro);

            pyro.setWizardFbMod(pyro.getPyroFbMod() + 0.2f);
            pyro.setWizardIgniteMod(pyro.getPyroIgniteMod() + 0.2f);
            pyro.setKnightFbMod(pyro.getPyroFbMod() + 0.2f);
            pyro.setKnightIgniteMod(pyro.getPyroIgniteMod() + 0.2f);
            pyro.setRogueFbMod(pyro.getRogueFbMod() + 0.2f);
            pyro.setRogueIgniteMod(pyro.getRogueIgniteMod() + 0.2f);
            pyro.setPyroFbMod(pyro.getPyroFbMod() + 0.2f);
            pyro.setPyroIgniteMod(pyro.getPyroIgniteMod()+ 0.2f);
        }
    }
}
