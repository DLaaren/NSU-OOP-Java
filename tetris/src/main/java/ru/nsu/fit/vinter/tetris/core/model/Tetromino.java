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

    public int getForm() { return form; }

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
        if (a.y() < 19 && b.y() < 19 && c.y() < 19 && d.y() < 19) {
            a = new Point(a.x(), a.y() + 1);
            b = new Point(b.x(), b.y() + 1);
            c = new Point(c.x(), c.y() + 1);
            d = new Point(d.x(), d.y() + 1);
        }
    }

    public void modeRight() {
        if (a.x() < 9 && b.x() < 9 && c.x() < 9 && d.x() < 9) {
            a = new Point(a.x() + 1, a.y());
            b = new Point(b.x() + 1, b.y());
            c = new Point(c.x() + 1, c.y());
            d = new Point(d.x() + 1, d.y());
        }
    }

    public void moveLeft() {
        if (a.x() > 0 && b.x() > 0 && c.x() > 0 && d.x() > 0) {
            a = new Point(a.x() - 1, a.y());
            b = new Point(b.x() - 1, b.y());
            c = new Point(c.x() - 1, c.y());
            d = new Point(d.x() - 1, d.y());
        }
    }

    //public Tetromino copy() {}
}
