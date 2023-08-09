package Application.ViewController;

import Application.TaskManager;
import Application.ViewModel.ViewModelFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ViewHandler
{
    private final Stage stage;
    private final ViewModelFactory viewModelFactory;
    public ViewHandler(Stage stage, ViewModelFactory viewModelFactory)
    {
        this.stage = stage;
        this.viewModelFactory = viewModelFactory;
    }

    public void start() throws IOException
    {
        openView();
    }

    private void openView() throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(TaskManager.class.getResource("LoginView.fxml"));

        Parent root = fxmlLoader.load();
        Login view = fxmlLoader.getController();
        view.init(viewModelFactory.getLoginViewModel(), this);

        stage.setTitle("Task manager");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void changeScene(String fxml) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(TaskManager.class.getResource(fxml));
        Parent root = loader.load();

        if(fxml.contains("RegisterView"))
        {
            Register view = loader.getController();
            view.init(viewModelFactory.getRegisterViewModel(), this);
        }

        stage.setScene(new Scene(root));
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
}
