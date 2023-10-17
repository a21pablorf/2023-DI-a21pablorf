/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;

/**
 *
 * @author a21pablorf
 */
public class MainFrame extends JFrame {
// Declarar os compoñentes como variables privadas de instancia

    private JButton aceptarButton;
    private TextPanel pan;
    private Toolbar tl;
    
    public MainFrame() {
        super("Ola Mundo!");
// Establecer o Layout
        setLayout(new BorderLayout());
// Inicializar os compoñentes
        aceptarButton = new JButton("Aceptar");
        pan = new TextPanel();
        tl = new Toolbar();
        
        tl.setTextListener(new StringListener() {
            @Override
            public void textEmited(String text) {
                pan.appendText(text);
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
        add(pan, BorderLayout.CENTER);
        add(aceptarButton, BorderLayout.PAGE_END);
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
}
