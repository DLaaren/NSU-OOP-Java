package ru.nsu.fit.vinter.tetris.core.presenter;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ru.nsu.fit.vinter.tetris.core.model.Tetris;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Presenter extends Application {
    @FXML
    private Button exitButton1;
    @FXML
    private Button exitButton2;
    @FXML
    private GridPane grid;
    @FXML
    private Pane pane;
    @FXML
    private Label scores;

    private final SceneController sceneController = new SceneController();
    private Tetris game = new Tetris();
    private boolean isGameRunning = true;
    private boolean isGameStopped = false;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Presenter.class.getResource("/gameScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Tetris");
        stage.setScene(scene);
        stage.show();
    }

    public void callTaskTimer() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater( () -> {
                    if (isGameRunning == true && isGameStopped == false) {
                        //game.moveTetrominoDown();
                        ArrayList<Integer> whichRowsRemove = game.removeRow();
                        if (whichRowsRemove.size() > 0) {
                            //remove rows
                            game.updateScores(whichRowsRemove.size());
                        }
                        scores.setText("Scores: " + game.getScores());
                    }
                    if (isGameRunning == false) {
                        Text gameOverText = new Text("*Game Over*");
                        gameOverText.setFill(Color.RED);
                        gameOverText.setStyle("-fx-font: 70 arial");
                        gameOverText.setX(80);
                        gameOverText.setY(300);
                        pane.getChildren().add(gameOverText);

                        saveScores(game.getScores());
                    }
                });
            }
        };
        timer.schedule(task, 0, 600);
    }

    @FXML
    private void moveKeyPressed() {
        pane.setOnKeyPressed(KeyEvent -> {
            switch (KeyEvent.getCode()) {
                case RIGHT -> game.moveTetrominoRight();
                case LEFT -> game.moveTetrominoLeft();
                case DOWN -> game.moveTetrominoDown();
                case UP -> game.rotateTetromino();
            }
        });
    }

    public void saveScores(int scores) {
        //write scores in file
    }

    @FXML
    public void newGameButtonClicked(){
        callTaskTimer();
        saveScores(game.getScores());
        game = new Tetris();
    }

    @FXML
    public void exitGameButtonClicked() {
        saveScores(game.getScores());
        Platform.exit();
        System.exit(0);
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
