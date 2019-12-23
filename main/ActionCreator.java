package main;

import angels.Angel;
import angels.AngelsFactory;
import constants.Constants;
import players.Human;
import strategies.*;

import java.util.ArrayList;

public final class ActionCreator {
    private int vectorIterator = Constants.DEFAULT_STARTING_VALUE;

    public static ActionCreator getActionCreator() {
        return actionCreator;
    }

    public static void setActionCreator(ActionCreator actionCreator) {
        ActionCreator.actionCreator = actionCreator;
    }

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
        inputLoader.declareDeath(player2, player1);
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
            inputLoader.displayLvlEvolution(player2);
            player2.setMaxHp(player2.getMaxHp() + lifeIncrease);
            player2.setHp(player2.getMaxHp());
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

            player1.setImobBeforeOvertimeDmg(player1.isImmobility());
            player1.setParalBeforeOvertimeDmg(player1.isParalysed());

            for (int l = k + 1; l < m; ++l) {
                Human player2 = players.get(l);

                player2.setImobBeforeOvertimeDmg(player2.isImmobility());
                player2.setParalBeforeOvertimeDmg(player2.isParalysed());

                // !!!!
                System.out.println("player xp before overtime dmg " + player1.getPlayerNumber() + " " + player1.getXp());
                System.out.println("player xp before overtime dmg " + player2.getPlayerNumber() + " " + player2.getXp());
                for (int a = 0; a < players.size(); ++a) {
                    Human h = players.get(a);
                    System.out.println("Hp of " + h.getPlayerNumber() + " before overtime dmg: " + h.getHp());
                }
                // !!!!
                // !!!
                // !!!!
                // Take into consideration their overtime affections.
                for (int a = 0; a < m; ++a) {
                    Human player = players.get(a);
                    player.checkOverTimeAbility();
                }
                // !!!!
                // !!!
                // !!!
                // !!!!
                System.out.println("player xp after overtime dmg " + player1.getPlayerNumber() + " " + player1.getXp());
                System.out.println("player xp after overtime dmg " + player2.getPlayerNumber() + " " + player2.getXp());
                for (int a = 0; a < players.size(); ++a) {
                    Human h = players.get(a);
                    System.out.println("Hp of " + h.getPlayerNumber() + " after overtime dmg: " + h.getHp());
                }
                // !!!!
                // !!!
                // Check if their are in the same position.
                if (player1.getCurrentAbscissa() == player2.getCurrentAbscissa()
                        && player1.getCurrentOrdinate() == player2.getCurrentOrdinate()) {
                    // Check for them not to be dead.
                    if (!player1.isDead() && !player2.isDead()) {
                        System.out.println("player xp before strategy " + player1.getPlayerNumber() + " " + player1.getXp());
                        System.out.println("player xp before strategy " + player2.getPlayerNumber() + " " + player2.getXp());
                        System.out.println("player " + player1.getPlayerNumber() + " before strategy " + player1.getHp());
                        System.out.println("player " + player2.getPlayerNumber() + " before strategy " + player2.getHp());
                        System.out.println("mod 1 of "+ player1.getPlayerNumber() + " before strategy " + player1.getKnightFbMod());
                        System.out.println("mod 2 of "+ player1.getPlayerNumber() + " before strategy " + player1.getKnightIgniteMod());
                        System.out.println("mod 1 of "+ player2.getPlayerNumber() + " before strategy " + player2.getPyroExecuteMod());
                        System.out.println("mod 2 of "+ player2.getPlayerNumber() + " before strategy " + player2.getPyroSlamMod());

                        if (!player1.isImobBeforeOvertimeDmg() && !player1.isParalBeforeOvertimeDmg()) {
                            chooseStrategy(player1, inputLoader);
                        }

                        if (!player2.isImobBeforeOvertimeDmg() && !player2.isParalBeforeOvertimeDmg()) {
                            chooseStrategy(player2, inputLoader);
                        }

                        System.out.println("player xp after strategy " + player1.getPlayerNumber() + " " + player1.getXp());
                        System.out.println("player xp after strategy " + player2.getPlayerNumber() + " " + player2.getXp());
                        System.out.println("mod 1 of "+ player1.getPlayerNumber() + " after strategy " + player1.getKnightFbMod());
                        System.out.println("mod 2 of "+ player1.getPlayerNumber() + " after strategy " + player1.getKnightIgniteMod());
                        System.out.println("mod 1 of "+ player2.getPlayerNumber() + " after strategy " + player2.getPyroExecuteMod());
                        System.out.println("mod 2 of "+ player2.getPlayerNumber() + " after strategy " + player2.getPyroSlamMod());
                        System.out.println("player " + player1.getPlayerNumber() + " after strategy " + player1.getHp());
                        System.out.println("player " + player2.getPlayerNumber() + " after strategy " + player2.getHp());
                        // !!!!!!
                        System.out.println("player xp before battle " + player1.getPlayerNumber() + " " + player1.getXp());
                        System.out.println("player xp before battle " + player2.getPlayerNumber() + " " + player2.getXp());
                        System.out.println("player " + player1.getPlayerNumber() + " before battle " + player1.getHp());
                        System.out.println("player " + player2.getPlayerNumber() + " before battle " + player2.getHp());
                        // !!!!
                        // Make sure that wizard strikes second.
                        if (player1.getPlayerType() != 2 && player2.getPlayerType() == 2) {
                            player1.accept(player2, inputLoader);
                            player2.accept(player1, inputLoader);
                            System.out.println("player xp after battle " + player1.getPlayerNumber() + " " + player1.getXp());
                            System.out.println("player xp after battle " + player2.getPlayerNumber() + " " + player2.getXp());
                            System.out.println("player after battle " + player1.getPlayerNumber() + " " + player1.getHp());
                            System.out.println("player after battle" + player2.getPlayerNumber() + " " + player2.getHp());

                            if (player2.isDead()) {
                                xpGiver(player1, player2, inputLoader);
                            }

                            if (player1.isDead()) {
                                xpGiver(player2, player1, inputLoader);
                            }
                        } else {
                            player2.accept(player1, inputLoader);
                            player1.accept(player2, inputLoader);
                            System.out.println("player xp after battle " + player1.getPlayerNumber() + " " + player1.getXp());
                            System.out.println("player xp after battle " + player2.getPlayerNumber() + " " + player2.getXp());
                            System.out.println("player after battle " + player1.getPlayerNumber() + " " + player1.getHp());
                            System.out.println("player after battle" + player2.getPlayerNumber() + " " + player2.getHp());

                            if (player2.isDead()) {
                                xpGiver(player1, player2, inputLoader);
                            }

                            if (player1.isDead()) {
                                xpGiver(player2, player1, inputLoader);
                            }
                        }
                        System.out.println("player xp before angels " + player1.getPlayerNumber() + " " + player1.getXp());
                        System.out.println("player xp before angels " + player2.getPlayerNumber() + " " + player2.getXp());
                        System.out.println("player before angels " + player1.getPlayerNumber() + " " + player1.getHp());
                        System.out.println("player before angels " + player2.getPlayerNumber() + " " + player2.getHp());
                        System.out.println("mod 1 of "+ player1.getPlayerNumber() + " before angels " + player1.getKnightFbMod());
                        System.out.println("mod 2 of "+ player1.getPlayerNumber() + " before angels " + player1.getKnightIgniteMod());
                        System.out.println("mod 1 of "+ player2.getPlayerNumber() + " before angels " + player2.getPyroExecuteMod());
                        System.out.println("mod 2 of "+ player2.getPlayerNumber() + " before angels " + player2.getPyroSlamMod());
                        for (int r = 0; r < angels.size(); ++r) {
                            Angel angel = angels.get(r);
                            inputLoader.displayAngel(angel);
                            for (int v = 0; v < players.size(); ++v) {
                                Human human = players.get(v);
                                if (angel.getMyAbscissa() == human.getCurrentAbscissa()
                                        && angel.getMyOrdinate() == human.getCurrentOrdinate()) {
                                    human.acceptAngel(angel, inputLoader);
                                }
                            }
                        }
                        System.out.println("player xp after angels " + player1.getPlayerNumber() + " " + player1.getXp());
                        System.out.println("player xp after angels " + player2.getPlayerNumber() + " " + player2.getXp());
                        System.out.println("player after angels " + player1.getPlayerNumber() + " " + player1.getHp());
                        System.out.println("player after angels " + player2.getPlayerNumber() + " " + player2.getHp());
                        System.out.println("mod 1 of "+ player1.getPlayerNumber() + " after angels " + player1.getKnightFbMod());
                        System.out.println("mod 2 of "+ player1.getPlayerNumber() + " after angels " + player1.getKnightIgniteMod());
                        System.out.println("mod 1 of "+ player2.getPlayerNumber() + " after angels " + player2.getPyroExecuteMod());
                        System.out.println("mod 2 of "+ player2.getPlayerNumber() + " after angels " + player2.getPyroSlamMod());
                    } else {
                        System.out.println("player xp before angels " + player1.getPlayerNumber() + " " + player1.getXp());
                        System.out.println("player xp before angels " + player2.getPlayerNumber() + " " + player2.getXp());
                        System.out.println("player before angels " + player1.getPlayerNumber() + " " + player1.getHp());
                        System.out.println("player before angels " + player2.getPlayerNumber() + " " + player2.getHp());
                        System.out.println("mod 1 of "+ player1.getPlayerNumber() + " before angels " + player1.getKnightFbMod());
                        System.out.println("mod 2 of "+ player1.getPlayerNumber() + " before angels " + player1.getKnightIgniteMod());
                        System.out.println("mod 1 of "+ player2.getPlayerNumber() + " before angels " + player2.getPyroExecuteMod());
                        System.out.println("mod 2 of "+ player2.getPlayerNumber() + " before angels " + player2.getPyroSlamMod());
                        for (int r = 0; r < angels.size(); ++r) {
                            Angel angel = angels.get(r);
                            inputLoader.displayAngel(angel);
                            for (int v = 0; v < players.size(); ++v) {
                                Human human = players.get(v);
                                if (angel.getMyAbscissa() == human.getCurrentAbscissa()
                                        && angel.getMyOrdinate() == human.getCurrentOrdinate()) {
                                    human.acceptAngel(angel, inputLoader);
                                }
                            }
                        }
                        System.out.println("player xp after angels " + player1.getPlayerNumber() + " " + player1.getXp());
                        System.out.println("player xp after angels " + player2.getPlayerNumber() + " " + player2.getXp());
                        System.out.println("player after angels " + player1.getPlayerNumber() + " " + player1.getHp());
                        System.out.println("player after angels " + player2.getPlayerNumber() + " " + player2.getHp());
                        System.out.println("mod 1 of "+ player1.getPlayerNumber() + " after angels " + player1.getKnightFbMod());
                        System.out.println("mod 2 of "+ player1.getPlayerNumber() + " after angels " + player1.getKnightIgniteMod());
                        System.out.println("mod 1 of "+ player2.getPlayerNumber() + " after angels " + player2.getPyroExecuteMod());
                        System.out.println("mod 2 of "+ player2.getPlayerNumber() + " after angels " + player2.getPyroSlamMod());
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
                groundSetter(ground, player);
            } else if (input.getMoves().get(i).charAt(j) == 'L'
                    && !player.isImmobility() && !player.isParalysed()) {
                player.setCurrentOrdinate(players.get(j).getCurrentOrdinate() - 1);
                groundSetter(ground, player);
            } else if (input.getMoves().get(i).charAt(j) == 'U'
                    && !player.isImmobility() && !player.isParalysed()) {
                player.setCurrentAbscissa(players.get(j).getCurrentAbscissa() - 1);
                groundSetter(ground, player);
            } else if (input.getMoves().get(i).charAt(j) == 'D'
                    && !player.isImmobility() && !player.isParalysed()) {
                player.setCurrentAbscissa(players.get(j).getCurrentAbscissa() + 1);
                groundSetter(ground, player);
            } else if (input.getMoves().get(i).charAt(j) == '_'
                    && !player.isImmobility() && !player.isParalysed()) {
                groundSetter(ground, player);
            }
        }
        return players;
    }

    public ArrayList<Angel> angelsVectorCreator(final Input input, final int i,
                                                int vectorIterator, final InputLoader inputLoader) {
        ArrayList<Angel> angels = new ArrayList<>();
        AngelsFactory angelsFactory = new AngelsFactory();
        for (int j = 0; j < input.getNumberAngelsRound().get(i); ++j) {
            String string = input.getAngelTypes().get(getVectorIterator());
            String angelType = string.substring(0, string.length() - 4);
            Integer firstCoordinate = Character.getNumericValue(string.charAt(string.length() - 3));
            Integer secondCoordinate = Character.getNumericValue(string.charAt(string.length() - 1));
            Angel angel = angelsFactory.getAngel(angelType, firstCoordinate, secondCoordinate);
            angels.add(angel);
            setVectorIterator(getVectorIterator() + 1);
        }
        return angels;
    }

    public ArrayList<Human> createMoves(final int n, final int m, final Input input,
                                        ArrayList<Human> players, final ArrayList<String> ground,
                                        final InputLoader inputLoader) {
        for (int i = 0; i < n; ++i) {
            inputLoader.displayRound(i + 1);
            players = checkForMovement(m, players, ground, i, input);

            ArrayList<Angel> angels = angelsVectorCreator(input, i, vectorIterator, inputLoader);

            players = battle(n, m, players, inputLoader, angels);

            inputLoader.createSpace();
        }
        return players;
    }
}
