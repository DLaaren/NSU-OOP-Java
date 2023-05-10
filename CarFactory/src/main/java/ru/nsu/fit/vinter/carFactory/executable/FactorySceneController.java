package ru.nsu.fit.vinter.carFactory.executable;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import ru.nsu.fit.vinter.carFactory.core.factory.CarFactory;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class FactorySceneController {
    private CarFactory carFactory;

    @FXML
    private Button exitButton;

    @FXML
    public void startButtonClicked() throws IOException {
        carFactory = new CarFactory();
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater( () -> {
                    //
                    System.out.println();
                });
            }
        };
        timer.schedule(timerTask, 0, 600);
    }

    @FXML
    public void exitButtonClicked() {
        carFactory.stopCarFactory();
        ((Stage)exitButton.getScene().getWindow()).close();
    }
}
