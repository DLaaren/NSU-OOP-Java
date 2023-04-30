package ru.nsu.fit.vinter.tetris.core.model;


abstract public class Tetromino {
    private Point a;
    private Point b;
    private Point c;
    private Point d;

    private String name;
    private int form;

    public Tetromino() {

    }

    public String getName() {
        return name;
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public Point getC() {
        return c;
    }

    public Point getD() {
        return d;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public void setB(Point b) {
        this.b = b;
    }

    public void setC(Point c) {
        this.c = c;
    }

    public void setD(Point d) {
        this.d = d;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setForm(int form) {
        this.form = form;
    }

    public void rotate() {}

    public void moveDown() {
        if (a.getY() < 20 && b.getY() < 20 && c.getY() < 20 && d.getY() < 20) {
            a.setY(a.getY() + 1);
            b.setY(b.getY() + 1);
            c.setY(c.getY() + 1);
            d.setY(d.getY() + 1);
        }
    }

    public void modeRight() {
        a.setX(a.getX() + 1);
        b.setX(b.getX() + 1);
        c.setX(c.getX() + 1);
        d.setX(d.getX() + 1);
    }

    public void moveLeft() {
        a.setX(a.getX() - 1);
        b.setX(b.getX() - 1);
        c.setX(c.getX() - 1);
        d.setX(d.getX() - 1);
    }
}
