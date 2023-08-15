package Application.Model.Services;

import Application.Model.Entities.Task;
import Application.Model.Entities.User;
import Application.Model.TaskModel;
import Application.Model.UserModel;
import lombok.Data;

import java.io.File;
import java.util.List;

@Data
public class TaskServices
{
    private TaskModel taskModel;

    public Task saveTask(String title, String description, String receiver, List<File> files)
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

        return taskBuilder.build();
    }

    public User genereteReceiverUser(String username)
    {
        return new User.UserBuilder(username).build();
    }
}
