module com.example.java_fx_2024_l3gl {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens com.example.java_fx_2024_l3gl to javafx.fxml;
    exports com.example.java_fx_2024_l3gl;
    exports com.example.java_fx_2024_l3gl.model;

}