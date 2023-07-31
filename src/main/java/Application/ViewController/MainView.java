package Application.ViewController;

import Application.Model.Entities.Task;
import Application.Model.TaskModel;
import Application.ViewModel.MainViewModel;
import com.jfoenix.controls.JFXChip;
import com.jfoenix.controls.JFXListCell;
import com.jfoenix.controls.JFXListView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainView
{
    @FXML
    private static final JFXListView<Task> allListView = new JFXListView<>();
    @FXML
    private static final JFXListView<Task> ownListView = new JFXListView<>();
    @FXML
    private static final JFXListView<Task> sentListView = new JFXListView<>();
    @FXML
    private static final JFXListView<Task> receivedListView = new JFXListView<>();
    @FXML
    private TabPane tabPane;
    private MainViewModel viewModel;


    public void init(MainViewModel mainViewModel)
    {
        this.viewModel = mainViewModel;

        setupLists();
    }

    public void addTask(ActionEvent event) throws IOException
    {

    }

    public void delete(ActionEvent event) throws IOException
    {
        //TODO find actual list, check if task is selected, delete

    }

    public void logout(ActionEvent event) throws IOException
    {

    }

    public void edit(ActionEvent event) throws IOException
    {

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
        allListView.setCellFactory((Callback)(new TaskCellListRender()));
        ownListView.setCellFactory((Callback)(new TaskCellListRender()));
        sentListView.setCellFactory((Callback)(new TaskCellListRender()));
        receivedListView.setCellFactory((Callback)(new TaskCellListRender()));

        allListView.setItems(viewModel.getListToBind(TaskModel.ALL));
        ownListView.setItems(viewModel.getListToBind(TaskModel.OWN));
        sentListView.setItems(viewModel.getListToBind(TaskModel.SENT));
        receivedListView.setItems(viewModel.getListToBind(TaskModel.RECEIVED));
    }

    private static class TaskCellListRender implements Callback<JFXListView<Task>, JFXListCell<Task>>
    {
        @Override
        public JFXListCell<Task> call(JFXListView<Task> taskJFXListView)
        {
            return new JFXListCell<>()
            {
                @Override
                protected void updateItem(Task item, boolean empty)
                {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setText(null);
                    } else {
                        setText(item.getTitle() + " " + item.getState());
                    }
                }
            };
        }
    }

}