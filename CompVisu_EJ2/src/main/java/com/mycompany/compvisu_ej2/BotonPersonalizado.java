/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.compvisu_ej2;

import java.io.Serializable;
import javax.swing.JButton;

/**
 *
 * @author a21pablorf
 */
public class BotonPersonalizado extends JButton implements Serializable {

    private Colores colores;

    public BotonPersonalizado() {
    }

    public Colores getColores() {
        return colores;
    }

    public void setColores(Colores colores) {
        this.colores = colores;
    }

}
