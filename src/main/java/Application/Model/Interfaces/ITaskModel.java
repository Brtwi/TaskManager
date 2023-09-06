package Application.Model.Interfaces;

import Application.Model.Entities.Task;

import java.io.File;
import java.util.List;

public interface ITaskModel
{
    List<Task> getTasks();
    void setSelectedTask(Task selectedTask);
    Task getSelectedTask();
    void saveTask(String title, String description, String receiver, List<File> files);
    void addListListener(ModelListListeners listener);
    boolean pullTasksFromServer();
    void update(String title, String description, String state);
    void delete(Task taskToRemove);
}
