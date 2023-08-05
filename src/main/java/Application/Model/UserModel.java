package Application.Model;

import Application.Model.Entities.User;
import Application.Model.Services.JsonServices;
import Application.Model.Services.TaskServices;

public class UserModel
{
    private static User user;
    private final TaskServices taskServices;

    public UserModel()
    {
        this.taskServices = new TaskServices();
    }

    public boolean register(String username, String password, String email)
    {
        return true;
    }

    public boolean login(String username, String password)
    {
        User user = new User.UserBuilder(username).password(password).build();
        return taskServices.login(JsonServices.toJson(user));
    }
}
