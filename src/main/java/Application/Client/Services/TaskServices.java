package Application.Client.Services;

import Application.Client.Controller.MainView;
import Application.Shared.Model.Task;
import Application.Shared.Model.User;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Data;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Data
public class TaskServices
{
    private final List<File> fileCache = new LinkedList<>();
    private static final List<Task> tasks = new ArrayList<>();
    public static ObservableList<Task> taskViewModel = FXCollections.observableArrayList(tasks);
    public void saveTask(Task task)
    {
        tasks.add(task);

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
