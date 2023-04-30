package ru.nsu.fit.vinter.tetris.core.model.shapes;

import ru.nsu.fit.vinter.tetris.core.model.Point;
import ru.nsu.fit.vinter.tetris.core.model.Tetromino;

public class ShapeT extends Tetromino {
    public ShapeT() {
        super();
        setA(new Point(4,1));
        setB(new Point(5,1));
        setC(new Point(5,0));
        setD(new Point(6, 1));
        setName("T");
        setForm(0);
    }
}
