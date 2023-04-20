package ru.nsu.fit.vinter.tetris.core.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Set;

public class ShapeI extends Tetromino {
    private Rectangle a;
    private Rectangle b;
    private Rectangle c;
    private Rectangle d;
    private Color color = Color.LIGHTSKYBLUE;
    private String nameShape = "ShapeI";
    private Set<Point> shapePoints;

    public ShapeI() {
        shapePoints = Set.of(new Point(0,0), new Point(1,0), new Point(2,0), new Point(3,0));
    }

    @Override
    public void rotateLeft() {

    }

    @Override
    public void rotateRight() {

    }
}
