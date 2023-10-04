/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio6;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author a21pablorf
 */
public class MainFrame extends JFrame {

    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    NumberFormat nf = NumberFormat.getCompactNumberInstance();

    private JLabel lb1 = new JLabel("Numero");
    private JLabel lb2 = new JLabel("Data");
    private JFormattedTextField txt1 = new JFormattedTextField(nf);
    private JFormattedTextField txt2 = new JFormattedTextField(df);
    private JButton btn = new JButton("Imprimir");

    public MainFrame() {
        super("Exercicio 6");

        setLayout(new FlowLayout());
        txt1.setColumns(10);
        txt1.setText("0");
        txt2.setColumns(16);
        txt2.setValue(new Date());

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Numero: " + txt1.getText() + "\n Data: " + txt2.getText());
            }
        };

        btn.addActionListener(al);

        add(lb1);
        add(txt1);
        add(lb2);
        add(txt2);
        add(btn);

        setSize(300, 100);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
