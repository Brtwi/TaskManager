package Application.Client.Helpers;

import Application.Shared.Model.Task;

import java.util.ArrayList;

public class TaskList
{
    private ArrayList<Task> taskList = new ArrayList<>();

    public void addTask(Task task)
    {
        taskList.add(task);
    }

    public void removeTask(Task task)
    {

    }
}
