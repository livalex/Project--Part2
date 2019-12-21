package players;

import main.InputLoader;

interface Visitable {
    void accept(Visitor visitor, InputLoader inputLoader);
}
