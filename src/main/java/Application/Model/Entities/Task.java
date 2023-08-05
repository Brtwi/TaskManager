package Application.Model.Entities;

import Application.Model.State;
import lombok.Data;

import java.io.File;
import java.util.List;
@Data
public class Task
{
    private final String ID;
    private User creator;
    private String title;
    private String description;
    private State state;
    private User receiver;
    private List<File> files;

    private Task(TaskBuilder builder)
    {
        this.ID = builder.ID;
        this.creator = builder.creator;
        this.title = builder.title;
        this.description = builder.description;
        this.state = builder.state;
        this.receiver = builder.receiver;
        this.files = builder.files;
    }

    public static class TaskBuilder
    {
        private static int IDint = 1;
        private String ID;
        private User creator;
        private String title;
        private String description;
        private State state;

        //optional
        private User receiver;
        private List<File> files;

        public TaskBuilder(User creator, String title, String description)
        {
            this.ID = String.valueOf(IDint++);
            this.creator = creator;
            this.title = title;
            this.description = description;
            this.state = State.TODO;
        }

        public TaskBuilder receiver(User receiver)
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
