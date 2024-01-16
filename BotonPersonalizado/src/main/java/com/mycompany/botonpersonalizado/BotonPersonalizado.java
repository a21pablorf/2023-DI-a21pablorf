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

    private Color corFondo;
    private Color corTexto;
    private Cor cor;

    public BotonPersonalizado() {
    }

    public Color getCorFondo() {
        return corFondo;
    }

    public void setCorFondo(Color corFondo) {
        setBackground(corFondo);
    }

    public Color getCorTexto() {
        return corTexto;
    }

    public void setCorTexto(Color corTexto) {
        setForeground(corTexto);
    }

}
