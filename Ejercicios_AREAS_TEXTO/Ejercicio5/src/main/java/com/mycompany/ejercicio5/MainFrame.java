/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio5;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author a21pablorf
 */
public class MainFrame extends JFrame {

    private JTextField txt1 = new JTextField(5);
    private JTextArea txt2 = new JTextArea(5, 20);

    public MainFrame() {

        super("Exercicio 5");

        setLayout(new FlowLayout());

        txt2.setEditable(false);
        txt2.setLineWrap(true);
        txt2.setWrapStyleWord(true);

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                txt2.append(txt1.getText());
                //txt1.setText("");
                txt1.selectAll();
            }
        };

        txt1.addActionListener(al);

        add(txt1);
        add(txt2);

        setSize(300, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
