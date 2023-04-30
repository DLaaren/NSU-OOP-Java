package ru.nsu.fit.vinter.tetris.core.model.shapes;

import ru.nsu.fit.vinter.tetris.core.model.Point;
import ru.nsu.fit.vinter.tetris.core.model.Tetromino;

public class ShapeZ extends Tetromino {
    public ShapeZ() {
        super();
        setA(new Point(6,1));
        setB(new Point(5,1));
        setC(new Point(5,0));
        setD(new Point(4,0));
        setName("Z");
        setForm(0);
    }

    @Override
    public void rotate() {
        if (getForm() == 0) {
            setA(new Point(getA().x() - 2, getA().y()));
            setB(new Point(getB().x() - 1, getB().y() - 1));
            setC(new Point(getC().x(), getC().y()));
            setD(new Point(getD().x() + 1, getD().y() - 1));
            setForm(1);
        }
        else if (getForm() == 1) {
            setA(new Point(getA().x() + 2, getA().y()));
            setB(new Point(getB().x() + 1, getB().y() + 1));
            setC(new Point(getC().x(), getC().y()));
            setD(new Point(getD().x() - 1, getD().y() + 1));
            setForm(0);
        }
    }
}
//  |d|c|     form = 0
//    |b|a|

//    |d|     form = 1
//  |b|c|
//  |a|
