package org.example.holamundo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class HelloController {
    @FXML
    public TextArea textArea;
    @FXML
    private Label welcomeText;
    @FXML
    public void incrementarTamaño(ActionEvent actionEvent) {
        //textArea.setStyle("-fx-font-size: 15px");
        double currentSize = textArea.getFont().getSize();
        textArea.setStyle("-fx-font-size: "+(currentSize*1.3)+"px");
    }
    @FXML
    public void pasarMayus(ActionEvent actionEvent) {
        String textoCompleto = textArea.getText();
        String textoSeleccionado = textArea.getSelectedText();
        if (textoSeleccionado != null && !textoSeleccionado.isEmpty()) {
            String textoModificado = textoCompleto.replace(textoSeleccionado, textoSeleccionado.toUpperCase());
            textArea.setText(textoModificado);
        }
    }
}