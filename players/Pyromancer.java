package players;

import angels.AngelVisitor;
import angels.VisitedByAngel;
import constants.Constants;
import main.InputLoader;
import strategies.*;

public class Pyromancer extends Human implements Visitable, Visitor, VisitedByAngel {

    Pyromancer(final int abscissa, final int ordinate) {
        setPlayerType(Constants.PLAYER_TYPE_ZERO);
        setHp(Constants.DEFAULT_PYRO_HP);
        setMaxHp(Constants.DEFAULT_PYRO_HP);
        setCurrentAbscissa(abscissa);
        setCurrentOrdinate(ordinate);
        setTotalNrPlayers(getTotalNrPlayers() + 1);
        setPlayerNumber(getTotalNrPlayers());
    }

    @Override
    public void acceptAngel(AngelVisitor angelVisitor, InputLoader inputLoader) {
        angelVisitor.angelVisit(this, inputLoader);
    }

    // Accept he visitor.
    @Override
    public final void accept(final Visitor visitor, InputLoader inputLoader) {
        visitor.fight(this, inputLoader);
    }

    // Be the visitor.
    @Override
    public final void fight(final Pyromancer pyromancer, InputLoader inputLoader) {
        super.pyroGame(pyromancer, pyromancer.getPyroFbMod(),
                pyromancer.getPyroIgniteMod(), Constants.VOLCANIC_GRD_BONUS, inputLoader);
    }

    @Override
    public final void fight(final Rogue rogue, InputLoader inputLoader) {
        super.rogueGame(rogue, rogue.getPyroBsMod(),
                rogue.getPyroParMod(), Constants.WOODS_GRD_BONUS, inputLoader);
    }

    @Override
    public final void fight(final Knight knight, InputLoader inputLoader) {
        super.knightGame(knight, knight.getPyroExecuteMod(),
                knight.getPyroSlamMod(), Constants.LAND_GRD_BONUS, inputLoader);
    }

    @Override
    public final void fight(final Wizard wizard, InputLoader inputLoader) {
        super.wizardGame(wizard, wizard.getPyroDrainMod(),
                wizard.getPyroDeflectMod(), Constants.DESERT_GRD_BONUS, inputLoader);
    }
}
