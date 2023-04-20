package ru.nsu.fit.vinter.tetris.core.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.HashSet;
import java.util.Set;

public class ShapeZ extends Tetromino {
    Rectangle a;
    Rectangle b;
    Rectangle c;
    Rectangle d;
    Color color = Color.RED;
    String nameShape = "ShapeZ";
    Set<Point> shapePoints = new HashSet<>();

    public ShapeZ() {
        shapePoints.add(new Point(0,0));
        shapePoints.add(new Point(1,0));
        shapePoints.add(new Point(1,1));
        shapePoints.add(new Point(2,1));
    }

    @Override
    public void rotateLeft() {

    }

    @Override
    public void rotateRight() {

    }
}
