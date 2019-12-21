package strategies;

import main.InputLoader;
import players.Human;
import players.Rogue;

public class OffensiveRogueStrategy implements RogueGameStrategy {
    @Override
    public void play(final Rogue rogue, final float modifier1,
                     final float modifier2, final float grdBonus,
                     final Human victim, InputLoader inputLoader) {
        // De sters param victim
        rogue.setHp(rogue.getHp() - (rogue.getHp() / 7));

        rogue.setRogueBsMod(rogue.getRogueBsMod() + 0.4f);
        rogue.setRogueParMod(rogue.getRogueParMod() + 0.4f);
        rogue.setRogueDrainMod(rogue.getRogueDrainMod() + 0.4f);
        rogue.setRogueDeflectMod(rogue.getRogueDeflectMod() + 0.4f);
        rogue.setRogueExecuteMod(rogue.getRogueExecuteMod() + 0.4f);
        rogue.setRogueSlamMod(rogue.getRogueSlamMod() + 0.4f);
        rogue.setRogueFbMod(rogue.getRogueFbMod() + 0.4f);
        rogue.setRogueIgniteMod(rogue.getRogueIgniteMod() + 0.4f);
    }
}
