/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author a21pablorf
 */
public class MainFrame extends JFrame {

    private JTextField txt1;
    private JTextField txt2;
    private JButton btn;
    private JLabel lb;

    public MainFrame() {
        super("Exercicio 1");

        setLayout(new FlowLayout());

        txt1 = new JTextField(5);
        txt2 = new JTextField(5);
        btn = new JButton("Sumar");
        lb = new JLabel();

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int x = Integer.parseInt(txt1.getText()) + Integer.parseInt(txt2.getText());
                lb.setText(String.valueOf(x));
            }
        };

        btn.addActionListener(al);

        add(txt1);
        add(txt2);
        add(btn);
        add(lb);

        setSize(600, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

}
