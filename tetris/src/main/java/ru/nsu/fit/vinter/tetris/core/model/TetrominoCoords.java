package ru.nsu.fit.vinter.tetris.core.model;

import java.util.ArrayList;
import java.util.List;

public class TetrominoCoords {
    List<Point> coords;

    public TetrominoCoords() {
        coords = new ArrayList<Point>(4);
    }

    public void moveDown() {
        for (int i = 0; i < 4; i++) {
            //add checking
                coords.get(i).subY();
        }
    }
}
