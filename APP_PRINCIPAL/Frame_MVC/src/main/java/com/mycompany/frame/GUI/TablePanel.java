package com.mycompany.frame.GUI;

import com.mycompany.frame.Model.Person;

import javax.swing.*;
import java.awt.BorderLayout;
import java.util.List;

public class TablePanel extends JPanel {
    private JTable table;
    private PersonTableModel personTableModel;
    public TablePanel() {
        personTableModel = new PersonTableModel();
        table = new JTable(personTableModel);
        setLayout(new BorderLayout());
        add(new JScrollPane(table),BorderLayout.CENTER);
    }
    public void setData(List<Person> personList) {
        personTableModel.setData(personList);
    }
    // para notificar á vista de que o modelo de datos cambiou
    public void refresh() {
        personTableModel.fireTableDataChanged();
    }
}
