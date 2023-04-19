package ru.nsu.fit.vinter.tetris.core.view;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {
    Scene scene;
    Parent root;

    @FXML
    public void setHighScoresScene() throws IOException {
        Stage primaryStage = new Stage();
        root = FXMLLoader.load(getClass().getResource("/highScores.fxml"));
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("HighScores");
        primaryStage.show();
    }

    @FXML
    public void setAboutGameScene() throws IOException {
        Stage primaryStage = new Stage();
        root = FXMLLoader.load(getClass().getResource("/aboutGame.fxml"));
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("About");
        primaryStage.show();
    }
}
