package players;

import angels.AngelVisitor;
import angels.VisitedByAngel;
import constants.Constants;
import main.InputLoader;

public final class Pyromancer extends Human implements Visitable, Visitor, VisitedByAngel {

    Pyromancer(final int abscissa, final int ordinate) {
        setPlayerType(Constants.PLAYER_TYPE_ZERO);
        setHp(Constants.DEFAULT_PYRO_HP);
        setMaxHp(Constants.DEFAULT_PYRO_HP);
        setCurrentAbscissa(abscissa);
        setCurrentOrdinate(ordinate);
        setTotalNrPlayers(getTotalNrPlayers() + 1);
        setPlayerNumber(getTotalNrPlayers());
    }

    // Accept the angel visitor
    @Override
    public void acceptAngel(final AngelVisitor angelVisitor, final InputLoader inputLoader) {
        angelVisitor.angelVisit(this, inputLoader);
    }

    // Accept the visitor.
    @Override
    public void accept(final Visitor visitor) {
        visitor.fight(this);
    }

    // Be the visitor.
    @Override
    public void fight(final Pyromancer pyromancer) {
        super.pyroGame(pyromancer, pyromancer.getPyroFbMod(),
                pyromancer.getPyroIgniteMod(), Constants.VOLCANIC_GRD_BONUS);
    }

    @Override
    public void fight(final Rogue rogue) {
        super.rogueGame(rogue, rogue.getPyroBsMod(),
                rogue.getPyroParMod(), Constants.WOODS_GRD_BONUS);
    }

    @Override
    public void fight(final Knight knight) {
        super.knightGame(knight, knight.getPyroExecuteMod(),
                knight.getPyroSlamMod(), Constants.LAND_GRD_BONUS);
    }

    @Override
    public void fight(final Wizard wizard) {
        super.wizardGame(wizard, wizard.getPyroDrainMod(),
                wizard.getPyroDeflectMod(), Constants.DESERT_GRD_BONUS);
    }
}
