package org.example.olamundo;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class HelloController {
    int contador=0;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        contador++;
        welcomeText.setText(String.valueOf(contador));
    }

    @FXML
    protected void onButtonClick() {
        Platform.exit();
    }
}