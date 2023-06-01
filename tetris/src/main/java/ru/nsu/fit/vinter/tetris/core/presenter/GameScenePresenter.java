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
import javafx.stage.Stage;
import ru.nsu.fit.vinter.tetris.core.model.Tetris;
import ru.nsu.fit.vinter.tetris.core.model.Tetromino;

import java.io.IOException;
import java.util.*;

public class GameScenePresenter extends Application {
    @FXML
    private GridPane grid;
    @FXML
    private Pane pane;
    @FXML
    private Label scores;
    @FXML
    private Label gameOverText;

    private final Map<String, Color> mapColor =
            Map.of(
                    "I", Color.LIGHTSKYBLUE,
                    "J", Color.CORNFLOWERBLUE,
                    "L", Color.ORANGE,
                    "S", Color.GREEN,
                    "T", Color.DEEPPINK,
                    "Z", Color.RED,
                    "O", Color.YELLOW
            );

    private Tetris game = new Tetris();
    private final int blockSize = 40;
    private boolean isNotGameOver = true;
    private static final Color GARBAGE_COLOR = Color.DARKBLUE;
    private static final int FRAME_DELAY_MILLIS = 500;

    private Timer timer;

    public GameScenePresenter() throws IOException {
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameScenePresenter.class.getResource("/gameScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Tetris");
        stage.setScene(scene);
        stage.show();
    }

//    private void

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
            drawBackground();
        });

        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                game.removeRows();
                game.moveTetrominoDown();
                Platform.runLater(() -> {
                    drawBackground();
                    drawTetromino();

                    scores.setText("Scores: " + game.getScores());
                    if (!isNotGameOver) {
                        gameOverText.setText("*Game Over*");
                        gameOverText.setStyle("-fx-font: 70 arial");
                        try {
                            game.saveScores(game.getScores());
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
            }
        };
        timer.schedule(task, 0, FRAME_DELAY_MILLIS);
    }

    public void stopTimerTask() {
        if (timer!= null) timer.cancel();
    }

    public void drawTetromino() {
        if (game.getCurrTetromino() == null) {
            isNotGameOver = game.generateTetromino();
            if (!isNotGameOver) return;
        } else {
            ArrayList<Node> rectanglesRemoved = new ArrayList<>();
            for (Node rect : grid.getChildren()) {
                if (rect instanceof Rectangle) {
                    if (((Rectangle) rect).getFill() != GARBAGE_COLOR) {
                        rectanglesRemoved.add(rect);
                    }
                }
            }
            grid.getChildren().removeAll(rectanglesRemoved);
        }

        Tetromino currTetromino = game.getCurrTetromino();
        String shapeName = currTetromino.getName();

        Rectangle a = new Rectangle(blockSize, blockSize, mapColor.get(shapeName));
        Rectangle b = new Rectangle(blockSize, blockSize, mapColor.get(shapeName));
        Rectangle c = new Rectangle(blockSize, blockSize, mapColor.get(shapeName));
        Rectangle d = new Rectangle(blockSize, blockSize, mapColor.get(shapeName));
        grid.add(a, currTetromino.getA().x(), currTetromino.getA().y());
        grid.add(b, currTetromino.getB().x(), currTetromino.getB().y());
        grid.add(c, currTetromino.getC().x(), currTetromino.getC().y());
        grid.add(d, currTetromino.getD().x(), currTetromino.getD().y());
    }

    public void drawBackground() {
        List<Node> rectanglesRemoved = new ArrayList<>();
        for (Node rect : grid.getChildren()) {
            if (rect instanceof Rectangle) {
                if (((Rectangle) rect).getFill() == GARBAGE_COLOR) {
                    rectanglesRemoved.add(rect);
                }
            }
        }

        grid.getChildren().removeAll(rectanglesRemoved);
        int[][] mesh = game.getMesh();
        for (int i = Tetris.SIZEY - 1; i >= 0; i--) {
            for (int j = 0; j < Tetris.SIZEX; j++) {
                if (mesh[i][j] == 1) {
                    Rectangle rect = new Rectangle(blockSize, blockSize, GARBAGE_COLOR);
                    grid.add(rect, j, i);
                }
            }
        }
    }

    @FXML
    public void newGameButtonClicked() throws IOException {
        game.saveScores(game.getScores());
        stopTimerTask();
        gameOverText.setText("");
        isNotGameOver = true;
        game = new Tetris();
        initGame();
    }

    @FXML
    public void exitGameButtonClicked() throws IOException {
        game.saveScores(game.getScores());
        stopTimerTask();
        Platform.exit();
    }

    @FXML
    public void highScoresButtonClicked() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/highScores.fxml")));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("HighScores");
        primaryStage.show();
    }

    @FXML
    public void aboutGameButtonClicked() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/aboutGame.fxml")));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("About");
        primaryStage.show();
    }

}
