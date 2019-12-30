package strategies;

import constants.Constants;
import main.InputLoader;
import players.Human;

public final class DefensiveKnightStrategy implements GameStrategy {

    // Adopt the defensive knight strategy if it's the case
    @Override
    public void play(final Human human, final InputLoader inputLoader) {

        // Update hp
        human.setHp(human.getHp() + (human.getHp() / Constants.DEF_KNIGHT_DIV));

        // Update the player's race modifiers
        human.setWizardExecuteMod(human.getWizardExecuteMod() - Constants.DEF_KNIGHT_MOD);
        human.setWizardSlamMod(human.getWizardSlamMod() - Constants.DEF_KNIGHT_MOD);
        human.setRogueExecuteMod(human.getRogueExecuteMod() - Constants.DEF_KNIGHT_MOD);
        human.setRogueSlamMod(human.getRogueSlamMod() - Constants.DEF_KNIGHT_MOD);
        if (human.getKnightExecuteMod() != Constants.UNCHANGEABLE_VALUE) {
            human.setKnightExecuteMod(human.getKnightExecuteMod()
                    - Constants.DEF_KNIGHT_MOD);
        }
        human.setKnightSlamMod(human.getKnightSlamMod() - Constants.DEF_KNIGHT_MOD);
        human.setPyroExecuteMod(human.getPyroExecuteMod() - Constants.DEF_KNIGHT_MOD);
        human.setPyroSlamMod(human.getPyroSlamMod() - Constants.DEF_KNIGHT_MOD);
    }
}
