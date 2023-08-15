package Application.Client.Services;

import Application.Model.Entities.Task;
import Application.Model.Entities.User;
import Application.Model.Services.JsonServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonServicesTest
{
    private final Task task = new Task.TaskBuilder("creator", "TestTitle", "TestDescription")
            .files(List.of(new File("src/main/resources/Objects.BankAccount.json")))
            .receiver("receiver")
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
    void fromJsonArray() throws JsonProcessingException
    {
        String jsonArray = "[\n" +
                "  {\n" +
                "    \"creator\": \"John\",\n" +
                "    \"title\": \"Finish Project\",\n" +
                "    \"description\": \"Complete the final tasks for the project.\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"creator\": \"Alice\",\n" +
                "    \"title\": \"Prepare Presentation\",\n" +
                "    \"description\": \"Create a compelling presentation for the team.\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"creator\": \"Bob\",\n" +
                "    \"title\": \"Review Code\",\n" +
                "    \"description\": \"Go through the codebase and provide feedback.\"\n" +
                "  }\n" +
                "]";

        List<Task> tasks = JsonServices.fromJsonArrayStringToTaskList(jsonArray);

        assertEquals("Finish Project", tasks.get(0).getTitle());
        assertEquals("Prepare Presentation", tasks.get(1).getTitle());
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