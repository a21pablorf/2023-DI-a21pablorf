package org.example.javafxdialogos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.util.List;

public class HelloController {


    @FXML
    public void showChoiceDialog(ActionEvent actionEvent) {
        List<String> choices = List.of("a", "b", "c");
        ChoiceDialog<String> dialog = new ChoiceDialog<>("Options",choices);
        dialog.setTitle("Choice Dialog");
        dialog.setHeaderText("Look, a Choice Dialog");
        dialog.setContentText("Choose your letter:");
        dialog.showAndWait();
    }

    @FXML
    public void showInformationAlert(ActionEvent actionEvent) {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Look, an Information Dialog");
        alert.setContentText("I have a great message for you!");
        alert.showAndWait();
    }

    @FXML
    public void showTextInputDialog(ActionEvent actionEvent) {
        TextInputDialog dialog = new TextInputDialog("walter");
        dialog.setTitle("Text Input Dialog");
        dialog.setHeaderText("Look, a Text Input Dialog");
        dialog.setContentText("Please enter your name:");
        dialog.showAndWait();
    }

    @FXML
    public void showWarningAlert(ActionEvent actionEvent) {
        Alert alert=new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning Dialog");
        alert.setHeaderText("Look, a Warning Dialog");
        alert.setContentText("Careful with the next step!");
        alert.showAndWait();
    }

    @FXML
    public void showErrorAlert(ActionEvent actionEvent) {
        //Image image = new Image("iconoErro.png");
        try {
            File file = new File("iconoErro.png");
            Image image = new Image(file.toURI().toString());
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(64);
            imageView.setFitWidth(64);
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Look, an Error Dialog");
            alert.setContentText("Something went wrong!");

            //ImageView imageView = new ImageView(image);
            alert.setGraphic(imageView);
            alert.showAndWait();
        } catch (Exception e) {
            System.err.println("Error al cargar la imagen.");
        }

    }
}