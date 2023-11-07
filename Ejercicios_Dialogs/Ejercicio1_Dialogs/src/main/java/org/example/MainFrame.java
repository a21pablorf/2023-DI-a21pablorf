package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JButton btnMessage;
    private JButton btnConfirm;
    private JButton btnInput;
    private JButton btnOption;
    private JTextArea areaTxt;
    private JPanel botones=new JPanel();

    public MainFrame(){
        super("Exercicio Diálogos");
        setLayout(new BorderLayout());

        areaTxt=new JTextArea();

        btnMessage=new JButton("Mensaje");
        btnMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(MainFrame.this,"MAL","PELIGRO",JOptionPane.ERROR_MESSAGE);
            }
        });

        btnConfirm=new JButton("Confirmar");
        btnConfirm.addActionListener(actionEvent -> {
            Object[] options={"SI","NON","CANCELAR"};
            int n=JOptionPane.showConfirmDialog(MainFrame.this,
                    "Quieres confirmar el evento?","CONFIRMACION",JOptionPane.YES_NO_CANCEL_OPTION);
            switch (n){
                case 0-> areaTxt.setText("Confirmo asistencia");
                case 1 -> areaTxt.setText("Deniego asistencia");
                case -1-> areaTxt.setText("Ventana pechada");
                default-> areaTxt.setText("Cancelo operacion");
            }
        });

        btnInput=new JButton("Introducir");
        btnInput.addActionListener(actionEvent -> {
            String[] options={"Menos de 18 anos","Entre 18 e 75 anos","Mais de 75 anos"};
            String n=(String) JOptionPane.showInputDialog(MainFrame.this,
                    "Cantos anos tes?","IDADE",JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            System.out.println(n);
        });


        botones.setLayout(new FlowLayout());
        botones.add(btnMessage);
        botones.add(btnConfirm);
        botones.add(btnInput);

        add(botones,BorderLayout.PAGE_START);
        add(areaTxt,BorderLayout.CENTER);

        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
