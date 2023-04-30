package ru.nsu.fit.vinter.tetris.core.presenter;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ru.nsu.fit.vinter.tetris.core.model.Tetris;
import ru.nsu.fit.vinter.tetris.core.model.Tetromino;

import java.io.IOException;
import java.util.*;

import static javafx.scene.paint.Color.LIGHTSKYBLUE;

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
    private final int blockSize = 40;
    private boolean isTimerCalled = false;

    private Timer timer;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Presenter.class.getResource("/gameScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Tetris");
        stage.setScene(scene);
        stage.show();
    }

    public void callTaskTimer() {
        timer = new Timer();

        pane.getScene().getWindow().setOnCloseRequest(e -> close());

        pane.getScene().setOnKeyPressed(KeyEvent -> {
            switch (KeyEvent.getCode()) {
                case D -> game.moveTetrominoRight();
                case A -> game.moveTetrominoLeft();
                case S -> game.moveTetrominoDown();
                case W -> game.rotateTetromino();
            }
            drawTetromino();
        });

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater( () -> {
                    if (isGameRunning == true && isGameStopped == false) {
                        if (game.getCurrTetromino() == null) {
                            game.generateTetromino();
                        }
                        drawTetromino();
                        game.moveTetrominoDown();
                        ArrayList<Integer> whichRowsRemove = game.removeRow();
                        if (whichRowsRemove.size() > 0) {
                            //removeRows(whichRowsRemove);
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
        timer.schedule(task, 0, 1000);
    }

    public void close() {
        timer.cancel();
    }

    public void drawTetromino() {
        Tetromino currTetromino = game.getCurrTetromino();
        String shapeName = currTetromino.getName();
        Map<String, Color> mapColor = Map.of("I", Color.LIGHTSKYBLUE, "J", Color.BLUE, "L", Color.ORANGE,
                "S", Color.GREEN,"T", Color.DEEPPINK, "Z", Color.RED, "O", Color.YELLOW);
        Rectangle a = new Rectangle(blockSize, blockSize, mapColor.get(shapeName));
        Rectangle b = new Rectangle(blockSize, blockSize, mapColor.get(shapeName));
        Rectangle c = new Rectangle(blockSize, blockSize, mapColor.get(shapeName));
        Rectangle d = new Rectangle(blockSize, blockSize, mapColor.get(shapeName));
        if (grid.getChildren().size() > 1) {
            grid.getChildren().remove(grid.getChildren().size() - 4, grid.getChildren().size());
        }
        grid.add(a, currTetromino.getA().getX(), currTetromino.getA().getY());
        grid.add(b, currTetromino.getB().getX(), currTetromino.getB().getY());
        grid.add(c, currTetromino.getC().getX(), currTetromino.getC().getY());
        grid.add(d, currTetromino.getD().getX(), currTetromino.getD().getY());
    }


    public void removeRows(ArrayList<Integer> whichRowsRemove) {
        Set<Node> deletedRectangles = new HashSet<>();
        Node mesh = grid.getChildren().get(0);
        /*for (Node rect : grid.getChildren()) {
            Integer currRowIndex = GridPane.getRowIndex(rect);
            int row;
            row = currRowIndex == null ? 0 : currRowIndex;
            if (row == y) {
                deletedRectangles.add(rect);
            }
        }*/
        grid.getChildren().removeAll(deletedRectangles);
        grid.getChildren().add(0,mesh);
    }

    public void saveScores(int scores) {
        //write scores in file
    }

    @FXML
    public void newGameButtonClicked(){
        if (isTimerCalled == false) {
            callTaskTimer();
            isTimerCalled = true;
        }
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
