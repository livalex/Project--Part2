package strategies;

import main.InputLoader;
import players.Human;

public class DefensiveRogueStrategy implements GameStrategy {
    @Override
    public void play(final Human human, InputLoader inputLoader) {
        human.setHp(human.getHp() + (human.getHp() / 2));

        human.setRogueBsMod(human.getRogueBsMod() - 0.1f);
        human.setRogueParMod(human.getRogueParMod() - 0.1f);
        human.setWizardBsMod(human.getWizardBsMod() - 0.1f);
        human.setWizardParMod(human.getWizardParMod() - 0.1f);
        human.setKnightBsMod(human.getKnightBsMod() - 0.1f);
        human.setKnightParMod(human.getKnightParMod() - 0.1f);
        human.setPyroBsMod(human.getPyroBsMod() - 0.1f);
        human.setPyroParMod(human.getPyroParMod()- 0.1f);
    }
}
