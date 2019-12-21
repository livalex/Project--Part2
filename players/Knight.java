package players;

import angels.AngelVisitor;
import angels.VisitedByAngel;
import constants.Constants;
import main.InputLoader;
import strategies.*;

public class Knight extends Human implements Visitable, Visitor, VisitedByAngel {

    private float knightExecuteMod = Constants.EXEC_KNIGHT_MOD;
    private float knightSlamMod = Constants.SLAM_KNIGHT_MOD;
    private float knightFbMod = Constants.FB_IGN_KNIGHT_MOD;
    private float knightIgniteMod = Constants.FB_IGN_KNIGHT_MOD;
    private float knightBsMod = Constants.BACKSTAB_KNIGHT_MOD;
    private float knightParMod = Constants.PARALYSIS_KNIGHT_MOD;
    private float knightDrainMod = Constants.DRAIN_KNIGHT_MOD;
    private float knightDeflectMod = Constants.DEFLECT_KNIGHT_MOD;

    Knight(final int abscissa, final int ordinate) {
        setPlayerType(Constants.PLAYER_TYPE_ONE);
        setHp(Constants.DEFAULT_KNIGHT_HP);
        setMaxHp(Constants.DEFAULT_KNIGHT_HP);
        setCurrentAbscissa(abscissa);
        setCurrentOrdinate(ordinate);
        setTotalNrPlayers(getTotalNrPlayers() + 1);
        setPlayerNumber(getTotalNrPlayers());
    }

    public float getKnightExecuteMod() {
        return knightExecuteMod;
    }

    public void setKnightExecuteMod(float knightExecuteMod) {
        this.knightExecuteMod = knightExecuteMod;
    }

    public float getKnightSlamMod() {
        return knightSlamMod;
    }

    public void setKnightSlamMod(float knightSlamMod) {
        this.knightSlamMod = knightSlamMod;
    }

    public float getKnightFbMod() {
        return knightFbMod;
    }

    public void setKnightFbMod(float knightFbMod) {
        this.knightFbMod = knightFbMod;
    }

    public float getKnightIgniteMod() {
        return knightIgniteMod;
    }

    public void setKnightIgniteMod(float knightIgniteMod) {
        this.knightIgniteMod = knightIgniteMod;
    }

    public float getKnightBsMod() {
        return knightBsMod;
    }

    public void setKnightBsMod(float knightBsMod) {
        this.knightBsMod = knightBsMod;
    }

    public float getKnightParMod() {
        return knightParMod;
    }

    public void setKnightParMod(float knightParMod) {
        this.knightParMod = knightParMod;
    }

    public float getKnightDrainMod() {
        return knightDrainMod;
    }

    public void setKnightDrainMod(float knightDrainMod) {
        this.knightDrainMod = knightDrainMod;
    }

    public float getKnightDeflectMod() {
        return knightDeflectMod;
    }

    public void setKnightDeflectMod(float knightDeflectMod) {
        this.knightDeflectMod = knightDeflectMod;
    }

    @Override
    public void acceptAngel(AngelVisitor angelVisitor, InputLoader inputLoader) {
        angelVisitor.angelVisit(this, inputLoader);
    }

    // Accept the visitor.
    @Override
    public final void accept(final Visitor visitor, InputLoader inputLoader) {
        visitor.fight(this, inputLoader);
    }

    @Override
    public final void fight(final Pyromancer pyromancer, InputLoader inputLoader) {
        if (pyromancer.getHp() > (pyromancer.getMaxHp() / 4) && pyromancer.getHp() < (pyromancer.getMaxHp() / 3)) {
            super.playPyroStrategy(new OffensivePyroStrategy(), pyromancer, getKnightFbMod(),
                    getKnightIgniteMod(), Constants.VOLCANIC_GRD_BONUS, this, inputLoader);
        } else if (pyromancer.getHp() < (pyromancer.getMaxHp() / 4)) {
            super.playPyroStrategy(new DefensivePyroStrategy(), pyromancer, getKnightFbMod(),
                    getKnightIgniteMod(), Constants.VOLCANIC_GRD_BONUS, this, inputLoader);
        }

        super.pyroGame(pyromancer, getKnightFbMod(),
                getKnightIgniteMod(), Constants.VOLCANIC_GRD_BONUS, inputLoader);
    }

    // Be the visitor.
    @Override
    public final void fight(final Rogue rogue, InputLoader inputLoader) {
        if (rogue.getHp() > (rogue.getMaxHp() / 7) && rogue.getHp() < (rogue.getMaxHp() / 5)) {
            super.playRogueStrategy(new OffensiveRogueStrategy(), rogue, getKnightBsMod(),
                    getKnightParMod(), Constants.WOODS_GRD_BONUS, this, inputLoader);
        } else if (rogue.getHp() < (rogue.getMaxHp() / 7)) {
            super.playRogueStrategy(new DefensiveRogueStrategy(), rogue, getKnightBsMod(),
                    getKnightParMod(), Constants.WOODS_GRD_BONUS, this, inputLoader);
        }

        super.rogueGame(rogue, getKnightBsMod(),
                getKnightParMod(), Constants.WOODS_GRD_BONUS, inputLoader);

    }

    @Override
    public final void fight(final Knight knight, InputLoader inputLoader) {
        if (knight.getHp() > (knight.getMaxHp() / 3) && knight.getHp() < (knight.getMaxHp() / 2)) {
            super.playKnightStrategy(new OffensiveKnightStrategy(), knight, getKnightExecuteMod(),
                    getKnightSlamMod(), Constants.LAND_GRD_BONUS, this, inputLoader);
        } else if (knight.getHp() < (knight.getMaxHp() / 3)) {
            super.playKnightStrategy(new DefensiveKnightStrategy(), knight, getKnightExecuteMod(),
                    getKnightSlamMod(), Constants.LAND_GRD_BONUS, this, inputLoader);
        }
        super.knightGame(knight, getKnightExecuteMod(),
                getKnightSlamMod(), Constants.LAND_GRD_BONUS, inputLoader);
    }

    @Override
    public final void fight(final Wizard wizard, InputLoader inputLoader) {
        if (wizard.getHp() > (wizard.getMaxHp() / 4) && wizard.getHp() < (wizard.getMaxHp() / 2)) {
            super.playWizardStrategy(new OffensiveWizardStrategy(), wizard, getKnightDrainMod(),
                    getKnightDeflectMod(), Constants.DESERT_GRD_BONUS, this, inputLoader);
        } else if (wizard.getHp() < (wizard.getMaxHp() / 4)) {
            super.playWizardStrategy(new DefensiveWizardStrategy(), wizard, getKnightDrainMod(),
                    getKnightDeflectMod(), Constants.DESERT_GRD_BONUS, this, inputLoader);
        }
        super.wizardGame(wizard, getKnightDrainMod(),
                getKnightDeflectMod(), Constants.DESERT_GRD_BONUS, inputLoader);
    }
}
