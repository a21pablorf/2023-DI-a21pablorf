/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.compvisu_ej2;

import java.awt.Color;
import java.io.Serializable;

/**
 *
 * @author a21pablorf
 */
class Colores implements Serializable {

    private Color colorTexto;
    private Color colorFondo;

    public Colores() {
    }

    public Colores(Color colorTexto, Color colorFondo) {
        this.colorTexto = colorTexto;
        this.colorFondo = colorFondo;
    }

    public Color getColorTexto() {
        return colorTexto;
    }

    public void setColorTexto(Color colorTexto) {
        this.colorTexto = colorTexto;
    }

    public Color getColorFondo() {
        return colorFondo;
    }

    public void setColorFondo(Color colorFondo) {
        this.colorFondo = colorFondo;
    }

}
