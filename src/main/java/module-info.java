module com.example.taskmanager {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
            requires net.synedra.validatorfx;
                requires org.kordamp.bootstrapfx.core;
            
    opens Application to javafx.fxml;
    exports Application;


    exports Application.Client.Controller;
    opens Application.Client.Controller to javafx.fxml;
    exports Application.View;
    opens Application.View to javafx.fxml;
}