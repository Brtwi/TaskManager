package Application.Model.Services;

import Application.Model.Entities.User;

public class UserServices
{
    private final NetworkServices networkServices;

    public UserServices()
    {
        this.networkServices = new NetworkServices();
    }
    public boolean registerUser(String username, String password, String email)
    {
        return networkServices.registerNewUser(username, password, email);
    }

    public boolean login(User user)
    {
        return networkServices.login(user);
    }
}
