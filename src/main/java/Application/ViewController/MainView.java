package Application.ViewController;

import Application.Model.Entities.Task;
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
    }

    public void addTask()
    {
        viewHandler.openDialog(FXMLNames.NEW_TASK_VIEW, "New task");
    }

    public void delete()
    {
        //TODO find actual list, check if task is selected, delete
    }

    public void logout()
    {

    }

    public void edit()
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
                if (allTaskView.getSelectionModel().getSelectedItem() == null)
                    alert.show();
                else
                    task = allTaskView.getSelectionModel().getSelectedItem();


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
        allTaskView.setCellFactory((Callback)new TaskCellListRender());
        ownListView.setCellFactory((Callback)(new TaskCellListRender()));
        sentListView.setCellFactory((Callback)(new TaskCellListRender()));
        receivedListView.setCellFactory((Callback)(new TaskCellListRender()));

        allTaskView.setItems(viewModel.getTasks());
        ownListView.setItems(viewModel.getOwnTask());
        sentListView.setItems(viewModel.getSentTask());
        receivedListView.setItems(viewModel.getReceivedTask());
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