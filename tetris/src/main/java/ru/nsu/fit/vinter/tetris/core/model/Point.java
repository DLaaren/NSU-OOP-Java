package ru.nsu.fit.vinter.tetris.core.model;

public class Point {
    private int x;
    private int y;

    public int getX() {
        return x;
    }
    public void subX() { this.x--; }
    public int getY() {
        return y;
    }
    public void subY() { this.y--; }
}
