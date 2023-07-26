package Application.Client.Services;

import Application.Shared.Model.Task;

import java.io.File;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskServices
{
    private final Queue<File> fileQueue = new PriorityQueue<>();
    public void saveTask(Task task)
    {
        System.out.println("Task saved");
    }

    public void addFileToQueue(File file)
    {
        fileQueue.add(file);
    }
}
