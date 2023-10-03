/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author a21pablorf
 */
public class Frame extends JFrame {
    
    private JTextArea txt;
    private JScrollPane sc;
    
    public Frame() {
        super("Exercicio 4");
        
        setLayout(new FlowLayout());
        
        txt = new JTextArea(5, 20);
        sc = new JScrollPane(txt);
        
        txt.setLineWrap(true);
        txt.setWrapStyleWord(true);
        
        add(sc);
        
        setSize(300, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
}
