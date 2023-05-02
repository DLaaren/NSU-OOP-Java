package ru.nsu.fit.vinter.tetris.core.presenter;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ResourceBundle;

public class HighScoresSceneController implements Initializable {
    @FXML
    private Button exitButton;
    @FXML
    private Label highScoresText;


    @FXML
    public void getBackButtonCLicked() {
        ((Stage)exitButton.getScene().getWindow()).close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String scores = null;
        try {
            scores = Files.readString(Path.of("data/highScores.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        highScoresText.setText(scores);
    }
}
