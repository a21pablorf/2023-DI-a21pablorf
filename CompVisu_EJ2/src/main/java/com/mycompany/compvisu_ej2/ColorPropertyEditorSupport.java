/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.compvisu_ej2;

import java.awt.Component;
import java.beans.PropertyEditorSupport;

/**
 *
 * @author a21pablorf
 */
public class ColorPropertyEditorSupport extends PropertyEditorSupport {

    private ColorPanel colorPanel = new ColorPanel();

    @Override
    public boolean supportsCustomEditor() {
        return true;
    }

    @Override
    public Component getCustomEditor() {
        return colorPanel;
    }

    @Override
    public String getJavaInitializationString() {
        return "";
    }

    @Override
    public Object getValue() {
        return colorPanel.getSelectedValue();
    }

}
