module org.example.listatarefasjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.listatarefasjavafx to javafx.fxml;
    exports org.example.listatarefasjavafx;
}