package Application.Model;

import Application.Model.Entities.Task;
import java.io.File;
import java.util.List;

public interface ITaskModel
{
    List<Task> getTasks();
    void saveTask(String title, String description, String receiver, List<File> files);
    void addListListener(ModelListListeners listener);
}
