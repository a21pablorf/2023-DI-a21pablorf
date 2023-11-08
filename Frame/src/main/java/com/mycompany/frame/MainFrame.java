/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.frame;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author a21pablorf
 */
public class MainFrame extends JFrame {
    // Declarar os compoñentes como variables privadas de instancia

    private JButton aceptarButton;
    private TextPanel pan;
    private Toolbar tl;
    private FormPanel fp;
    private JFileChooser fileChooserExp;
    private JFileChooser fileChooserImp;

    public MainFrame() {
        super("Ola Mundo!");
        // Establecer o Layout
        setLayout(new BorderLayout());
        // Inicializar os compoñentes
        aceptarButton = new JButton("Aceptar");
        pan = new TextPanel();
        tl = new Toolbar();
        fp = new FormPanel();
        fileChooserExp =new JFileChooser();
        fileChooserImp=new JFileChooser();

        setJMenuBar(createMenuBar());

        tl.setTextListener(new StringListener() {
            @Override
            public void textEmited(StringEvent se) {
                pan.appendText(se.getText());
            }
        });

        fp.setFormListener(new FormListener() {
            @Override
            public void TextEmitted(FormEvent e) {
                pan.appendText(e.toString());
            }
        });

        ActionListener l = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pan.appendText("aceptar");
            }
        };

        aceptarButton.addActionListener(l);

        // engadir os compoñentes
        add(tl, BorderLayout.PAGE_START);
        add(fp, BorderLayout.LINE_START);
        add(pan, BorderLayout.CENTER);
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
            fileChooserExp.addChoosableFileFilter(new FileChooserFilter());
            int n=fileChooserExp.showSaveDialog(MainFrame.this);

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
}