/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.frame;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author a21pablorf
 */
public class FormPanel extends JPanel {

    private JLabel person_LB = new JLabel("Add Person");
    private JLabel name_LB = new JLabel("Name");
    private JLabel occ_LB = new JLabel("Occupation");
    private JTextField name_txt = new JTextField();
    private JTextField occ_txt = new JTextField();
    private JButton ok_btn = new JButton("OK");

    public FormPanel() {

        Dimension dim = getPreferredSize();
        dim.width
                = GridBagConstraints
        this.setLayout(new GridBagLayout());

        Border inBorder = BorderFactory.createTitledBorder(person_LB.getText());
        Border outBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);

        setBorder(BorderFactory.createCompoundBorder(outBorder, inBorder));

        gbc.gridheight = 1;
    }

}
