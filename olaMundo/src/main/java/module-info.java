module org.example.olamundo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens org.example.olamundo to javafx.fxml;
    exports org.example.olamundo;
}