package players;

import angels.AngelVisitor;
import angels.VisitedByAngel;
import constants.Constants;
import main.InputLoader;

public final class Wizard extends Human implements Visitable, Visitor, VisitedByAngel {

    Wizard(final int abscissa, final int ordinate) {
        setPlayerType(Constants.PLAYER_TYPE_TWO);
        setHp(Constants.DEFAULT_WIZARD_HP);
        setMaxHp(Constants.DEFAULT_WIZARD_HP);
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
        super.pyroGame(pyromancer, pyromancer.getWizardFbMod(),
                pyromancer.getWizardIgniteMod(), Constants.VOLCANIC_GRD_BONUS);

    }

    @Override
    public void fight(final Rogue rogue) {
        super.rogueGame(rogue, rogue.getWizardBsMod(),
                rogue.getWizardParMod(), Constants.WOODS_GRD_BONUS);

    }

    @Override
    public void fight(final Knight knight) {
        super.knightGame(knight, knight.getWizardExecuteMod(),
                knight.getWizardSlamMod(), Constants.LAND_GRD_BONUS);
    }

    @Override
    public void fight(final Wizard wizard) {
        super.wizardGame(wizard, wizard.getWizardDrainMod(),
                wizard.getWizardDrainMod(), Constants.DESERT_GRD_BONUS);
    }
}
