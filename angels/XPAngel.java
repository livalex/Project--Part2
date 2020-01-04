package angels;

import admin.GreatMagician;
import constants.Constants;
import main.InputLoader;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public final class XPAngel extends Angel implements Subject, AngelVisitor {

    public XPAngel(final int abscissa, final int ordinate) {
        setMyAbscissa(abscissa);
        setMyOrdinate(ordinate);
        setAngelType(Constants.XP_ANGEL);
        super.updateAngelAbs(abscissa);
        super.updateAngelOrd(ordinate);
    }

    @Override
    public void angelVisit(final Knight knight, final InputLoader inputLoader) {
        if (!knight.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            // Display player helped by angel message
            inputLoader.displayGoodAngel(this, knight);

            // Update XP
            int lvl = knight.getLevel();
            knight.setXp(knight.getXp() + Constants.XP_ANGEL_KNIGHT_INCREASE);

            // Make sure the XP corresponds with the level
            while ((Constants.XP_FORMULA_FIRST_FACTOR + lvl
                    * Constants.XP_FORMULA_SECOND_FACTOR) <= knight.getXp()) {
                ++lvl;
                knight.setLevel(lvl);
                knight.setHp(Constants.DEFAULT_KNIGHT_HP
                        + knight.getLevel() * Constants.KNIGHT_INCREASE);
                knight.setMaxHp(Constants.DEFAULT_KNIGHT_HP
                        + knight.getLevel() * Constants.KNIGHT_INCREASE);
                inputLoader.displayLvlEvolution(knight);
            }

            // Notify the great magician
            greatMagician.attachHelpedPlayers(knight);
        }
    }

    @Override
    public void angelVisit(final Wizard wizard, final InputLoader inputLoader) {

        // Same as above
        if (!wizard.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayGoodAngel(this, wizard);

            int lvl = wizard.getLevel();
            wizard.setXp(wizard.getXp() + Constants.XP_ANGEL_WIZARD_INCREASE);

            while ((Constants.XP_FORMULA_FIRST_FACTOR + lvl
                    * Constants.XP_FORMULA_SECOND_FACTOR) <= wizard.getXp()) {
                ++lvl;
                wizard.setLevel(lvl);
                wizard.setHp(Constants.DEFAULT_WIZARD_HP
                        + wizard.getLevel() * Constants.WIZARD_INCREASE);
                wizard.setMaxHp(Constants.DEFAULT_WIZARD_HP
                        + wizard.getLevel() * Constants.WIZARD_INCREASE);
                inputLoader.displayLvlEvolution(wizard);
            }

            greatMagician.attachHelpedPlayers(wizard);
        }
    }

    @Override
    public void angelVisit(final Rogue rogue, final InputLoader inputLoader) {

        // Same as above
        if (!rogue.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayGoodAngel(this, rogue);

            int lvl = rogue.getLevel();
            rogue.setXp(rogue.getXp() + Constants.XP_ANGEL_ROGUE_INCREASE);

            while ((Constants.XP_FORMULA_FIRST_FACTOR + lvl
                    * Constants.XP_FORMULA_SECOND_FACTOR) <= rogue.getXp()) {
                ++lvl;
                rogue.setLevel(lvl);
                rogue.setHp(Constants.DEFAULT_ROGUE_HP
                        + rogue.getLevel() * Constants.ROGUE_INCREASE);
                rogue.setMaxHp(Constants.DEFAULT_ROGUE_HP
                        + rogue.getLevel() * Constants.ROGUE_INCREASE);
                inputLoader.displayLvlEvolution(rogue);
            }

            greatMagician.attachHelpedPlayers(rogue);
        }
    }

    @Override
    public void angelVisit(final Pyromancer pyro, final InputLoader inputLoader) {

        // Same as above
        if (!pyro.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayGoodAngel(this, pyro);

            int lvl = pyro.getLevel();
            pyro.setXp(pyro.getXp() + Constants.XP_ANGEL_PYRP_INCREASE);

            while ((Constants.XP_FORMULA_FIRST_FACTOR + lvl
                    * Constants.XP_FORMULA_SECOND_FACTOR) <= pyro.getXp()) {
                ++lvl;
                pyro.setLevel(lvl);
                pyro.setHp(Constants.DEFAULT_PYRO_HP + pyro.getLevel() * Constants.PYRO_INCREASE);
                pyro.setMaxHp(Constants.DEFAULT_PYRO_HP
                        + pyro.getLevel() * Constants.PYRO_INCREASE);
                inputLoader.displayLvlEvolution(pyro);
            }

            greatMagician.attachHelpedPlayers(pyro);
        }
    }
}
