package ru.nsu.fit.vinter.tetris.core.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.HashSet;
import java.util.Set;

public class ShapeL extends Tetromino {
    Rectangle a;
    Rectangle b;
    Rectangle c;
    Rectangle d;
    Color color = Color.ORANGE;
    String nameShape = "ShapeL";
    Set<Point> shapePoints = new HashSet<>();

    public ShapeL() {
        shapePoints.add(new Point(0,0));
        shapePoints.add(new Point(0,1));
        shapePoints.add(new Point(0,2));
        shapePoints.add(new Point(1,2));
    }

    @Override
    public void rotateLeft() {

    }

    @Override
    public void rotateRight() {

    }
}
