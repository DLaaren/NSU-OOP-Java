package ru.nsu.fit.vinter.tetris.core.presenter;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import ru.nsu.fit.vinter.tetris.core.model.Game;

import java.io.IOException;

public class Presenter extends Application {
    public Button exitButton1;
    public Button exitButton2;
    public GridPane grid;

    private final SceneController sceneController = new SceneController();;
    private Game game = new Game();

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/game.fxml"));
        primaryStage.setTitle("Tetris");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    public void update() {
        ///
        game.updateGameField();
        //
    }

    @FXML
    public void moveRight() {
        if (game.getCurrTetromino().getRightPoint().getX() > 10 || game.getCurrTetromino().getRightPoint().getX() < 0) {
            //throw exception
        } else if (game.getCurrTetromino().getRightPoint().getX() == 10) {
            return;
        } else {
            game.getCurrTetromino().moveRightTetromino();

        }
    }

    @FXML
    public void moveLeft() {
        if (game.getCurrTetromino().getRightPoint().getX() < 0 || game.getCurrTetromino().getRightPoint().getX() > 10) {
            //throw exception
        } else if (game.getCurrTetromino().getRightPoint().getX() == 0) {
            return;
        } else {
            game.getCurrTetromino().moveLeftTetromino();

        }
    }

    @FXML
    public void moveDown() {
        if (game.getCurrTetromino().getRightPoint().getY() < 0 || game.getCurrTetromino().getRightPoint().getY() > 20) {
            //throw exception
        } else if (game.getCurrTetromino().getRightPoint().getY() == 0) {
            return;
        } else {
            game.getCurrTetromino().moveDownTetromino();

        }
    }

    @FXML
    public void rotateLeft() {

    }

    @FXML
    public void rotateRight() {

    }

    @FXML
    public void newGameButtonClicked() throws IOException {
        game.saveScores();
        game = new Game();
    }

    @FXML
    public void exitGameButtonClicked() throws IOException {
        game.saveScores();
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
