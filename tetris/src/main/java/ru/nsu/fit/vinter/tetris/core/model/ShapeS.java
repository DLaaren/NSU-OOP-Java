package ru.nsu.fit.vinter.tetris.core.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.HashSet;
import java.util.Set;

public class ShapeS extends Tetromino {
    Rectangle a;
    Rectangle b;
    Rectangle c;
    Rectangle d;
    Color color = Color.GREEN;
    String nameShape = "ShapeS";
    Set<Point> shapePoints = new HashSet<>();

    public ShapeS() {
        shapePoints.add(new Point(0,1));
        shapePoints.add(new Point(1,0));
        shapePoints.add(new Point(1,1));
        shapePoints.add(new Point(2,0));
    }

    @Override
    public void rotateLeft() {

    }

    @Override
    public void rotateRight() {

    }
}
