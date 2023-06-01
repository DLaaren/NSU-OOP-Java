package ru.nsu.fit.vinter.carFactory.executable;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import ru.nsu.fit.vinter.carFactory.core.factory.CarFactory;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class FactorySceneController {
    private CarFactory carFactory;
    @FXML
    private Label budgetLabel;
    @FXML
    private ProgressBar motorStorageItems;
    @FXML
    private ProgressBar accessoriesStorageItems;
    @FXML
    private ProgressBar carBodyStorageItems;
    @FXML
    private ProgressBar carStorageItems;

    @FXML
    public void startButtonClicked() throws IOException {
        carFactory = new CarFactory();
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater( () -> {
                    budgetLabel.setText("Budget = " + carFactory.getBudget());
                    motorStorageItems.setProgress((double) carFactory.getMotorStorage().getItemCount() / carFactory.getMotorStorage().getStorageCapacity());
                    accessoriesStorageItems.setProgress((double) carFactory.getAccessoriesStorage().getItemCount() / carFactory.getAccessoriesStorage().getStorageCapacity());
                    carBodyStorageItems.setProgress((double) carFactory.getCarBodyStorage().getItemCount() / carFactory.getCarBodyStorage().getStorageCapacity());
                    carStorageItems.setProgress((double) carFactory.getCarStorage().getItemCount() / carFactory.getCarStorage().getStorageCapacity());
                });
            }
        };
        timer.schedule(timerTask, 0, 100);
    }

    @FXML
    public void exitButtonClicked() {
        carFactory.stopCarFactory();
    }
}
