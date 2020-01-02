package strategies;

import main.InputLoader;
import players.Human;
import players.Knight;

public interface KnightGameStrategy {
    void play(final Knight knight, final float modifier1,
              final float modifier2, final float grdBonus,
              final Human victim, InputLoader inputLoader);
}
