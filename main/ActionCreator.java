package main;

import angels.Angel;
import angels.AngelsFactory;
import constants.Constants;
import players.Human;
import strategies.*;

import java.util.ArrayList;

public final class ActionCreator {
    private int vectorIterator = Constants.DEFAULT_STARTING_VALUE;

    public int getVectorIterator() {
        return vectorIterator;
    }

    public void setVectorIterator(int vectorIterator) {
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

    public void xpGiver(final Human player2, final Human player1, InputLoader inputLoader) {
        // Update xp.
        player2.setXp(player2.getXp() + Math.max(0,
                Constants.XP_FORMULA_FACTOR - (player2.getLevel()
                        - player1.getLevel()) * Constants.XP_FORMULA_MULTIPLICATION));

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

            if (!player2.isDead()) {
                inputLoader.displayLvlEvolution(player2);
            }
        }
    }

    public void chooseStrategy(Human human, InputLoader inputLoader) {
        if (human.getPlayerType() == 0) {
            if (human.getHp() > (human.getMaxHp() / 4) && human.getHp() < (human.getMaxHp() / 3)) {
                human.playThisStrategy(new OffensivePyroStrategy(), human, inputLoader);
            } else if (human.getHp() < (human.getMaxHp() / 4)) {
                human.playThisStrategy(new DefensivePyroStrategy(), human, inputLoader);
            }
        } else if (human.getPlayerType() == 1) {
            if (human.getHp() > (human.getMaxHp() / 3) && human.getHp() < (human.getMaxHp() / 2)) {
                human.playThisStrategy(new OffensiveKnightStrategy(), human, inputLoader);
            } else if (human.getHp() < (human.getMaxHp() / 3)) {
                human.playThisStrategy(new DefensiveKnightStrategy(), human, inputLoader);
            }
        } else if (human.getPlayerType() == 2) {
            if (human.getHp() > (human.getMaxHp() / 4) && human.getHp() < (human.getMaxHp() / 2)) {
                human.playThisStrategy(new OffensiveWizardStrategy(), human, inputLoader);
            } else if (human.getHp() < (human.getMaxHp() / 4)) {
                human.playThisStrategy(new DefensiveWizardStrategy(), human, inputLoader);
            }
        } else if (human.getPlayerType() == 3) {
            if (human.getHp() > (human.getMaxHp() / 7) && human.getHp() < (human.getMaxHp() / 5)) {
                human.playThisStrategy(new OffensiveRogueStrategy(), human, inputLoader);
            } else if (human.getHp() < (human.getMaxHp() / 7)) {
                human.playThisStrategy(new DefensiveRogueStrategy(), human, inputLoader);
            }
        }
    }

    public ArrayList<Human> battle(final int n, final int m, ArrayList<Human> players,
                                   final InputLoader inputLoader, ArrayList<Angel> angels) {
        for (int k = 0; k < m - 1; ++k) {
            Human player1 = players.get(k);

            player1.setPlayerStartRoundXp(player1.getXp());

            for (int l = k + 1; l < m; ++l) {
                Human player2 = players.get(l);

                player2.setPlayerStartRoundXp(player2.getXp());

                // Check if their are in the same position.
                if (player1.getCurrentAbscissa() == player2.getCurrentAbscissa()
                        && player1.getCurrentOrdinate() == player2.getCurrentOrdinate()) {
                    // Check for them not to be dead.
                    if (!player1.isDead() && !player2.isDead()) {

                        // Make sure that wizard strikes second.
                        if (player1.getPlayerType() != 2 && player2.getPlayerType() == 2) {
                            player1.accept(player2);
                            player2.accept(player1);

                            if (player2.isDead()) {
                                inputLoader.declareDeath(player1, player2);
                            }

                            if (player1.isDead()) {
                                inputLoader.declareDeath(player2, player1);
                            }

                            if (player2.isDead() && !player1.isDead()) {
                                xpGiver(player1, player2, inputLoader);
                            }

                            if (player1.isDead() && !player2.isDead()) {
                                xpGiver(player2, player1, inputLoader);
                            }
                        } else {
                            player2.accept(player1);
                            player1.accept(player2);

                            if (player2.isDead()) {
                                inputLoader.declareDeath(player1, player2);
                            }

                            if (player1.isDead()) {
                                inputLoader.declareDeath(player2, player1);
                            }

                            if (player2.isDead() && !player1.isDead()) {
                                xpGiver(player1, player2, inputLoader);
                            }

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
        for (int j = 0; j < m; ++j) {
            // Check if they move and if they can move.
            Human player = players.get(j);
            if (input.getMoves().get(i).charAt(j) == 'R'
                    && !player.isImmobility() && !player.isParalysed()) {
                player.setCurrentOrdinate(players.get(j).getCurrentOrdinate() + 1);
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
        AngelsFactory angelsFactory = new AngelsFactory();
        for (int j = 0; j < input.getNumberAngelsRound().get(i); ++j) {
            String str = input.getAngelTypes().get(getVectorIterator());

            if (str.charAt(str.length() - 2) != ',') {
                String angelType = str.substring(0, str.length() - 5);
                Integer firstNumber = Character.getNumericValue(str.charAt(str.length() - 4));
                Integer secondNumber = Character.getNumericValue(str.charAt(str.length() - 2));
                secondNumber = secondNumber * 10 + Character.getNumericValue(str.charAt(str.length() - 1));

                Angel angel = angelsFactory.getAngel(angelType, firstNumber, secondNumber, inputLoader);
                angels.add(angel);
                setVectorIterator(getVectorIterator() + 1);
            } else if (str.charAt(str.length() - 4) != ',') {
                String angelType = str.substring(0, str.length() - 5);
                Integer firstNumber = Character.getNumericValue(str.charAt(str.length() - 4));
                firstNumber = firstNumber * 10 + Character.getNumericValue(str.charAt(str.length() - 3));
                Integer secondNumber = Character.getNumericValue(str.charAt(str.length() - 1));

                Angel angel = angelsFactory.getAngel(angelType, firstNumber, secondNumber, inputLoader);
                angels.add(angel);
                setVectorIterator(getVectorIterator() + 1);
            } else {

                String angelType = str.substring(0, str.length() - 4);

                Integer firstCoordinate = Character.getNumericValue(str.charAt(str.length() - 3));
                Integer secondCoordinate = Character.getNumericValue(str.charAt(str.length() - 1));
                Angel angel = angelsFactory.getAngel(angelType, firstCoordinate, secondCoordinate, inputLoader);
                angels.add(angel);
                setVectorIterator(getVectorIterator() + 1);
            }

        }
        return angels;
    }

    public ArrayList<Human> createMoves(final int n, final int m, final Input input,
                                        ArrayList<Human> players, final ArrayList<String> ground,
                                        final InputLoader inputLoader) {
        for (int i = 0; i < n; ++i) {
            inputLoader.displayRound(i + 1);

            players = checkForMovement(m, players, ground, i, input);

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

            ArrayList<Angel> angels = angelsVectorCreator(input, i, inputLoader);

            // Choose player strategy
            for (int j = 0; j < players.size(); ++j) {
                Human human = players.get(j);
                if (!human.isImobBeforeOvertimeDmg() && !human.isParalBeforeOvertimeDmg()) {
                    chooseStrategy(human, inputLoader);
                }
            }

            players = battle(n, m, players, inputLoader, angels);

            for (int r = 0; r < angels.size(); ++r) {
                Angel angel = angels.get(r);

                if (!angel.isSpawnMessageDisplay()) {
                    inputLoader.displayAngel(angel);
                    angel.setSpawnMessageDisplay(true);
                }

                for (int v = 0; v < players.size(); ++v) {
                    Human human = players.get(v);
                    if (angel.getMyAbscissa() == human.getCurrentAbscissa()
                            && angel.getMyOrdinate() == human.getCurrentOrdinate()) {
                        human.acceptAngel(angel, inputLoader);
                    }
                }
            }

            for (int a = 0; a < m; ++a) {
                Human player = players.get(a);
                player.setKilledByDoomer(false);
                player.setKilledByDoomer(false);
            }

            inputLoader.createSpace();
        }
        return players;
    }
}
