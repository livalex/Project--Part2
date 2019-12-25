package strategies;

import main.InputLoader;
import players.Human;

public class DefensiveKnightStrategy implements GameStrategy {
    @Override
    public void play(final Human human, InputLoader inputLoader) {
        human.setHp(human.getHp() + (human.getHp() / 4));

        human.setWizardExecuteMod(human.getWizardExecuteMod() - 0.2f);
        human.setWizardSlamMod(human.getWizardSlamMod() - 0.2f);
        human.setRogueExecuteMod(human.getRogueExecuteMod() - 0.2f);
        human.setRogueSlamMod(human.getRogueSlamMod() - 0.2f);
        if (human.getKnightExecuteMod() != 0.0f) {
            human.setKnightExecuteMod(human.getKnightExecuteMod() - 0.2f);
        }
        human.setKnightSlamMod(human.getKnightSlamMod() - 0.2f);
        human.setPyroExecuteMod(human.getPyroExecuteMod() - 0.2f);
        human.setPyroSlamMod(human.getPyroSlamMod() - 0.2f);
    }
}
