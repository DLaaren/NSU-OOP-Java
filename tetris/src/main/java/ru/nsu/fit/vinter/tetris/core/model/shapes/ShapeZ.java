package ru.nsu.fit.vinter.tetris.core.model.shapes;

import ru.nsu.fit.vinter.tetris.core.model.Point;
import ru.nsu.fit.vinter.tetris.core.model.Tetromino;

public class ShapeZ extends Tetromino {
    public ShapeZ() {
        super();
        setA(new Point(4,0));
        setB(new Point(5,0));
        setC(new Point(5,1));
        setD(new Point(6,0));
        setName("Z");
        setForm(0);
    }
}
