package strategies;

import constants.Constants;
import main.InputLoader;
import players.Human;

public final class OffensiveKnightStrategy implements GameStrategy {

    // Adopt the offensive knight strategy if it's the case
    @Override
    public void play(final Human human, final InputLoader inputLoader) {

        // Update hp
        human.setHp(human.getHp() - (human.getHp() / Constants.OFF_KNIGHT_DIV));

        // Update the player's race modifiers
        human.setWizardExecuteMod(human.getWizardExecuteMod() + Constants.OFF_KNIGHT_MOD);
        human.setWizardSlamMod(human.getWizardSlamMod() + Constants.OFF_KNIGHT_MOD);
        human.setRogueExecuteMod(human.getRogueExecuteMod() + Constants.OFF_KNIGHT_MOD);
        human.setRogueSlamMod(human.getRogueSlamMod() + Constants.OFF_KNIGHT_MOD);
        if (human.getKnightExecuteMod() != Constants.UNCHANGEABLE_VALUE) {
            human.setKnightExecuteMod(human.getKnightExecuteMod()
                    + Constants.OFF_KNIGHT_MOD);
        }
        human.setKnightSlamMod(human.getKnightSlamMod() + Constants.OFF_KNIGHT_MOD);
        human.setPyroExecuteMod(human.getPyroExecuteMod() + Constants.OFF_KNIGHT_MOD);
        human.setPyroSlamMod(human.getPyroSlamMod() + Constants.OFF_KNIGHT_MOD);
    }
}
