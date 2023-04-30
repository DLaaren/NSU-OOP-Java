package ru.nsu.fit.vinter.tetris.core.model.shapes;

import ru.nsu.fit.vinter.tetris.core.model.Point;
import ru.nsu.fit.vinter.tetris.core.model.Tetromino;

public class ShapeL extends Tetromino {
    public ShapeL() {
        super();
        setA(new Point(4,0));
        setB(new Point(4,1));
        setC(new Point(4,2));
        setD(new Point(5,2));
        setName("L");
        setForm(0);
    }
}
