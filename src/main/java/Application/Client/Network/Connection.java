package Application.Client.Network;

import Application.Client.Services.ClientNetworkService;
import Application.Client.Services.UserServices;

import java.io.*;
import java.net.Socket;

public class Connection
{
    private final static int PORT = 2002;
    private static final String SERVER = "localhost";
    private static ClientNetworkService networkService;

    public void start()
    {
        try
        {
            Socket socket = new Socket(SERVER, PORT);
            Socket fileSocket = new Socket(SERVER, PORT);

            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());


            DataOutputStream dos = new DataOutputStream(fileSocket.getOutputStream());
            DataInputStream dis = new DataInputStream(fileSocket.getInputStream());

            networkService = new ClientNetworkService(new Client(socket, in, out, fileSocket, dos, dis));

        } catch (IOException e)
        {
            System.out.println("Error while connecting server");
        }
    }

    public static ClientNetworkService getNetworkService()
    {
        return networkService;
    }
}
