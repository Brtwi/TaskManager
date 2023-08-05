package Application.Model.Network;

import lombok.Getter;

import java.io.*;
import java.net.Socket;

public class Connection
{
    private final static int PORT = 2002;
    private static final String SERVER = "localhost";
    private static Socket taskSocket;
    private static Socket fileSocket;
    @Getter
    private static SocketHandler socketHandler;


    public void start()
    {
        try
        {
            Socket taskSocket = new Socket(SERVER, PORT);
            Socket fileSocket = new Socket(SERVER, PORT);

            socketHandler = setupSocketHandler(taskSocket, fileSocket);
        } catch (IOException e)
        {
            System.out.println("Error while getting connection");
        }
    }

    private SocketHandler setupSocketHandler (Socket taskSocket, Socket fileSocket) throws IOException
    {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(taskSocket.getOutputStream());
        ObjectInputStream objectInputStream = new ObjectInputStream(taskSocket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(fileSocket.getOutputStream());
        DataInputStream dataInputStream = new DataInputStream(fileSocket.getInputStream());
        return new SocketHandler(objectOutputStream, objectInputStream, dataOutputStream, dataInputStream);
    }

}
