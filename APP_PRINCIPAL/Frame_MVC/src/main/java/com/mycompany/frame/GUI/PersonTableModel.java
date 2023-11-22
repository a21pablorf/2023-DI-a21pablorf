package com.mycompany.frame.GUI;

import com.mycompany.frame.Model.Person;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class PersonTableModel extends AbstractTableModel {
    private List<Person> personList;
    private String[] columnNames = {"ID", "Name", "Occupation", "Age Category",
            "Employment Category", "US Citizen", "Tax ID", "Gender"};
    public PersonTableModel() { }
    public void setData(List<Person> personList) {
        this.personList = personList;
    }
    @Override
    public int getRowCount() {
        return this.personList.size();
    }
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    @Override
    public Object getValueAt(int row, int column) {
        Person person=personList.get(row);
    // obter o obxecto persoa na posición indicada por row
    // Se a columna é a 0, devolver o identificador da persoa (getId),
    // se a columna é a 1, devolver o nome da persoa, etc
    // se a columna está fóra do rango válido, devolver null
        return switch (column) {
            case 0 -> person.getId();
            case 1 -> person.getName();
            case 2 -> person.getOccupation();
            case 3 -> person.getAgeCategory();
            case 4 -> person.getEmpCategory();
            case 5 -> person.isUsCitizen();
            case 6 -> person.getTaxId();
            case 7 -> person.getGender();
            default -> null;
        };
    }
    @Override
    public String getColumnName(int column) {
        if (column < 0 || column >= getColumnCount()) {
            throw new ArrayIndexOutOfBoundsException(column);
        } else {
            return columnNames[column];
        }
    }
}
