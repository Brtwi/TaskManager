package Application.Controller;

import Application.Model.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
    @FXML
    private ListView<Task> allListView;
    @FXML
    private ListView<Task> ownListView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }
}