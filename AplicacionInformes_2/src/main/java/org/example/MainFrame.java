package org.example;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainFrame extends JFrame {
    private String url="jdbc:h2:/home/sanclemente.local/a21pablorf/Escritorio/Informes/BaseDeDatos/northwind";
    private List<String> resultados;
    private String[] arrayResultados;

    public MainFrame() {
        setTitle("Selecciona el precio maximo: ");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try (Connection connection = DriverManager.getConnection(url)) {
            // Define la consulta SQL
            String sql = "SELECT distinct(country) FROM suppliers";

            // Crea la declaración preparada
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // Ejecuta la consulta y obtén el resultado
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    // Procesa los resultados y almacénalos en un array de String
                    resultados=new ArrayList<>();
                    while (resultSet.next()) {
                        String valorColumna = resultSet.getString("country");
                        resultados.add(valorColumna);
                    }

                    // Convierte la lista a un array de String
                    arrayResultados = resultados.toArray(new String[0]);

                    // Imprime los resultados (puedes hacer lo que necesites con el array)
                    for (String resultado : arrayResultados) {
                        System.out.println(resultado);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Crear un JComboBox con varias ciudades
        Integer[] ciudades = {10, 40, 20, 100};
        // Convertir el array de Integer a un array de Strings usando stream y map
        String[] arrayStrings = Arrays.stream(ciudades)
                .map(Object::toString)
                .toArray(String[]::new);

        JComboBox<String> comboBoxCiudades = new JComboBox<>(arrayResultados);

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
                    System.out.println(arrayResultados[comboBoxCiudades.getSelectedIndex()]);
                    parametros.put("Pais", arrayResultados[comboBoxCiudades.getSelectedIndex()]);
                    JasperPrint print
                            = JasperFillManager.fillReport("src/main/resources/ClientesGroupByPaisjrxml.jasper",
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
