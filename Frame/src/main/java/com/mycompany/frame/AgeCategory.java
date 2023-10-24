package com.mycompany.frame;

public class AgeCategory {

    private int id;
    private String text;

    public AgeCategory(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

    //    model.addElement("Under 18");
//        model.addElement("18 to 65");
//        model.addElement("65 or over");
}
