package angels;

import main.InputLoader;
import players.Knight;
import players.Pyromancer;
import players.Rogue;
import players.Wizard;

public interface AngelVisitor {
    void angelVisit(Knight knight, InputLoader inputLoader);
    void angelVisit(Wizard wizard, InputLoader inputLoader);
    void angelVisit(Rogue rogue, InputLoader inputLoader);
    void angelVisit(Pyromancer pyromancer, InputLoader inputLoader);
}
