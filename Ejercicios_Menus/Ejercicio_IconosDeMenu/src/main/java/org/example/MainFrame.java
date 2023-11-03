package org.example;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class MainFrame extends JFrame {
    private JTextArea areaTxt;

    public MainFrame(){
        super("Ejercicio Iconos de Menu");
        setLayout(new BorderLayout());
        setJMenuBar(createMenuBar());

        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JMenuBar createMenuBar(){
        JMenuBar menuBar=new JMenuBar();
        JMenu casa=new JMenu("Casa");
        casa.setIcon(createIcon("/houseIcon.png"));
        JMenu extra=new JMenu("Extras");
        JMenu rooms=new JMenu("Habitacions");

        JCheckBoxMenuItem salon=new JCheckBoxMenuItem("Salon");
        JRadioButton kitchen=new JRadioButton("Cociña");
        JRadioButton bath=new JRadioButton("Baño");

        JMenuItem room1=new JMenuItem("Habitacion 1");
        room1.setToolTipText("Selecionna a habitacion 1");
        JMenuItem room2=new JMenuItem("Habitacion 2");
        room1.setToolTipText("Selecionna a habitacion 2");

        JMenuItem garage=new JMenuItem("Garaxe");
        JMenuItem trast=new JMenuItem("Trasteiro");

        room2.setEnabled(false);

        rooms.add(room1);
        rooms.add(room2);

        casa.add(rooms);
        casa.add(salon);
        casa.addSeparator();
        casa.add(kitchen);
        casa.add(bath);

        menuBar.add(casa);
        menuBar.add(extra);

        return menuBar;
    }
    private ImageIcon createIcon(String path){
        URL url = getClass().getResource(path);
        if (url==null){
            System.out.println("Erro ao encontrar a imaxe.");
        }
        ImageIcon icon=new ImageIcon(url);
        return icon;
    }
}