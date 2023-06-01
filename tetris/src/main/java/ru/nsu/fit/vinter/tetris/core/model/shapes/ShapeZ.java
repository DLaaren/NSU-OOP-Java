package ru.nsu.fit.vinter.tetris.core.model.shapes;

import ru.nsu.fit.vinter.tetris.core.model.Point;
import ru.nsu.fit.vinter.tetris.core.model.Tetromino;

import java.util.ArrayList;

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
    public ArrayList<Point> getRotationShift() {
        ArrayList<Point> rotationShift = new ArrayList<>();
        if (getForm() == 0) {
            rotationShift.add(new Point(-2,0));
            rotationShift.add(new Point(-1,-1));
            rotationShift.add(new Point(0,0));
            rotationShift.add(new Point(1,-1));
        }
        if (getForm() == 1) {
            rotationShift.add(new Point(2,0));
            rotationShift.add(new Point(1,1));
            rotationShift.add(new Point(0,0));
            rotationShift.add(new Point(-1,1));
        }
        return rotationShift;
    }

    @Override
    public void rotate() {
        super.rotate();
        setForm((getForm() + 1) % 2);
    }
}
//  |d|c|     form = 0
//    |b|a|

//    |d|     form = 1
//  |b|c|
//  |a|
