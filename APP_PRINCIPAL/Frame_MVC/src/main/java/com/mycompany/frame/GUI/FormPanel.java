/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.frame.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
    private JLabel employmentLabel;
    private JLabel genderLabel;
    private JLabel citizenLabel;
    private JLabel taxLabel;
    private JCheckBox citizenBox;
    private JTextField taxText;
    private JTextField nameField;
    private JTextField OccupationField;
    private JRadioButton fmBtn;
    private JRadioButton mBtn;
    private ButtonGroup group=new ButtonGroup();
    private JList ageList;
    private JComboBox employment;
    private JScrollPane sp;


    private JButton okButton;

    public FormPanel() {
        setLayout(new GridBagLayout());
        Dimension dim = getPreferredSize();
        dim.width = 275;
        setPreferredSize(dim);

        GridBagConstraints c = new GridBagConstraints();

        addLabel = new JLabel("Add Person");
        nameLabel = new JLabel("Name: ");
        ageLabel=new JLabel("Age: ");
        nameField = new JTextField(10);
        employmentLabel=new JLabel("Employment: ");
        OccupationLabel = new JLabel("Occupation: ");
        genderLabel=new JLabel("Gender: ");
        OccupationField = new JTextField(10);
        ageList=new JList();

        String[] opciones={"employed","unemployed","self-employed",""};
        employment=new JComboBox(opciones);

        okButton = new JButton("ENGADIR");

        //Alteracion del comboBox
        employment.setEditable(true);

        //Creacion del TAX donde comprueba el CITIZEN
        citizenLabel = new JLabel("US Citizen");
        citizenBox = new JCheckBox();
        taxLabel = new JLabel("Tax ID");
        taxLabel.setEnabled(false);
        taxText = new JTextField(10);
        taxText.setEnabled(false);
        citizenBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                if(ie.getStateChange() == ItemEvent.SELECTED){
                    taxText.setEnabled(true);
                    taxLabel.setEnabled(true);
                }else if(ie.getStateChange() == ItemEvent.DESELECTED){
                    taxText.setEnabled(false);
                    taxLabel.setEnabled(false);
                }
            }
        });

        //Creacion Radio Buttons
        fmBtn=new JRadioButton("female");
        fmBtn.setActionCommand("FEMALE");
        fmBtn.setSelected(true);
        mBtn=new JRadioButton("male");
        mBtn.setActionCommand("MALE");

        group.add(fmBtn);
        group.add(mBtn);

        //Creacion Lista de AGE
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
                //Selecciono Index del JList, para buscar el texto en el array a través del índice

                AgeCategory c=(AgeCategory) model.getElementAt(ageList.getSelectedIndex());
                String emp=opciones[employment.getSelectedIndex()];
                    for (int i = 0; i < opciones.length; i++) {
                        if(emp!=opciones[i]){
                            emp=opciones[1];
                        }
                    }
                    System.out.println(citizenBox.isSelected());
                    FormEvent fe = new FormEvent(this,nameField.getText(),OccupationField.getText(),c.getId()-1,emp,citizenBox.isSelected(),taxText.getText(),group.getSelection().getActionCommand());
                if(fe!=null){
                    formListener.TextEmitted(fe);
                }
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
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(0, 0, 0, 5);
        c.anchor = GridBagConstraints.LINE_END;
        add(employmentLabel, c);

        c.gridx = 1;
        c.gridy = 3;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(0, 0, 0, 0);
        add(employment, c);

        //Quinta y sexta
        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(0, 0, 0, 5);
        c.anchor = GridBagConstraints.LINE_END;
        add(citizenLabel, c);

        c.gridx = 1;
        c.gridy = 4;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(0, 0, 0, 0);
        add(citizenBox, c);

        c.gridx = 0;
        c.gridy = 5;
        c.insets = new Insets(0, 0, 0, 5);
        c.anchor = GridBagConstraints.LINE_END;
        add(taxLabel, c);

        c.gridx = 1;
        c.gridy = 5;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(0, 0, 0, 0);
        add(taxText, c);

        //Septima y octava Fila (Radio Buttons)
        c.gridx = 0;
        c.gridy = 6;
        c.insets = new Insets(0, 0, 0, 5);
        c.anchor = GridBagConstraints.LINE_END;
        add(genderLabel, c);

        c.gridx = 1;
        c.gridy = 6;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(0, 0, 0, 0);
        add(fmBtn, c);

        c.gridx = 1;
        c.gridy = 7;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(0, 0, 0, 0);
        add(mBtn, c);

        //Ultima Fila(BOTON DE OK)
        c.weighty = 2.0;
        c.gridy = 8;
        c.gridx=1;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        add(okButton, c);
    }
    public void setFormListener(FormListener textListener) {
        this.formListener = textListener;
    }
}

class AgeCategory {

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
}