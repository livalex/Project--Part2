package players;

import angels.AngelVisitor;
import angels.VisitedByAngel;
import constants.Constants;
import main.Input;
import main.InputLoader;
import strategies.*;

public class Wizard extends Human implements Visitable, Visitor, VisitedByAngel {

    Wizard(final int abscissa, final int ordinate) {
        setPlayerType(Constants.PLAYER_TYPE_TWO);
        setHp(Constants.DEFAULT_WIZARD_HP);
        setMaxHp(Constants.DEFAULT_WIZARD_HP);
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
    public final void accept(final Visitor visitor) {
        visitor.fight(this);
    }

    // Be the visitor.
    @Override
    public final void fight(final Pyromancer pyromancer) {
        super.pyroGame(pyromancer, pyromancer.getWizardFbMod(),
                pyromancer.getWizardIgniteMod(), Constants.VOLCANIC_GRD_BONUS);

    }

    @Override
    public final void fight(final Rogue rogue) {
        super.rogueGame(rogue, rogue.getWizardBsMod(),
                rogue.getWizardParMod(), Constants.WOODS_GRD_BONUS);

    }

    @Override
    public final void fight(final Knight knight) {
        super.knightGame(knight, knight.getWizardExecuteMod(),
                knight.getWizardSlamMod(), Constants.LAND_GRD_BONUS);
    }

    @Override
    public final void fight(final Wizard wizard) {
        super.wizardGame(wizard, wizard.getWizardDrainMod(),
                wizard.getWizardDrainMod(), Constants.DESERT_GRD_BONUS);
    }
}
