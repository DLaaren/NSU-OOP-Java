package ru.nsu.fit.vinter.tetris.core.model.shapes;

import ru.nsu.fit.vinter.tetris.core.model.Point;
import ru.nsu.fit.vinter.tetris.core.model.Tetromino;

import java.util.ArrayList;

public class ShapeJ extends Tetromino {
    public ShapeJ() {
        super();
        setA(new Point(4,2));
        setB(new Point(5,2));
        setC(new Point(5,1));
        setD(new Point(5,0));
        setName("J");
        setForm(0);
    }

    @Override
    public ArrayList<Point> getRotationShift() {
        ArrayList<Point> rotationShift = new ArrayList<>();
        if (getForm() == 0) {
            rotationShift.add(new Point(0,-2));
            rotationShift.add(new Point(-1,-1));
            rotationShift.add(new Point(0,0));
            rotationShift.add(new Point(1,1));
        }
        if (getForm() == 1) {
            rotationShift.add(new Point(2,0));
            rotationShift.add(new Point(1,-1));
            rotationShift.add(new Point(0,0));
            rotationShift.add(new Point(-1,1));
        }
        if (getForm() == 2) {
            rotationShift.add(new Point(0,2));
            rotationShift.add(new Point(1,1));
            rotationShift.add(new Point(0,0));
            rotationShift.add(new Point(-1,-1));
        }
        if (getForm() == 3) {
            rotationShift.add(new Point(-2,0));
            rotationShift.add(new Point(-1,1));
            rotationShift.add(new Point(0,0));
            rotationShift.add(new Point(1,-1));
        }
        return rotationShift;
    }

    @Override
    public void rotate() {
        super.rotate();
        setForm((getForm() + 1) % 4);
    }
}
//    |d|    form = 0
//    |c|
//  |a|b|

//  |a|      form = 1
//  |b|c|d|

//  |b|a|    form = 2
//  |c|
//  |d|

//  |d|c|b|  form = 3
//      |a|
