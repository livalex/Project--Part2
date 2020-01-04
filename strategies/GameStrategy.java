package strategies;

import main.InputLoader;
import players.Human;

public interface GameStrategy {
    void play(Human human, InputLoader inputLoader);
}
