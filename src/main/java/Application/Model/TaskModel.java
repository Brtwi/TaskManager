package Application.Model;

import Application.Model.Entities.Task;
import Application.Model.Services.NetworkServices;
import Application.Model.Services.TaskServices;
import lombok.Data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
@Data
public class TaskModel implements ITaskModel
{
    private final ArrayList<Task> tasks = new ArrayList<>();
    private final ArrayList<ModelListListeners> listListeners = new ArrayList<>();
    private Task selectedTask = new Task();

    private final TaskServices taskServices = new TaskServices();
    private final NetworkServices networkServices = new NetworkServices();

    @Override
    public void saveTask(String title, String description, String receiver, List<File> files)
    {
        tasks.add(taskServices.saveTask(title, description, receiver, files));
        notifyListListeners(tasks.get(tasks.size() - 1));
    }
    @Override
    public List<Task> getTasks()
    {
        return tasks;
    }

    @Override
    public void setSelectedTask(Task selectedTask)
    {
        this.selectedTask = selectedTask;
    }

    public void addListListener(ModelListListeners listener)
    {
        listListeners.add(listener);
    }

    private void notifyListListeners(Task task)
    {
        listListeners.forEach(listener -> listener.onAddedItem(task));
    }

    private void notifyListListenersUpdate()
    {
        listListeners.forEach(ModelListListeners::onUpdatedItem);
    }

    public boolean pullTasksFromServer()
    {
        List<Task> pulledTasks = networkServices.pullTasksFromServer();
        if(pulledTasks != null)
        {
            synchronizeWithPulled(pulledTasks);
            return true;
        }
        return false;
    }

    @Override
    public void update(String title, String description, String state)
    {
        taskServices.updateTask(title, description, state, selectedTask);
        notifyListListenersUpdate();
    }

    @Override
    public void delete(Task taskToRemove)
    {
        tasks.remove(taskToRemove);
    }

    private void synchronizeWithPulled(List<Task> pulledTasks)
    {
        this.tasks.addAll(pulledTasks);
        for(Task task : pulledTasks)
        {
            notifyListListeners(task);
        }
    }

}
