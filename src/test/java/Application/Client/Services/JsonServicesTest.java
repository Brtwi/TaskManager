package Application.Client.Services;

import Application.Model.Entities.Task;
import Application.Model.Entities.User;
import Application.Model.Services.JsonServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonServicesTest
{
    User user = new User.UserBuilder("test").build();
    User receiver = new User.UserBuilder("testReceiver").build();
    private final Task task = new Task.TaskBuilder(user, "TestTitle", "TestDescription")
            .files(List.of(new File("src/main/resources/Objects.BankAccount.json")))
            .receiver(receiver)
            .build();

    @Test
    void fromJson() throws JsonProcessingException
    {
        User user = new User.UserBuilder("test").password("test").build();
        JsonNode node = JsonServices.toJson(user);
        User testUser = JsonServices.fromJson(node, User.class);

        assertEquals(user, testUser);
    }

    @Test
    void toJson()
    {
        JsonNode node = JsonServices.toJson(task);

        assertEquals(node.get("title").asText(), task.getTitle() );
    }

    @Test
    void stringify() throws JsonProcessingException
    {
        JsonNode node = JsonServices.toJson(task);
        System.out.println(JsonServices.stringify(node));
    }
}