package ru.nsu.fit.vinter.tetris.core.model;

import ru.nsu.fit.vinter.tetris.core.model.shapes.*;

import java.security.SecureRandom;
import java.util.List;

public class TetrominoFactory {
    private final List<Tetromino> shapes = List.of(
            /*new ShapeI(blockSize), new ShapeJ(blockSize), new ShapeL(blockSize),*/ new ShapeO()
            //new ShapeS(blockSize), new ShapeT(blockSize), new ShapeZ(blockSize)
    );

    public Tetromino generateNextTetromino() {
        //SecureRandom randomizer = new SecureRandom();
        //int randomShapeID = randomizer.nextInt(0, 6);
        //return shapes.get(randomShapeID);
        return new ShapeO();
    }
}
