package ru.nsu.fit.vinter.tetris.core.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.HashSet;
import java.util.Set;

public class ShapeJ extends Tetromino {
    Rectangle a;
    Rectangle b;
    Rectangle c;
    Rectangle d;
    Color color = Color.BLUE;
    String nameShape = "ShapeJ";
    Set<Point> shapePoints = new HashSet<>();

    public ShapeJ() {
        shapePoints.add(new Point(0,2));
        shapePoints.add(new Point(1,0));
        shapePoints.add(new Point(1,1));
        shapePoints.add(new Point(1,2));
    }

    @Override
    public void rotateLeft() {

    }

    @Override
    public void rotateRight() {

    }
}
