package ru.nsu.fit.vinter.tetris.core.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

abstract public class Tetromino {
    private Rectangle a;
    private Rectangle b;
    private Rectangle c;
    private Rectangle d;
    private Color color;
    private String nameShape;
    TetrominoCoords coords;

    public void rotateLeft() {}
    public void rotateRight() {}

    public Point getRightPoint() {}
    public Point getLeftPoint() {}

    public void moveRightTetromino() {}
    public void moveLeftTetromino() {}
    public void moveDownTetromino() {
        coords.moveDown();
    }
}
