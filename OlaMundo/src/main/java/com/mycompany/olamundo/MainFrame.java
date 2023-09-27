/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.olamundo;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

/**
 *
 * @author a21pablorf
 */
public class MainFrame extends JFrame {
// Declarar os compoñentes como variables privadas de instancia

    private JTextArea textArea;
    private JButton aceptarButton;
    private JLabel nomeEtiqueta;

    public MainFrame() {
        super("Ola Mundo!");
// Establecer o Layout
        setLayout(new BorderLayout());
// Inicializar os compoñentes
        textArea = new JTextArea();
        aceptarButton = new JButton("Aceptar");
        aceptarButton.addActionListener((ae) -> {
            dispose();
        });

        nomeEtiqueta = new JLabel("Pablo Romero", (int) CENTER_ALIGNMENT);
// engadir os compoñentes
        add(textArea, BorderLayout.CENTER);
        add(aceptarButton, BorderLayout.PAGE_END);
        add(nomeEtiqueta, BorderLayout.PAGE_START);
        setSize(600, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        nomeEtiqueta.setFont(new Font("Arial", Font.ITALIC, 24));

    }
}
