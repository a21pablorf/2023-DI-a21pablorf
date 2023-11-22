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
public class FormEvent extends EventObject {

    private int id;
    private String name;
    private String oc;
    private int ageCategory;
    private String empCategory;
    private boolean usCitizen;
    private String taxId;
    private String gender;

    public FormEvent(Object source) {
        super(source);
    }


    //Constructor completo
    public FormEvent(Object source,String name, String oc, int ageCategory, String employed, boolean usCitizen, String taxId, String gender) {
        super(source);
        this.id=getId()+1;
        this.name = name;
        this.oc = oc;
        this.ageCategory = ageCategory;
        this.empCategory = employed;
        this.usCitizen = usCitizen;
        this.taxId = taxId;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public boolean isUsCitizen() {
        return usCitizen;
    }

    public void setUsCitizen(boolean usCitizen) {
        this.usCitizen = usCitizen;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOc() {
        return oc;
    }

    public void setOc(String oc) {
        this.oc = oc;
    }

    public int getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(int ageCategory) {
        this.ageCategory = ageCategory;
    }

    public String getEmpCategory() {
        return empCategory;
    }

    public void setEmpCategory(String empCategory) {
        this.empCategory = empCategory;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        if(usCitizen){
            return id+" : "+name+" : "+ oc +" : "+ ageCategory +" : "+ empCategory +" : "+usCitizen+" : "+taxId+" : "+gender+System.lineSeparator();
        }
        else{
            return id+" : "+name+" : "+ oc +" : "+ ageCategory +" : "+ empCategory +" : "+gender+System.lineSeparator();
        }
    }
}