/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.frame.GUI;

import com.mycompany.frame.Controller.Controller;
import com.mycompany.frame.Model.Person;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.swing.*;

/**
 * @author a21pablorf
 */
public class MainFrame extends JFrame {
    // Declarar os compoñentes como variables privadas de instancia

    private JButton aceptarButton;
    private TextPanel txtPan;
    private Toolbar tl;
    private FormPanel fp;
    private TablePanel tp;
    private JFileChooser fileChooser;
    private JFileChooser fileChooserImp;
    private Controller controller;

    public MainFrame() {
        super("Ola Mundo!");
        // Establecer o Layout
        setLayout(new BorderLayout());
        // Inicializar os compoñentes
        aceptarButton = new JButton("Aceptar");
        txtPan = new TextPanel();
        tl = new Toolbar(MainFrame.this);
        fp = new FormPanel();
        tp=new TablePanel();
        controller=new Controller();

        fileChooser=new JFileChooser();
        tp.setData(controller.getPeople());

        //Actualizar estado TABLA


        setJMenuBar(createMenuBar());

        fp.setFormListener(new FormListener() {
            @Override
            public void TextEmitted(FormEvent e) {
                controller.addPerson(e);
                tp.refresh();
            }
        });


        ///TOOLBAR
        tl.setToolbarListener(new ToolbarListener() {
            @Override
            public void importData() {
                int n=fileChooser.showOpenDialog(MainFrame.this);
                if (n == JFileChooser.APPROVE_OPTION) {
                    try {
                        controller.importFromFile(fileChooser.getSelectedFile());
                        tp.refresh();
                    } catch (IOException e) {
                        System.out.println("Open command cancelled by user.");
                    }
                } else {
                    System.out.println("Open command cancelled by user.");
                }
            }

            @Override
            public void exportData() {
                int n=fileChooser.showSaveDialog(MainFrame.this);
                if (n == JFileChooser.APPROVE_OPTION) {
                    File f=fileChooser.getSelectedFile();
                    System.out.println(f);
                    try {
                        controller.saveToFile(f);
                    } catch (IOException e) {
                        System.err.println("Ese archivo está feo "+e.getMessage());
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Open command cancelled by user.");
                }
//
            }
        });

        // engadir os compoñentes
        add(tl, BorderLayout.PAGE_START);
        add(fp, BorderLayout.LINE_START);
        add(tp, BorderLayout.CENTER);
        add(aceptarButton, BorderLayout.PAGE_END);
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private JMenuBar createMenuBar(){
        JMenuBar menuBar = new JMenuBar();

        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);

        JMenu window = new JMenu("Window");
        JMenuItem exportItem = new JMenuItem("Export Data");
        exportItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
        exportItem.addActionListener(actionEvent -> {
            fileChooser.addChoosableFileFilter(new FileChooserFilter());
            int n=fileChooser.showSaveDialog(MainFrame.this);
        });

        JMenuItem importItem = new JMenuItem("Import Data");
        importItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,ActionEvent.CTRL_MASK));
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic(KeyEvent.VK_X);
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int n=JOptionPane.showConfirmDialog(MainFrame.this,"Está seguro que quere saír?",
                        "Pechar",JOptionPane.YES_NO_CANCEL_OPTION);
                if(n==0){
                    dispose();
                }
            }
        });
        JMenu showItem=new JMenu("Show");
        JCheckBoxMenuItem personItem=new JCheckBoxMenuItem("Person Form");
        personItem.setSelected(true);
        personItem.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                fp.setVisible(ie.getStateChange() != ItemEvent.DESELECTED);
            }
        });
        showItem.add(personItem);
        window.add(showItem);
        file.add(exportItem);
        file.add(importItem);
        file.addSeparator();
        file.add(exitItem);
        menuBar.add(file);
        menuBar.add(window);
        return menuBar;
    }

    public MainFrame getComponent(){
        return this;
    }
}