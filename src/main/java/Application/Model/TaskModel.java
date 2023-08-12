package Application.Model;

import Application.Model.Entities.Task;
import lombok.Data;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
@Data
public class TaskModel implements ITaskModel
{
    private final ArrayList<Task> tasks = new ArrayList<>();
    private final ArrayList<ModelListListeners> listListeners = new ArrayList<>();
    private final List<File> fileCache = new LinkedList<>();

    @Override
    public void saveTask(String title, String description, String receiver, List<File> files)
    {
        Task.TaskBuilder taskBuilder = new Task.TaskBuilder(UserModel.getUser().getUsername(), title, description);

        if (receiver != null)
        {
            taskBuilder.receiver(receiver);
        }
        if (files != null)
        {
            taskBuilder.files(files);
        }

        tasks.add(taskBuilder.build());
        notifyListListeners(taskBuilder.build());
    }

    public List<Task> getTasks()
    {
        return tasks;
    }

    public void addListListener(ModelListListeners listener)
    {
        listListeners.add(listener);
    }

    private void notifyListListeners(Task task)
    {
        for(ModelListListeners listener : listListeners)
        {
            listener.onAddedItem(task);
        }
    }
}
