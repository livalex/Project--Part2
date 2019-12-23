package players;

import angels.AngelVisitor;
import angels.VisitedByAngel;
import constants.Constants;
import main.InputLoader;
import strategies.*;

public class Rogue extends Human implements Visitable, Visitor, VisitedByAngel {

    Rogue(final int abscissa, final int ordinate) {
        setPlayerType(Constants.PLAYER_TYPE_THREE);
        setHp(Constants.DEFAULT_ROGUE_HP);
        setMaxHp(Constants.DEFAULT_ROGUE_HP);
        setCurrentAbscissa(abscissa);
        setCurrentOrdinate(ordinate);
        setTotalNrPlayers(getTotalNrPlayers() + 1);
        setPlayerNumber(getTotalNrPlayers());
    }

    @Override
    public void acceptAngel(AngelVisitor angelVisitor, InputLoader inputLoader) {
        angelVisitor.angelVisit(this, inputLoader);
    }

    // Accept the visitor.
    @Override
    public final void accept(final Visitor visitor, InputLoader inputLoader) {
        visitor.fight(this, inputLoader);
    }

    // Be the visitor.
    @Override
    public final void fight(final Pyromancer pyromancer, InputLoader inputLoader) {
        super.pyroGame(pyromancer, pyromancer.getRogueFbMod(),
                pyromancer.getRogueIgniteMod(), Constants.VOLCANIC_GRD_BONUS, inputLoader);
    }

    @Override
    public final void fight(final Rogue rogue, InputLoader inputLoader) {
        super.rogueGame(rogue, rogue.getRogueBsMod(),
                rogue.getRogueParMod(), Constants.WOODS_GRD_BONUS, inputLoader);
    }

    @Override
    public final void fight(final Knight knight, InputLoader inputLoader) {
        super.knightGame(knight, knight.getRogueExecuteMod(),
                knight.getRogueSlamMod(), Constants.LAND_GRD_BONUS, inputLoader);
    }

    @Override
    public final void fight(final Wizard wizard, InputLoader inputLoader) {
        super.wizardGame(wizard, wizard.getRogueDrainMod(),
                wizard.getRogueDeflectMod(), Constants.DESERT_GRD_BONUS, inputLoader);
    }
}
