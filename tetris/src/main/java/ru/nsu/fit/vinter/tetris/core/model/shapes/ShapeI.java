package ru.nsu.fit.vinter.tetris.core.model.shapes;

import ru.nsu.fit.vinter.tetris.core.model.Point;
import ru.nsu.fit.vinter.tetris.core.model.Tetromino;

import java.util.ArrayList;

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
    public ArrayList<Point> getRotationShift() {
        ArrayList<Point> rotationShift = new ArrayList<>();
        if (getForm() == 0) {
            rotationShift.add(0, new Point(2,-2));
            rotationShift.add(1, new Point(1,-1));
            rotationShift.add(2, new Point(0,0));
            rotationShift.add(3, new Point(-1,1));
        }
        else if (getForm() == 1) {
            rotationShift.add(0, new Point(-2,2));
            rotationShift.add(1, new Point(-1,1));
            rotationShift.add(2, new Point(0,0));
            rotationShift.add(3, new Point(1,-1));
        }
        return rotationShift;
    }

    @Override
    public void rotate() {
        super.rotate();
        setForm((getForm() + 1) % 2);
    }
}
//  |a|b|c|d|  form = 0

//  |a|        form = 1
//  |b|
//  |c|
//  |d|
