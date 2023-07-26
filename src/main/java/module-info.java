module Application {
    requires javafx.fxml;
    requires javafx.controls;
            
        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
            requires net.synedra.validatorfx;
                requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires com.microsoft.sqlserver.jdbc;
    requires lombok;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;


    opens Application to javafx.fxml;
    exports Application;
    exports Application.Shared.Model;


    exports Application.Client.Controller;
    opens Application.Client.Controller to javafx.fxml;

    opens Application.Icons to javafx.fxml;
}