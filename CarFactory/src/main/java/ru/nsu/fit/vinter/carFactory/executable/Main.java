package ru.nsu.fit.vinter.carFactory.executable;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class Main extends Application {
    @FXML
    private Pane pane;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/configInterface.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Settings");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void applyButtonClicked() throws IOException {
        //save settings
        Properties properties = new Properties();
        properties.load(this.getClass().getResourceAsStream("/config.properties"));
        for (Node node : pane.getChildren()) {
            if (node instanceof Label) {
                String key = node.getId();
                String value = properties.getProperty(key);
                for (Node child : ((Label) node).getChildrenUnmodifiable()) {
                    if (child instanceof TextField) {
                        value = ((TextField) child).getText();
                    }
                }
                if (value == null || value.equals("")) {
                    System.out.println("Enter all parameters and try again");
                    return;
                }
                try {
                    Integer.parseInt(value);
                } catch(NumberFormatException e) {
                    System.out.println("Check entered parameters and try again");
                    return;
                }
                System.out.println(key);
                System.out.println(value);
                properties.setProperty(key, value);
            }
        }
        System.out.println("Properties applied");
    }

    @FXML
    public void startButtonClicked() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/factory.fxml")));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Factory");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
