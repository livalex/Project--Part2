package strategies;

import main.InputLoader;
import players.Human;

public class OffensiveKnightStrategy implements GameStrategy {
    @Override
    public void play(final Human human, InputLoader inputLoader) {
        human.setHp(human.getHp() - (human.getHp() / 5));

        human.setWizardExecuteMod(human.getWizardExecuteMod() + 0.5f);
        human.setWizardSlamMod(human.getWizardSlamMod() + 0.5f);
        human.setRogueExecuteMod(human.getRogueExecuteMod() + 0.5f);
        human.setRogueSlamMod(human.getRogueSlamMod() + 0.5f);
        if (human.getKnightExecuteMod() != 0.0f) {
            human.setKnightExecuteMod(human.getKnightExecuteMod() + 0.5f);
        }
        human.setKnightSlamMod(human.getKnightSlamMod() + 0.5f);
        human.setPyroExecuteMod(human.getPyroExecuteMod() + 0.5f);
        human.setPyroSlamMod(human.getPyroSlamMod() + 0.5f);
    }
}
