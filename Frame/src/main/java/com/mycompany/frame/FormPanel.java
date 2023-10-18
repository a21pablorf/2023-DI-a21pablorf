/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.frame;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
    private JTextField nameField;
    private JTextField OccupationField;
    private JButton okButton;

    public FormPanel() {
        setLayout(new GridBagLayout());
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

        GridBagConstraints c = new GridBagConstraints();

        addLabel = new JLabel("Add Person");
        nameLabel = new JLabel("Name");
        nameField = new JTextField(10);
        OccupationLabel = new JLabel("Occupation");
        OccupationField = new JTextField(10);
        okButton = new JButton("OK");

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                FormEvent fe = new FormEvent("Nombre: " + nameField.getText() + "\nOcuppation: " + OccupationField.getText(), this);
                formListener.TextEmitted(fe);
            }
        };

        okButton.addActionListener(al);

        Border inBorder = BorderFactory.createTitledBorder(addLabel.getText());
        Border outBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);

        setBorder(BorderFactory.createCompoundBorder(outBorder, inBorder));

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
        c.weighty = 2.0;

        c.gridy = 2;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        add(okButton, c);

    }

    public void setFormListener(FormListener textListener) {
        this.formListener = textListener;
    }
}
