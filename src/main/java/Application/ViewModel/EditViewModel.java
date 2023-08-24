package Application.ViewModel;

import Application.Model.ITaskModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Getter;

import java.io.File;
import java.util.List;

@Getter
public class EditViewModel
{
    private final ITaskModel taskModel;
    private final StringProperty creator;
    private final StringProperty title;
    private final StringProperty description;
    private final StringProperty receiver;
    private final StringProperty state;
    private final StringProperty filenames;

    public EditViewModel(ITaskModel taskModel)
    {
        this.taskModel = taskModel;
        this.creator = new SimpleStringProperty();
        this.title = new SimpleStringProperty();
        this.description = new SimpleStringProperty();
        this.receiver = new SimpleStringProperty();
        this.state = new SimpleStringProperty();
        this.filenames = new SimpleStringProperty();
    }

    public void loadTask()
    {
        this.creator.setValue(taskModel.getSelectedTask().getCreator());
        this.title.setValue(taskModel.getSelectedTask().getTitle());
        this.description.setValue(taskModel.getSelectedTask().getDescription());
        this.receiver.setValue(taskModel.getSelectedTask().getReceiver());
        this.state.setValue(taskModel.getSelectedTask().getState());
        this.filenames.setValue(fileListToPrettyString(taskModel.getSelectedTask().getFiles()));
    }

    public void updateTask()
    {
        taskModel.update(title.getValue(), description.getValue(), state.getValue());
    }

    private String fileListToPrettyString(List<File> fileList)
    {
        if(fileList.isEmpty())
            return null;

        StringBuilder result = new StringBuilder();
        for(File file : fileList)
        {
            result.append(file.getName()).append(", ");
        }
        result.delete(result.length() - 2, result.length());
        return result.toString();
    }

}
