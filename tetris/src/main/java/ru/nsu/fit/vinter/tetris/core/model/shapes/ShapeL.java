package ru.nsu.fit.vinter.tetris.core.model.shapes;

import ru.nsu.fit.vinter.tetris.core.model.Point;
import ru.nsu.fit.vinter.tetris.core.model.Tetromino;

public class ShapeL extends Tetromino {
    public ShapeL() {
        super();
        setA(new Point(5,2));
        setB(new Point(4,2));
        setC(new Point(4,1));
        setD(new Point(4,0));
        setName("L");
        setForm(0);
    }

    @Override
    public void rotate() {
        if (getForm() == 0) {
            setA(new Point(getA().x() - 2, getA().y()));
            setB(new Point(getB().x() - 1, getB().y() - 1));
            setC(new Point(getC().x(), getC().y()));
            setD(new Point(getD().x() + 1, getD().y() + 1));
            setForm(1);
        }
        else if (getForm() == 1) {
            setA(new Point(getA().x(), getA().y() - 2));
            setB(new Point(getB().x() + 1, getB().y() - 1));
            setC(new Point(getC().x(), getC().y()));
            setD(new Point(getD().x() - 1, getD().y() + 1));
            setForm(2);
        } else if (getForm() == 2) {
            setA(new Point(getA().x() + 2, getA().y()));
            setB(new Point(getB().x() + 1, getB().y() + 1));
            setC(new Point(getC().x(), getC().y()));
            setD(new Point(getD().x() - 1, getD().y() - 1));
            setForm(3);
        } else if (getForm() == 3) {
            setA(new Point(getA().x(), getA().y() + 2));
            setB(new Point(getB().x() - 1, getB().y() + 1));
            setC(new Point(getC().x(), getC().y()));
            setD(new Point(getD().x() + 1, getD().y() - 1));
            setForm(0);
        }
    }
}
//  |d|      form = 0
//  |c|
//  |b|a|

//  |b|c|d|  form = 1
//  |a|

//  |a|b|    form = 2
//    |c|
//    |d|

//      |a|  form = 3
//  |d|c|b|

