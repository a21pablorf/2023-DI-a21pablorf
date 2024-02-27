package org.example.listatarefasjavafx;

import datamodel.Tarefa;
import datamodel.TarefasFicheiro;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controlador implements Initializable {
    private List<Tarefa> tarefas;



    @FXML
    private TextArea descripcionTarefa;
    @FXML
    private Label data;
    @FXML
    private Label infoData;
    @FXML
    private ListView tarefasListView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Primer elemento de la lista seleccionado
        tarefasListView.getSelectionModel().selectFirst();

        tarefasListView.getItems().setAll(TarefasFicheiro.getInstance().getTarefas());


        tarefasListView.getSelectionModel().selectedItemProperty().addListener((observableValue, tarefaAntiga, tarefaNova) -> {
            Tarefa tarefa = (Tarefa) tarefasListView.getSelectionModel().getSelectedItem();
            descripcionTarefa.setText(tarefa.getDetalles());
            data.setText(tarefa.getDataLimite().toString());
        });
    }


}