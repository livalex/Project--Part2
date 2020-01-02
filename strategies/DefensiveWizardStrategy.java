package strategies;


import constants.Constants;
import main.InputLoader;
import players.Human;

public final class DefensiveWizardStrategy implements GameStrategy {

    // Adopt the defensive wizard strategy if it's the case
    @Override
    public void play(final Human human, final InputLoader inputLoader) {

        // Update hp
        human.setHp(human.getHp() + (human.getHp() / Constants.DEF_WIZARD_DIV));

        // Update the player's race modifiers
        human.setRogueDrainMod(human.getRogueDrainMod() - Constants.DEF_WIZARD_MOD);
        human.setRogueDeflectMod(human.getRogueDeflectMod() - Constants.DEF_WIZARD_MOD);
        human.setWizardDrainMod(human.getWizardDrainMod() - Constants.DEF_WIZARD_MOD);
        human.setWizardDeflectMod(human.getWizardDeflectMod() - Constants.DEF_WIZARD_MOD);
        human.setPyroDrainMod(human.getPyroDrainMod() - Constants.DEF_WIZARD_MOD);
        human.setPyroDeflectMod(human.getPyroDeflectMod() - Constants.DEF_WIZARD_MOD);
        human.setKnightDrainMod(human.getKnightDrainMod() - Constants.DEF_WIZARD_MOD);
        human.setKnightDeflectMod(human.getKnightDeflectMod() - Constants.DEF_WIZARD_MOD);
    }
}
