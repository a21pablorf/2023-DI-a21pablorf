/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.botonpersonalizado;

import java.awt.Color;
import java.io.Serializable;
import javax.swing.JButton;

/**
 *
 * @author a21pablorf
 */
public class BotonPersonalizado extends JButton implements Serializable {

    private Cor cor;

    public BotonPersonalizado() {
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }
}
