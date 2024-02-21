package org.example.javafxproperties;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;

public class HelloController {

    @FXML
    private Slider slider;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private Button decreaseButton;
    @FXML
    private Button increaseButton;


    public void initialize() {
        progressBar.setMaxWidth(Double.MAX_VALUE);
        // Vincular el valor del Slider al IntegerProperty(La propiedad es la que maneja el valor del slider, para que el progress lo entienda)
        slider.valueProperty().bindBidirectional(progressBar.progressProperty());

    }

    @FXML
    public void increaseProgress(ActionEvent actionEvent) {
        double newValue = progressBar.getProgress() + 0.1;
        if (newValue <= 1.0) {
            progressBar.setProgress(newValue);
        }
    }

    @FXML
    public void decreaseProgress(ActionEvent actionEvent) {
        double newValue = progressBar.getProgress() - 0.1;
        if (newValue >= 0.0) {
            progressBar.setProgress(newValue);
        }
    }
}