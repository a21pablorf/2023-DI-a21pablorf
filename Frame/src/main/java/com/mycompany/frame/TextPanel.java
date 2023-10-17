/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.frame;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author a21pablorf
 */
public class TextPanel extends JPanel {
    
    private JTextArea txtArea;
    
    public TextPanel() {
        txtArea = new JTextArea();
        setLayout(new BorderLayout());
        
        add(new JScrollPane(txtArea), BorderLayout.CENTER);
    }
    
    public void appendText(String texto) {
        txtArea.append(texto);
    }
    
}
