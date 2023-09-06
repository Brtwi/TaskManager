package Application.Model;

import Application.Model.Entities.User;
import Application.Model.Services.UserServices;
import lombok.Getter;
@Getter
public class UserModel //TODO Check if user need to be static, error appears in main view model
{
    @Getter
    private static User user;
    private final UserServices userServices;

    public UserModel()
    {
        this.userServices = new UserServices();
    }

    public boolean register(String username, String password, String email)
    {
        return userServices.registerUser(username, password, email);
    }

    public boolean login(String username, String password)
    {
        user = new User.UserBuilder(username).password(password).build();
        return userServices.login(user);
    }

    public boolean isConnected()
    {
        return !user.getUsername().equals("localhost");
    }

    public void locally()
    {
        user = new User.UserBuilder("localhost").build();
    }

    public void cleanUser()
    {
        user = null;
    }
}
