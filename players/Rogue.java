package players;

import angels.AngelVisitor;
import angels.VisitedByAngel;
import constants.Constants;
import main.InputLoader;
import strategies.*;

public class Rogue extends Human implements Visitable, Visitor, VisitedByAngel {

    private float rogueExecuteMod = Constants.EXEC_ROGUE_MOD;
    private float rogueSlamMod = Constants.SLAM_ROGUE_MOD;
    private float rogueFbMod = Constants.FB_ROGUE_MOD;
    private float rogueIgniteMod = Constants.IGNITE_ROGUE_MOD;
    private float rogueBsMod = Constants.BACKSTAB_ROGUE_MOD;
    private float rogueParMod = Constants.PARALYSIS_ROGUE_MOD;
    private float rogueDrainMod = Constants.DRAIN_ROGUE_MOD;
    private float rogueDeflectMod = Constants.DEFLECT_ROGUE_MOD;


    Rogue(final int abscissa, final int ordinate) {
        setPlayerType(Constants.PLAYER_TYPE_THREE);
        setHp(Constants.DEFAULT_ROGUE_HP);
        setMaxHp(Constants.DEFAULT_ROGUE_HP);
        setCurrentAbscissa(abscissa);
        setCurrentOrdinate(ordinate);
        setTotalNrPlayers(getTotalNrPlayers() + 1);
        setPlayerNumber(getTotalNrPlayers());
    }

    public float getRogueExecuteMod() {
        return rogueExecuteMod;
    }

    public void setRogueExecuteMod(float rogueExecuteMod) {
        this.rogueExecuteMod = rogueExecuteMod;
    }

    public float getRogueSlamMod() {
        return rogueSlamMod;
    }

    public void setRogueSlamMod(float rogueSlamMod) {
        this.rogueSlamMod = rogueSlamMod;
    }

    public float getRogueFbMod() {
        return rogueFbMod;
    }

    public void setRogueFbMod(float rogueFbMod) {
        this.rogueFbMod = rogueFbMod;
    }

    public float getRogueIgniteMod() {
        return rogueIgniteMod;
    }

    public void setRogueIgniteMod(float rogueIgniteMod) {
        this.rogueIgniteMod = rogueIgniteMod;
    }

    public float getRogueBsMod() {
        return rogueBsMod;
    }

    public void setRogueBsMod(float rogueBsMod) {
        this.rogueBsMod = rogueBsMod;
    }

    public float getRogueParMod() {
        return rogueParMod;
    }

    public void setRogueParMod(float rogueParMod) {
        this.rogueParMod = rogueParMod;
    }

    public float getRogueDrainMod() {
        return rogueDrainMod;
    }

    public void setRogueDrainMod(float rogueDrainMod) {
        this.rogueDrainMod = rogueDrainMod;
    }

    public float getRogueDeflectMod() {
        return rogueDeflectMod;
    }

    public void setRogueDeflectMod(float rogueDeflectMod) {
        this.rogueDeflectMod = rogueDeflectMod;
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

    // Be the visitor.
    @Override
    public final void fight(final Pyromancer pyromancer, InputLoader inputLoader) {
        if (pyromancer.getHp() > (pyromancer.getMaxHp() / 4) && pyromancer.getHp() < (pyromancer.getMaxHp() / 3)) {
            super.playPyroStrategy(new OffensivePyroStrategy(), pyromancer, getRogueFbMod(),
                    getRogueIgniteMod(), Constants.VOLCANIC_GRD_BONUS, this, inputLoader);
        } else if (pyromancer.getHp() < (pyromancer.getMaxHp() / 4)) {
            super.playPyroStrategy(new DefensivePyroStrategy(), pyromancer, getRogueFbMod(),
                    getRogueIgniteMod(), Constants.VOLCANIC_GRD_BONUS, this, inputLoader);
        }
        super.pyroGame(pyromancer, getRogueFbMod(),
                getRogueIgniteMod(), Constants.VOLCANIC_GRD_BONUS, inputLoader);
    }

    @Override
    public final void fight(final Rogue rogue, InputLoader inputLoader) {
        if (rogue.getHp() > (rogue.getMaxHp() / 7) && rogue.getHp() < (rogue.getMaxHp() / 5)) {
            super.playRogueStrategy(new OffensiveRogueStrategy(), rogue, getRogueBsMod(),
                    getRogueParMod(), Constants.WOODS_GRD_BONUS, this, inputLoader);
        } else if (rogue.getHp() < (rogue.getMaxHp() / 7)) {
            super.playRogueStrategy(new DefensiveRogueStrategy(), rogue, getRogueBsMod(),
                    getRogueParMod(), Constants.WOODS_GRD_BONUS, this, inputLoader);
        }
        super.rogueGame(rogue, getRogueBsMod(),
                getRogueParMod(), Constants.WOODS_GRD_BONUS, inputLoader);
    }

    @Override
    public final void fight(final Knight knight, InputLoader inputLoader) {
        if (knight.getHp() > (knight.getMaxHp() / 3) && knight.getHp() < (knight.getMaxHp() / 2)) {
            super.playKnightStrategy(new OffensiveKnightStrategy(), knight, getRogueExecuteMod(),
                    getRogueSlamMod(), Constants.LAND_GRD_BONUS, this, inputLoader);
        } else if (knight.getHp() < (knight.getMaxHp() / 3)) {
            super.playKnightStrategy(new DefensiveKnightStrategy(), knight, getRogueExecuteMod(),
                    getRogueSlamMod(), Constants.LAND_GRD_BONUS, this, inputLoader);
        }
        super.knightGame(knight, getRogueExecuteMod(),
                getRogueSlamMod(), Constants.LAND_GRD_BONUS, inputLoader);
    }

    @Override
    public final void fight(final Wizard wizard, InputLoader inputLoader) {
        if (wizard.getHp() > (wizard.getMaxHp() / 4) && wizard.getHp() < (wizard.getMaxHp() / 2)) {
            super.playWizardStrategy(new OffensiveWizardStrategy(), wizard, getRogueDrainMod(),
                    getRogueDeflectMod(), Constants.DESERT_GRD_BONUS, this, inputLoader);
        } else if (wizard.getHp() < (wizard.getMaxHp() / 4)) {
            super.playWizardStrategy(new DefensiveWizardStrategy(), wizard, getRogueDrainMod(),
                    getRogueDeflectMod(), Constants.DESERT_GRD_BONUS, this, inputLoader);
        }
        super.wizardGame(wizard, getRogueDrainMod(),
                getRogueDeflectMod(), Constants.DESERT_GRD_BONUS, inputLoader);
    }
}
