package ru.nsu.fit.vinter.tetris.core.controller;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import ru.nsu.fit.vinter.tetris.core.model.Tetris;

import java.io.IOException;

public class Controller extends Application {
    @FXML
    private Button exitButton1;
    @FXML
    private Button exitButton2;
    @FXML
    private GridPane grid;

    private final SceneController sceneController = new SceneController();
    private Tetris game = new Tetris();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Controller.class.getResource("/gameScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Tetris");
        stage.setScene(scene);
        stage.show();
    }

    public void saveScores() {

    }

    @FXML
    public void newGameButtonClicked() throws IOException {
        saveScores();
        game = new Tetris();
        Rectangle rect = new Rectangle(0,0,40,40);
        grid.getChildren().add(rect);
    }

    @FXML
    public void exitGameButtonClicked() throws IOException {
        saveScores();
        Platform.exit();
    }

    @FXML
    public void highScoresButtonClicked() throws IOException {
        sceneController.setHighScoresScene();
    }

    @FXML
    public void aboutGameButtonClicked() throws IOException {
        sceneController.setAboutGameScene();
    }

    @FXML
    public void getBackButtonCLicked() {
        if (exitButton1 != null) {
            Stage highScoresStage = (Stage) exitButton1.getScene().getWindow();
            highScoresStage.close();
        }
        if (exitButton2 != null) {
            Stage aboutGameStage = (Stage) exitButton2.getScene().getWindow();
            aboutGameStage.close();
        }
    }
}
