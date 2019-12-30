package angels;

import main.InputLoader;

public interface VisitedByAngel {
    void acceptAngel(AngelVisitor angelVisitor, InputLoader inputLoader);
}
