package players;

import angels.AngelVisitor;
import angels.VisitedByAngel;
import constants.Constants;
import main.InputLoader;
import strategies.*;

public class Knight extends Human implements Visitable, Visitor, VisitedByAngel {

    Knight(final int abscissa, final int ordinate) {
        setPlayerType(Constants.PLAYER_TYPE_ONE);
        setHp(Constants.DEFAULT_KNIGHT_HP);
        setMaxHp(Constants.DEFAULT_KNIGHT_HP);
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

    @Override
    public final void fight(final Pyromancer pyromancer, InputLoader inputLoader) {
        super.pyroGame(pyromancer, pyromancer.getKnightFbMod(),
                pyromancer.getKnightIgniteMod(), Constants.VOLCANIC_GRD_BONUS, inputLoader);
    }

    // Be the visitor.
    @Override
    public final void fight(final Rogue rogue, InputLoader inputLoader) {
        super.rogueGame(rogue, rogue.getKnightBsMod(),
                rogue.getKnightParMod(), Constants.WOODS_GRD_BONUS, inputLoader);
    }

    @Override
    public final void fight(final Knight knight, InputLoader inputLoader) {
        super.knightGame(knight, knight.getKnightExecuteMod(),
                knight.getKnightSlamMod(), Constants.LAND_GRD_BONUS, inputLoader);
    }

    @Override
    public final void fight(final Wizard wizard, InputLoader inputLoader) {
        super.wizardGame(wizard, wizard.getKnightDrainMod(),
                wizard.getKnightDeflectMod(), Constants.DESERT_GRD_BONUS, inputLoader);
    }
}
