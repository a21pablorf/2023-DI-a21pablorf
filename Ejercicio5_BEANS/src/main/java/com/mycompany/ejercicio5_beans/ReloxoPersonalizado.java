/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio5_beans;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author a21pablorf
 */
public class ReloxoPersonalizado extends JLabel implements Serializable {

    private boolean formato12h;

    public ReloxoPersonalizado() {
        ActionListener al = (ActionEvent ae) -> {
            if (formato12h) {
                String date = new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis()));
                setText(date);
            } else {
                String date = new SimpleDateFormat("HH:mm:ss").format(new Date(System.currentTimeMillis()));
                setText(date);
            }

        };
        new Timer(1000, al).start();
    }

    public boolean isFormato12h() {
        return formato12h;
    }

    public void setFormato12h(boolean formato12h) {
        this.formato12h = formato12h;
    }

}
