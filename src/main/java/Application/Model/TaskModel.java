package Application.Model;

import Application.Model.Entities.Task;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Data;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
@Data
public class TaskModel implements ITaskModel
{
    private final ObservableList<Task> allTasks = FXCollections.observableArrayList();
    private final ObservableList<Task> ownTasks = FXCollections.observableArrayList();
    private final ObservableList<Task> sentTasks = FXCollections.observableArrayList();
    private final ObservableList<Task> receivedTasks = FXCollections.observableArrayList();
    private final List<File> fileCache = new LinkedList<>();

    //task types
    public static final String ALL = "all";
    public static final String OWN = "own";
    public static final String SENT = "sent";
    public static final String RECEIVED = "received";

    @Override
    public Task getTask(int itemIndex, int tabIndex)
    {
        switch (tabIndex)
        {
            case 0 ->
            {
                return allTasks.get(itemIndex);
            }
            case 1 ->
            {
                return ownTasks.get(itemIndex);
            }
            case 2 ->
            {
                return sentTasks.get(itemIndex);
            }
            case 3 ->
            {
                return receivedTasks.get(itemIndex);
            }
        }
        return null;
    }



}
