package com.mycompany.frame.GUI;

import com.mycompany.frame.Model.EmploymentCategory;
import com.mycompany.frame.Model.Person;

import javax.swing.*;
import javax.swing.event.PopupMenuListener;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class TablePanel extends JPanel {
    private JTable table;
    private JPopupMenu popup;
    private PersonTableModel personTableModel;
    private TableModelListener tableModelListener;

    public TablePanel() {
        personTableModel = new PersonTableModel();
        table = new JTable(personTableModel);
        setLayout(new BorderLayout());
        add(new JScrollPane(table),BorderLayout.CENTER);

        popup=new JPopupMenu();

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point row=e.getPoint();
                int p=table.rowAtPoint(row);
                table.setRowSelectionInterval(p,p);
            }
        });

        table.setDefaultRenderer(EmploymentCategory.class,new EmploymentCategoryRender());

        JMenuItem menuBorrar=new JMenuItem("Borrar fila");
        menuBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        popup.add(menuBorrar);



//        popup.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//
//            }
//        });

    }
    public void setData(List<Person> personList) {
        personTableModel.setData(personList);
    }
    // para notificar á vista de que o modelo de datos cambiou
    public void refresh() {
        personTableModel.fireTableDataChanged();
    }
}
