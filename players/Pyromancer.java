package players;

import angels.AngelVisitor;
import angels.VisitedByAngel;
import constants.Constants;
import main.InputLoader;
import strategies.*;

public class Pyromancer extends Human implements Visitable, Visitor, VisitedByAngel {

    private float pyroExecuteMod = Constants.EXEC_PYRO_MOD;
    private float pyroSlamMod = Constants.SLAM_PYRO_MOD;
    private float pyroFbMod = Constants.FB_IGN_PYRO_MOD;
    private float pyroIgniteMod = Constants.FB_IGN_PYRO_MOD;
    private float pyroBsMod = Constants.BACKSTAB_PYRO_MOD;
    private float pyroParMod = Constants.PARALYSIS_PYRO_MOD;
    private float pyroDrainMod = Constants.DRAIN_PYRO_MOD;
    private float pyroDeflectMod = Constants.DEFLECT_PYRO_MOD;

    Pyromancer(final int abscissa, final int ordinate) {
        setPlayerType(Constants.PLAYER_TYPE_ZERO);
        setHp(Constants.DEFAULT_PYRO_HP);
        setMaxHp(Constants.DEFAULT_PYRO_HP);
        setCurrentAbscissa(abscissa);
        setCurrentOrdinate(ordinate);
        setTotalNrPlayers(getTotalNrPlayers() + 1);
        setPlayerNumber(getTotalNrPlayers());
    }

    public float getPyroExecuteMod() {
        return pyroExecuteMod;
    }

    public void setPyroExecuteMod(float pyroExecuteMod) {
        this.pyroExecuteMod = pyroExecuteMod;
    }

    public float getPyroSlamMod() {
        return pyroSlamMod;
    }

    public void setPyroSlamMod(float pyroSlamMod) {
        this.pyroSlamMod = pyroSlamMod;
    }

    public float getPyroFbMod() {
        return pyroFbMod;
    }

    public void setPyroFbMod(float pyroFbMod) {
        this.pyroFbMod = pyroFbMod;
    }

    public float getPyroIgniteMod() {
        return pyroIgniteMod;
    }

    public void setPyroIgniteMod(float pyroIgniteMod) {
        this.pyroIgniteMod = pyroIgniteMod;
    }

    public float getPyroBsMod() {
        return pyroBsMod;
    }

    public void setPyroBsMod(float pyroBsMod) {
        this.pyroBsMod = pyroBsMod;
    }

    public float getPyroParMod() {
        return pyroParMod;
    }

    public void setPyroParMod(float pyroParMod) {
        this.pyroParMod = pyroParMod;
    }

    public float getPyroDrainMod() {
        return pyroDrainMod;
    }

    public void setPyroDrainMod(float pyroDrainMod) {
        this.pyroDrainMod = pyroDrainMod;
    }

    public float getPyroDeflectMod() {
        return pyroDeflectMod;
    }

    public void setPyroDeflectMod(float pyroDeflectMod) {
        this.pyroDeflectMod = pyroDeflectMod;
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
        if (pyromancer.getHp() > (pyromancer.getMaxHp() / 4) && pyromancer.getHp() < (pyromancer.getMaxHp() / 3)) {
            super.playPyroStrategy(new OffensivePyroStrategy(), pyromancer, getPyroFbMod(),
                    getPyroIgniteMod(), Constants.VOLCANIC_GRD_BONUS, this, inputLoader);
        } else if (pyromancer.getHp() < (pyromancer.getMaxHp() / 4)) {
            super.playPyroStrategy(new DefensivePyroStrategy(), pyromancer, getPyroFbMod(),
                    getPyroIgniteMod(), Constants.VOLCANIC_GRD_BONUS, this, inputLoader);
        }
        super.pyroGame(pyromancer, getPyroFbMod(),
                getPyroIgniteMod(), Constants.VOLCANIC_GRD_BONUS, inputLoader);
    }

    @Override
    public final void fight(final Rogue rogue, InputLoader inputLoader) {
        if (rogue.getHp() > (rogue.getMaxHp() / 7) && rogue.getHp() < (rogue.getMaxHp() / 5)) {
            super.playRogueStrategy(new OffensiveRogueStrategy(), rogue, getPyroBsMod(),
                    getPyroParMod(), Constants.WOODS_GRD_BONUS, this, inputLoader);
        } else if (rogue.getHp() < (rogue.getMaxHp() / 7)) {
            super.playRogueStrategy(new DefensiveRogueStrategy(), rogue, getPyroBsMod(),
                    getPyroParMod(), Constants.WOODS_GRD_BONUS, this, inputLoader);
        }
        super.rogueGame(rogue, getPyroBsMod(),
                getPyroParMod(), Constants.WOODS_GRD_BONUS, inputLoader);
    }

    @Override
    public final void fight(final Knight knight, InputLoader inputLoader) {
        if (knight.getHp() > (knight.getMaxHp() / 3) && knight.getHp() < (knight.getMaxHp() / 2)) {
            super.playKnightStrategy(new OffensiveKnightStrategy(), knight, getPyroExecuteMod(),
                    getPyroSlamMod(), Constants.LAND_GRD_BONUS, this, inputLoader);
        } else if (knight.getHp() < (knight.getMaxHp() / 3)) {
            super.playKnightStrategy(new DefensiveKnightStrategy(), knight, getPyroExecuteMod(),
                    getPyroSlamMod(), Constants.LAND_GRD_BONUS, this, inputLoader);
        }
        super.knightGame(knight, getPyroExecuteMod(),
                getPyroSlamMod(), Constants.LAND_GRD_BONUS, inputLoader);
    }

    @Override
    public final void fight(final Wizard wizard, InputLoader inputLoader) {
        if (wizard.getHp() > (wizard.getMaxHp() / 4) && wizard.getHp() < (wizard.getMaxHp() / 2)) {
            super.playWizardStrategy(new OffensiveWizardStrategy(), wizard, getPyroDrainMod(),
                    getPyroDeflectMod(), Constants.DESERT_GRD_BONUS, this, inputLoader);
        } else if (wizard.getHp() < (wizard.getMaxHp() / 4)) {
            super.playWizardStrategy(new DefensiveWizardStrategy(), wizard, getPyroDrainMod(),
                    getPyroDeflectMod(), Constants.DESERT_GRD_BONUS, this, inputLoader);
        }
        super.wizardGame(wizard, getPyroDrainMod(),
                getPyroDeflectMod(), Constants.DESERT_GRD_BONUS, inputLoader);
    }
}
