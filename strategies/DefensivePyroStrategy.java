package strategies;

import main.InputLoader;
import players.Human;

public class DefensivePyroStrategy implements GameStrategy {
    @Override
    public void play(final Human human, InputLoader inputLoader) {
        int value = human.getHp() / 3;
        human.setHp(human.getHp() + value);

        human.setWizardFbMod(human.getWizardFbMod() - 0.3f);
        human.setWizardIgniteMod(human.getWizardIgniteMod() - 0.3f);
        human.setKnightFbMod(human.getKnightFbMod() - 0.3f);
        human.setKnightIgniteMod(human.getKnightIgniteMod() - 0.3f);
        human.setRogueFbMod(human.getRogueFbMod() - 0.3f);
        human.setRogueIgniteMod(human.getRogueIgniteMod() - 0.3f);
        human.setPyroFbMod(human.getPyroFbMod() - 0.3f);
        human.setPyroIgniteMod(human.getPyroIgniteMod()- 0.3f);
    }
}
