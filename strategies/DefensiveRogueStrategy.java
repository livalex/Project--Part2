package strategies;

import constants.Constants;
import main.InputLoader;
import players.Human;

public final class DefensiveRogueStrategy implements GameStrategy {

    // Adopt the defensive rogue strategy if it's the case
    @Override
    public void play(final Human human, final InputLoader inputLoader) {

        // Update hp
        human.setHp(human.getHp() + (human.getHp() / Constants.DEF_ROGUE_DIV));

        // Update the player's race modifiers
        human.setRogueBsMod(human.getRogueBsMod() - Constants.DEF_ROGUE_MOD);
        human.setRogueParMod(human.getRogueParMod() - Constants.DEF_ROGUE_MOD);
        human.setWizardBsMod(human.getWizardBsMod() - Constants.DEF_ROGUE_MOD);
        human.setWizardParMod(human.getWizardParMod() - Constants.DEF_ROGUE_MOD);
        human.setKnightBsMod(human.getKnightBsMod() - Constants.DEF_ROGUE_MOD);
        human.setKnightParMod(human.getKnightParMod() - Constants.DEF_ROGUE_MOD);
        human.setPyroBsMod(human.getPyroBsMod() - Constants.DEF_ROGUE_MOD);
        human.setPyroParMod(human.getPyroParMod() - Constants.DEF_ROGUE_MOD);
    }
}
