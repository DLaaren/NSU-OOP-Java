package ru.nsu.fit.vinter.tetris.executable;

import javafx.application.Application;
import ru.nsu.fit.vinter.tetris.core.presenter.Game;

public class Main {
    public static void main(String[] args) {
        Application.launch(Game.class, args);
    }
}
