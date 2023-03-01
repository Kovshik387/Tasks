module com.example.javafxtask {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxtask to javafx.fxml;
    exports com.example.javafxtask;
}