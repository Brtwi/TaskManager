package Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
        primaryStage.setResizable(false);

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LoginView.fxml"));
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("Task manager");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    public void changeScene(String fxml) throws IOException
    {
        Parent pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml)));
        stage.getScene().setRoot(pane);
    }

    public static void main(String[] args)
    {
        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("javafx.version"));
        launch();


    }
}