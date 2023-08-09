package Application.Model.Services;

import Application.Model.Entities.User;
import Application.Model.Network.Connection;
import Application.Model.Network.HTTPRequest;
import Application.Model.Network.SocketHandler;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.net.URISyntaxException;

public class NetworkServices
{
    private final SocketHandler socketHandler;
    private HTTPRequest httpRequest;

    public NetworkServices()
    {
        this.socketHandler = Connection.getSocketHandler();
    }

    public boolean registerNewUser(String username, String password, String email) throws URISyntaxException, IOException, InterruptedException
    {
        User newUser = new User.UserBuilder(username)
                .password(password)
                .email(email)
                .build();

        return HTTPRequest.registerUserRequest(newUser);
    }
    public void connect()
    {

    }
}
