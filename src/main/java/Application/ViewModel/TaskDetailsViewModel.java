package Application.ViewModel;

import Application.Model.ITaskModel;
import javafx.beans.property.StringProperty;

public class TaskDetailsViewModel
{
    private ITaskModel taskModel;
    private StringProperty title;
    private StringProperty description;

    public TaskDetailsViewModel(ITaskModel taskModel)
    {
        this.taskModel = taskModel;
    }
}
