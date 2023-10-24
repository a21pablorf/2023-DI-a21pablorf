/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.print.attribute.standard.JobMediaSheetsCompleted;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author a21pablorf
 */
public class FormPanel extends JPanel {

    private FormListener formListener;
    private JLabel nameLabel;
    private JLabel OccupationLabel;
    private JLabel addLabel;
    private JLabel ageLabel;
    private JTextField nameField;
    private JTextField OccupationField;
    private JList ageList;
    private JScrollPane sp;


    private JButton okButton;

    public FormPanel() {
        setLayout(new GridBagLayout());
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

        GridBagConstraints c = new GridBagConstraints();

        addLabel = new JLabel("Add Person");
        nameLabel = new JLabel("Name: ");
        ageLabel=new JLabel("Age: ");
        nameField = new JTextField(10);
        OccupationLabel = new JLabel("Occupation: ");
        OccupationField = new JTextField(10);
        ageList=new JList();
        okButton = new JButton("ENGADIR");


        DefaultListModel model=new DefaultListModel();
        model.addElement(new AgeCategory(1,"Under 18"));
        model.addElement(new AgeCategory(2, "18 to 65"));
        model.addElement(new AgeCategory(3, "65 or over"));

        ageList.setModel(model);
        ageList.setPreferredSize(new Dimension(70,100));

        ageList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ageList.setSelectedIndex(1);
        sp=new JScrollPane(ageList);


        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                AgeCategory c=(AgeCategory) model.getElementAt(ageList.getSelectedIndex());
                FormEvent fe = new FormEvent(nameField.getText() + ": " + OccupationField.getText()+": "+c.getId()+"\n", this);
                formListener.TextEmitted(fe);
            }
        };

        okButton.addActionListener(al);

        Border inBorder = BorderFactory.createTitledBorder(addLabel.getText());
        Border outBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);

        setBorder(BorderFactory.createCompoundBorder(outBorder, inBorder));

        sp.setPreferredSize(new Dimension(120,70));

        c.weightx = 1;
        c.weighty = 0.1;

        //Primeira Fila
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.LINE_END;
        c.insets = new Insets(0, 0, 0, 5);
        add(nameLabel, c);

        c.gridx = 1;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(0, 0, 0, 0);
        add(nameField, c);

        //Segunda Fila
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(0, 0, 0, 5);
        c.anchor = GridBagConstraints.LINE_END;
        add(OccupationLabel, c);

        c.gridx = 1;
        c.gridy = 1;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(0, 0, 0, 0);
        add(OccupationField, c);

        //Terceira Fila
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(0, 0, 0, 5);
        c.anchor = GridBagConstraints.LINE_END;
        add(ageLabel, c);

        c.gridx = 1;
        c.gridy = 2;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(0, 0, 0, 0);
        add(sp, c);

        //Cuarta Fila
        c.weighty = 2.0;
        c.gridy = 3;
        c.gridx=1;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        add(okButton, c);

    }
    public void setFormListener(FormListener textListener) {
        this.formListener = textListener;
    }
}
