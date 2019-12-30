package strategies;

import constants.Constants;
import main.InputLoader;
import players.Human;

public final class OffensivePyroStrategy implements GameStrategy {

    // Adopt the offensive pyromancer strategy if it's the case
    @Override
    public void play(final Human human, final InputLoader inputLoader) {

        // Update hp
        human.setHp(human.getHp() - (human.getHp() / Constants.OFF_PYRO_DIV));

        // Update the player's race modifiers
        human.setWizardFbMod(human.getWizardFbMod() + Constants.OFF_PYRO_MOD);
        human.setWizardIgniteMod(human.getWizardIgniteMod()
                + Constants.OFF_PYRO_MOD);
        human.setKnightFbMod(human.getKnightFbMod() + Constants.OFF_PYRO_MOD);
        human.setKnightIgniteMod(human.getKnightIgniteMod()
                + Constants.OFF_PYRO_MOD);
        human.setRogueFbMod(human.getRogueFbMod() + Constants.OFF_PYRO_MOD);
        human.setRogueIgniteMod(human.getRogueIgniteMod()
                + Constants.OFF_PYRO_MOD);
        human.setPyroFbMod(human.getPyroFbMod() + Constants.OFF_PYRO_MOD);
        human.setPyroIgniteMod(human.getPyroIgniteMod()
                + Constants.OFF_PYRO_MOD);
    }
}
