package ru.nsu.fit.vinter.tetris.core.model.shapes;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import ru.nsu.fit.vinter.tetris.core.model.Tetromino;

public class ShapeI extends Tetromino {
    private Rectangle a;
    private Rectangle b;
    private Rectangle c;
    private Rectangle d;
    private Color color = Color.LIGHTSKYBLUE;
    private String nameShape = "ShapeI";

    public ShapeI() {
        this.a.setFill(color);
        this.b.setFill(color);
        this.c.setFill(color);
        this.d.setFill(color);
    }
}
