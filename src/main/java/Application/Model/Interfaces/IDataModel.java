package Application.Model.Interfaces;

import Application.Model.Entities.Task;
import Application.Model.Entities.User;

import java.util.List;
import java.util.Optional;

public interface IDataModel
{
    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    void saveLocal(List<Task> taskList, Optional<String> email);

    void loadLocalTasks();

    void loadUserCacheTasks(User user);

    List<Task> getLocalTasks();
}
