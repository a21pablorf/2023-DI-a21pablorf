package org.example.ejercicio2_paneles_javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Ej1 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Button[] buttons = new Button[21];
        FlowPane pane=new FlowPane();

        for (int i = 1; i < 21; i++) {
            buttons[i]=new Button(String.valueOf(i));
            pane.getChildren().add(buttons[i]);
        }

        Scene scene = new Scene(pane, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}


