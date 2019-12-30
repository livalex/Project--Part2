package admin;

import players.Human;

import java.util.ArrayList;

public final class GreatMagician implements Observer {

    private static GreatMagician greatMagician = null;

    private ArrayList<Integer> angelAbs = new ArrayList<>();
    private ArrayList<Integer> angelOrd = new ArrayList<>();
    private ArrayList<Human> helpedPlayers = new ArrayList<>();
    private ArrayList<Human> hitPlayers = new ArrayList<>();
    private ArrayList<Human> killedPlayers = new ArrayList<>();
    private ArrayList<Human> reanimatedPlayers = new ArrayList<>();

    private GreatMagician() {
    }

    public static GreatMagician getInstance() {
        if (greatMagician == null) {
            greatMagician = new GreatMagician();
        }
        return greatMagician;
    }

    // Methods to notify the Magician about he events

    // Attach the abscissa of the new angel
    @Override
    public void attachAbs(final int x) {
        angelAbs.add(x);
    }

    // Attach the ordinate of the new player
    @Override
    public void attachOrd(final int y) {
        angelOrd.add(y);
    }

    // Notify if a player is helped by an angel
    @Override
    public void attachHelpedPlayers(final Human human) {
        helpedPlayers.add(human);
    }

    // Notify if a player is hit by an angel
    @Override
    public void attachHitPlayers(final Human human) {
        hitPlayers.add(human);
    }

    // Notify if a player is killed by an angel
    @Override
    public void attachKilledPlayers(final Human human) {
        killedPlayers.add(human);
    }

    // Notify if a player is brought back to life by an angel (Spawner)
    @Override
    public void attachReanimatedPlayers(final Human human) {
        reanimatedPlayers.add(human);
    }

}
