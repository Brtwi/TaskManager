package Application.ViewModel;

import Application.Model.Entities.Task;
import Application.Model.ITaskModel;
import Application.Model.TaskModel;
import javafx.collections.ObservableList;


public class MainViewModel
{
    private ITaskModel taskModel;


    public MainViewModel(ITaskModel taskModel)
    {
        this.taskModel = taskModel;
    }
    public ObservableList<Task> getListToBind(String taskListType)
    {
        switch (taskListType)
        {
            case TaskModel.ALL ->
            {
                return taskModel.getAllTasks();
            }
            case TaskModel.OWN ->
            {
                return taskModel.getOwnTasks();
            }
            case TaskModel.SENT ->
            {
                return taskModel.getSentTasks();
            }
            case TaskModel.RECEIVED ->
            {
                return taskModel.getReceivedTasks();
            }
        }
        return null;
    }
}
