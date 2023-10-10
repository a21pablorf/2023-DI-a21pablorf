/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author a21pablorf
 */
public class MainFrame extends JFrame {

    private JButton btn1 = new JButton("Boton 1");
    private JButton btn2 = new JButton("Boton 2");
    private JButton btn3 = new JButton("Boton 3");
    private JButton btn4 = new JButton("Boton 4");
    private JButton btn5 = new JButton("Boton 5");
    private JButton btn6 = new JButton("Boton 6");
    private JButton btn7 = new JButton("Boton 7");
    private JButton btn8 = new JButton("Boton 8");
    private JButton btn9 = new JButton("Boton 9");
    private JButton btn10 = new JButton("Boton 10");
    private JTextField arriba = new JTextField("Titulo: ");
    private JTextField abaixo = new JTextField("Pablo");
    private JTextArea texto = new JTextArea();

    public MainFrame() {
        super("Ej 1");

        setLayout(new BorderLayout());

        JPanel izq = new JPanel(new GridLayout(5, 1));
        JPanel der = new JPanel(new GridLayout(5, 1));

        izq.add(btn1);
        izq.add(btn2);
        izq.add(btn3);
        izq.add(btn4);
        izq.add(btn5);

        der.add(btn6);
        der.add(btn7);
        der.add(btn8);
        der.add(btn9);
        der.add(btn10);

        abaixo.setHorizontalAlignment((int) CENTER_ALIGNMENT);

        add(arriba, BorderLayout.PAGE_START);
        add(izq, BorderLayout.LINE_START);
        add(der, BorderLayout.LINE_END);
        add(texto, BorderLayout.CENTER);
        add(abaixo, BorderLayout.PAGE_END);

        setSize(600, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
}
