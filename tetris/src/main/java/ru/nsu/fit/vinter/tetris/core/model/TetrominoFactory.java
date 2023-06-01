package ru.nsu.fit.vinter.tetris.core.model;

import ru.nsu.fit.vinter.tetris.core.model.shapes.*;

import java.security.SecureRandom;
import java.util.List;
import java.util.function.Supplier;

public class TetrominoFactory {
//    private final List<Tetromino> shapes = List.of(
//            new ShapeI(), new ShapeJ(), new ShapeL(), new ShapeO(),
//            new ShapeS(), new ShapeT(), new ShapeZ()
//    );
//
//    public Tetromino generateNextTetromino() {
//        SecureRandom randomizer = new SecureRandom();
//        int randomShapeID = randomizer.nextInt(0, 7);
//        return shapes.get(randomShapeID);
//    }

    private final SecureRandom randomizer = new SecureRandom();

    public enum Shape {
        SHAPE_I(ShapeI::new),
        SHAPE_J(ShapeJ::new),
        SHAPE_L(ShapeL::new),
        SHAPE_O(ShapeO::new),
        SHAPE_S(ShapeS::new),
        SHAPE_T(ShapeT::new),
        SHAPE_Z(ShapeZ::new);

        private final Supplier<Tetromino> tetrominoSupplier;

        Shape(Supplier<Tetromino> tetrominoSupplier) {
            this.tetrominoSupplier = tetrominoSupplier;
        }

        public Tetromino instance() {
            return tetrominoSupplier.get();
        }
    }

    public Tetromino generateNextTetromino() {
        int randomShapeID = randomizer.nextInt(0, 7);
        return Shape.values()[randomShapeID].instance();
    }
}
