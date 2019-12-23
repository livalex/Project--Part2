package strategies;

import main.InputLoader;
import players.Human;

public class OffensivePyroStrategy implements GameStrategy {
    @Override
    public void play(final Human human, InputLoader inputLoader) {
        // De sters param victim
        human.setHp(human.getHp() - (human.getHp() / 4));

        human.setWizardFbMod(human.getPyroFbMod() + 0.7f);
        human.setWizardIgniteMod(human.getPyroIgniteMod() + 0.7f);
        human.setKnightFbMod(human.getPyroFbMod() + 0.7f);
        human.setKnightIgniteMod(human.getPyroIgniteMod() + 0.7f);
        human.setRogueFbMod(human.getRogueFbMod() + 0.7f);
        human.setRogueIgniteMod(human.getRogueIgniteMod() + 0.7f);
        human.setPyroFbMod(human.getPyroFbMod() + 0.7f);
        human.setPyroIgniteMod(human.getPyroIgniteMod()+ 0.7f);
    }
}