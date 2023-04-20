package ru.nsu.fit.vinter.tetris.core.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Set;

abstract public class Tetromino {
    Rectangle a;
    Rectangle b;
    Rectangle c;
    Rectangle d;
    Color color;
    String nameShape;
    Set<Point> shapePoints;
    /*
    for points
     ______y
    |
    |
    x

    */

    public void rotateLeft() {}
    public void rotateRight() {}
}
