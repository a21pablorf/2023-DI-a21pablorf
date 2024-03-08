package org.example.listatarefasjavafx;

import datamodel.Tarefa;
import datamodel.TarefasFicheiro;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class NovaTarefaDialogoController {
    @FXML
    private TextField descripcionTarefa;
    @FXML
    private TextArea detallesTarefa;
    @FXML
    private DatePicker infoData;

    public Tarefa procesarResultado(){
        String descripcion = descripcionTarefa.getText().trim();
        String detalles = detallesTarefa.getText().trim();
        LocalDate data = infoData.getValue();

        Tarefa novaTarefa = new Tarefa(descripcion, detalles, data);
        TarefasFicheiro.getInstance().engadirTarefa(novaTarefa);
        return novaTarefa;
    }

    public void editarTarefa(Tarefa tarefa){
        descripcionTarefa.setText(tarefa.getDescripcion());
        detallesTarefa.setText(tarefa.getDetalles());
        infoData.setValue(tarefa.getDataLimite());


    }
}
