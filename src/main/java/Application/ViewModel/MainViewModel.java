package Application.ViewModel;

import Application.Model.Entities.Task;
import Application.Model.Entities.User;
import Application.Model.Interfaces.IDataModel;
import Application.Model.Interfaces.ITaskModel;
import Application.Model.Interfaces.ModelListListeners;
import Application.Model.UserModel;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import lombok.Getter;

import java.util.Optional;


@Getter
public class MainViewModel implements ModelListListeners
{
    private final ITaskModel taskModel;
    private final IDataModel dataModel;
    private final UserModel userModel;
    private final ObservableList<Task> tasks;
    private final FilteredList<Task> ownTask;
    private final FilteredList<Task> sentTask;
    private final FilteredList<Task> receivedTask;
    private final ObjectProperty<Task> selectedTask;


    public MainViewModel(ITaskModel taskModel, IDataModel dataModel, UserModel userModel)
    {
        this.taskModel = taskModel;
        this.taskModel.addListListener(this);

        this.dataModel = dataModel;
        this.userModel = userModel;

        this.tasks = FXCollections.observableArrayList(taskModel.getTasks());
        this.ownTask = tasks.filtered(task -> task.getReceiver() == null);

        this.sentTask = tasks.filtered(task -> task.getReceiver() != null &&
                !task.getReceiver().equals(UserModel.getUser().getUsername()));

        this.receivedTask = tasks.filtered(task -> task.getReceiver() != null &&
                task.getReceiver().equals(UserModel.getUser().getUsername()));

        this.selectedTask = new SimpleObjectProperty<>();

        this.selectedTask.addListener(((observableValue, oldValue, newValue) ->
                taskModel.setSelectedTask(newValue)));
    }

    @Override
    public void onAddedItem(Task item)
    {
        Platform.runLater(() -> tasks.add(item));
    }

    @Override
    public void onUpdatedItem()
    {
        Task tempTask = selectedTask.getValue();
        selectedTask.setValue(null);
        selectedTask.setValue(tempTask);
    }

    public void deleteTask()
    {
        taskModel.delete(selectedTask.getValue());
        tasks.remove(selectedTask.getValue());
    }

    public void saveLocally()
    {
        dataModel.saveLocal(tasks, Optional.ofNullable(UserModel.getUser().getEmail()));
    }

    public void clearUser()
    {
        userModel.cleanUser();
    }

    public void clearTasks()
    {
        taskModel.getTasks().clear();
        tasks.clear();
    }

    public void loadTask(User user)
    {
        if(user.getUsername().equals("localhost"))
        {
            dataModel.loadLocalTasks();
            System.out.println(taskModel.getTasks().size() + " tasks size");
            tasks.addAll(taskModel.getTasks());
        }
    }

}
