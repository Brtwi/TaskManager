package Application.ViewModel;

import Application.Model.ITaskModel;
import Application.Model.UserModel;
import javafx.beans.property.StringProperty;

public class EditViewModel
{
    private ITaskModel taskModel;
    private StringProperty title;
    private StringProperty description;

    public EditViewModel(ITaskModel taskModel)
    {
        this.taskModel = taskModel;
    }
}
