package ru.nsu.fit.vinter.tetris.core.model.shapes;

import ru.nsu.fit.vinter.tetris.core.model.Point;
import ru.nsu.fit.vinter.tetris.core.model.Tetromino;

import java.util.ArrayList;

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
    public ArrayList<Point> getRotationShift() {
        ArrayList<Point> rotationShift = new ArrayList<>();
        if (getForm() == 0) {
            rotationShift.add(new Point(1,-1));
            rotationShift.add(new Point(1,1));
            rotationShift.add(new Point(0,0));
            rotationShift.add(new Point(-1,1));
        }
        if (getForm() == 1) {
            rotationShift.add(new Point(1,1));
            rotationShift.add(new Point(-1,1));
            rotationShift.add(new Point(0,0));
            rotationShift.add(new Point(-1,-1));
        }
        if (getForm() == 2) {
            rotationShift.add(new Point(-1,1));
            rotationShift.add(new Point(-1,-1));
            rotationShift.add(new Point(0,0));
            rotationShift.add(new Point(1,-1));
        }
        if (getForm() == 3) {
            rotationShift.add(new Point(-1,-1));
            rotationShift.add(new Point(1,-1));
            rotationShift.add(new Point(0,0));
            rotationShift.add(new Point(1,1));
        }
        return rotationShift;
    }

    @Override
    public void rotate() {
        super.rotate();
        setForm((getForm() + 1) % 4);
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