package Application;

import Application.Client.Controller.MainView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Dialog;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.application.Application;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application
{
    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws IOException
    {
        stage = primaryStage;

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LoginView.fxml"));
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("Task manager");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void changeScene(String fxml) throws IOException
    {
        Parent pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml)));
        stage.setScene(new Scene(pane));
        stage.centerOnScreen();
    }

    public void openDialog(String fxml, String title) throws IOException
    {
        Stage dialog = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml)));
        dialog.setScene(new Scene(root));

        dialog.initOwner(stage);
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.setTitle(title);
        dialog.show();
        dialog.centerOnScreen();
    }

    public static void main(String[] args)
    {
        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("javafx.version"));
        launch();


    }
}