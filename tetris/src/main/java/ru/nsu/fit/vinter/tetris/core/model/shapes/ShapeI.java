package ru.nsu.fit.vinter.tetris.core.model.shapes;

import ru.nsu.fit.vinter.tetris.core.model.Point;
import ru.nsu.fit.vinter.tetris.core.model.Tetromino;

public class ShapeI extends Tetromino {
    public ShapeI() {
        super();
        setA(new Point(3,0));
        setB(new Point(4,0));
        setC(new Point(5,0));
        setD(new Point(6,0));
        setName("I");
        setForm(0);
    }
}
