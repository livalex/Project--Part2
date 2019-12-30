package strategies;

import constants.Constants;
import main.InputLoader;
import players.Human;

public final class OffensiveRogueStrategy implements GameStrategy {

    // Adopt the offensive rogue strategy if it's the case
    @Override
    public void play(final Human human, final InputLoader inputLoader) {

        // Update hp
        human.setHp(human.getHp() - (human.getHp() / Constants.OFF_ROGUE_DIV));

        // Update the player's race modifiers
        human.setRogueBsMod(human.getRogueBsMod() + Constants.OFF_ROGUE_MOD);
        human.setRogueParMod(human.getRogueParMod() + Constants.OFF_ROGUE_MOD);
        human.setWizardBsMod(human.getWizardBsMod() + Constants.OFF_ROGUE_MOD);
        human.setWizardParMod(human.getWizardParMod() + Constants.OFF_ROGUE_MOD);
        human.setKnightBsMod(human.getKnightBsMod() + Constants.OFF_ROGUE_MOD);
        human.setKnightParMod(human.getKnightParMod() + Constants.OFF_ROGUE_MOD);
        human.setPyroBsMod(human.getPyroBsMod() + Constants.OFF_ROGUE_MOD);
        human.setPyroParMod(human.getPyroParMod() + Constants.OFF_ROGUE_MOD);
    }
}
