package Application.ViewController;

import Application.TaskManager;
import Application.ViewModel.ViewModelFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{
    private final Stage stage;
    private final ViewModelFactory viewModelFactory;

    public ViewHandler(Stage stage, ViewModelFactory viewModelFactory)
    {
        this.stage = stage;
        this.viewModelFactory = viewModelFactory;
    }

    public void start()
    {
        changeScene(FXMLNames.LOGIN_VIEW);
    }

    public void changeScene(String fxml)
    {
        try
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(TaskManager.class.getResource(fxml));
            Parent root = loader.load();

            initViewController(fxml, loader);

            stage.setScene(new Scene(root));
            stage.centerOnScreen();
            stage.show();
        }catch (Exception e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error while loading screen");
            alert.show();
        }
    }

    public void openDialog(String fxml, String title)
    {
        Stage dialog = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(TaskManager.class.getResource(fxml));
        Parent root;
        try
        {
            root = loader.load();
            dialog.setScene(new Scene(root));

            initViewController(fxml, loader);

            dialog.initOwner(stage);
            dialog.initModality(Modality.WINDOW_MODAL);
            dialog.setTitle(title);
            dialog.show();
            dialog.centerOnScreen();
        } catch (IOException ignored)
        {
        }
    }


    private void initViewController(String fxmlName, FXMLLoader loader)
    {
        switch (fxmlName)
        {
            case FXMLNames.MAIN_VIEW ->
            {
                MainView view = loader.getController();
                view.init(viewModelFactory.getMainViewModel(), this);
            }
            case FXMLNames.REGISTER_VIEW ->
            {
                Register view = loader.getController();
                view.init(viewModelFactory.getRegisterViewModel(), this);
            }
            case FXMLNames.LOGIN_VIEW ->
            {
                Login view = loader.getController();
                view.init(viewModelFactory.getLoginViewModel(), this);
            }
            case FXMLNames.NEW_TASK_VIEW ->
            {
                NewTask view = loader.getController();
                view.init(viewModelFactory.getNewTaskViewModel(), this);
            }
            case FXMLNames.ONLINE_USERS_VIEW ->
            {
                OnlineUsers view = loader.getController();
                view.init(viewModelFactory.getOnlineUsersViewModel());
            }
            case FXMLNames.EDIT_VIEW ->
            {
                Edit view = loader.getController();
                view.init(viewModelFactory.getEditViewModel());
            }
        }
    }
}
