/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.frame.GUI;

import java.util.EventObject;

/**
 *
 * @author a21pablorf
 */
public class StringEvent extends EventObject {

    private String text;

    public StringEvent(Object source) {
        super(source);
    }

    public StringEvent(String text, Object source) {
        super(source);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
