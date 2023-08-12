package Application.ViewModel;

import Application.Model.Entities.Task;
import Application.Model.ITaskModel;
import Application.Model.ModelListListeners;
import Application.Model.UserModel;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import lombok.Getter;

@Getter
public class MainViewModel implements ModelListListeners
{
    private final ITaskModel taskModel;
    private final ObservableList<Task> tasks;
    private final FilteredList<Task> ownTask;
    private final FilteredList<Task> sentTask;
    private final FilteredList<Task> receivedTask;


    public MainViewModel(ITaskModel taskModel)
    {
        this.taskModel = taskModel;
        this.taskModel.addListListener(this);

        this.tasks = FXCollections.observableArrayList(taskModel.getTasks());
        this.ownTask = tasks.filtered(task -> task.getReceiver() == null);

        this.sentTask = tasks.filtered(task -> task.getReceiver() != null &&
                !task.getReceiver().equals(UserModel.getUser().getUsername()));

        this.receivedTask = tasks.filtered(task -> task.getReceiver() != null &&
                task.getReceiver().equals(UserModel.getUser().getUsername()));
    }

    @Override
    public void onAddedItem(Task item)
    {
        Platform.runLater(() -> tasks.add(item));
    }
}
