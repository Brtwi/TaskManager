package Application.Client.Controller;

import Application.Main;
import Application.Shared.Model.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainView implements Initializable, IMain
{
    @FXML
    private ListView<Task> allListView = new ListView<>();
    @FXML
    private ListView<Task> ownListView = new ListView<>();
    @FXML
    private ListView<Task> sentListView = new ListView<>();
    @FXML
    private TabPane tabPane;

    public void addTask(ActionEvent event) throws IOException
    {
        main.openDialog("NewTaskView.fxml", "New Task");
    }

    public void delete(ActionEvent event) throws IOException
    {
        //TODO find actual list, check if task is selected, delete

    }

    public void logout(ActionEvent event) throws IOException
    {
        main.changeScene("LoginView.fxml");
    }

    public void edit(ActionEvent event) throws IOException
    {
        Task task = getSelectedTask();

        if(task != null)
            main.openDialog("TaskDetailsView.fxml", "Edit Task");

    }

    private Task getSelectedTask()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Please select task to edit", ButtonType.OK);
        Task task = null;

        switch (tabPane.getSelectionModel().getSelectedIndex())
        {
            case 0 ->
            {
                if (allListView.getSelectionModel().getSelectedItem() == null)
                    alert.show();
                else
                    task = allListView.getSelectionModel().getSelectedItem();
            }
            case 1 ->
            {
                if (ownListView.getSelectionModel().getSelectedItem() == null)
                    alert.show();
                task = ownListView.getSelectionModel().getSelectedItem();
            }
            case 2 ->
            {
                if (sentListView.getSelectionModel().getSelectedItem() == null)
                    alert.show();
                task = sentListView.getSelectionModel().getSelectedItem();
            }
        }
        return task;
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