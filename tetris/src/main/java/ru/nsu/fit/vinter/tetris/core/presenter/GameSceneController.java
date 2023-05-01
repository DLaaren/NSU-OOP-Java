package ru.nsu.fit.vinter.tetris.core.presenter;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

public class GameSceneController extends Application {
    @FXML
    private GridPane grid;
    @FXML
    private Pane pane;
    @FXML
    private Label scores;
    @FXML
    private Label gameOverText;

    private Tetris game = new Tetris();
    private final int blockSize = 40;
    private boolean isNotGameOver = true;

    private Timer timer;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameSceneController.class.getResource("/gameScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Tetris");
        stage.setScene(scene);
        stage.show();
    }

    public void initGame() {
        grid.getChildren().remove(1, grid.getChildren().size());
        pane.getScene().getWindow().setOnCloseRequest(event -> stopTimerTask());
        pane.getScene().setOnKeyPressed(keyEvent -> {
            switch (keyEvent.getCode()) {
                case D -> game.moveTetrominoRight();
                case A -> game.moveTetrominoLeft();
                case S -> game.moveTetrominoDown();
                case W -> game.rotateTetromino();
            }
            drawTetromino();
        });

        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater( () -> {
                    game.moveTetrominoDown();
                    drawTetromino();
                    ArrayList<Integer> whichRowsRemove = game.removeRow();
                    if (whichRowsRemove.size() > 0) {
                        //removeRows(whichRowsRemove);
                        game.updateScores(whichRowsRemove.size());
                    }
                    scores.setText("Scores: " + game.getScores());
                    if (!isNotGameOver) {
                        gameOverText.setText("*Game Over*");
                        gameOverText.setStyle("-fx-font: 70 arial");
                        saveScores(game.getScores());
                    }
                });
            }
        };
        timer.schedule(task, 0, 300);
    }

    public void stopTimerTask() {
        if (timer!= null) timer.cancel();
    }

    public void drawTetromino() {
        if (game.getCurrTetromino() == null) {
            isNotGameOver = game.generateTetromino();
            if (!isNotGameOver) return;
        } else {
            if (grid.getChildren().size() > 1) {
                grid.getChildren().remove(grid.getChildren().size() - 4, grid.getChildren().size());
            }
        }
        Tetromino currTetromino = game.getCurrTetromino();
        String shapeName = currTetromino.getName();
        Map<String, Color> mapColor = Map.of("I", Color.LIGHTSKYBLUE, "J", Color.BLUE, "L", Color.ORANGE,
                "S", Color.GREEN,"T", Color.DEEPPINK, "Z", Color.RED, "O", Color.YELLOW);
        Rectangle a = new Rectangle(blockSize, blockSize, mapColor.get(shapeName));
        Rectangle b = new Rectangle(blockSize, blockSize, mapColor.get(shapeName));
        Rectangle c = new Rectangle(blockSize, blockSize, mapColor.get(shapeName));
        Rectangle d = new Rectangle(blockSize, blockSize, mapColor.get(shapeName));
        grid.add(a, currTetromino.getA().x(), currTetromino.getA().y());
        grid.add(b, currTetromino.getB().x(), currTetromino.getB().y());
        grid.add(c, currTetromino.getC().x(), currTetromino.getC().y());
        grid.add(d, currTetromino.getD().x(), currTetromino.getD().y());
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
        saveScores(game.getScores());
        stopTimerTask();
        gameOverText.setText("");
        isNotGameOver = true;
        game = new Tetris();
        initGame();
    }

    @FXML
    public void exitGameButtonClicked() {
        saveScores(game.getScores());
        stopTimerTask();
        Platform.exit();
    }

    @FXML
    public void highScoresButtonClicked() throws IOException {
        stopTimerTask();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/highScores.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("HighScores");
        primaryStage.show();
    }

    @FXML
    public void aboutGameButtonClicked() throws IOException {
        stopTimerTask();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/aboutGame.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("About");
        primaryStage.show();
    }

}
