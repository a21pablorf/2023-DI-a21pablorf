module org.example.holamundo {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.holamundo to javafx.fxml;
    exports org.example.holamundo;
}