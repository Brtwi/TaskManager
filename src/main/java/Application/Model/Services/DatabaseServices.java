package Application.Model.Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseServices
{
    private final String url = "jdbc:sqlserver://bartek\\sqlexpress;databaseName=TransportPP;encrypt=true;trustServerCertificate=true;";
    private final String username = "sa";
    private final String password = "admin1234";
    private Connection connection;

    public void connect()
    {
        try
        {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());

            connection = DriverManager.getConnection(url, username, password);

        } catch (SQLException e)
        {
            System.out.println("Error while connecting to dataabase: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
