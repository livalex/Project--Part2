package strategies;

import main.InputLoader;
import players.Human;

public interface GameStrategy {
    void play(final Human human, InputLoader inputLoader);
}
