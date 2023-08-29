package Application.ViewModel;

import Application.Model.ITaskModel;
import Application.Model.UserModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Getter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class NewTaskViewModel
{
    private final ITaskModel taskModel;
    private final UserModel userModel;
    @Getter
    private final StringProperty title;
    @Getter
    private final StringProperty description;
    @Getter
    private final StringProperty receiver;
    @Getter
    private final List<File> files;

    public NewTaskViewModel(ITaskModel taskModel, UserModel userModel)
    {
        this.taskModel = taskModel;
        this.userModel = userModel;
        this.title = new SimpleStringProperty();
        this.description = new SimpleStringProperty();
        this.receiver = new SimpleStringProperty();
        this.files = new ArrayList<>();
    }

    public void saveTask()
    {
        taskModel.saveTask(title.getValue(), description.getValue(), receiver.getValue(), files);
    }

    public boolean isUserConnected()
    {
        return userModel.isConnected();
    }
}
