/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio1.listas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author a21pablorf
 */
class MainFrame extends JFrame {

    private DefaultListModel nombres = new DefaultListModel();
    private JList listaNom = new JList();

    private JButton addBtn = new JButton("Agregar");
    private JButton deleteBtn = new JButton("Borrar");
    private JTextField txt = new JTextField(10);

    public MainFrame() {
        super("Ejercicio Lista");

        setLayout(new BorderLayout());

        nombres.addElement("Ada");
        nombres.addElement("Erea");
        nombres.addElement("Navia");

        listaNom.setModel(nombres);

        listaNom.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaNom.setSelectedIndex(0);

        JPanel pan = new JPanel();
        pan.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        pan.setLayout(new GridLayout(1, 3, 4, 4));

        addBtn.setEnabled(false);

        //Funcionalidad Boton Borrar:
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int selected = listaNom.getSelectedIndex();
                if (listaNom.getSelectedIndex() == listaNom.getLastVisibleIndex()) {
                    nombres.remove(listaNom.getSelectedIndex());
                    listaNom.setSelectedIndex(listaNom.getLastVisibleIndex());
                } else {
                    nombres.remove(listaNom.getSelectedIndex());
                    listaNom.setSelectedIndex(selected);
                }
                if (nombres.size() == 0) {
                    deleteBtn.setEnabled(false);
                }
            }
        };

        //Boton añadir
        ActionListener a = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                nombres.addElement(txt.getText());
                listaNom.setSelectedIndex(listaNom.getLastVisibleIndex());
                txt.setText("");
                deleteBtn.setEnabled(true);
            }
        };

        //Campo de texto y boton añadir
        DocumentListener dl = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent de) {
                addBtn.setEnabled(true);
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                if (txt.getText().equals("")) {
                    addBtn.setEnabled(false);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                if (txt.getText().equals("")) {
                    addBtn.setEnabled(false);
                } else {
                    addBtn.setEnabled(true);
                }
            }

        };

        txt.getDocument().addDocumentListener(dl);
        txt.addActionListener(a);

        deleteBtn.addActionListener(al);
        addBtn.addActionListener(a);

        pan.add(deleteBtn);
        pan.add(txt);
        pan.add(addBtn);

        add(listaNom, BorderLayout.CENTER);
        add(pan, BorderLayout.PAGE_END);

        setSize(400, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
