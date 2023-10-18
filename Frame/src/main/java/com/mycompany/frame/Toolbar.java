/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.frame;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author a21pablorf
 */
public class Toolbar extends JPanel {

    private StringListener textListener;

    private JButton btn1 = new JButton("Hello");
    private JButton btn2 = new JButton("Goodbye");

    public Toolbar() {
        setLayout(new FlowLayout(FlowLayout.LEFT));

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton clickedButton = (JButton) e.getSource();
                if (clickedButton == btn1) {
                    if (textListener != null) {
                        StringEvent se = new StringEvent("Hola\n", this);
                        textListener.textEmited(se);
                    }
                } else if (clickedButton == btn2) {
                    if (textListener != null) {
                        StringEvent se = new StringEvent("Aceptar\n", this);
                        textListener.textEmited(se);
                    }
                }
            }
        };

        btn1.addActionListener(al);
        btn2.addActionListener(al);

        add(btn1);
        add(btn2);

    }

    public void setTextListener(StringListener textListener) {
        this.textListener = textListener;
    }

}
