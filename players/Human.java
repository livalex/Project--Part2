package players;

import angels.AngelVisitor;
import angels.VisitedByAngel;
import constants.Constants;
import main.InputLoader;
import strategies.GameStrategy;

public abstract class Human implements Visitor, Visitable, VisitedByAngel {
    private int hp = Constants.STARTING_HP;
    private int xp = Constants.STARTING_XP;
    private int currentGround = Constants.STARTING_GROUND;
    private int currentAbscissa = Constants.DEFAULT_ABSCISSA;
    private int currentOrdinate = Constants.DEFAULT_ORDINATE;
    private int level = Constants.DEFAULT_LEVEL;
    private int maxHp = Constants.STARTING_HP;
    private boolean igniteFlag = false;
    private boolean dead = false;
    private int overyimeAbilityCounter = Constants.ABILITY_COUNTER;
    private float fireBlast = Constants.FIREBLAST_DAMAGE;
    private float ignite = Constants.IGNITE_BASE_DAMAGE;
    private float igniteDmgTakeRound = Constants.PYRO_INCREASE;
    private float igniteDmgGiveRound = Constants.PYRO_INCREASE;
    private boolean newOvertimeAffection = false;
    private int playerType = Constants.DEFAULT_PLAYER;
    private float execute = Constants.EXECUTE_DAMAGE;
    private float slam = Constants.SLAM_DAMAGE;
    private boolean immobility = false;
    private int backStabCounter = Constants.DEFAULT_BS_COUNTER;
    private float backStab = Constants.BACKSTAB_DEFAULT_DAMAGE;
    private boolean paralysed = false;
    private float paralysis = Constants.PARALYSIS_DEFAULT_DAMAGE;
    private boolean woodsHitFlag = false;
    private float paralysisDmgTakeRound = Constants.DEFAULT_STARTING_VALUE;
    private float noRaceDamage = Constants.DEFAULT_STARTING_VALUE;
    private int playerNumber = Constants.DEFAULT_PLAYER_NUMBER;
    private static int totalNrPlayers = Constants.DEFAULT_PLAYER_NUMBER;
    private float knightExecuteMod = Constants.EXEC_KNIGHT_MOD;
    private float knightSlamMod = Constants.SLAM_KNIGHT_MOD;
    private float knightFbMod = Constants.FB_IGN_KNIGHT_MOD;
    private float knightIgniteMod = Constants.FB_IGN_KNIGHT_MOD;
    private float knightBsMod = Constants.BACKSTAB_KNIGHT_MOD;
    private float knightParMod = Constants.PARALYSIS_KNIGHT_MOD;
    private float knightDrainMod = Constants.DRAIN_KNIGHT_MOD;
    private float knightDeflectMod = Constants.DEFLECT_KNIGHT_MOD;
    private float pyroExecuteMod = Constants.EXEC_PYRO_MOD;
    private float pyroSlamMod = Constants.SLAM_PYRO_MOD;
    private float pyroFbMod = Constants.FB_IGN_PYRO_MOD;
    private float pyroIgniteMod = Constants.FB_IGN_PYRO_MOD;
    private float pyroBsMod = Constants.BACKSTAB_PYRO_MOD;
    private float pyroParMod = Constants.PARALYSIS_PYRO_MOD;
    private float pyroDrainMod = Constants.DRAIN_PYRO_MOD;
    private float pyroDeflectMod = Constants.DEFLECT_PYRO_MOD;
    private float rogueExecuteMod = Constants.EXEC_ROGUE_MOD;
    private float rogueSlamMod = Constants.SLAM_ROGUE_MOD;
    private float rogueFbMod = Constants.FB_ROGUE_MOD;
    private float rogueIgniteMod = Constants.IGNITE_ROGUE_MOD;
    private float rogueBsMod = Constants.BACKSTAB_ROGUE_MOD;
    private float rogueParMod = Constants.PARALYSIS_ROGUE_MOD;
    private float rogueDrainMod = Constants.DRAIN_ROGUE_MOD;
    private float rogueDeflectMod = Constants.DEFLECT_ROGUE_MOD;
    private float wizardExecuteMod = Constants.EXECUTE_WIZARD_MOD;
    private float wizardSlamMod = Constants.SLAM_WIZARD_MOD;
    private float wizardFbMod = Constants.FB_IGN_WIZARD_MOD;
    private float wizardIgniteMod = Constants.FB_IGN_WIZARD_MOD;
    private float wizardBsMod = Constants.BACKSTAB_PARALYSIS_WIZARD_MOD;
    private float wizardParMod = Constants.BACKSTAB_PARALYSIS_WIZARD_MOD;
    private float wizardDrainMod = Constants.DRAIN_WIZARD_MOD;
    private float wizardDeflectMod = Constants.DRAIN_WIZARD_MOD;
    private boolean paralBeforeOvertimeDmg = false;
    private boolean imobBeforeOvertimeDmg = false;
    private int playerStartRoundXp = Constants.DEFAULT_STARTING_VALUE;
    private boolean killedByDoomer = false;

    public final boolean isKilledByDoomer() {
        return killedByDoomer;
    }

    public final void setKilledByDoomer(final boolean killedByDoomer) {
        this.killedByDoomer = killedByDoomer;
    }

    public final int getPlayerStartRoundXp() {
        return playerStartRoundXp;
    }

    public final void setPlayerStartRoundXp(final int playerStartRoundXp) {
        this.playerStartRoundXp = playerStartRoundXp;
    }

    public final boolean isParalBeforeOvertimeDmg() {
        return paralBeforeOvertimeDmg;
    }

    public final void setParalBeforeOvertimeDmg(final boolean paralBeforeOvertimeDmg) {
        this.paralBeforeOvertimeDmg = paralBeforeOvertimeDmg;
    }

    public final boolean isImobBeforeOvertimeDmg() {
        return imobBeforeOvertimeDmg;
    }

    public final void setImobBeforeOvertimeDmg(final boolean imobBeforeOvertimeDmg) {
        this.imobBeforeOvertimeDmg = imobBeforeOvertimeDmg;
    }

    public final float getWizardExecuteMod() {
        return wizardExecuteMod;
    }

    public final void setWizardExecuteMod(final float wizardExecuteMod) {
        this.wizardExecuteMod = wizardExecuteMod;
    }

    public final float getWizardSlamMod() {
        return wizardSlamMod;
    }

    public final void setWizardSlamMod(final float wizardSlamMod) {
        this.wizardSlamMod = wizardSlamMod;
    }

    public final float getWizardFbMod() {
        return wizardFbMod;
    }

    public final void setWizardFbMod(final float wizardFbMod) {
        this.wizardFbMod = wizardFbMod;
    }

    public final float getWizardIgniteMod() {
        return wizardIgniteMod;
    }

    public final void setWizardIgniteMod(final float wizardIgniteMod) {
        this.wizardIgniteMod = wizardIgniteMod;
    }

    public final float getWizardBsMod() {
        return wizardBsMod;
    }

    public final void setWizardBsMod(final float wizardBsMod) {
        this.wizardBsMod = wizardBsMod;
    }

    public final float getWizardParMod() {
        return wizardParMod;
    }

    public final void setWizardParMod(final float wizardParod) {
        this.wizardParMod = wizardParod;
    }

    public final float getWizardDrainMod() {
        return wizardDrainMod;
    }

    public final void setWizardDrainMod(final float wizardDrainMod) {
        this.wizardDrainMod = wizardDrainMod;
    }

    public final float getWizardDeflectMod() {
        return wizardDeflectMod;
    }

    public final void setWizardDeflectMod(final float wizardDeflectMod) {
        this.wizardDeflectMod = wizardDeflectMod;
    }

    public final float getRogueExecuteMod() {
        return rogueExecuteMod;
    }

    public final void setRogueExecuteMod(final float rogueExecuteMod) {
        this.rogueExecuteMod = rogueExecuteMod;
    }

    public final float getRogueSlamMod() {
        return rogueSlamMod;
    }

    public final void setRogueSlamMod(final float rogueSlamMod) {
        this.rogueSlamMod = rogueSlamMod;
    }

    public final float getRogueFbMod() {
        return rogueFbMod;
    }

    public final void setRogueFbMod(final float rogueFbMod) {
        this.rogueFbMod = rogueFbMod;
    }

    public final float getRogueIgniteMod() {
        return rogueIgniteMod;
    }

    public final void setRogueIgniteMod(final float rogueIgniteMod) {
        this.rogueIgniteMod = rogueIgniteMod;
    }

    public final float getRogueBsMod() {
        return rogueBsMod;
    }

    public final void setRogueBsMod(final float rogueBsMod) {
        this.rogueBsMod = rogueBsMod;
    }

    public final float getRogueParMod() {
        return rogueParMod;
    }

    public final void setRogueParMod(final float rogueParMod) {
        this.rogueParMod = rogueParMod;
    }

    public final float getRogueDrainMod() {
        return rogueDrainMod;
    }

    public final void setRogueDrainMod(final float rogueDrainMod) {
        this.rogueDrainMod = rogueDrainMod;
    }

    public final float getRogueDeflectMod() {
        return rogueDeflectMod;
    }

    public final void setRogueDeflectMod(final float rogueDeflectMod) {
        this.rogueDeflectMod = rogueDeflectMod;
    }

    public final float getPyroExecuteMod() {
        return pyroExecuteMod;
    }

    public final void setPyroExecuteMod(final float pyroExecuteMod) {
        this.pyroExecuteMod = pyroExecuteMod;
    }

    public final float getPyroSlamMod() {
        return pyroSlamMod;
    }

    public final void setPyroSlamMod(final float pyroSlamMod) {
        this.pyroSlamMod = pyroSlamMod;
    }

    public final float getPyroFbMod() {
        return pyroFbMod;
    }

    public final void setPyroFbMod(final float pyroFbMod) {
        this.pyroFbMod = pyroFbMod;
    }

    public final float getPyroIgniteMod() {
        return pyroIgniteMod;
    }

    public final void setPyroIgniteMod(final float pyroIgniteMod) {
        this.pyroIgniteMod = pyroIgniteMod;
    }

    public final float getPyroBsMod() {
        return pyroBsMod;
    }

    public final void setPyroBsMod(final float pyroBsMod) {
        this.pyroBsMod = pyroBsMod;
    }

    public final float getPyroParMod() {
        return pyroParMod;
    }

    public final void setPyroParMod(final float pyroParMod) {
        this.pyroParMod = pyroParMod;
    }

    public final float getPyroDrainMod() {
        return pyroDrainMod;
    }

    public final void setPyroDrainMod(final float pyroDrainMod) {
        this.pyroDrainMod = pyroDrainMod;
    }

    public final float getPyroDeflectMod() {
        return pyroDeflectMod;
    }

    public final void setPyroDeflectMod(final float pyroDeflectMod) {
        this.pyroDeflectMod = pyroDeflectMod;
    }

    public final float getKnightExecuteMod() {
        return knightExecuteMod;
    }

    public final void setKnightExecuteMod(final float knightExecuteMod) {
        this.knightExecuteMod = knightExecuteMod;
    }

    public final float getKnightSlamMod() {
        return knightSlamMod;
    }

    public final void setKnightSlamMod(final float knightSlamMod) {
        this.knightSlamMod = knightSlamMod;
    }

    public final float getKnightFbMod() {
        return knightFbMod;
    }

    public final void setKnightFbMod(final float knightFbMod) {
        this.knightFbMod = knightFbMod;
    }

    public final float getKnightIgniteMod() {
        return knightIgniteMod;
    }

    public final void setKnightIgniteMod(final float knightIgniteMod) {
        this.knightIgniteMod = knightIgniteMod;
    }

    public final float getKnightBsMod() {
        return knightBsMod;
    }

    public final void setKnightBsMod(final float knightBsMod) {
        this.knightBsMod = knightBsMod;
    }

    public final float getKnightParMod() {
        return knightParMod;
    }

    public final void setKnightParMod(final float knightParMod) {
        this.knightParMod = knightParMod;
    }

    public final float getKnightDrainMod() {
        return knightDrainMod;
    }

    public final void setKnightDrainMod(final float knightDrainMod) {
        this.knightDrainMod = knightDrainMod;
    }

    public final float getKnightDeflectMod() {
        return knightDeflectMod;
    }

    public final void setKnightDeflectMod(final float knightDeflectMod) {
        this.knightDeflectMod = knightDeflectMod;
    }

    public static final int getTotalNrPlayers() {
        return totalNrPlayers;
    }

    public static final void setTotalNrPlayers(final int totalNrPlayers) {
        Human.totalNrPlayers = totalNrPlayers;
    }

    public final int getPlayerNumber() {
        return playerNumber;
    }

    public final void setPlayerNumber(final int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public final float getNoRaceDamage() {
        return noRaceDamage;
    }

    public final void setNoRaceDamage(final float noRaceDamage) {
        this.noRaceDamage = noRaceDamage;
    }

    public final float getParalysisDmgTakeRound() {
        return paralysisDmgTakeRound;
    }

    public final void setParalysisDmgTakeRound(final float paralysisDmgTakeRound) {
        this.paralysisDmgTakeRound = paralysisDmgTakeRound;
    }

    public final boolean isWoodsHitFlag() {
        return woodsHitFlag;
    }

    public final void setWoodsHitFlag(final boolean woodsHitFlag) {
        this.woodsHitFlag = woodsHitFlag;
    }

    public final boolean isParalysed() {
        return paralysed;
    }

    public final void setParalysed(final boolean paralysed) {
        this.paralysed = paralysed;
    }

    public final float getParalysis() {
        return paralysis;
    }

    public final void setParalysis(final float paralysis) {
        this.paralysis = paralysis;
    }

    public final int getBackStabCounter() {
        return backStabCounter;
    }

    public final void setBackStabCounter(final int backStabCounter) {
        this.backStabCounter = backStabCounter;
    }

    public final float getBackStab() {
        return backStab;
    }

    public final void setBackStab(final float backStab) {
        this.backStab = backStab;
    }

    public final boolean isImmobility() {
        return immobility;
    }

    public final void setImmobility(final boolean immobility) {
        this.immobility = immobility;
    }

    public final float getSlam() {
        return slam;
    }

    public final void setSlam(final float slam) {
        this.slam = slam;
    }

    public final float getExecute() {
        return execute;
    }

    public final void setExecute(final float execute) {
        this.execute = execute;
    }

    public final int getPlayerType() {
        return playerType;
    }

    public final void setPlayerType(final int playerType) {
        this.playerType = playerType;
    }

    public final boolean isNewOvertimeAffection() {
        return newOvertimeAffection;
    }

    public final void setNewOvertimeAffection(final boolean newOvertimeAffection) {
        this.newOvertimeAffection = newOvertimeAffection;
    }

    public final float getIgniteDmgGiveRound() {
        return igniteDmgGiveRound;
    }

    public final void setIgniteDmgGiveRound(final float igniteDmgGiveRound) {
        this.igniteDmgGiveRound = igniteDmgGiveRound;
    }

    public final float getIgniteDmgTakeRound() {
        return igniteDmgTakeRound;
    }

    public final void setIgniteDmgTakeRound(final float igniteDmgRound) {
        this.igniteDmgTakeRound = igniteDmgRound;
    }

    public final float getFireBlast() {
        return fireBlast;
    }

    public final void setFireBlast(final float fireBlast) {
        this.fireBlast = fireBlast;
    }

    public final float getIgnite() {
        return ignite;
    }

    public final void setIgnite(final float ignite) {
        this.ignite = ignite;
    }

    public final boolean isDead() {
        return dead;
    }

    public final void setDead(final boolean dead) {
        this.dead = dead;
    }

    public final boolean isIgniteFlag() {
        return igniteFlag;
    }

    public final void setIgniteFlag(final boolean igniteFlag) {
        this.igniteFlag = igniteFlag;
    }

    public final int getOveryimeAbilityCounter() {
        return overyimeAbilityCounter;
    }

    public final void setOveryimeAbilityCounter(final int overyimeAbilityCounter) {
        this.overyimeAbilityCounter = overyimeAbilityCounter;
    }

    public final int getMaxHp() {
        return maxHp;
    }

    public final void setMaxHp(final int maxHp) {
        this.maxHp = maxHp;
    }

    public final int getLevel() {
        return level;
    }

    public final void setLevel(final int level) {
        this.level = level;
    }

    public final int getHp() {
        return hp;
    }

    public final void setHp(final int hp) {
        this.hp = hp;
    }

    public final int getXp() {
        return xp;
    }

    public final void setXp(final int xp) {
        this.xp = xp;
    }

    public final int getCurrentGround() {
        return currentGround;
    }

    public final void setCurrentGround(final int currentGround) {
        this.currentGround = currentGround;
    }

    public final int getCurrentAbscissa() {
        return currentAbscissa;
    }

    public final void setCurrentAbscissa(final int currentAbscissa) {
        this.currentAbscissa = currentAbscissa;
    }

    public final int getCurrentOrdinate() {
        return currentOrdinate;
    }

    public final void setCurrentOrdinate(final int currentOrdinate) {
        this.currentOrdinate = currentOrdinate;
    }

    public abstract void acceptAngel(AngelVisitor angelVisitor, InputLoader inputLoader);

    public abstract void accept(Visitor visitor);

    public abstract void fight(Pyromancer pyromancer);

    public abstract void fight(Rogue rogue);

    public abstract void fight(Knight knight);

    public abstract void fight(Wizard wizard);

    public final void playThisStrategy(final GameStrategy gameStrategy, final Human human,
                                final InputLoader inputLoader) {
        gameStrategy.play(human, inputLoader);
    }

    // Check the player's overtime ability and
    // If any of them affects a player, update
    // The player's stats.
    public final void checkOverTimeAbility() {
        if (!isDead()) {
            // The effect has just been given.
            if (isNewOvertimeAffection()) {
                // For Paralysed effect.
                if (isParalysed()) {
                    if (isWoodsHitFlag()) {
                        setOveryimeAbilityCounter(Constants.WOODS_HIT);
                        setWoodsHitFlag(false);
                    } else {
                        setOveryimeAbilityCounter(Constants.NORMAL_HIT);
                    }

                    setHp(getHp() - Math.round(getParalysisDmgTakeRound()));
                    setOveryimeAbilityCounter(getOveryimeAbilityCounter() - 1);
                    if (getHp() <= 0) {
                        setDead(true);
                    }
                }

                // For ignite effect
                if (isIgniteFlag()) {
                    setOveryimeAbilityCounter(2);
                    setHp(getHp() - Math.round(getIgniteDmgTakeRound()));
                    setOveryimeAbilityCounter(getOveryimeAbilityCounter() - 1);
                    if (getHp() <= 0) {
                        setDead(true);
                    }
                }
            } else {
                // Same thing as above
                // But for abilities that have been given
                // Earlier in the game.
                if (isIgniteFlag()) {
                    setHp(getHp() - Math.round(getIgniteDmgTakeRound()));
                    setOveryimeAbilityCounter(getOveryimeAbilityCounter() - 1);
                    if (getOveryimeAbilityCounter() == 0) {
                        setIgniteFlag(false);
                    }
                    if (getHp() <= 0) {
                        setDead(true);
                    }
                }

                if (isParalysed()) {
                    setHp(getHp() - Math.round(getParalysisDmgTakeRound()));
                    setOveryimeAbilityCounter(getOveryimeAbilityCounter() - 1);
                    if (getOveryimeAbilityCounter() == 0) {
                        setParalysed(false);
                        setOveryimeAbilityCounter(0);
                    }
                    if (getHp() <= 0) {
                        setDead(true);
                    }
                }
            }
        }
        setNewOvertimeAffection(false);
        setImmobility(false);
    }

    /**
     * The way wizard strategy works.
     * <p>
     *     The implementation of this player's strategy taking into
     *     consideration factors like ground, level and race modifiers.
     *     Check the README for more information.
     * </p>
     * @param wizard
     * @param modifier1
     * @param modifier2
     * @param groundBonus
     */
    public void wizardGame(final Wizard wizard, final float modifier1,
                           final float modifier2, final float groundBonus) {
        float percentage;
        int drainDamage;
        int finalDamage;
        int deflectDamage = 0;

        // Level factor.
        percentage = Constants.WIZARD_PROCENT + wizard.getLevel()
                * Constants.WIZARD_LEVEL_MULTIPLIER;

        // Ground factor.
        if (wizard.getCurrentGround() == 2) {
            percentage = percentage + groundBonus * percentage;
        }

        // Modifiers factor.
        percentage = percentage + modifier1 * percentage;

        drainDamage = Math.round(percentage
                * Math.min(Constants.WIZARD_MULTIPLIER_FACTOR * getMaxHp(), getHp()));

        // Check for wizard vs wizard.
        if (getPlayerType() != 2) {
            float percentageOperator = 0.0f;

            // Level factor.
            percentageOperator = Constants.DEFLECT_PERCENTAGE + wizard.getLevel()
                    * Constants.DEFLECT_LVL_MULTIPLIER;


            if (percentageOperator > Constants.DEFLECT_MAX_PERCENTAGE) {
                percentageOperator = Constants.DEFLECT_MAX_PERCENTAGE;
            }

            // Ground factor.
            if (getCurrentGround() == 2) {
                percentageOperator = percentageOperator + groundBonus * percentageOperator;  // !!!!
            }

            // Modifiers factor.
            percentageOperator = percentageOperator + modifier2 * percentageOperator;
            deflectDamage = Math.round(percentageOperator * getNoRaceDamage());
        }

        if (getPlayerType() != 2) {
            // In case of wizard vs any other player.
            finalDamage = drainDamage + deflectDamage;
        } else {
            // In case of wizard vs wizard.
            finalDamage = drainDamage;
        }

        setHp(getHp() - finalDamage);

        if (getHp() <= 0) {
            setDead(true);
        }
    }

    /**
     * The way pyromancer strategy works.
     * <p>
     *     The implementation of this player's strategy taking into
     *     consideration factors like ground, level and race modifiers.
     *     Check the README for more information.
     * </p>
     * @param pyromancer
     * @param modifier1
     * @param modifier2
     * @param groundBonus
     */
    public void pyroGame(final Pyromancer pyromancer, final float modifier1,
                         final float modifier2, final float groundBonus) {

        // Level factor.
        pyromancer.setFireBlast(Constants.FIREBLAST_DAMAGE
                + pyromancer.getLevel() * Constants.PYRO_INCREASE);
        pyromancer.setIgnite(Constants.IGNITE_BASE_DAMAGE
                + pyromancer.getLevel() * Constants.IGN_LVL_DMG);
        pyromancer.setIgniteDmgGiveRound(Constants.PYRO_INCREASE
                + pyromancer.getLevel() * Constants.IGN_SEC_LVL_DMG);

        // Ground factor.
        if (pyromancer.getCurrentGround() == 1) {
            pyromancer.setFireBlast(Math.round(pyromancer.getFireBlast()
                    + groundBonus * pyromancer.getFireBlast()));
            pyromancer.setIgnite(Math.round(pyromancer.getIgnite()
                    + groundBonus * pyromancer.getIgnite()));
            pyromancer.setIgniteDmgGiveRound(Math.round(pyromancer.getIgniteDmgGiveRound()
                    + groundBonus * pyromancer.getIgniteDmgGiveRound()));
        }

        // Damage taken as a parameter for the deflect ability of the wizard.
        pyromancer.setNoRaceDamage(pyromancer.getFireBlast() + pyromancer.getIgnite());

        // Modifiers factor.
        pyromancer.setFireBlast(Math.round((pyromancer.getFireBlast()
                + modifier1 * pyromancer.getFireBlast()))); // !!!!!!
        pyromancer.setIgnite(Math.round((pyromancer.getIgnite()
                + modifier2 * pyromancer.getIgnite()))); // !!!!!!
        pyromancer.setIgniteDmgGiveRound(Math.round(pyromancer.getIgniteDmgGiveRound()
                + modifier2 * pyromancer.getIgniteDmgGiveRound()));

        // Turn on the new affection and ignite flags and off the others.
        setIgniteDmgTakeRound(pyromancer.getIgniteDmgGiveRound());
        setNewOvertimeAffection(true);
        setIgniteFlag(true);
        setImmobility(false);
        setParalysed(false);

        int finalDamage = Math.round(pyromancer.getFireBlast() + pyromancer.getIgnite());
        setHp(getHp() - finalDamage);

        if (getHp() <= 0) {
            setDead(true);
        }
    }

    /**
     * The way knight strategy works.
     * <p>
     *     The implementation of this player's strategy taking into
     *     consideration factors like ground, level and race modifiers.
     *     Check the README for more information.
     * </p>
     * @param knight
     * @param modifier1
     * @param modifier2
     * @param groundBonus
     */
    public void knightGame(final Knight knight, final float modifier1,
                           final float modifier2, final float groundBonus) {
        float percentage = Constants.HP_LIMIT_FPARAM
                + knight.getLevel() * Constants.HP_LIMIT_SPARAM;
        if (percentage > Constants.MAX_KNIGHT_HP_LIMIT) {
            percentage = Constants.MAX_KNIGHT_HP_LIMIT;
        }
        int hpLimit = Math.round(percentage * getMaxHp());

        // Calculates if the victim immediately dies.
        if (getHp() < hpLimit) {
            setHp(0);
            setDead(true);

        } else {
            // Level factor.
            knight.setExecute(Constants.EXECUTE_DAMAGE
                    + knight.getLevel() * Constants.EXECUTE_INCREASE);
            knight.setSlam(Constants.SLAM_DAMAGE + knight.getLevel() * Constants.SLAM_INCREASE);

            // Ground factor.
            if (knight.getCurrentGround() == 0) {
                knight.setExecute(Math.round(knight.getExecute()
                        + groundBonus * knight.getExecute()));
                knight.setSlam(Math.round(knight.getSlam() + groundBonus * knight.getSlam()));
            }

            // Damage taken as a parameter for the deflect ability of the wizard.
            knight.setNoRaceDamage(knight.getExecute() + knight.getSlam());

            // Modifiers factor.
            knight.setExecute(Math.round(knight.getExecute() + modifier1 * knight.getExecute()));
            knight.setSlam(Math.round(knight.getSlam() + modifier2 * knight.getSlam()));

            // Turn on the new affection and immobility flags and off the others.
            setNewOvertimeAffection(true);
            setIgniteFlag(false);
            setImmobility(true);
            setParalysed(false);

            int finalDamage = Math.round(knight.getExecute() + knight.getSlam());
            setHp(getHp() - finalDamage);

            if (getHp() <= 0) {
                setDead(true);
            }
        }
    }

    /**
     * The way rogue strategy works.
     * <p>
     *     The implementation of this player's strategy taking into
     *     consideration factors like ground, level and race modifiers.
     *     Check the README for more information.
     * </p>
     * @param rogue
     * @param modifier1
     * @param modifier2
     * @param groundBonus
     */
    public void rogueGame(final Rogue rogue, final float modifier1,
                          final float modifier2, final float groundBonus) {
        // Level factor.
        rogue.setBackStab(Constants.BACKSTAB_DEFAULT_DAMAGE
                + rogue.getLevel() * Constants.BACKSTAB_LVL_INC);
        rogue.setParalysis(Constants.PARALYSIS_DEFAULT_DAMAGE
                + rogue.getLevel() * Constants.PARALYSIS_LVL_INC);

        // Ground factor.
        if (rogue.getCurrentGround() == Constants.THREE_TYPE_GROUND) {
            rogue.setBackStab(Math.round(rogue.getBackStab()
                    + groundBonus * rogue.getBackStab()));
            rogue.setParalysis(Math.round(rogue.getParalysis()
                    + groundBonus * rogue.getParalysis()));
            setWoodsHitFlag(true);
        }

        // Damage taken as a parameter for the deflect ability of the wizard.
        // It also adds the critical hit factor.
        if (rogue.getCurrentGround() == Constants.THREE_TYPE_GROUND
                && rogue.getBackStabCounter() == Constants.DEFAULT_BS_COUNTER) {
            rogue.setNoRaceDamage(Math.round(rogue.getBackStab() * Constants.CRITICAL_HIT)
                    + rogue.getParalysis());
        } else {
            rogue.setNoRaceDamage(rogue.getBackStab() + rogue.getParalysis());
        }

        // Modifiers factor.
        rogue.setBackStab((rogue.getBackStab() + modifier1 * rogue.getBackStab()));
        rogue.setParalysis((rogue.getParalysis() + modifier2 * rogue.getParalysis()));  //  !!!!!!!
        // Critical hit factor.
        if (rogue.getCurrentGround() == Constants.THREE_TYPE_GROUND
                && rogue.getBackStabCounter() == Constants.DEFAULT_BS_COUNTER) {
            rogue.setBackStab(Math.round(rogue.getBackStab() * Constants.CRITICAL_HIT));
            rogue.setBackStabCounter(0);
        }

        // Turn on the new affection and paralysed flags and off the others.
        setParalysisDmgTakeRound(rogue.getParalysis());
        setNewOvertimeAffection(true);
        setIgniteFlag(false);
        setImmobility(false);
        setParalysed(true);

        float finalDamage = (rogue.getBackStab() + rogue.getParalysis());
        setHp(getHp() - Math.round(finalDamage));
        rogue.setBackStabCounter(rogue.getBackStabCounter() + 1);

        if (getHp() <= 0) {
            setDead(true);
            setNewOvertimeAffection(false);
            setIgniteFlag(false);
            setImmobility(false);
            setParalysed(false);
        }
    }
}
