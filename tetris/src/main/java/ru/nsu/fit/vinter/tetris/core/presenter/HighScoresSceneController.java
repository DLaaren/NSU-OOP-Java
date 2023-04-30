package ru.nsu.fit.vinter.tetris.core.presenter;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HighScoresSceneController {
    @FXML
    private Button exitButton;

    @FXML
    public void getBackButtonCLicked() {
        ((Stage)exitButton.getScene().getWindow()).close();
    }
}
