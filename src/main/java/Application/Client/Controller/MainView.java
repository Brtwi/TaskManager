package Application.Client.Controller;

import Application.Main;
import Application.Shared.Model.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainView implements Initializable
{
    @FXML
    private ListView<Task> allListView = new ListView<>();
    @FXML
    private ListView<Task> ownListView = new ListView<>();
    @FXML
    private ListView<Task> sentListView = new ListView<>();
    @FXML
    private Button addTaskButton;
    @FXML
    private Button deleteTaskButton;
    @FXML
    private Button editTaskButton;




    public void addTask(ActionEvent event) throws IOException
    {
        Main main = new Main();
        main.openDialog("NewTaskView.fxml", "New Task");
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        setupLists();
    }
}