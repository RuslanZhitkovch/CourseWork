module com.example.coursework {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.coursework to javafx.fxml;
    exports com.example.coursework;
}