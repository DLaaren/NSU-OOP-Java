package ru.nsu.fit.vinter.tetris.core.model.shapes;

import ru.nsu.fit.vinter.tetris.core.model.Point;
import ru.nsu.fit.vinter.tetris.core.model.Tetromino;

public class ShapeT extends Tetromino {
    public ShapeT() {
        super();
        setA(new Point(4,1));
        setB(new Point(5,0));
        setC(new Point(5,1));
        setD(new Point(6, 1));
        setName("T");
        setForm(0);
    }

    @Override
    public void rotate() {
        if (getForm() == 0) {
            setA(new Point(getA().x() + 1, getA().y() - 1));
            setB(new Point(getB().x() + 1, getB().y() + 1));
            setC(new Point(getC().x(), getC().y()));
            setD(new Point(getD().x() - 1, getD().y() + 1));
            setForm(1);
        }
        else if (getForm() == 1) {
            setA(new Point(getA().x() + 1, getA().y() + 1));
            setB(new Point(getB().x() - 1, getB().y() + 1));
            setC(new Point(getC().x(), getC().y()));
            setD(new Point(getD().x() - 1, getD().y() - 1));
            setForm(2);
        } else if (getForm() == 2) {
            setA(new Point(getA().x() - 1, getA().y() + 1));
            setB(new Point(getB().x() - 1, getB().y() - 1));
            setC(new Point(getC().x(), getC().y()));
            setD(new Point(getD().x() + 1, getD().y() - 1));
            setForm(3);
        } else if (getForm() == 3) {
            setA(new Point(getA().x() - 1, getA().y() - 1));
            setB(new Point(getB().x() + 1, getB().y() - 1));
            setC(new Point(getC().x(), getC().y()));
            setD(new Point(getD().x() + 1, getD().y() + 1));
            setForm(0);
        }
    }
}
//    |b|        form = 0
//  |a|c|d|

//    |a|        form = 1
//    |c|b|
//    |d|

//  |d|c|a|      form = 2
//    |b|

//    |d|        form = 3
//  |b|c|
//    |a|