package ru.nsu.fit.vinter.tetris.core.model.shapes;

import ru.nsu.fit.vinter.tetris.core.model.Point;
import ru.nsu.fit.vinter.tetris.core.model.Tetromino;

import java.util.ArrayList;

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

    @Override
    public ArrayList<Point> getRotationShift() {
        ArrayList<Point> rotationShift = new ArrayList<>();
        if (getForm() == 0) {
            rotationShift.add(new Point(0,0));
            rotationShift.add(new Point(0,0));
            rotationShift.add(new Point(0,0));
            rotationShift.add(new Point(0,0));
        }
        if (getForm() == 1) {
            rotationShift.add(new Point(0,0));
            rotationShift.add(new Point(0,0));
            rotationShift.add(new Point(0,0));
            rotationShift.add(new Point(0,0));
        }
        return rotationShift;
    }
    //   |b|c|
    //   |a|d|
}
