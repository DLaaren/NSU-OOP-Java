package ru.nsu.fit.vinter.tetris.core.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tetris {
    private int currScores = 0;
    private Tetromino currTetromino;
    public static final int SIZEX = 10;
    public static final int SIZEY = 20;

    public int [][] mesh = new int[SIZEY][SIZEX];
    private final TetrominoFactory tetrominoFactory = new TetrominoFactory();

    public Tetris() {
        for (int[] line: mesh) {
            Arrays.fill(line, 0);
        }
    }

    public int[][] getMesh() {
        return mesh;
    }

    public boolean generateTetromino() {
        if (mesh[0][3] == 1 ||mesh[0][4] == 1 || mesh[0][5] == 1 || mesh[0][6] == 1) {
            currTetromino = null;
            return false;
        }
        currTetromino = tetrominoFactory.generateNextTetromino();
        return  true;
    }

    public void updateScores(int v) {
        if (v == 1) {
            currScores += 40;
        } else if (v == 2) {
            currScores += 100;
        } else if (v == 3) {
            currScores += 300;
        } else if (v == 4) {
            currScores += 1200;
        }
    }

    public int getScores() {
        return currScores;
    }

    public Tetromino getCurrTetromino() {
        return currTetromino;
    }

    public boolean canTetrominoRotates(List<Point> shiftRotation) {
        if (currTetromino.getA().y() + shiftRotation.get(0).y() > SIZEY - 1 || currTetromino.getA().y() + shiftRotation.get(0).y() < 0 ||
        currTetromino.getA().x() + shiftRotation.get(0).x() > SIZEX - 1 || currTetromino.getA().x() + shiftRotation.get(0).x() < 0 ||
        currTetromino.getB().y() + shiftRotation.get(1).y() > SIZEY - 1 || currTetromino.getB().y() + shiftRotation.get(1).y() < 0 ||
        currTetromino.getB().x() + shiftRotation.get(1).x() > SIZEX - 1 || currTetromino.getB().x() + shiftRotation.get(1).x() < 0 ||
        currTetromino.getC().y() + shiftRotation.get(2).y() > SIZEY - 1 || currTetromino.getC().y() + shiftRotation.get(2).y() < 0 ||
        currTetromino.getC().x() + shiftRotation.get(2).x() > SIZEX - 1 || currTetromino.getC().x() + shiftRotation.get(2).x() < 0 ||
        currTetromino.getD().y() + shiftRotation.get(3).y() > SIZEY - 1 || currTetromino.getD().y() + shiftRotation.get(3).y() < 0 ||
        currTetromino.getD().x() + shiftRotation.get(3).x() > SIZEX - 1 || currTetromino.getD().x() + shiftRotation.get(3).x() < 0 ||
        mesh[currTetromino.getA().y() + shiftRotation.get(0).y()] [currTetromino.getA().x() + shiftRotation.get(0).x()] == 1 ||
        mesh[currTetromino.getB().y() + shiftRotation.get(1).y()] [currTetromino.getB().x() + shiftRotation.get(1).x()] == 1 ||
        mesh[currTetromino.getC().y() + shiftRotation.get(2).y()] [currTetromino.getC().x() + shiftRotation.get(2).x()] == 1 ||
        mesh[currTetromino.getD().y() + shiftRotation.get(3).y()] [currTetromino.getD().x() + shiftRotation.get(3).x()] == 1) {
            return false;
        }
        return true;
    }

    public void rotateTetromino() {
        if (currTetromino == null) return;
        List<Point> shiftRotation = currTetromino.getRotationShift();
        if (canTetrominoRotates(shiftRotation)) {
            currTetromino.rotate();
        }
    }

    public void moveTetrominoRight() {
        if (currTetromino == null) return;
        if (currTetromino.getA().x() == SIZEX - 1 ||
        currTetromino.getB().x() == SIZEX - 1 ||
        currTetromino.getC().x() == SIZEX - 1 ||
        currTetromino.getD().x() == SIZEX - 1 ||
        mesh [currTetromino.getA().y()] [currTetromino.getA().x() + 1] == 1 ||
        mesh [currTetromino.getB().y()] [currTetromino.getB().x() + 1] == 1 ||
        mesh [currTetromino.getC().y()] [currTetromino.getC().x() + 1] == 1 ||
        mesh [currTetromino.getD().y()] [currTetromino.getD().x() + 1] == 1) {
        } else {
            currTetromino.modeRight();
        }
    }

    public void moveTetrominoLeft() {
        if (currTetromino == null) return;
        if (currTetromino.getA().x() == 0 ||
        currTetromino.getB().x() == 0 ||
        currTetromino.getC().x() == 0 ||
        currTetromino.getD().x() == 0 ||
        mesh [currTetromino.getA().y()] [currTetromino.getA().x() - 1] == 1 ||
        mesh [currTetromino.getB().y()] [currTetromino.getB().x() - 1] == 1 ||
        mesh [currTetromino.getC().y()] [currTetromino.getC().x() - 1] == 1 ||
        mesh [currTetromino.getD().y()] [currTetromino.getD().x() - 1] == 1) {
        } else {
            currTetromino.moveLeft();
        }
    }

    public void moveTetrominoDown() {
        if (currTetromino == null) return;
        if (currTetromino.getA().y() == SIZEY - 1 ||
        currTetromino.getB().y() == SIZEY - 1 ||
        currTetromino.getC().y() == SIZEY - 1 ||
        currTetromino.getD().y() == SIZEY - 1 ||
        mesh [currTetromino.getA().y() + 1] [currTetromino.getA().x()] == 1 ||
        mesh [currTetromino.getB().y() + 1] [currTetromino.getB().x()] == 1 ||
        mesh [currTetromino.getC().y() + 1] [currTetromino.getC().x()] == 1 ||
        mesh [currTetromino.getD().y() + 1] [currTetromino.getD().x()] == 1 ) {
            mesh [currTetromino.getA().y()] [currTetromino.getA().x()] = 1;
            mesh [currTetromino.getB().y()] [currTetromino.getB().x()] = 1;
            mesh [currTetromino.getC().y()] [currTetromino.getC().x()] = 1;
            mesh [currTetromino.getD().y()] [currTetromino.getD().x()] = 1;
            currTetromino = null;
        } else {
            currTetromino.moveDown();
        }
    }

    public void removeRows() {
        List<Integer> whichLinesRemove = new ArrayList<>();
        for (int i = SIZEY - 1; i >= 0; i--) {
            int count = 0;
            for (int j = 0; j < SIZEX; j++) {
                if (mesh[i][j] == 1) {
                    count += 1;
                }
                if (count == SIZEX) {
                    whichLinesRemove.add(i);
                }
            }
        }

        for (int i : whichLinesRemove) {
            Arrays.fill(mesh[i], 0);
        }
        if (whichLinesRemove.size() > 0) {
            int shift = 0;
            int index = 0;
            for (int i = whichLinesRemove.get(index); i >= 0; i--) {
                int m = 0;
                while (index < whichLinesRemove.size() && i - m == whichLinesRemove.get(index)) {
                    index += 1;
                    shift += 1;
                    m += 1;
                }
                for (int j = 0; j < Tetris.SIZEX; j++) {
                    if (i - shift >= 0) {
                        mesh[i][j] = mesh[i - shift][j];
                    } else {
                        mesh[i][j] = 0;
                    }
                }
            }
        }
        updateScores(whichLinesRemove.size());
    }
}
