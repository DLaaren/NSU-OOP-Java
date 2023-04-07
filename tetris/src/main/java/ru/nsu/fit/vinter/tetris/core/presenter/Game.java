package ru.nsu.fit.vinter.tetris.core.presenter;

import javafx.application.Application;
import javafx.stage.Stage;


public class Game extends Application {
    /*public static final int blockSize = 25;
    public static int horizontalSizeField = 10 * blockSize;
    public static int verticalSizeField = 20 * blockSize;
    public static int horizontalSizeSidebar = 5 * blockSize;
    public static int verticalSizeSidebar = 20 * blockSize;
    public static int[][] fieldMesh = new int[horizontalSizeField][verticalSizeField];
    public static int[][] sidebarMesh = new int[horizontalSizeSidebar][verticalSizeSidebar];*/

    Parent root = FXMLLoader.load(getClass().getResource("/gameStage.fxml"));

    @Override
    public void start(Stage primaryStage) throws Exception {
    }

}
