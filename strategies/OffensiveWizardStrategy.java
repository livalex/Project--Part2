package strategies;

import main.InputLoader;
import players.Human;
import players.Wizard;

public class OffensiveWizardStrategy implements GameStrategy {
    @Override
    public void play(final Human human, InputLoader inputLoader) {
        human.setHp(human.getHp() - (human.getHp() / 10));

        human.setRogueDrainMod(human.getRogueDrainMod() + 0.6f);
        human.setRogueDeflectMod(human.getRogueDeflectMod() + 0.6f);
        human.setWizardDrainMod(human.getWizardDrainMod() + 0.6f);
        human.setWizardDeflectMod(human.getWizardDeflectMod() + 0.6f);
        human.setPyroDrainMod(human.getPyroDrainMod() + 0.6f);
        human.setPyroDeflectMod(human.getPyroDeflectMod() + 0.6f);
        human.setKnightDrainMod(human.getKnightDrainMod() + 0.6f);
        human.setKnightDeflectMod(human.getKnightDeflectMod()+ 0.6f);
    }
}
