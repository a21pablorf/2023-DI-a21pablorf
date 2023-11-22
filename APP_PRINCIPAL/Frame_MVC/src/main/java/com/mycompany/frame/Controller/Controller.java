package com.mycompany.frame.Controller;

import com.mycompany.frame.GUI.FormEvent;
import com.mycompany.frame.Model.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Controller {
    // Garda unha referencia á base de datos
    private Database db = new Database();

    public Controller(){

    }

    public void addPerson(FormEvent ev) {
// Recuperar toda a información do obxecto ev
        String name = ev.getName();
        String occupation=ev.getOc();
        int ageCatId = ev.getAgeCategory();
        String empCat = ev.getEmpCategory();
        AgeCategory ageCategory = switch (ageCatId) {
            case 0 -> AgeCategory.CHILD;
            case 1 -> AgeCategory.ADULT;
            case 2 -> AgeCategory.SENIOR;
            default -> null;
        };
        EmploymentCategory empCategory;
        if (empCat.equals("employed")) {
            empCategory = EmploymentCategory.EMPLOYED;
        } else{
            empCategory=EmploymentCategory.OTHER;
        }
        String taxId=ev.getTaxId();
        boolean isUs=ev.isUsCitizen();
        String genderCat=ev.getGender();
        Gender genderCategory;
        if (genderCat.equals("MALE")){
            genderCategory=Gender.MALE;
        }
        else
            genderCategory=Gender.FEMALE;


        Person person = new Person(name, occupation, ageCategory, empCategory,
                isUs, taxId,  genderCategory);
        db.addPerson(person);
    }

    public List<Person> getPeople(){
        return db.getPeople();
    }

    public void saveToFile(File f) throws IOException {
        db.saveToFile(f);
    }

    public void importFromFile(File f) throws IOException {
        db.loadFromFile(f);
    }
}
