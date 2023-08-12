package Application.ViewController;

import Application.Model.Entities.User;
import Application.ViewModel.OnlineUsersViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class OnlineUsers
{
    @FXML
    private ListView<User> usersList;
    @FXML
    private Button cancelButton;
    private OnlineUsersViewModel viewModel;

    public void cancel(ActionEvent event)
    {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void init(OnlineUsersViewModel onlineUsersViewModel)
    {
        this.viewModel = onlineUsersViewModel;
    }
}
