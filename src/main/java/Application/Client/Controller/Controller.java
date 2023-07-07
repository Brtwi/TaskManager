package Application.Client.Controller;

import Application.Shared.Model.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
    @FXML
    private ListView<Task> allListView;
    @FXML
    private ListView<Task> ownListView;
    @FXML
    private ListView<Task> sentListView;
    @FXML
    private Button addTaskButton;
    @FXML
    private Button deleteTaskButton;
    @FXML
    private Button editTaskButton;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }

    private void setupButtons()
    {

    }

    private void setupLists()
    {
        allListView.setCellFactory(param -> new ListCell<>()
        {
            @Override
            protected void updateItem(Task task, boolean b)
            {
                super.updateItem(task, b);

                if(b || task == null)
                {
                    setText(null);
                }
                else
                {
                    setText(task.getTitle() + " " + task.getState());
                }
            }
        });

        ownListView.setCellFactory(param -> new ListCell<>()
        {
            @Override
            protected void updateItem(Task task, boolean b)
            {
                super.updateItem(task, b);

                if(b || task == null)
                {
                    setText(null);
                }
                else
                {
                    setText(task.getTitle() + " " + task.getState());
                }
            }
        });

        sentListView.setCellFactory(param -> new ListCell<>()
        {
            @Override
            protected void updateItem(Task task, boolean b)
            {
                super.updateItem(task, b);

                if(b || task == null)
                {
                    setText(null);
                }
                else
                {
                    setText(task.getTitle() + " " + task.getState());
                }
            }
        });
    }
}