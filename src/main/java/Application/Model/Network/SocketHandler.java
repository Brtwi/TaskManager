package Application.Model.Network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SocketHandler
{
    private final ObjectOutputStream outputStream;
    private final ObjectInputStream inputStream;
    private final DataOutputStream dataOutputStream;
    private final DataInputStream dataInputStream;

    public SocketHandler(ObjectOutputStream outputStream, ObjectInputStream inputStream,
                         DataOutputStream dataOutputStream, DataInputStream dataInputStream)
    {
        this.outputStream = outputStream;
        this.inputStream = inputStream;
        this.dataOutputStream = dataOutputStream;
        this.dataInputStream = dataInputStream;
    }
}
