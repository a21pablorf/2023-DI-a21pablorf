module org.example.javafxproperties {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.javafxproperties to javafx.fxml;
    exports org.example.javafxproperties;
}