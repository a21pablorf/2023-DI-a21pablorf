package org.example.ejercicio2_paneles_javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MenuBarExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 400, 300);

        // Crear la barra de menús
        MenuBar menuBar = new MenuBar();

        // Menú Archivo
        Menu menuArchivo = new Menu("Archivo");
        MenuItem itemNuevo = new MenuItem("Nuevo");
        MenuItem itemAbrir = new MenuItem("Abrir");
        MenuItem itemGuardar = new MenuItem("Guardar");
        MenuItem itemSalir = new MenuItem("Salir");
        menuArchivo.getItems().addAll(itemNuevo, itemAbrir, itemGuardar, new SeparatorMenuItem(), itemSalir);
        itemAbrir.setOnAction(event -> mostrarAbrir(primaryStage));
        itemSalir.setOnAction(event -> System.exit(0));

        // Menú Ayuda
        Menu menuAyuda = new Menu("Ayuda");
        MenuItem itemAcercaDe = new MenuItem("Acerca de...");
        menuAyuda.getItems().add(itemAcercaDe);
        itemAcercaDe.setOnAction(event -> mostrarAcercaDe());

        DatePicker datePicker = new DatePicker();
        root.setCenter(datePicker);

        Label label = new Label("dddd");
        root.setBottom(label);

        //listener dataPicker
        datePicker.setOnAction(event -> label.setText(String.valueOf(datePicker.getValue())));

        // Agregar menús a la barra de menús
        menuBar.getMenus().addAll(menuArchivo, menuAyuda);

        // Agregar la barra de menús al layout principal
        root.setTop(menuBar);

        primaryStage.setTitle("Ejemplo de Barra de Menús");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void mostrarAcercaDe() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Acerca de");
        alert.setHeaderText(null);
        alert.setContentText("Esta es una aplicación de ejemplo de JavaFX con una barra de menús.");
        alert.showAndWait();
    }

    private void mostrarAbrir(Stage primaryStage){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.showOpenDialog(primaryStage);

    }



    public static void main(String[] args) {
        launch();
    }
}