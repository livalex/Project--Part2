package angels;

import admin.GreatMagician;
import constants.Constants;
import main.InputLoader;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public abstract class Angel implements Subject, AngelVisitor {

    // Data specific to every instance of an angel
    private int myAbscissa = Constants.DEFAULT_ABSCISSA;
    private int myOrdinate = Constants.DEFAULT_ORDINATE;
    private int angelType = Constants.DAMAGE_ANGEL;

    // Instance used to notify the Magician
    private GreatMagician greatMagician = GreatMagician.getInstance();

    // Used in order to display the apparition message only once
    private boolean spawnMessageDisplay = false;

    public final boolean isSpawnMessageDisplay() {
        return spawnMessageDisplay;
    }

    public final void setSpawnMessageDisplay(final boolean spawnMessageDisplay) {
        this.spawnMessageDisplay = spawnMessageDisplay;
    }

    public final GreatMagician getGreatMagician() {
        return greatMagician;
    }

    public final int getMyAbscissa() {
        return myAbscissa;
    }

    public final void setMyAbscissa(final int myAbscissa) {
        this.myAbscissa = myAbscissa;
    }

    public final int getMyOrdinate() {
        return myOrdinate;
    }

    public final void setMyOrdinate(final int myOrdinate) {
        this.myOrdinate = myOrdinate;
    }

    public final int getAngelType() {
        return angelType;
    }

    public final void setAngelType(final int angelType) {
        this.angelType = angelType;
    }

    @Override
    public final void updateAngelAbs(final int x) {
        getGreatMagician().attachAbs(x);
    }

    @Override
    public final void updateAngelOrd(final int y) {
        greatMagician.attachOrd(y);
    }

    @Override
    public void angelVisit(final Knight knight, final InputLoader inputLoader) {
    }

    @Override
    public void angelVisit(final Wizard wizard, final InputLoader inputLoader) {
    }

    @Override
    public void angelVisit(final Rogue rogue, final InputLoader inputLoader) {
    }

    @Override
    public void angelVisit(final Pyromancer pyromancer, final InputLoader inputLoader) {
    }
}
