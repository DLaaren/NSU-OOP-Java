package ru.nsu.fit.vinter.chat.client.core;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientChatController implements Initializable {
    private ClientNetworkCommunication clientNetworkCommunication;
    @FXML
    TextField messageField;
    @FXML
    TextArea chatArea;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clientNetworkCommunication = new ClientNetworkCommunication(args -> {
            chatArea.appendText((String)args[0]);
        });
    }

    public void setName() {
        clientNetworkCommunication.sendMessage("/setname " + messageField.getText());
        messageField.clear();
        messageField.requestFocus();
    }

    public void changeName() {
        clientNetworkCommunication.sendMessage("/changename " + messageField.getText());
        messageField.clear();
        messageField.requestFocus();
    }

    public void sendMessageAction(ActionEvent event) {
        clientNetworkCommunication.sendMessage(messageField.getText());
        messageField.clear();
        messageField.requestFocus();
    }

    public void exitAction() {
        clientNetworkCommunication.close();
        Platform.exit();
    }
}
