module com.example.splashscreen {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.splashscreen to javafx.fxml;
    exports com.example.splashscreen;
}