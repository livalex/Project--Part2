package strategies;

import main.InputLoader;
import players.Human;

public class DefensivePyroStrategy implements GameStrategy {
    @Override
    public void play(final Human human, InputLoader inputLoader) {
        // De sters param victim
        human.setHp(human.getHp() + (human.getHp() / 3));

        human.setWizardFbMod(human.getPyroFbMod() - 0.3f);
        human.setWizardIgniteMod(human.getPyroIgniteMod() - 0.3f);
        human.setKnightFbMod(human.getPyroFbMod() - 0.3f);
        human.setKnightIgniteMod(human.getPyroIgniteMod() - 0.3f);
        human.setRogueFbMod(human.getRogueFbMod() - 0.3f);
        human.setRogueIgniteMod(human.getRogueIgniteMod() - 0.3f);
        human.setPyroFbMod(human.getPyroFbMod() - 0.3f);
        human.setPyroIgniteMod(human.getPyroIgniteMod()- 0.3f);
    }
}
