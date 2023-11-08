/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.frame;

import java.util.EventObject;

/**
 *
 * @author a21pablorf
 */
public class FormEvent extends EventObject {

    private String name;
    private String oc;
    private int ageCId;
    private String employed;
    private String gender;

    public FormEvent(Object source) {
        super(source);
    }

    public FormEvent(Object source, String name, String oc, int ageCId, String employed, String gender) {
        super(source);
        this.name = name;
        this.oc = oc;
        this.ageCId = ageCId;
        this.employed = employed;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return name+" : "+ oc +" : "+ageCId+" : "+employed+" : "+gender;
    }
}