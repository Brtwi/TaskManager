package Application.Model;

import Application.Model.Entities.Task;
import javafx.collections.ObservableList;

public interface ITaskModel
{
    Task getTask(int itemIndex, int tabIndex);
    ObservableList<Task> getAllTasks();
    ObservableList<Task> getOwnTasks();
    ObservableList<Task> getSentTasks();
    ObservableList<Task> getReceivedTasks();

}
