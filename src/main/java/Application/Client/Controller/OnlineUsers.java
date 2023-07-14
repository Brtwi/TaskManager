package Application.Client.Controller;

import Application.Shared.Model.User;
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

    public void cancel(ActionEvent event)
    {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
