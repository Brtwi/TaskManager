package Application.Client.Services;

import Application.Shared.Model.Task;
import Application.Shared.Model.User;
import lombok.Data;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

@Data
public class TaskServices
{
    private final List<File> fileCache = new LinkedList<>();
    public void saveTask(Task task)
    {
        System.out.println("Task saved");
    }

    public void addFileToCache(File file)
    {
        fileCache.add(file);
    }

    public User genereteReceiverUser(String username)
    {
        return new User(username);
    }
}
