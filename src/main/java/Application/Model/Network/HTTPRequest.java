package Application.Model.Network;

import Application.Model.Entities.User;
import Application.Model.Services.JsonServices;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;

public class HTTPRequest
{
    public static boolean registerUserRequest(User user)
    {
        JsonNode node = JsonServices.toJson(user);
        String requestBody;
        try
        {
            requestBody = JsonServices.stringify(node);

            HttpRequest postRequest = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8080/api/v1/user/register"))
                    .header("Content-Type", "application/json")
                    .POST(BodyPublishers.ofString(requestBody))
                    .build();

            HttpClient httpClient = HttpClient.newHttpClient();

            HttpResponse<String> response = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());

            return response.statusCode() == 200;
        } catch (URISyntaxException | IOException | InterruptedException e)
        {
            return false;
        }


    }

    public static boolean loginRequest(User user)
    {
        try
        {
            JsonNode node = JsonServices.toJson(user);
            String bodyRequest = JsonServices.stringify(node);

            HttpRequest postRequest = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8080/api/v1/user/login"))
                    .header("Content-Type", "application/json")
                    .POST(BodyPublishers.ofString(bodyRequest))
                    .build();

            HttpClient client = HttpClient.newHttpClient();

            HttpResponse<String> response = client.send(postRequest, HttpResponse.BodyHandlers.ofString());
            return response.statusCode() == 200;
        }catch(InterruptedException | URISyntaxException | IOException e)
        {
            return false;
        }
    }
}
