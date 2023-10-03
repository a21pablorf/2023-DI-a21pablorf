/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exercicio2;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author a21pablorf
 */
public class FramePrincipal extends JFrame {

    private JTextField txt1 = new JTextField("0", 2);
    private JButton btn = new JButton("Incrementar");

    public FramePrincipal() {
        super("Exercicio 2");

        setLayout(new GridBagLayout());

        txt1.setEditable(false);

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                txt1.setText(String.valueOf(1 + Integer.parseInt(txt1.getText())));
            }
        };

        btn.addActionListener(al);

        add(txt1);
        add(btn);

        setSize(300, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
