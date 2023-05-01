package ru.nsu.fit.vinter.tetris.core.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Tetris {
    private int currScores = 0;
    private Tetromino currTetromino;
    public int [][] mesh = new int[20][10];
    private final TetrominoFactory tetrominoFactory = new TetrominoFactory();

    public Tetris() {
        for (int[] a: mesh) {
            Arrays.fill(a, 0);
        }
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
        currScores += 50*v;
    }

    public int getScores() {
        return currScores;
    }

    public Tetromino getCurrTetromino() {
        return currTetromino;
    }

    public void rotateTetromino() {
        if (currTetromino == null) return;
        currTetromino.rotate();
    }

    public void moveTetrominoRight() {
        if (currTetromino == null) return;
        if (currTetromino.getA().x() == 9 ||
        currTetromino.getB().x() == 9 ||
        currTetromino.getC().x() == 9 ||
        currTetromino.getD().x() == 9 ||
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
        if (currTetromino.getA().y() == 19 ||
        currTetromino.getB().y() == 19 ||
        currTetromino.getC().y() == 19 ||
        currTetromino.getD().y() == 19 ||
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

    public ArrayList<Integer> removeRow() {
        ArrayList<Integer> whichLinesRemove = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < 20; i++) {
            count = 0;
            for (int j = 0; j < 10; j++) {
                if (mesh[i][j] == 1) {
                    count += 1;
                }
                if (count == 10) {
                    whichLinesRemove.add(i);
                }
            }
        }
        updateScores(whichLinesRemove.size());
        return whichLinesRemove;
    }
}
