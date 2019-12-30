package strategies;

import constants.Constants;
import main.InputLoader;
import players.Human;

public final class OffensiveWizardStrategy implements GameStrategy {

    // Adopt the offensive wizard strategy if it's the case
    @Override
    public void play(final Human human, final InputLoader inputLoader) {

        // Update hp
        human.setHp(human.getHp() - (human.getHp() / Constants.OFF_WIZARD_DIV));


        // Update the player's race modifiers
        human.setRogueDrainMod(human.getRogueDrainMod() + Constants.OFF_WIZARD_MOD);
        human.setRogueDeflectMod(human.getRogueDeflectMod() + Constants.OFF_WIZARD_MOD);
        human.setWizardDrainMod(human.getWizardDrainMod() + Constants.OFF_WIZARD_MOD);
        human.setWizardDeflectMod(human.getWizardDeflectMod() + Constants.OFF_WIZARD_MOD);
        human.setPyroDrainMod(human.getPyroDrainMod() + Constants.OFF_WIZARD_MOD);
        human.setPyroDeflectMod(human.getPyroDeflectMod() + Constants.OFF_WIZARD_MOD);
        human.setKnightDrainMod(human.getKnightDrainMod() + Constants.OFF_WIZARD_MOD);
        human.setKnightDeflectMod(human.getKnightDeflectMod() + Constants.OFF_WIZARD_MOD);
    }
}
