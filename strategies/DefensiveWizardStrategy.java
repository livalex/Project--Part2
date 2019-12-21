package strategies;


import main.InputLoader;
import players.Human;
import players.Wizard;

public class DefensiveWizardStrategy implements WizardGameStrategy {
    @Override
    public void play(final Wizard wizard, final float modifier1,
                     final float modifier2, final float grdBonus,
                     final Human victim, InputLoader inputLoader) {
        // De sters param victim
        wizard.setHp(wizard.getHp() + (wizard.getHp() / 5));

        wizard.setWizardBsMod(wizard.getWizardBsMod() - 0.2f);
        wizard.setWizardParMod(wizard.getWizardParMod() - 0.2f);
        wizard.setWizardDrainMod(wizard.getWizardDrainMod() - 0.2f);
        wizard.setWizardDeflectMod(wizard.getWizardDeflectMod() - 0.2f);
        wizard.setWizardExecuteMod(wizard.getWizardExecuteMod() - 0.2f);
        wizard.setWizardSlamMod(wizard.getWizardSlamMod() - 0.2f);
        wizard.setWizardFbMod(wizard.getWizardFbMod() - 0.2f);
        wizard.setWizardIgniteMod(wizard.getWizardIgniteMod()- 0.2f);
    }
}
