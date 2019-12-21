package strategies;

import main.InputLoader;
import players.Human;
import players.Pyromancer;

public class DefensivePyroStrategy implements PyroGameStrategy {
    @Override
    public void play(final Pyromancer pyro, final float modifier1,
                     final float modifier2, final float grdBonus,
                     final Human victim, InputLoader inputLoader) {
        // De sters param victim
        pyro.setHp(pyro.getHp() + (pyro.getHp() / 3));

        pyro.setPyroBsMod(pyro.getPyroBsMod() - 0.3f);
        pyro.setPyroParMod(pyro.getPyroParMod() - 0.3f);
        pyro.setPyroDrainMod(pyro.getPyroDrainMod() - 0.3f);
        pyro.setPyroDeflectMod(pyro.getPyroDeflectMod() - 0.3f);
        pyro.setPyroExecuteMod(pyro.getPyroExecuteMod() - 0.3f);
        pyro.setPyroSlamMod(pyro.getPyroSlamMod() - 0.3f);
        pyro.setPyroFbMod(pyro.getPyroFbMod() - 0.3f);
        pyro.setPyroIgniteMod(pyro.getPyroIgniteMod()- 0.3f);
    }
}
