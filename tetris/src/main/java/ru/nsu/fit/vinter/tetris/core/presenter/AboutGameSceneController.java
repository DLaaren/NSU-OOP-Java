package ru.nsu.fit.vinter.tetris.core.presenter;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AboutGameSceneController {
    @FXML
    private Button exitButton;
    public void getBackButtonCLicked() {
        ((Stage)exitButton.getScene().getWindow()).close();
    }
}
