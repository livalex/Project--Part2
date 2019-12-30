package main;

import angels.Angel;
import constants.Constants;
import fileio.FileSystem;
import players.Human;

import java.util.ArrayList;

public final class InputLoader {
    private static InputLoader inputLoader = null;

    private final String inpPath, outPath;

    public String getInpPath() {
        return inpPath;
    }

    public String getOutPath() {
        return outPath;
    }

    public FileSystem getFileSystem() {
        return fileSystem;
    }

    public void setFileSystem(final FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    private FileSystem fileSystem;

    private InputLoader(final String inpPath, final String outPath) {
        this.inpPath = inpPath;
        this.outPath = outPath;
        try {
            fileSystem = new FileSystem(inpPath, outPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static InputLoader getInstance(final String arg1, final String arg2) {
        if (inputLoader == null) {
            inputLoader = new InputLoader(arg1, arg2);
        }
        return inputLoader;
    }

    public Input load() {
        int n = 0, m = 0, p = 0, r = 0;
        ArrayList<String> battleGround = new ArrayList<>();
        ArrayList<String> playerTypes = new ArrayList<>();
        ArrayList<Integer> firstCoordonates = new ArrayList<>();
        ArrayList<Integer> secondCoordonates = new ArrayList<>();
        ArrayList<String> moves = new ArrayList<>();
        ArrayList<Integer> numberAngelsRound = new ArrayList<>();
        ArrayList<String> angelTypes = new ArrayList<>();

        // To trick the checkstyle arguments error
        ArrayList<Integer> integersData = new ArrayList<>();

        try {
            FileSystem fileSys = new FileSystem(getInpPath(), getOutPath());

            // Map dimensions
            n = fileSys.nextInt();
            m = fileSys.nextInt();
            integersData.add(n);
            integersData.add(m);

            // Types of terrain
            for (int j = 0; j < n; ++j) {
                battleGround.add(fileSys.nextWord());
            }

            // Number of players
            p = fileSys.nextInt();
            integersData.add(p);

            // Player's race and coordinates
            for (int j = 0; j < p; ++j) {
                playerTypes.add(fileSys.nextWord());
                firstCoordonates.add(fileSys.nextInt());
                secondCoordonates.add(fileSys.nextInt());
            }

            for (int j = 0; j < firstCoordonates.size(); ++j) {
                integersData.add(firstCoordonates.get(j));
            }

            // Number of rounds
            r = fileSys.nextInt();
            integersData.add(r);

            // The movement of the players on the map
            for (int j = 0; j < r; ++j) {
                moves.add(fileSys.nextWord());
            }

            // String formed of the angel type and coordinates
            for (int j = 0; j < r; ++j) {
                numberAngelsRound.add(fileSys.nextInt());
                if (numberAngelsRound.get(j) != 0) {
                    for (int z = 0; z < numberAngelsRound.get(j); ++z) {
                        angelTypes.add(fileSys.nextWord());
                    }
                }
            }

            fileSys.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Input(battleGround, playerTypes,
                integersData, secondCoordonates, moves, numberAngelsRound, angelTypes);
    }

    // Check the first letter of the output of the player.
    public void typeDecider(final Human player) {
        try {
            if (player.getPlayerType() == Constants.PLAYER_TYPE_ZERO) {
                fileSystem.writeCharacter('P');
            } else if (player.getPlayerType() == Constants.PLAYER_TYPE_ONE) {
                fileSystem.writeCharacter('K');
            } else if (player.getPlayerType() == Constants.PLAYER_TYPE_TWO) {
                fileSystem.writeCharacter('W');
            } else if (player.getPlayerType() == Constants.PLAYER_TYPE_THREE) {
                fileSystem.writeCharacter('R');
            }
            fileSystem.writeCharacter(' ');
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Used to display in the file.
    public void exposeOutput(final ArrayList<Human> players) {
        try {
            int j, size = players.size();
            fileSystem.writeWord("~~");
            fileSystem.writeCharacter(' ');
            fileSystem.writeWord("Results");
            fileSystem.writeCharacter(' ');
            fileSystem.writeWord("~~");
            fileSystem.writeNewLine();
            for (j = 0; j < size; ++j) {
                Human player = players.get(j);
                if (player.isDead()) {
                    typeDecider(player);
                    fileSystem.writeWord("dead");
                    fileSystem.writeNewLine();
                } else {
                    typeDecider(player);
                    fileSystem.writeInt(player.getLevel());
                    fileSystem.writeCharacter(' ');
                    fileSystem.writeInt(player.getXp());
                    fileSystem.writeCharacter(' ');
                    fileSystem.writeInt(player.getHp());
                    fileSystem.writeCharacter(' ');
                    fileSystem.writeInt(player.getCurrentAbscissa());
                    fileSystem.writeCharacter(' ');
                    fileSystem.writeInt(player.getCurrentOrdinate());
                    fileSystem.writeNewLine();
                }
            }

            fileSystem.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Function used to display the angel type
    public void angelTypeDecider(final Angel angel, final FileSystem fileSys) {
        try {
            if (angel.getAngelType() == Constants.DAMAGE_ANGEL) {
                fileSys.writeWord("DamageAngel");
                fileSys.writeCharacter(' ');
            } else if (angel.getAngelType() == Constants.DARK_ANGEL) {
                fileSys.writeWord("DarkAngel");
                fileSys.writeCharacter(' ');
            }  else if (angel.getAngelType() == Constants.DRACULA_ANGEL) {
                fileSys.writeWord("Dracula");
                fileSys.writeCharacter(' ');
            } else if (angel.getAngelType() == Constants.GOOD_BOY_ANGEL) {
                fileSys.writeWord("GoodBoy");
                fileSys.writeCharacter(' ');
            } else if (angel.getAngelType() == Constants.LEVEL_UP_ANGEL) {
                fileSys.writeWord("LevelUpAngel");
                fileSys.writeCharacter(' ');
            } else if (angel.getAngelType() == Constants.LIFE_GIVER_ANGEL) {
                fileSys.writeWord("LifeGiver");
                fileSys.writeCharacter(' ');
            } else if (angel.getAngelType() == Constants.SMALL_ANGEL) {
                fileSys.writeWord("SmallAngel");
                fileSys.writeCharacter(' ');
            } else if (angel.getAngelType() == Constants.SPAWNER_ANGEL) {
                fileSys.writeWord("Spawner");
                fileSys.writeCharacter(' ');
            } else if (angel.getAngelType() == Constants.THE_DOOMER_ANGEL) {
                fileSys.writeWord("TheDoomer");
                fileSys.writeCharacter(' ');
            } else if (angel.getAngelType() == Constants.XP_ANGEL) {
                fileSys.writeWord("XPAngel");
                fileSys.writeCharacter(' ');
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Function used to signal the apparition of an angel
    public void displayAngel(final Angel angel) {
        try {
            fileSystem.writeWord("Angel");
            fileSystem.writeCharacter(' ');
            angelTypeDecider(angel, fileSystem);
            fileSystem.writeWord("was");
            fileSystem.writeCharacter(' ');
            fileSystem.writeWord("spawned");
            fileSystem.writeCharacter(' ');
            fileSystem.writeWord("at");
            fileSystem.writeCharacter(' ');
            fileSystem.writeInt(angel.getMyAbscissa());
            fileSystem.writeCharacter(' ');
            fileSystem.writeInt(angel.getMyOrdinate());
            fileSystem.writeNewLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Display current round
    public void displayRound(final int roundNumber) {
        try {
            fileSystem.writeWord("~~");
            fileSystem.writeCharacter(' ');
            fileSystem.writeWord("Round");
            fileSystem.writeCharacter(' ');
            fileSystem.writeInt(roundNumber);
            fileSystem.writeCharacter(' ');
            fileSystem.writeWord("~~");
            fileSystem.writeNewLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Function used to display the race of a player
    public void humanTypeDecider(final Human player) {
        try {
            if (player.getPlayerType() == Constants.PLAYER_TYPE_ZERO) {
                fileSystem.writeWord("Pyromancer");
            } else if (player.getPlayerType() == Constants.PLAYER_TYPE_ONE) {
                fileSystem.writeWord("Knight");
            } else if (player.getPlayerType() == Constants.PLAYER_TYPE_TWO) {
                fileSystem.writeWord("Wizard");
            } else if (player.getPlayerType() == Constants.PLAYER_TYPE_THREE) {
                fileSystem.writeWord("Rogue");
            }
            fileSystem.writeCharacter(' ');
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Display a message if a player was killed by an angel
    public void deathByAngel(final Human human) {
        try {
            fileSystem.writeWord("Player");
            fileSystem.writeCharacter(' ');
            humanTypeDecider(human);
            fileSystem.writeInt(human.getPlayerNumber());
            fileSystem.writeCharacter(' ');
            fileSystem.writeWord("was");
            fileSystem.writeCharacter(' ');
            fileSystem.writeWord("killed");
            fileSystem.writeCharacter(' ');
            fileSystem.writeWord("by");
            fileSystem.writeCharacter(' ');
            fileSystem.writeWord("an");
            fileSystem.writeCharacter(' ');
            fileSystem.writeWord("angel");
            fileSystem.writeNewLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Display a message if an angel hit a player
    public void displayBadAngel(final Angel angel, final Human human) {
        try {
            angelTypeDecider(angel, fileSystem);
            fileSystem.writeWord("hit");
            fileSystem.writeCharacter(' ');
            humanTypeDecider(human);
            fileSystem.writeInt(human.getPlayerNumber());
            fileSystem.writeNewLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Display a message if an angel helped a player
    public void displayGoodAngel(final Angel angel, final Human human) {
        try {
            angelTypeDecider(angel, fileSystem);
            fileSystem.writeWord("helped");
            fileSystem.writeCharacter(' ');
            humanTypeDecider(human);
            fileSystem.writeInt(human.getPlayerNumber());
            fileSystem.writeNewLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Display a message if an angel reached a higher level
    public void displayLvlEvolution(final Human human) {
        try {
            humanTypeDecider(human);
            fileSystem.writeInt(human.getPlayerNumber());
            fileSystem.writeCharacter(' ');
            fileSystem.writeWord("reached");
            fileSystem.writeCharacter(' ');
            fileSystem.writeWord("level");
            fileSystem.writeCharacter(' ');
            fileSystem.writeInt(human.getLevel());
            fileSystem.writeNewLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Display a message if a player was brought to life
    // By an angel
    public void bringToLife(final Human human) {
        try {
            fileSystem.writeWord("Player");
            fileSystem.writeCharacter(' ');
            humanTypeDecider(human);
            fileSystem.writeInt(human.getPlayerNumber());
            fileSystem.writeCharacter(' ');
            fileSystem.writeWord("was");
            fileSystem.writeCharacter(' ');
            fileSystem.writeWord("brought");
            fileSystem.writeCharacter(' ');
            fileSystem.writeWord("to");
            fileSystem.writeCharacter(' ');
            fileSystem.writeWord("life");
            fileSystem.writeCharacter(' ');
            fileSystem.writeWord("by");
            fileSystem.writeCharacter(' ');
            fileSystem.writeWord("an");
            fileSystem.writeCharacter(' ');
            fileSystem.writeWord("angel");
            fileSystem.writeNewLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Display a message if a player was killed by other player
    public void declareDeath(final Human human2, final Human human1) {
        try {
            fileSystem.writeWord("Player");
            fileSystem.writeCharacter(' ');
            humanTypeDecider(human1);
            fileSystem.writeInt(human1.getPlayerNumber());
            fileSystem.writeCharacter(' ');
            fileSystem.writeWord("was");
            fileSystem.writeCharacter(' ');
            fileSystem.writeWord("killed");
            fileSystem.writeCharacter(' ');
            fileSystem.writeWord("by");
            fileSystem.writeCharacter(' ');
            humanTypeDecider(human2);
            fileSystem.writeInt(human2.getPlayerNumber());
            fileSystem.writeNewLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Print space after every round
    public void createSpace() {
        try {
            fileSystem.writeNewLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
