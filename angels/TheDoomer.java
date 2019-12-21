package angels;

import constants.Constants;
import main.InputLoader;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public class TheDoomer extends Angel implements Subject,AngelVisitor {

    public TheDoomer(final int abscissa, final int ordinate) {
        setMyAbscissa(abscissa);
        setMyOrdinate(ordinate);
        setAngelType(Constants.THE_DOOMER_ANGEL);
        super.updateAngelAbs(abscissa);
        super.updateAngelOrd(ordinate);
    }

    @Override
    public void angelVisit(Knight knight, InputLoader inputLoader) {

    }

    @Override
    public void angelVisit(Wizard wizard, InputLoader inputLoader) {

    }

    @Override
    public void angelVisit(Rogue rogue, InputLoader inputLoader) {

    }

    @Override
    public void angelVisit(Pyromancer pyro, InputLoader inputLoader) {

    }
}
