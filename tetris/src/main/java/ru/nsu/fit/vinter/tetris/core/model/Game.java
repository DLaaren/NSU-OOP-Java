package ru.nsu.fit.vinter.tetris.core.model;

import java.io.*;
import java.util.Objects;

public class Game {
    InputStream scoresFileInputStream;
    File scoresFile;
    TetrominoFactory tetrominoFactory = new TetrominoFactory();
    int currScores;

    public Game() {
        scoresFile = new File("/highScores.txt");
        scoresFileInputStream = Game.class.getResourceAsStream("/highScores.txt");
    }

    public void generateNextTetromino() {
        Tetromino currTetromino = tetrominoFactory.generateNextTetromino();
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
