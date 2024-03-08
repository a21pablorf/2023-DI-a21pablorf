package org.example.listatarefasjavafx;

import datamodel.Tarefa;
import datamodel.TarefasFicheiro;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.util.Callback;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controlador implements Initializable {
    //private List<Tarefa> tarefas;
    private ObservableList<Tarefa> tarefas;

    @FXML
    private BorderPane mainBorderPane;
    @FXML
    private TextArea descripcionTarefa;
    @FXML
    private Label infoData;
    @FXML
    private ListView tarefasListView;
    @FXML
    private MenuItem novaTarefa;
    @FXML
    private MenuItem sair;
    @FXML
    private Label data;
    private ContextMenu listContextMenu;

    public ObservableList<Tarefa> getTarefasObservableList() {
        return tarefas;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tarefasListView.getSelectionModel().selectedItemProperty().addListener((observableValue, tarefaAntiga, tarefaNova) -> {
            Tarefa tarefa = (Tarefa) tarefasListView.getSelectionModel().getSelectedItem();
            descripcionTarefa.setText(tarefa.getDetalles());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
            infoData.setText(tarefa.getDataLimite().format(formatter));
        });

        tarefasListView.setItems(TarefasFicheiro.getInstance().getTarefas());
        //Primer elemento de la lista seleccionado
        tarefasListView.getSelectionModel().selectFirst();

        tarefasListView.setCellFactory(new Callback<ListView<Tarefa>, ListCell<Tarefa>>() {
            @Override
            public ListCell<Tarefa> call(ListView<Tarefa> p) {
                ListCell<Tarefa> cela = new ListCell<>() {
                    // este método execútase cada vez que se repinta unha cela
                    @Override
                    protected void updateItem(Tarefa t, boolean empty) {
                    // execútase o método da clase ancestra para manter o estilo
                    // e comportamento por defecto
                        super.updateItem(t, empty);
                        if (empty) {
                            setText(null);
                        } else {
                            setText(t.getDescripcion());
                            if (!t.getDataLimite().isAfter(LocalDate.now())) {
                                setTextFill(Color.RED);
                            }
                            if(t.getDataLimite().isEqual(LocalDate.now().plusDays(1))){
                                setTextFill(Color.BLUE);
                            }
                        }
                    }
                };
                return cela;
            }
        });
        novaTarefa.setOnAction(actionEvent -> {
            mostrarDialogoNovaTarefa();
        });

        listContextMenu = new ContextMenu();
        MenuItem eliminarMenuItem = new MenuItem("Eliminar");
        eliminarMenuItem.setOnAction(actionEvent -> {
            Tarefa tarefa = (Tarefa) tarefasListView.getSelectionModel().getSelectedItem();
            eliminarTarefa(tarefa);
        });
        MenuItem editarMenuItem = new MenuItem("Editar");
        editarMenuItem.setOnAction(actionEvent -> {
            Tarefa tarefa = (Tarefa) tarefasListView.getSelectionModel().getSelectedItem();
            editarTarefa(tarefa);
        });
        listContextMenu.getItems().addAll(eliminarMenuItem, editarMenuItem);
        tarefasListView.setContextMenu(listContextMenu);
    }

    public void mostrarDialogoNovaTarefa(){
        Dialog<ButtonType> dialog = new Dialog<>();

        dialog.initOwner(mainBorderPane.getScene().getWindow());
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("novaTarefaDialogo.fxml"));

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (Exception e) {
            System.out.println("Non se puido cargar o diálogo: " + e.getMessage());
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            NovaTarefaDialogoController controller = fxmlLoader.getController();
            controller.procesarResultado();
            tarefasListView.getSelectionModel().selectLast();
            System.out.println("OK pressed");
        } else {
            System.out.println("Cancel pressed");
        }
    }

    public void eliminarTarefa(Tarefa tarefa){
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Eliminar tarefa");
        alerta.setHeaderText("Eliminar tarefa: " + tarefa.getDescripcion());
        alerta.setContentText("Estás seguro de que queres eliminar a tarefa?");
        Optional<ButtonType> resultado = alerta.showAndWait();
        if(resultado.isPresent() && resultado.get() == ButtonType.OK){
            TarefasFicheiro.getInstance().borrarTarefa(tarefa);
        }
    }

    public void editarTarefa(Tarefa tarefa){
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("novaTarefaDialogo.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (Exception e) {
            System.out.println("Non se puido cargar o diálogo: " + e.getMessage());
            e.printStackTrace();
            return;
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        NovaTarefaDialogoController controller = fxmlLoader.getController();
        controller.editarTarefa(tarefa);
        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            controller.procesarResultado();
            tarefasListView.getSelectionModel().selectLast();
            System.out.println("OK pressed");
        } else {
            System.out.println("Cancel pressed");
        }
    }
}