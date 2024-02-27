package org.example.listatarefasjavafx;

import datamodel.TarefasFicheiro;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("ventaPrincipal.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        try {
            TarefasFicheiro.getInstance().gardarTarefas();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void init() throws Exception {
        try {
            TarefasFicheiro.getInstance().lerTarefas();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch();
    }
}