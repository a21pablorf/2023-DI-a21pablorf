/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio5;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author a21pablorf
 */
public class FramePrincipal extends JFrame {

    private JLabel etiqueta1;
    private JButton bt1;
    private JButton bt2;

    public FramePrincipal() {
        super("Ejercicio 4");

        setLayout(new FlowLayout());
        etiqueta1 = new JLabel("Etiqueta 1");
        bt1 = new JButton("BOTON 1");
        bt2 = new JButton("BOTON 2");

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                etiqueta1.setText(e.getActionCommand());
            }
        };

        bt1.addActionListener(al);
        bt2.addActionListener(al);

        add(etiqueta1);
        add(bt1);
        add(bt2);

        setSize(600, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
