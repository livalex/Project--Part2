package strategies;

import main.InputLoader;
import players.Human;

public class OffensiveRogueStrategy implements GameStrategy {
    @Override
    public void play(final Human human, InputLoader inputLoader) {
        // De sters param victim
        human.setHp(human.getHp() - (human.getHp() / 7));

        human.setRogueBsMod(human.getRogueBsMod() + 0.4f);
        human.setRogueParMod(human.getRogueParMod() + 0.4f);
        human.setWizardBsMod(human.getWizardBsMod() + 0.4f);
        human.setWizardParMod(human.getWizardParMod() + 0.4f);
        human.setKnightBsMod(human.getKnightBsMod() + 0.4f);
        human.setKnightParMod(human.getKnightParMod() + 0.4f);
        human.setPyroBsMod(human.getPyroBsMod() + 0.4f);
        human.setPyroParMod(human.getPyroParMod()+ 0.4f);
    }
}
