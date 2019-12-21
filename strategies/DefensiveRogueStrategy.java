package strategies;

import main.InputLoader;
import players.Human;
import players.Rogue;

public class DefensiveRogueStrategy implements RogueGameStrategy {
    @Override
    public void play(final Rogue rogue, final float modifier1,
                     final float modifier2, final float grdBonus,
                     final Human victim, InputLoader inputLoader) {
        // De sters param victim
        rogue.setHp(rogue.getHp() + (rogue.getHp() / 2));

        rogue.setRogueBsMod(rogue.getRogueBsMod() - 0.1f);
        rogue.setRogueParMod(rogue.getRogueParMod() - 0.1f);
        rogue.setRogueDrainMod(rogue.getRogueDrainMod() - 0.1f);
        rogue.setRogueDeflectMod(rogue.getRogueDeflectMod() - 0.1f);
        rogue.setRogueExecuteMod(rogue.getRogueExecuteMod() - 0.1f);
        rogue.setRogueSlamMod(rogue.getRogueSlamMod() - 0.1f);
        rogue.setRogueFbMod(rogue.getRogueFbMod() - 0.1f);
        rogue.setRogueIgniteMod(rogue.getRogueIgniteMod()- 0.1f);
    }
}
