package Application.ViewModel;

import Application.Model.ITaskModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Getter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class NewTaskViewModel
{
    private final ITaskModel taskModel;
    @Getter
    private StringProperty title;
    @Getter
    private StringProperty description;
    @Getter
    private StringProperty receiver;
    @Getter
    private final List<File> files;

    public NewTaskViewModel(ITaskModel taskModel)
    {
        this.taskModel = taskModel;

        this.title = new SimpleStringProperty();
        this.description = new SimpleStringProperty();
        this.receiver = new SimpleStringProperty();
        this.files = new ArrayList<>();
    }

    public void saveTask()
    {
        taskModel.saveTask(title.getValue(), description.getValue(), receiver.getValue(), files);
    }
}
