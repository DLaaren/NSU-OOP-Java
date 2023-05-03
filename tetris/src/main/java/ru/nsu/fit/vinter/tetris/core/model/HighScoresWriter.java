package ru.nsu.fit.vinter.tetris.core.model;

import java.io.*;
import java.util.Objects;

public class HighScoresWriter {
    BufferedReader reader = new BufferedReader(new FileReader("data/highScores.txt"));
    String[] fileContent = new String[10];
    FileWriter writer = new FileWriter("data/highScores.txt", false);

    public HighScoresWriter() throws IOException {
    }

    private void read() throws IOException {
        int index = 0;
        String line = reader.readLine();
        while (line != null && index < 10) {
            fileContent[index] = line;
            index += 1;
            line = reader.readLine();
        }
    }

    private int isNewHighScore(int scores) throws IOException {
        read();
        if (Objects.equals(fileContent[0], "===")) {
            return 0;
        }
        for (int i = 0; i < 10; i++) {
            if (!Objects.equals(fileContent[i], "===")) {
                int currHighScore = Integer.parseInt(fileContent[i]);
                if(scores > currHighScore) {
                    return i;
                }
            } else if (Objects.equals(fileContent[i], "===") && Integer.parseInt(fileContent[i-1]) > scores) {
                return i;
            }
        }
        return -1;
    }

    public void write(int scores) throws IOException {
        System.out.println("scores " + scores);
        if (scores == 0) {
            return;
        }
        int index = isNewHighScore(scores);
        System.out.println("index " + index);
        if (index != -1) {
            writer.write("");
            for (int i = 0; i < 10; i++) {
                if (i < index) {
                    writer.append(fileContent[i]).append("\n");
                } else if (i == index) {
                    writer.append(String.valueOf(scores)).append("\n");
                } else {
                    writer.append(fileContent[i - 1]).append("\n");
                }
            }
        }
    }
}
