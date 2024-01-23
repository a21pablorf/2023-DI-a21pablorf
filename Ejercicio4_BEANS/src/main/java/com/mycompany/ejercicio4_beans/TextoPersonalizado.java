/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio4_beans;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import javax.swing.JTextField;

/**
 *
 * @author a21pablorf
 */
public class TextoPersonalizado extends JTextField implements Serializable {

    private boolean isInt;

    public TextoPersonalizado() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                System.out.println(Character.isDigit(c));
                if (isInt) {
                    if (!Character.isDigit(c)) {
                        e.consume();
                    }
                }
            }

        });
    }

    public boolean isIsInt() {
        return isInt;
    }

    public void setIsInt(boolean isInt) {
        this.isInt = isInt;
    }

}
