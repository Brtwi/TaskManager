package Application.Model;

import Application.Model.Entities.User;
import Application.Model.Services.JsonServices;
import Application.Model.Services.NetworkServices;
import Application.Model.Services.TaskServices;
import Application.Model.Services.UserServices;

import java.io.IOException;
import java.net.URISyntaxException;

public class UserModel
{
    private static User user;
    private final UserServices userServices;
    private final TaskServices taskServices;

    public UserModel()
    {
        this.taskServices = new TaskServices();
        this.userServices = new UserServices();
    }

    public boolean register(String username, String password, String email) throws URISyntaxException, IOException, InterruptedException
    {
        return userServices.registerUser(username, password, email);
    }

    public boolean login(String username, String password)
    {
        User user = new User.UserBuilder(username).password(password).build();
        return taskServices.login(JsonServices.toJson(user));
    }
}
