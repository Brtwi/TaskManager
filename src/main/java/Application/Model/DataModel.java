package Application.Model;

import Application.Model.Entities.Task;
import Application.Model.Entities.User;
import Application.Model.Helpers.DataContainer;
import Application.Model.Interfaces.IDataModel;
import Application.Model.Services.JsonServices;

import java.io.File;
import java.util.List;
import java.util.Optional;

public class DataModel implements IDataModel
{
    private final List<Task> modelTaskList;
    public static final String JSON_DIR = System.getProperty("user.dir") + File.separator;
    private final String localUserFile = "local.json";
    private final String cacheUserFile = "backupUserFile.json";

    public DataModel(List<Task> modelTaskList)
    {
        this.modelTaskList = modelTaskList;
    }
    @Override
    public void saveLocal(List<Task> taskList, Optional<String> email)
    {
        if(email.isPresent())
        {
            JsonServices.toJsonFile(cacheUserFile, email, taskList);
        }
        else
        {
            JsonServices.toJsonFile(localUserFile, UserModel.getUser().getUsername(), taskList);
        }
    }

    @Override
    public void loadLocalTasks()
    {
        DataContainer<String, Task> container = JsonServices.fromJsonFile(localUserFile, String.class, Task.class);
        if (container != null)
        {
            this.modelTaskList.addAll(container.getObjects());
        }
    }

    @Override
    public void loadUserCacheTasks(User user)
    {

    }

    @Override
    public List<Task> getLocalTasks()
    {
        return modelTaskList;
    }
}
