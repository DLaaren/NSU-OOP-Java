package ru.nsu.fit.vinter.tetris.core.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.HashSet;
import java.util.Set;

public class ShapeO extends Tetromino {
    Rectangle a;
    Rectangle b;
    Rectangle c;
    Rectangle d;
    Color color = Color.YELLOW;
    String nameShape = "ShapeO";
    Set<Point> shapePoints = new HashSet<>();

    public ShapeO() {
        shapePoints.add(new Point(0,0));
        shapePoints.add(new Point(0,1));
        shapePoints.add(new Point(1,0));
        shapePoints.add(new Point(1,1));
    }
}
