/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exercicio2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author a21pablorf
 */
public class MainFrame extends JFrame {

    private JButton btn1 = new JButton("1");
    private JButton btn2 = new JButton("2");
    private JButton btn3 = new JButton("3");
    private JButton btn4 = new JButton("4");
    private JButton btn5 = new JButton("5");
    private JButton btn6 = new JButton("6");
    private JButton btn7 = new JButton("7");
    private JButton btn8 = new JButton("8");
    private JButton btn9 = new JButton("9");
    private JButton btn0 = new JButton("0");
    private JButton btnDivisor = new JButton("/");
    private JButton btnMult = new JButton("*");
    private JButton btnSuma = new JButton("+");
    private JButton btnResta = new JButton("-");
    private JButton btnIgual = new JButton("=");
    private JButton btnDecimal = new JButton(".");

    private JTextField texto = new JTextField(" ");

    public MainFrame() {
        super("Exercicio 2");

        setLayout(new BorderLayout());
        ((BorderLayout) getContentPane().getLayout()).setVgap(5);
        ((BorderLayout) getContentPane().getLayout()).setHgap(5);

        JPanel contenido = new JPanel(new GridLayout(4, 4, 5, 5));

        contenido.add(btn7);
        contenido.add(btn8);
        contenido.add(btn9);
        contenido.add(btnDivisor);
        contenido.add(btn4);
        contenido.add(btn5);
        contenido.add(btn6);
        contenido.add(btnMult);
        contenido.add(btn1);
        contenido.add(btn2);
        contenido.add(btn3);
        contenido.add(btnResta);
        contenido.add(btn0);
        contenido.add(btnDecimal);
        contenido.add(btnIgual);
        contenido.add(btnSuma);

        //texto.setHorizontalAlignment((int) RIGHT_ALIGNMENT);
        add(texto, BorderLayout.PAGE_START);
        add(contenido, BorderLayout.CENTER);

        setSize(400, 300);
        setLocationRelativeTo(null);
        //setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
