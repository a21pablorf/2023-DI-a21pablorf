/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicioslisteners;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author a21pablorf
 */
public class MainFrame extends JFrame {

    private JButton boton1;
    private JButton boton2;
    private JButton boton3;

    public MainFrame() {
        super("Titulo");

        setLayout(new FlowLayout());
        boton1 = new JButton("BOTON 1");
        boton2 = new JButton("BOTON 2");
        boton3 = new JButton("BOTON 3");

        MouseAdapter ma = new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                var c = e.getComponent();
                c.setBackground(Color.red);
            }

            public void mouseExited(MouseEvent e) {
                e.getComponent().setBackground(null);
            }
        };

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTitle(e.getActionCommand());
            }
        };

        boton1.addActionListener(al);
        boton2.addActionListener(al);
        boton3.addActionListener(al);

        boton1.addMouseListener(ma);
        boton2.addMouseListener(ma);
        boton3.addMouseListener(ma);

        add(boton1);
        add(boton2);
        add(boton3);

        setSize(600, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

}
