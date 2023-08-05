package Application.Model.Services;

import Application.Model.Network.Connection;
import Application.Model.Network.SocketHandler;

public class NetworkServices
{
    private final SocketHandler socketHandler;

    public NetworkServices()
    {
        this.socketHandler = Connection.getSocketHandler();
    }
    public void connect()
    {

    }
}
