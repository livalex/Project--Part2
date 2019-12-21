package strategies;

import main.InputLoader;
import players.Human;
import players.Knight;

public class DefensiveKnightStrategy implements KnightGameStrategy {
    @Override
    public void play(final Knight knight, final float modifier1,
                     final float modifier2, final float grdBonus,
                     final Human victim, InputLoader inputLoader) {
        // De sters param victim
        knight.setHp(knight.getHp() + (knight.getHp() / 4));

        knight.setKnightBsMod(knight.getKnightBsMod() - 0.2f);
        knight.setKnightParMod(knight.getKnightParMod() - 0.2f);
        knight.setKnightDrainMod(knight.getKnightDrainMod() - 0.2f);
        knight.setKnightDeflectMod(knight.getKnightDeflectMod() - 0.2f);
        if (knight.getKnightExecuteMod() != 0.0f) {
            knight.setKnightExecuteMod(knight.getKnightExecuteMod() - 0.2f);
        }
        knight.setKnightSlamMod(knight.getKnightSlamMod() - 0.2f);
        knight.setKnightFbMod(knight.getKnightFbMod() - 0.2f);
        knight.setKnightIgniteMod(knight.getKnightIgniteMod()- 0.2f);
    }
}
