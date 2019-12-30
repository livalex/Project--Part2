package admin;

import players.Human;

public interface Observer {

    void attachAbs(int x);

    void attachOrd(int y);

    void attachHelpedPlayers(Human human);

    void attachHitPlayers(Human human);

    void attachKilledPlayers(Human human);

    void attachReanimatedPlayers(Human human);

}
