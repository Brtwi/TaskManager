package Application.Model.Services;

import Application.Model.Entities.Task;
import Application.Model.Entities.User;
import Application.Model.Network.APIData;
import Application.Model.Network.Connection;
import Application.Model.Network.SocketHandler;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class NetworkServices
{
    private final SocketHandler socketHandler;
    private HttpRequest httpRequest;
    private final HttpClient httpClient = HttpClient.newHttpClient();
    public NetworkServices()
    {
        this.socketHandler = Connection.getSocketHandler();
    }

    public boolean registerNewUser(String username, String password, String email)
    {
        User newUser = new User.UserBuilder(username)
                .password(password)
                .email(email)
                .build();

        JsonNode node = JsonServices.toJson(newUser);
        String requestBody;
        try
        {
            requestBody = JsonServices.stringify(node);

            httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(APIData.REGISTRATION_URI))
                    .header(APIData.HEADER_CONTENT_TYPE, APIData.HEADER_APP_JSON)
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            return response.statusCode() == 200;
        } catch (URISyntaxException | IOException | InterruptedException e)
        {
            return false;
        }
    }

    public boolean login(User user)
    {
        try
        {
            JsonNode node = JsonServices.toJson(user);
            String bodyRequest = JsonServices.stringify(node);

            httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(APIData.LOGIN_URI))
                    .header(APIData.HEADER_CONTENT_TYPE, APIData.HEADER_APP_JSON)
                    .POST(HttpRequest.BodyPublishers.ofString(bodyRequest))
                    .build();


            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            return response.statusCode() == 200;

        }catch(InterruptedException | URISyntaxException | IOException e)
        {
            return false;
        }
    }

    public List<Task> pullTasksFromServer()
    {
        try
        {
            httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(APIData.GET_TASK_URI))
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if(response.statusCode() == 200)
            {
                return JsonServices.fromJsonArrayStringToTaskList(response.body());
            }

        } catch (URISyntaxException | IOException | InterruptedException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
