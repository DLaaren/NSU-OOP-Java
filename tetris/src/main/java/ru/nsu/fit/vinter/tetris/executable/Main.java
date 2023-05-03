package ru.nsu.fit.vinter.tetris.executable;

import javafx.application.Application;
import ru.nsu.fit.vinter.tetris.core.presenter.GameScenePresenter;

public class Main {
    public static void main(String[] args) {
        Application.launch(GameScenePresenter.class);
    }
}
