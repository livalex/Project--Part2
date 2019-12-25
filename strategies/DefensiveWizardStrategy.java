package strategies;


import main.InputLoader;
import players.Human;
import players.Wizard;

public class DefensiveWizardStrategy implements GameStrategy {
    @Override
    public void play(final Human human, InputLoader inputLoader) {
        human.setHp(human.getHp() + (human.getHp() / 5));

        human.setRogueDrainMod(human.getRogueDrainMod() - 0.2f);
        human.setRogueDeflectMod(human.getRogueDeflectMod() - 0.2f);
        human.setWizardDrainMod(human.getWizardDrainMod() - 0.2f);
        human.setWizardDeflectMod(human.getWizardDeflectMod() - 0.2f);
        human.setPyroDrainMod(human.getPyroDrainMod() - 0.2f);
        human.setPyroDeflectMod(human.getPyroDeflectMod() - 0.2f);
        human.setKnightDrainMod(human.getKnightDrainMod() - 0.2f);
        human.setKnightDeflectMod(human.getKnightDeflectMod()- 0.2f);
    }
}
