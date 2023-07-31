package Application.Model.Services;

import Application.Model.Entities.Task;
import Application.Model.Entities.User;
import Application.Model.TaskModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Data;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Data
public class TaskServices
{
    private TaskModel taskModel;

    public void saveTask(Task task)
    {

    }

    public void addFileToCache(File file)
    {
        taskModel.getFileCache().add(file);
    }

    public User genereteReceiverUser(String username)
    {
        return new User(username);
    }
}
