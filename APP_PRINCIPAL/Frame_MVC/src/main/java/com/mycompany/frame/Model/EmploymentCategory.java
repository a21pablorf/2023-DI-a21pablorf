package com.mycompany.frame.Model;

public enum EmploymentCategory {
    EMPLOYED("Employed"),SELFEMPLOYED("Selfemployed"),UNEMPLOYED("Unemployed"),OTHER("Other");


    private String descripcion;

    EmploymentCategory(String descripcion){
        this.descripcion=descripcion;
    }
    @Override
    public String toString() {
        return descripcion;
    }
}
