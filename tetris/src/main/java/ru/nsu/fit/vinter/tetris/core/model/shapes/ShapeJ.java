package ru.nsu.fit.vinter.tetris.core.model.shapes;

import ru.nsu.fit.vinter.tetris.core.model.Point;
import ru.nsu.fit.vinter.tetris.core.model.Tetromino;

public class ShapeJ extends Tetromino {
    public ShapeJ() {
        super();
        setA(new Point(4,2));
        setB(new Point(5,2));
        setC(new Point(5,1));
        setD(new Point(5,0));
        setName("J");
        setForm(0);
    }
}
