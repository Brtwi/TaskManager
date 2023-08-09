package Application.Model.Services;


import java.io.IOException;
import java.net.URISyntaxException;

public class UserServices
{
    private final NetworkServices networkServices;

    public UserServices()
    {
        this.networkServices = new NetworkServices();
    }
    public boolean registerUser(String username, String password, String email) throws URISyntaxException, IOException, InterruptedException
    {
        return networkServices.registerNewUser(username, password, email);
    }

}
