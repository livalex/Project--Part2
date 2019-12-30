package players;

import angels.AngelVisitor;
import angels.VisitedByAngel;
import constants.Constants;
import main.InputLoader;

public final class Rogue extends Human implements Visitable, Visitor, VisitedByAngel {

    Rogue(final int abscissa, final int ordinate) {
        setPlayerType(Constants.PLAYER_TYPE_THREE);
        setHp(Constants.DEFAULT_ROGUE_HP);
        setMaxHp(Constants.DEFAULT_ROGUE_HP);
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
        super.pyroGame(pyromancer, pyromancer.getRogueFbMod(),
                pyromancer.getRogueIgniteMod(), Constants.VOLCANIC_GRD_BONUS);
    }

    @Override
    public void fight(final Rogue rogue) {
        super.rogueGame(rogue, rogue.getRogueBsMod(),
                rogue.getRogueParMod(), Constants.WOODS_GRD_BONUS);
    }

    @Override
    public void fight(final Knight knight) {
        super.knightGame(knight, knight.getRogueExecuteMod(),
                knight.getRogueSlamMod(), Constants.LAND_GRD_BONUS);
    }

    @Override
    public void fight(final Wizard wizard) {
        super.wizardGame(wizard, wizard.getRogueDrainMod(),
                wizard.getRogueDeflectMod(), Constants.DESERT_GRD_BONUS);
    }
}
