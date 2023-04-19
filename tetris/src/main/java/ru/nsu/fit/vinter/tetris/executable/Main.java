package ru.nsu.fit.vinter.tetris.executable;

import javafx.application.Application;
import ru.nsu.fit.vinter.tetris.core.presenter.Presenter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Presenter presenter = new Presenter();
        Application.launch(Presenter.class);
    }
}
