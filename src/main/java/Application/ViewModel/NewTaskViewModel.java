package Application.ViewModel;

import Application.Model.ITaskModel;
import javafx.beans.property.StringProperty;

public class NewTaskViewModel
{
    private ITaskModel taskModel;
    private StringProperty title;
    private StringProperty description;

    public NewTaskViewModel(ITaskModel taskModel)
    {
        this.taskModel = taskModel;
    }
}
