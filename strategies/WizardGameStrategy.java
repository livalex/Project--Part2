package strategies;

import main.InputLoader;
import players.Human;
import players.Wizard;

public interface WizardGameStrategy {
    void play(final Wizard wizard, final float modifier1,
              final float modifier2, final float grdBonus,
              final Human human, InputLoader inputLoader);
}
