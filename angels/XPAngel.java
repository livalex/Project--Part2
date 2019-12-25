package angels;

import GameAdmin.GreatMagician;
import constants.Constants;
import main.InputLoader;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public class XPAngel extends Angel implements Subject, AngelVisitor {

    public XPAngel(final int abscissa, final int ordinate) {
        setMyAbscissa(abscissa);
        setMyOrdinate(ordinate);
        setAngelType(Constants.XP_ANGEL);
        super.updateAngelAbs(abscissa);
        super.updateAngelOrd(ordinate);
    }

    @Override
    public void angelVisit(Knight knight, InputLoader inputLoader) {
        if (!knight.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayGoodAngel(this, knight);

            int lvl = knight.getLevel();
            knight.setXp(knight.getXp() + 45);

            while ((250 + lvl * 50) <= knight.getXp()) {
                ++lvl;
                knight.setLevel(lvl);
                knight.setHp(Constants.DEFAULT_KNIGHT_HP + knight.getLevel() * Constants.KNIGHT_INCREASE);
                knight.setMaxHp(Constants.DEFAULT_KNIGHT_HP + knight.getLevel() * Constants.KNIGHT_INCREASE);
                inputLoader.displayLvlEvolution(knight);
            }

            greatMagician.attachHelpedPlayers(knight);
        }
    }

    @Override
    public void angelVisit(Wizard wizard, InputLoader inputLoader) {
        if (!wizard.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayGoodAngel(this, wizard);

            int lvl = wizard.getLevel();
            wizard.setXp(wizard.getXp() + 60);

            while ((250 + lvl * 50) <= wizard.getXp()) {
                ++lvl;
                wizard.setLevel(lvl);
                wizard.setHp(Constants.DEFAULT_WIZARD_HP + wizard.getLevel() * Constants.WIZARD_INCREASE);
                wizard.setMaxHp(Constants.DEFAULT_WIZARD_HP + wizard.getLevel() * Constants.WIZARD_INCREASE);
                inputLoader.displayLvlEvolution(wizard);
            }

            greatMagician.attachHelpedPlayers(wizard);
        }
    }

    @Override
    public void angelVisit(Rogue rogue, InputLoader inputLoader) {
        if (!rogue.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayGoodAngel(this, rogue);

            int lvl = rogue.getLevel();
            rogue.setXp(rogue.getXp() + 40);

            while ((250 + lvl * 50) <= rogue.getXp()) {
                ++lvl;
                rogue.setLevel(lvl);
                rogue.setHp(Constants.DEFAULT_ROGUE_HP + rogue.getLevel() * Constants.ROGUE_INCREASE);
                rogue.setMaxHp(Constants.DEFAULT_ROGUE_HP + rogue.getLevel() * Constants.ROGUE_INCREASE);
                inputLoader.displayLvlEvolution(rogue);
            }

            greatMagician.attachHelpedPlayers(rogue);
        }
    }

    @Override
    public void angelVisit(Pyromancer pyro, InputLoader inputLoader) {
        if (!pyro.isDead()) {
            GreatMagician greatMagician = GreatMagician.getInstance();

            inputLoader.displayGoodAngel(this, pyro);

            int lvl = pyro.getLevel();
            pyro.setXp(pyro.getXp() + 50);

            while ((250 + lvl * 50) <= pyro.getXp()) {
                ++lvl;
                pyro.setLevel(lvl);
                pyro.setHp(Constants.DEFAULT_PYRO_HP + pyro.getLevel() * Constants.PYRO_INCREASE);
                pyro.setMaxHp(Constants.DEFAULT_PYRO_HP + pyro.getLevel() * Constants.PYRO_INCREASE);
                inputLoader.displayLvlEvolution(pyro);
            }

            greatMagician.attachHelpedPlayers(pyro);
        }
    }
}
