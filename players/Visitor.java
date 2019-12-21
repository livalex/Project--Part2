package players;

import main.InputLoader;

interface Visitor {
    void fight(Pyromancer pyromancer, InputLoader inputLoader);
    void fight(Rogue rogue, InputLoader inputLoader);
    void fight(Knight knight, InputLoader inputLoader);
    void fight(Wizard wizard, InputLoader inputLoader);
}
