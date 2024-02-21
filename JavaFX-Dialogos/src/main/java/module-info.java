module org.example.javafxdialogos {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.javafxdialogos to javafx.fxml;
    exports org.example.javafxdialogos;
}