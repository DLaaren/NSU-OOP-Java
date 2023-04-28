package ru.nsu.fit.vinter.tetris.executable;

import javafx.application.Application;
import ru.nsu.fit.vinter.tetris.core.controller.Controller;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        Application.launch(Controller.class);
    }
}
