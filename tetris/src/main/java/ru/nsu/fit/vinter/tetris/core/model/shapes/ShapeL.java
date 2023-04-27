package ru.nsu.fit.vinter.tetris.core.model.shapes;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import ru.nsu.fit.vinter.tetris.core.model.Tetromino;

public class ShapeL extends Tetromino {
    private Rectangle a;
    private Rectangle b;
    private Rectangle c;
    private Rectangle d;
    private Color color = Color.ORANGE;
    private String nameShape = "ShapeL";

    public ShapeL() {
        this.a.setFill(color);
        this.b.setFill(color);
        this.c.setFill(color);
        this.d.setFill(color);
    }

    @Override
    public void rotateLeft() {

    }

    @Override
    public void rotateRight() {

    }
}
