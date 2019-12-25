package players;

import main.InputLoader;

interface Visitor {
    void fight(Pyromancer pyromancer);
    void fight(Rogue rogue);
    void fight(Knight knight);
    void fight(Wizard wizard);
}
