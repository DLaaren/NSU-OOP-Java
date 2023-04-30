package ru.nsu.fit.vinter.tetris.core.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Tetris {
    private int blockSize = 40;
    private int currScores = 0;
    private Tetromino currTetromino;
    private final TetrominoFactory tetrominoFactory = new TetrominoFactory();
    public int [][] mesh = new int[20][10];

    public Tetris() {
        for (int[] a: mesh) {
            Arrays.fill(a, 0);
        }
    }

    public void generateTetromino() {
        currTetromino = tetrominoFactory.generateNextTetromino();
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

    }

    public void moveTetrominoRight() {
        currTetromino.modeRight();
    }

    public void moveTetrominoLeft() {
        currTetromino.moveLeft();
    }

    public void moveTetrominoDown() {
        currTetromino.moveDown();
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
