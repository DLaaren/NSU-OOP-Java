package ru.nsu.fit.vinter.tetris.core.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tetromino {
    protected Rectangle a;
    protected Rectangle b;
    protected Rectangle c;
    protected Rectangle d;
    private Color color;
    private String name;
    private int form;
    private int blockSize;

    public Tetromino(int blockSize) {
        this.blockSize = blockSize;
        a = new Rectangle(blockSize, blockSize);
        b = new Rectangle(blockSize, blockSize);
        c = new Rectangle(blockSize, blockSize);
        d = new Rectangle(blockSize, blockSize);
        a.setFill(color);
        b.setFill(color);
        c.setFill(color);
        d.setFill(color);
    }

    public void moveDown() {
        a.setY(a.getY() + blockSize);
        b.setY(b.getY() + blockSize);
        c.setY(c.getY() + blockSize);
        d.setY(d.getY() + blockSize);
    }

    public void modeRight() {
        a.setX(a.getX() + blockSize);
        b.setX(b.getX() + blockSize);
        c.setX(c.getX() + blockSize);
        d.setX(d.getX() + blockSize);
    }

    public void moveLeft() {
        a.setX(a.getX() - blockSize);
        b.setX(b.getX() - blockSize);
        c.setX(c.getX() - blockSize);
        d.setX(d.getX() - blockSize);
    }

}
