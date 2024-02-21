package org.example;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("Selecciona el precio maximo: ");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear un JComboBox con varias ciudades
        Integer[] ciudades = {10, 40, 20, 100};
        // Convertir el array de Integer a un array de Strings usando stream y map
        String[] arrayStrings = Arrays.stream(ciudades)
                .map(Object::toString)
                .toArray(String[]::new);

        JComboBox<String> comboBoxCiudades = new JComboBox<>(arrayStrings);

        JButton botonOK = new JButton("OK");
        botonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection conexion;
                try {
                    String url = "jdbc:h2:/home/sanclemente.local/a21pablorf/Escritorio/Informes/BaseDeDatos/northwind";
                    conexion = DriverManager.getConnection(url);
                    Map parametros = new HashMap();
                    //parametros.put("precio", comboBoxCiudades.getSelectedItem());
                    parametros.put("precio", ciudades[comboBoxCiudades.getSelectedIndex()]);
                    JasperPrint print
                            = JasperFillManager.fillReport("src/main/resources/Productos.jasper",
                            parametros,
                            conexion);
                    // exportar a PDF
                    JasperExportManager.exportReportToPdfFile(print, "src/main/resources/informe.pdf");
                    System.out.println("PDF creado ----------------");
                } catch (Throwable ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Crear un panel para organizar los componentes
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(comboBoxCiudades);
        panel.add(botonOK);

        // Agregar el panel al contenido del JFrame
        getContentPane().add(panel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

}
