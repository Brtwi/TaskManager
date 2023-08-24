package Application.Model.Entities;

import Application.Model.State;
import lombok.Data;

import java.io.File;
import java.util.List;
@Data
public class Task
{
    //private final String ID;
    private String id;
    private String creator;
    private String title;
    private String description;
    private String state;
    private String receiver;
    private List<File> files;

    public Task()
    {

    }

    private Task(TaskBuilder builder)
    {
        //this.ID = builder.ID;
        this.creator = builder.creator;
        this.title = builder.title;
        this.description = builder.description;
        this.state = builder.state;
        this.receiver = builder.receiver;
        this.files = builder.files;
    }

    public static class TaskBuilder
    {
        //private final String ID;
        private final String creator;
        private final String title;
        private final String description;
        private final String state;

        //optional
        private String receiver;
        private List<File> files;

        public TaskBuilder(String creator, String title, String description)
        {

            this.creator = creator;
            this.title = title;
            this.description = description;
            this.state = State.TODO;
        }

        public TaskBuilder receiver(String receiver)
        {
            this.receiver = receiver;
            return this;
        }
        public TaskBuilder files(List<File> files)
        {
            this.files = files;
            return this;
        }
        public Task build()
        {
            return new Task(this);
        }
    }

}
