package com.mycompany.frame.Model;

import java.io.*;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Database {
    private List<Person> people;

    public Database() {
        this.people = new LinkedList<Person>();
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public List<Person> getPeople() {
        return Collections.unmodifiableList(this.people);
    }

    public void saveToFile(File file) throws IOException {
        // crear un fluxo de saída a disco pasándolle un obxecto File
        FileOutputStream fos = new FileOutputStream(file);
        // Vincular o ObjectOuputStream co fluxo de saída
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        // writeObject permite escribir a ficheiro un arrayList porque é un obxecto
        oos.writeObject(people);
        System.out.println(people.size());
        //cerrar os fluxos de saída
        oos.close();
        fos.close();
    }

    public void loadFromFile(File file) throws IOException {
        // crear un fluxo de entrada de disco pasándolle un obxecto File
        FileInputStream fis = new FileInputStream(file);
        // Vincular o ObjectInputStream co fluxo de entrada
        ObjectInputStream ois = new ObjectInputStream(fis);
        try {
        // para evitar problemas, eliminar elementos da lista e cargalos de ficheiro
            people.clear();
            people.addAll((LinkedList<Person>) ois.readObject());
            System.out.println(people.size());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // cerrar os fluxos de entrada
        ois.close();
        fis.close();
    }
}
