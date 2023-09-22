module com.example.coba {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.coba to javafx.fxml;
    exports com.example.coba;
    exports com.example.coba.model;
    opens com.example.coba.model to javafx.fxml;
}