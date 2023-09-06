package Application.ViewController;

import Application.Model.Entities.Task;
import Application.Model.UserModel;
import Application.ViewModel.MainViewModel;
import com.jfoenix.controls.JFXListCell;
import com.jfoenix.controls.JFXListView;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TabPane;
import javafx.util.Callback;


public class MainView
{
    @FXML
    private JFXListView<Task> allTaskView;
    @FXML
    private JFXListView<Task> ownListView;
    @FXML
    private JFXListView<Task> sentListView;
    @FXML
    private JFXListView<Task> receivedListView;
    @FXML
    private TabPane tabPane;

    private MainViewModel viewModel;
    private ViewHandler viewHandler;


    public void init(MainViewModel mainViewModel, ViewHandler viewHandler)
    {
        this.viewModel = mainViewModel;
        this.viewHandler = viewHandler;
        setupLists();
        viewModel.loadTask(UserModel.getUser());
    }

    public void addTask()
    {
        viewHandler.openDialog(FXMLNames.NEW_TASK_VIEW, "New task");
    }

    public void delete()
    {
        if(isTaskSelected())
        {
            viewModel.deleteTask();
        }
    }

    public void logout()
    {
        viewModel.saveLocally();
        viewModel.clearUser();
        viewModel.clearTasks();
        viewHandler.changeScene(FXMLNames.LOGIN_VIEW);
    }

    public void edit()
    {
        if(isTaskSelected())
        {
            viewHandler.openDialog(FXMLNames.EDIT_VIEW, "Edit task");
        }
    }

    public boolean isTaskSelected()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Please select task to edit", ButtonType.OK);

        switch (tabPane.getSelectionModel().getSelectedIndex())
        {
            case 0 ->
            {
                if (allTaskView.getSelectionModel().isEmpty())
                {
                    alert.show();
                    return false;
                }
                return true;
            }
            case 1 ->
            {
                if (ownListView.getSelectionModel().isEmpty())
                {
                    alert.show();
                    return false;
                }
                return true;
            }
            case 2 ->
            {
                if (sentListView.getSelectionModel().isEmpty())
                {
                    alert.show();
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private void setupLists()
    {
        allTaskView.setCellFactory((Callback)new TaskCellListRender());
        ownListView.setCellFactory((Callback)(new TaskCellListRender()));
        sentListView.setCellFactory((Callback)(new TaskCellListRender()));
        receivedListView.setCellFactory((Callback)(new TaskCellListRender()));

        allTaskView.setItems(viewModel.getTasks());
        ownListView.setItems(viewModel.getOwnTask());
        sentListView.setItems(viewModel.getSentTask());
        receivedListView.setItems(viewModel.getReceivedTask());

        allTaskView.getSelectionModel().selectedItemProperty().addListener((observable,oldItem ,newItem) ->
                viewModel.getSelectedTask().set(newItem));

        ownListView.getSelectionModel().selectedItemProperty().addListener((observable,oldItem ,newItem) ->
                viewModel.getSelectedTask().set(newItem));

        sentListView.getSelectionModel().selectedItemProperty().addListener((observable,oldItem ,newItem) ->
                viewModel.getSelectedTask().set(newItem));

        receivedListView.getSelectionModel().selectedItemProperty().addListener((observable,oldItem ,newItem) ->
                viewModel.getSelectedTask().set(newItem));

        viewModel.getSelectedTask().addListener((observable) ->
        {
            allTaskView.refresh();
            ownListView.refresh();
            sentListView.refresh();
            receivedListView.refresh();
        });
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