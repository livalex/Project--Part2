package main;

import angels.Angel;
import angels.AngelsFactory;
import constants.Constants;
import players.Human;
import strategies.DefensiveKnightStrategy;
import strategies.OffensiveKnightStrategy;
import strategies.DefensiveWizardStrategy;
import strategies.OffensiveWizardStrategy;
import strategies.DefensiveRogueStrategy;
import strategies.OffensiveRogueStrategy;
import strategies.DefensivePyroStrategy;
import strategies.OffensivePyroStrategy;

import java.util.ArrayList;

public final class ActionCreator {
    private int vectorIterator = Constants.DEFAULT_STARTING_VALUE;

    public int getVectorIterator() {
        return vectorIterator;
    }

    public void setVectorIterator(final int vectorIterator) {
        this.vectorIterator = vectorIterator;
    }

    private static ActionCreator actionCreator = null;

    private ActionCreator() {
    }

    public static ActionCreator getInstance() {
        if (actionCreator == null) {
            actionCreator = new ActionCreator();
        }
        return actionCreator;
    }

    // Update the ground after the player moves
    public void groundSetter(final ArrayList<String> ground, final Human player) {
        if (ground.get(player.getCurrentAbscissa())
                .charAt(player.getCurrentOrdinate()) == 'L') {
            player.setCurrentGround(Constants.ZERO_TYPE_GROUND);
        } else if (ground.get(player.getCurrentAbscissa())
                .charAt(player.getCurrentOrdinate()) == 'V') {
            player.setCurrentGround(Constants.ONE_TYPE_GROUND);
        } else if (ground.get(player.getCurrentAbscissa())
                .charAt(player.getCurrentOrdinate()) == 'D') {
            player.setCurrentGround(Constants.TWO_TYPE_GROUND);
        } else if (ground.get(player.getCurrentAbscissa())
                .charAt(player.getCurrentOrdinate()) == 'W') {
            player.setCurrentGround(Constants.THREE_TYPE_GROUND);
        }
    }

    public void xpGiver(final Human player2, final Human player1, final InputLoader inputLoader) {
        // Update xp.
        player2.setXp(player2.getXp() + Math.max(0,
                Constants.XP_FORMULA_FACTOR - (player2.getLevel()
                        - player1.getLevel()) * Constants.XP_FORMULA_MULTIPLICATION));

        // Continue update his health and level, if the XP is bigger than
        // his level
        while (player2.getXp() >= Constants.LVL_UP_FACTOR
                + player2.getLevel() * Constants.LVL_UP_MULTIPLICATION) {
            // Calculate the level of the player.
            int lifeIncrease = 0;
            if (player2.getPlayerType() == Constants.ZERO_TYPE_GROUND) {
                lifeIncrease = Constants.PYRO_INCREASE;
            } else if (player2.getPlayerType() == Constants.ONE_TYPE_GROUND) {
                lifeIncrease = Constants.KNIGHT_INCREASE;
            } else if (player2.getPlayerType() == Constants.TWO_TYPE_GROUND) {
                lifeIncrease = Constants.WIZARD_INCREASE;
            } else {
                lifeIncrease = Constants.ROGUE_INCREASE;
            }

            // Update the stats.
            player2.setLevel(player2.getLevel() + 1);
            player2.setMaxHp(player2.getMaxHp() + lifeIncrease);
            player2.setHp(player2.getMaxHp());

            // Display a message if the level of the player increases
            if (!player2.isDead()) {
                inputLoader.displayLvlEvolution(player2);
            }
        }
    }

    // Function to select if the players will adopt an "Offensive"
    // Approach or a "Defensive" one, depending on his health
    public void chooseStrategy(final Human human, final InputLoader inputLoader) {
        if (human.getPlayerType() == Constants.PLAYER_TYPE_ZERO) {
            if (human.getHp() > (human.getMaxHp() / Constants.PYRO_LOW_LIMIT_DIV)
                    && human.getHp() < (human.getMaxHp() / Constants.PYRO_HIGH_LIMIT_DIV)) {
                human.playThisStrategy(new OffensivePyroStrategy(), human, inputLoader);
            } else if (human.getHp() < (human.getMaxHp() / Constants.PYRO_LOW_LIMIT_DIV)) {
                human.playThisStrategy(new DefensivePyroStrategy(), human, inputLoader);
            }
        } else if (human.getPlayerType() == Constants.PLAYER_TYPE_ONE) {
            if (human.getHp() > (human.getMaxHp() / Constants.KNIGHT_LOW_LIMIT_DIV)
                    && human.getHp() < (human.getMaxHp() / Constants.KNIGHT_HIGH_LIMIT_DIV)) {
                human.playThisStrategy(new OffensiveKnightStrategy(), human, inputLoader);
            } else if (human.getHp() < (human.getMaxHp() / Constants.KNIGHT_LOW_LIMIT_DIV)) {
                human.playThisStrategy(new DefensiveKnightStrategy(), human, inputLoader);
            }
        } else if (human.getPlayerType() == Constants.PLAYER_TYPE_TWO) {
            if (human.getHp() > (human.getMaxHp() / Constants.WIZARD_LOW_LIMIT_DIV)
                    && human.getHp() < (human.getMaxHp() / Constants.WIZARD_HIGH_LIMIT_DIV)) {
                human.playThisStrategy(new OffensiveWizardStrategy(), human, inputLoader);
            } else if (human.getHp() < (human.getMaxHp() / Constants.WIZARD_LOW_LIMIT_DIV)) {
                human.playThisStrategy(new DefensiveWizardStrategy(), human, inputLoader);
            }
        } else if (human.getPlayerType() == Constants.PLAYER_TYPE_THREE) {
            if (human.getHp() > (human.getMaxHp() / Constants.ROGUE_LOW_LIMIT_DIV)
                    && human.getHp() < (human.getMaxHp() / Constants.ROGUE_HIGH_LIMIT_DIV)) {
                human.playThisStrategy(new OffensiveRogueStrategy(), human, inputLoader);
            } else if (human.getHp() < (human.getMaxHp() / Constants.ROGUE_LOW_LIMIT_DIV)) {
                human.playThisStrategy(new DefensiveRogueStrategy(), human, inputLoader);
            }
        }
    }

    public ArrayList<Human> battle(final int n, final int m, final ArrayList<Human> players,
                                   final InputLoader inputLoader, final ArrayList<Angel> angels) {
        // Take every pair of players
        for (int k = 0; k < m - 1; ++k) {
            Human player1 = players.get(k);

            // If a player is brought back to life by
            // A Spawner, he will have the XP specific
            // To the beginning of the round
            player1.setPlayerStartRoundXp(player1.getXp());

            for (int l = k + 1; l < m; ++l) {
                Human player2 = players.get(l);

                player2.setPlayerStartRoundXp(player2.getXp());

                // Check if they are in the same position.
                if (player1.getCurrentAbscissa() == player2.getCurrentAbscissa()
                        && player1.getCurrentOrdinate() == player2.getCurrentOrdinate()) {

                    // Check for them not to be dead.
                    if (!player1.isDead() && !player2.isDead()) {

                        // Make sure that the wizard strikes second.
                        if (player1.getPlayerType() != 2 && player2.getPlayerType() == 2) {

                            // Fight
                            player1.accept(player2);
                            player2.accept(player1);

                            // Declare the death of the player
                            if (player2.isDead()) {
                                inputLoader.declareDeath(player1, player2);
                            }

                            // Declare the death of the player
                            if (player1.isDead()) {
                                inputLoader.declareDeath(player2, player1);
                            }

                            // The XP is given if both players
                            //  ARE NOT dead
                            if (player2.isDead() && !player1.isDead()) {
                                xpGiver(player1, player2, inputLoader);
                            }

                            // The XP is given if both players
                            //  ARE NOT dead
                            if (player1.isDead() && !player2.isDead()) {
                                xpGiver(player2, player1, inputLoader);
                            }
                        } else {

                            // Fight
                            player2.accept(player1);
                            player1.accept(player2);

                            // Declare the death of the player
                            if (player2.isDead()) {
                                inputLoader.declareDeath(player1, player2);
                            }

                            // Declare the death of the player
                            if (player1.isDead()) {
                                inputLoader.declareDeath(player2, player1);
                            }

                            // The XP is given if both players
                            //  ARE NOT dead
                            if (player2.isDead() && !player1.isDead()) {
                                xpGiver(player1, player2, inputLoader);
                            }

                            // The XP is given if both players
                            //  ARE NOT dead
                            if (player1.isDead() && !player2.isDead()) {
                                xpGiver(player2, player1, inputLoader);
                            }
                        }
                    }
                }
            }
        }

        return players;
    }

    public ArrayList<Human> checkForMovement(final int m, final ArrayList<Human> players,
                                  final ArrayList<String> ground, final int i,
                                  final Input input) {
        // Take every player and check if
        // They move and if they can move.
        for (int j = 0; j < m; ++j) {

            Human player = players.get(j);

            // If a player takes a certain direction, update
            // The coordinates fields
            if (input.getMoves().get(i).charAt(j) == 'R'
                    && !player.isImmobility() && !player.isParalysed()) {

                player.setCurrentOrdinate(players.get(j).getCurrentOrdinate() + 1);

                // Make sure the ground is set ONLY if the player stays on the map
                // Same for the rest of the cases
                if (player.getCurrentAbscissa() >= 0 && player.getCurrentOrdinate() >= 0) {
                    groundSetter(ground, player);
                }

            } else if (input.getMoves().get(i).charAt(j) == 'L'

                    && !player.isImmobility() && !player.isParalysed()) {
                player.setCurrentOrdinate(players.get(j).getCurrentOrdinate() - 1);

                if (player.getCurrentAbscissa() >= 0 && player.getCurrentOrdinate() >= 0) {
                    groundSetter(ground, player);
                }

            } else if (input.getMoves().get(i).charAt(j) == 'U'
                    && !player.isImmobility() && !player.isParalysed()) {

                player.setCurrentAbscissa(players.get(j).getCurrentAbscissa() - 1);

                if (player.getCurrentAbscissa() >= 0 && player.getCurrentOrdinate() >= 0) {
                    groundSetter(ground, player);
                }

            } else if (input.getMoves().get(i).charAt(j) == 'D'
                    && !player.isImmobility() && !player.isParalysed()) {

                player.setCurrentAbscissa(players.get(j).getCurrentAbscissa() + 1);

                if (player.getCurrentAbscissa() >= 0 && player.getCurrentOrdinate() >= 0) {
                    groundSetter(ground, player);
                }

            } else if (input.getMoves().get(i).charAt(j) == '_'
                    && !player.isImmobility() && !player.isParalysed()) {

                if (player.getCurrentAbscissa() >= 0 && player.getCurrentOrdinate() >= 0) {
                    groundSetter(ground, player);
                }
            }
        }
        return players;
    }

    public ArrayList<Angel> angelsVectorCreator(final Input input, final int i,
                                                final InputLoader inputLoader) {
        ArrayList<Angel> angels = new ArrayList<>();
        AngelsFactory angelsFactory = AngelsFactory.getInstance();

        // Get all the strings with the type of angel and coordinates
        for (int j = 0; j < input.getNumberAngelsRound().get(i); ++j) {
            String str = input.getAngelTypes().get(getVectorIterator());

            // If the input is of this form: LevelUpAngel,9,13
            if (str.charAt(str.length() - 2) != ',') {

                // Type
                String angelType = str.substring(0, str.length() - Constants.ANGEL_TYPE_FACTOR);

                // First coordinate
                Integer firstNumber = Character.getNumericValue(str.charAt(str.length()
                        - Constants.FIRST_NUMBER_FACTOR));

                // Second coordinate
                Integer secondNumber = Character.getNumericValue(str.charAt(str.length() - 2));
                secondNumber = secondNumber * Constants.DOUBLE_DIGIT_MULT
                        + Character.getNumericValue(str.charAt(str.length() - 1));

                // The instance of the angel
                Angel angel = angelsFactory.getAngel(angelType,
                        firstNumber, secondNumber, inputLoader);
                angels.add(angel);

                // Used to iterate through the input String ArrayList
                setVectorIterator(getVectorIterator() + 1);

                // If the input is of this form: LevelUpAngel19,3
                // See the first if for more explanations of the
                // Instructions
            } else if (str.charAt(str.length() - Constants.SECOND_CASE_INPUT_NR) != ',') {
                String angelType = str.substring(0, str.length() - Constants.ANGEL_TYPE_FACTOR);
                Integer firstNumber = Character.getNumericValue(str.charAt(str.length()
                        - Constants.FIRST_NUMBER_FACTOR));
                firstNumber = firstNumber * Constants.DOUBLE_DIGIT_MULT
                        + Character.getNumericValue(str.charAt(str.length() - Constants.FN_FACTOR));
                Integer secondNumber = Character.getNumericValue(str.charAt(str.length() - 1));

                Angel angel = angelsFactory.getAngel(angelType,
                        firstNumber, secondNumber, inputLoader);
                angels.add(angel);
                setVectorIterator(getVectorIterator() + 1);

                // If the input is of this form: LevelUpAngel
            } else {
                // Angel type
                String angelType = str.substring(0, str.length() - Constants.ANG_TYPE_FACTOR);

                // Coordinates
                Integer firstCoordinate = Character.getNumericValue(str.charAt(str.length()
                        - Constants.INPUT_FIRST_NR_CASE));
                Integer secondCoordinate = Character.getNumericValue(str.charAt(str.length()
                        - Constants.INPUT_SECOND_NR_CASE));

                // Instance of an angel
                Angel angel = angelsFactory.getAngel(angelType,
                        firstCoordinate, secondCoordinate, inputLoader);
                angels.add(angel);
                setVectorIterator(getVectorIterator() + 1);
            }

        }
        return angels;
    }

    public void angelsEffect(final ArrayList<Angel> angels, final InputLoader inputLoader,
                             final ArrayList<Human> players) {

        // Take every angel
        for (int r = 0; r < angels.size(); ++r) {
            Angel angel = angels.get(r);

            // Display a message only once if a player
            // Appeared on the map
            if (!angel.isSpawnMessageDisplay()) {
                inputLoader.displayAngel(angel);
                angel.setSpawnMessageDisplay(true);
            }

            // Take every player
            for (int v = 0; v < players.size(); ++v) {
                Human human = players.get(v);
                if (angel.getMyAbscissa() == human.getCurrentAbscissa()
                        && angel.getMyOrdinate() == human.getCurrentOrdinate()) {

                    // An angel will affect a player if it is in the same
                    // Position as the player
                    human.acceptAngel(angel, inputLoader);
                }
            }
        }

        // Reset the killed by Doomer flag in case the player
        // Is killed by Doomer then brought back to life
        for (int a = 0; a < players.size(); ++a) {
            Human player = players.get(a);
            if (!player.isDead()) {
                player.setKilledByDoomer(false);
            }
        }
    }

    public ArrayList<Human> createMoves(final int n, final int m, final Input input,
                                        final ArrayList<Human> players,
                                        final ArrayList<String> ground,
                                        final InputLoader inputLoader) {

        // To trick the "final argument" checkstyle error
        ArrayList<Human> playersCopy = new ArrayList<>();
        for (int j = 0; j < players.size(); ++j) {
            Human h = players.get(j);
            playersCopy.add(h);
        }

        // Take every round at a time
        for (int i = 0; i < n; ++i) {

            // Display round
            inputLoader.displayRound(i + 1);

            // Move the players to the specified location in this round
            playersCopy = checkForMovement(m, players, ground, i, input);

            // If a player is paralysed or immobilised he
            // Won't play any strategy
            for (int j = 0; j < players.size(); ++j) {
                Human h = players.get(j);
                h.setParalBeforeOvertimeDmg(h.isParalysed());
                h.setImobBeforeOvertimeDmg(h.isImmobility());
            }

            // Take into consideration their overtime affections.
            for (int a = 0; a < m; ++a) {
                Human player = players.get(a);
                player.checkOverTimeAbility();
            }

            // Create an array with the angels of this round
            ArrayList<Angel> angels = angelsVectorCreator(input, i, inputLoader);

            // Choose player strategy
            for (int j = 0; j < players.size(); ++j) {
                Human human = players.get(j);
                if (!human.isImobBeforeOvertimeDmg() && !human.isParalBeforeOvertimeDmg()) {
                    chooseStrategy(human, inputLoader);
                }
            }

            // Players fight if they are in the same location
            playersCopy = battle(n, m, players, inputLoader, angels);

            // Check if the players take any effect from the angels
            angelsEffect(angels, inputLoader, playersCopy);

            inputLoader.createSpace();
        }
        return playersCopy;
    }
}
