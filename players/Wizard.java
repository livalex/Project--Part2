package players;

import angels.AngelVisitor;
import angels.VisitedByAngel;
import constants.Constants;
import main.Input;
import main.InputLoader;
import strategies.*;

public class Wizard extends Human implements Visitable, Visitor, VisitedByAngel {

    private float wizardExecuteMod = Constants.EXECUTE_WIZARD_MOD;
    private float wizardSlamMod = Constants.SLAM_WIZARD_MOD;
    private float wizardFbMod = Constants.FB_IGN_WIZARD_MOD;
    private float wizardIgniteMod = Constants.FB_IGN_WIZARD_MOD;
    private float wizardBsMod = Constants.BACKSTAB_PARALYSIS_WIZARD_MOD;
    private float wizardParMod = Constants.BACKSTAB_PARALYSIS_WIZARD_MOD;
    private float wizardDrainMod = Constants.DRAIN_WIZARD_MOD;
    private float wizardDeflectMod = Constants.DRAIN_WIZARD_MOD;

    Wizard(final int abscissa, final int ordinate) {
        setPlayerType(Constants.PLAYER_TYPE_TWO);
        setHp(Constants.DEFAULT_WIZARD_HP);
        setMaxHp(Constants.DEFAULT_WIZARD_HP);
        setCurrentAbscissa(abscissa);
        setCurrentOrdinate(ordinate);
        setTotalNrPlayers(getTotalNrPlayers() + 1);
        setPlayerNumber(getTotalNrPlayers());
    }

    public float getWizardExecuteMod() {
        return wizardExecuteMod;
    }

    public void setWizardExecuteMod(float wizardExecuteMod) {
        this.wizardExecuteMod = wizardExecuteMod;
    }

    public float getWizardSlamMod() {
        return wizardSlamMod;
    }

    public void setWizardSlamMod(float wizardSlamMod) {
        this.wizardSlamMod = wizardSlamMod;
    }

    public float getWizardFbMod() {
        return wizardFbMod;
    }

    public void setWizardFbMod(float wizardFbMod) {
        this.wizardFbMod = wizardFbMod;
    }

    public float getWizardIgniteMod() {
        return wizardIgniteMod;
    }

    public void setWizardIgniteMod(float wizardIgniteMod) {
        this.wizardIgniteMod = wizardIgniteMod;
    }

    public float getWizardBsMod() {
        return wizardBsMod;
    }

    public void setWizardBsMod(float wizardBsMod) {
        this.wizardBsMod = wizardBsMod;
    }

    public float getWizardParMod() {
        return wizardParMod;
    }

    public void setWizardParMod(float wizardParod) {
        this.wizardParMod = wizardParod;
    }

    public float getWizardDrainMod() {
        return wizardDrainMod;
    }

    public void setWizardDrainMod(float wizardDrainMod) {
        this.wizardDrainMod = wizardDrainMod;
    }

    public float getWizardDeflectMod() {
        return wizardDeflectMod;
    }

    public void setWizardDeflectMod(float wizardDeflectMod) {
        this.wizardDeflectMod = wizardDeflectMod;
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
            super.playPyroStrategy(new OffensivePyroStrategy(), pyromancer, getWizardFbMod(),
                    getWizardIgniteMod(), Constants.VOLCANIC_GRD_BONUS, this, inputLoader);
        } else if (pyromancer.getHp() < (pyromancer.getMaxHp() / 4)) {
            super.playPyroStrategy(new DefensivePyroStrategy(), pyromancer, getWizardFbMod(),
                    getWizardIgniteMod(), Constants.VOLCANIC_GRD_BONUS, this, inputLoader);
        }
        super.pyroGame(pyromancer, getWizardFbMod(),
                getWizardIgniteMod(), Constants.VOLCANIC_GRD_BONUS, inputLoader);

    }

    @Override
    public final void fight(final Rogue rogue, InputLoader inputLoader) {
        if (rogue.getHp() > (rogue.getMaxHp() / 7) && rogue.getHp() < (rogue.getMaxHp() / 5)) {
            super.playRogueStrategy(new OffensiveRogueStrategy(), rogue, getWizardBsMod(),
                    getWizardParMod(), Constants.WOODS_GRD_BONUS, this, inputLoader);
        } else if (rogue.getHp() < (rogue.getMaxHp() / 7)) {
            super.playRogueStrategy(new DefensiveRogueStrategy(), rogue, getWizardBsMod(),
                    getWizardParMod(), Constants.WOODS_GRD_BONUS, this, inputLoader);
        }
        super.rogueGame(rogue, getWizardBsMod(),
                getWizardParMod(), Constants.WOODS_GRD_BONUS, inputLoader);

    }

    @Override
    public final void fight(final Knight knight, InputLoader inputLoader) {
        if (knight.getHp() > (knight.getMaxHp() / 3) && knight.getHp() < (knight.getMaxHp() / 2)) {
            super.playKnightStrategy(new OffensiveKnightStrategy(), knight, getWizardExecuteMod(),
                    getWizardSlamMod(), Constants.LAND_GRD_BONUS, this, inputLoader);
        } else if (knight.getHp() < (knight.getMaxHp() / 3)) {
            super.playKnightStrategy(new DefensiveKnightStrategy(), knight, getWizardExecuteMod(),
                    getWizardSlamMod(), Constants.LAND_GRD_BONUS, this, inputLoader);
        }
        super.knightGame(knight, getWizardExecuteMod(),
                getWizardSlamMod(), Constants.LAND_GRD_BONUS, inputLoader);
    }

    @Override
    public final void fight(final Wizard wizard, InputLoader inputLoader) {
        if (wizard.getHp() > (wizard.getMaxHp() / 4) && wizard.getHp() < (wizard.getMaxHp() / 2)) {
            super.playWizardStrategy(new OffensiveWizardStrategy(), wizard, getWizardDrainMod(),
                    getWizardDrainMod(), Constants.DESERT_GRD_BONUS, this, inputLoader);
        } else if (wizard.getHp() < (wizard.getMaxHp() / 4)) {
            super.playWizardStrategy(new DefensiveWizardStrategy(), wizard, getWizardDrainMod(),
                    getWizardDeflectMod(), Constants.DESERT_GRD_BONUS, this, inputLoader);
        }
        super.wizardGame(wizard, getWizardDrainMod(),
                getWizardDrainMod(), Constants.DESERT_GRD_BONUS, inputLoader);
    }
}
