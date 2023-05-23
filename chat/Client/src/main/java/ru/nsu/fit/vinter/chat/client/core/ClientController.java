package ru.nsu.fit.vinter.chat.client.core;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable {
    private Network network;
    @FXML
    TextField messageField;
    @FXML
    TextArea chat;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        network = new Network(args -> {
            chat.appendText((String)args[0]);
        });
    }

    public void sendMessageAction(ActionEvent event) {
        network.sendMessage(messageField.getText());
        messageField.clear();
        messageField.requestFocus();
    }
}
