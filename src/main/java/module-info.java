module com.example.coursework {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.coursework to javafx.fxml;
    exports com.example.coursework;
}