module Application {
    requires javafx.fxml;
    requires javafx.controls;
            
        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
            requires net.synedra.validatorfx;
                requires org.kordamp.bootstrapfx.core;

    requires java.sql;
    requires java.net.http;
    requires com.microsoft.sqlserver.jdbc;
    requires lombok;
    requires com.google.gson;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.jfoenix;


    opens Application to javafx.fxml;
    exports Application;
    exports Application.Model.Entities;
    exports Application.ViewModel;


    exports Application.ViewController;
    opens Application.ViewController to javafx.fxml;

    opens Application.Model.Helpers to com.fasterxml.jackson.databind;

    opens Application.Model to com.fasterxml.jackson.databind;

    opens Application.Icons to javafx.fxml;
    exports Application.Model;
    exports Application.Model.Interfaces;
    exports Application.Model.Helpers;
}