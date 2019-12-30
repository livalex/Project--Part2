package strategies;

import main.InputLoader;
import players.Human;
import players.Pyromancer;

public interface PyroGameStrategy {
    void play(final Pyromancer pyro, final float modifier1,
              final float modifier2, final float grdBonus,
              final Human victim, InputLoader inputLoader);
}
