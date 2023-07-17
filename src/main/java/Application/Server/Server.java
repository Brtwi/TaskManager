package Application.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    public static final int PORT = 2002;
    private static final ServerSocket serverSocket = null;


    public void start()
    {
        System.out.println("Starting server");

        try
        {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while(true)
            {
                System.out.println("Waiting for clients...");

                Socket socket = serverSocket.accept();
                Socket socketFile = serverSocket.accept();

                System.out.println("New Client");


            }
        } catch (IOException e)
        {
            System.out.println("Error while connecting to client");
        }
        finally
        {
            try
            {
                serverSocket.close();
            } catch (IOException e)
            {
                System.out.println("Error while closing server");
            }
        }
    }

}

