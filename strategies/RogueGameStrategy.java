package strategies;

import main.InputLoader;
import players.Human;
import players.Rogue;

public interface RogueGameStrategy {
    void play(final Rogue rogue, final float modifier1,
              final float modifier2, final float grdBonus,
              final Human victim, InputLoader inputLoader);
}
