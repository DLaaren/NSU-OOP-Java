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

    @Override
    public void rotate() {
        if (getForm() == 0) {
            setA(new Point(getA().x() + 2, getA().y() - 2));
            setB(new Point(getB().x() + 1, getB().y() - 1));
            setC(new Point(getC().x(), getC().y()));
            setD(new Point(getD().x() - 1, getD().y() + 1));
            setForm(1);
        }
        else if (getForm() == 1) {
            setA(new Point(getA().x() - 2, getA().y() + 2));
            setB(new Point(getB().x() - 1, getB().y() + 1));
            setC(new Point(getC().x(), getC().y()));
            setD(new Point(getD().x() + 1, getD().y() - 1));
            setForm(0);
        }
    }
}
//  |a|b|c|d|  form = 0

//  |a|        form = 1
//  |b|
//  |c|
//  |d|
