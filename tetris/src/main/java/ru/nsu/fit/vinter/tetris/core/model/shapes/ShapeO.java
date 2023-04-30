package ru.nsu.fit.vinter.tetris.core.model.shapes;

import ru.nsu.fit.vinter.tetris.core.model.Point;
import ru.nsu.fit.vinter.tetris.core.model.Tetromino;

public class ShapeO extends Tetromino {
    public ShapeO() {
        super();
        setA(new Point(4,1));
        setB(new Point(4,0));
        setC(new Point(5,0));
        setD(new Point(5,1));
        setName("O");
        setForm(0);
    }
    //   |b|c|
    //   |a|d|
}
