package strategies;

import constants.Constants;
import main.InputLoader;
import players.Human;

public final class DefensivePyroStrategy implements GameStrategy {

    // Adopt the defensive pyromancer strategy if it's the case
    @Override
    public void play(final Human human, final InputLoader inputLoader) {

        // Update hp
        int value = human.getHp() / Constants.DEF_PYRO_DIV;
        human.setHp(human.getHp() + value);

        // Update the player's race modifiers
        human.setWizardFbMod(human.getWizardFbMod() - Constants.DEF_PYRO_MOD);
        human.setWizardIgniteMod(human.getWizardIgniteMod()
                - Constants.DEF_PYRO_MOD);
        human.setKnightFbMod(human.getKnightFbMod() - Constants.DEF_PYRO_MOD);
        human.setKnightIgniteMod(human.getKnightIgniteMod()
                - Constants.DEF_PYRO_MOD);
        human.setRogueFbMod(human.getRogueFbMod() - Constants.DEF_PYRO_MOD);
        human.setRogueIgniteMod(human.getRogueIgniteMod()
                - Constants.DEF_PYRO_MOD);
        human.setPyroFbMod(human.getPyroFbMod() - Constants.DEF_PYRO_MOD);
        human.setPyroIgniteMod(human.getPyroIgniteMod()
                - Constants.DEF_PYRO_MOD);
    }
}
