module org.example.ejercicio2_paneles_javafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens org.example.ejercicio2_paneles_javafx to javafx.fxml;
    exports org.example.ejercicio2_paneles_javafx;
}