module Application {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
            requires net.synedra.validatorfx;
                requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires com.microsoft.sqlserver.jdbc;

    opens Application to javafx.fxml;
    exports Application;
    exports Application.Shared.Model;


    exports Application.Client.Controller;
    opens Application.Client.Controller to javafx.fxml;
    exports Application.View;
    opens Application.View to javafx.fxml;
}