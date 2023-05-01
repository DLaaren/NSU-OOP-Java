package ru.nsu.fit.vinter.tetris.core.model.shapes;

import ru.nsu.fit.vinter.tetris.core.model.Point;
import ru.nsu.fit.vinter.tetris.core.model.Tetromino;

import java.util.ArrayList;

public class ShapeS extends Tetromino {
    public ShapeS() {
        super();
        setA(new Point(4,1));
        setB(new Point(5,1));
        setC(new Point(5,0));
        setD(new Point(6,0));
        setName("S");
        setForm(0);
    }

    @Override
    public ArrayList<Point> getRotationShift() {
        ArrayList<Point> rotationShift = new ArrayList<>();
        if (getForm() == 0) {
            rotationShift.add(new Point(0,-2));
            rotationShift.add(new Point(-1,-1));
            rotationShift.add(new Point(0,0));
            rotationShift.add(new Point(-1,1));
        }
        if (getForm() == 1) {
            rotationShift.add(new Point(0,2));
            rotationShift.add(new Point(1,1));
            rotationShift.add(new Point(0,0));
            rotationShift.add(new Point(1,-1));
        }
        return rotationShift;
    }

    @Override
    public void rotate() {
        super.rotate();
        setForm((getForm() + 1) % 2);
    }
}
//    |c|d|     form = 0
//  |a|b|

//  |a|         form = 1
//  |b|c|
//    |d|


