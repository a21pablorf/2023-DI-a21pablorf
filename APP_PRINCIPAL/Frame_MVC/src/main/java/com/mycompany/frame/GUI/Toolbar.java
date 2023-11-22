/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.frame.GUI;

import com.mycompany.frame.Model.Database;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.swing.*;


/**
 *
 * @author a21pablorf
 */
public class Toolbar extends JToolBar {

    private JButton btn1 = new JButton();
    private JButton btn2 = new JButton();
    private ToolbarListener toolbarListener;
    private JFileChooser fileChooserExp=new JFileChooser();
    private JFileChooser fileChooserImp=new JFileChooser();

    public Toolbar(MainFrame mf) {
        setLayout(new FlowLayout(FlowLayout.LEFT));

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton clickedButton = (JButton) e.getSource();
                if (clickedButton == btn1) {
                    if(toolbarListener!=null){
                        ToolbarEvent te=new ToolbarEvent(this);
                        toolbarListener.exportData();
                    }
                } else if (clickedButton == btn2) {
                    if(toolbarListener!=null){
                        ToolbarEvent te=new ToolbarEvent(this);
                        toolbarListener.importData();
                    }
                }
            }
        };

        btn1.setIcon(createIcon("/Save24.gif"));
        btn2.setIcon(createIcon("/Import24.gif"));

//        btn1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//                int n=fileChooserExp.showSaveDialog(mf);
//                if (n == JFileChooser.APPROVE_OPTION) {
//                    File f=fileChooserExp.getSelectedFile();
//                    try {
//                        db.saveToFile(f);
//                    } catch (IOException e) {
//                        System.err.println("Ese archivo está feo "+e.getMessage());
//                    }
//                } else {
//                    System.out.println("Open command cancelled by user.");
//                }
//
//            }
//        });
//        btn2.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//                int n=fileChooserExp.showOpenDialog(mf);
//                if (n == JFileChooser.APPROVE_OPTION) {
//                    File f=fileChooserImp.getSelectedFile();
//                    try {
//                        db.loadFromFile(f);
//
//                    } catch (IOException e) {
//                        System.out.println("Open command cancelled by user.");
//                    }
//                } else {
//                    System.out.println("Open command cancelled by user.");
//                }
//            }
//        });
        btn1.addActionListener(al);
        btn2.addActionListener(al);

        add(btn1);
        add(btn2);

    }

    public void setToolbarListener(ToolbarListener tb){
        this.toolbarListener=tb;
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


