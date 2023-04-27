package ru.nsu.fit.vinter.tetris.core.model;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;

public class Game {
    private InputStream scoresFileInputStream;
    private TetrominoFactory tetrominoFactory = new TetrominoFactory();
    private int currScores;
    private Tetromino currTetromino;
    private boolean[] fieldState = new boolean[10*20];

    public Game() {
        scoresFileInputStream = Game.class.getResourceAsStream("/highScores.txt");
        Arrays.fill(fieldState, false);
    }

    public void generateNextTetromino() {
        currTetromino = tetrominoFactory.generateNextTetromino();
    }

    public Tetromino getCurrTetromino() {
        return this.currTetromino;
    }

    public void updateGameField() {
        //
        currTetromino.moveDownTetromino();
        //check if it stoped or been moved
        //check if is there a complete line --> add scores

    }

    private void updateScores(int scores) {
        this.currScores += scores;
    }

    public void saveScores() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(scoresFileInputStream));
        BufferedWriter writer = new BufferedWriter(new FileWriter("/highScores.txt"));
        String content = "";
        boolean changed = false;
        while (reader.ready()) {
            String line = reader.readLine();
            content = content + line + System.lineSeparator();
            String[] splitLine = line.split(" ");
            String newScoresLine = splitLine[0] + " " + currScores + "\n";
            if (!changed && !Objects.equals(splitLine[1], "---") && Integer.parseInt(splitLine[1]) < currScores) {
                content = content.replaceAll(splitLine[1], String.valueOf(currScores));
                changed = true;
            }
            if (Objects.equals(splitLine[1], "---")) {
            }
        }
        writer.write(content);
    }
}
