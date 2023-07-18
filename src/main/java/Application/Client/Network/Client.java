package Application.Client.Network;


import java.io.*;
import java.net.Socket;


public class Client
{
    private final Socket socket;
    private final Socket fileSocket;
    private final ObjectInputStream inputStream;
    private final ObjectOutputStream outputStream;
    private final DataInputStream dataInputStream;
    private final DataOutputStream dataOutputStream;
    private static final Integer LOCK = 1212;

    public Client(Socket socket, ObjectInputStream inputStream, ObjectOutputStream outputStream, Socket socketFile, DataOutputStream dos, DataInputStream dis)
    {
        this.socket = socket;
        this.inputStream = inputStream;
        this.outputStream = outputStream;
        this.fileSocket = socketFile;
        this.dataInputStream = dis;
        this.dataOutputStream = dos;
    }

    public Socket getSocket()
    {
        return socket;
    }

    public Socket getFileSocket()
    {
        return fileSocket;
    }

    public ObjectInputStream getInputStream()
    {
        return inputStream;
    }

    public ObjectOutputStream getOutputStream()
    {
        return outputStream;
    }

    public DataInputStream getDataInputStream()
    {
        return dataInputStream;
    }

    public DataOutputStream getDataOutputStream()
    {
        return dataOutputStream;
    }
}
