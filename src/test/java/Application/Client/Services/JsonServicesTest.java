package Application.Client.Services;

import Application.Model.Entities.Task;
import Application.Model.Entities.User;
import Application.Model.Helpers.DataContainer;
import Application.Model.POJOTest;
import Application.Model.Services.JsonServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
        String jsonArray = """
                [
                  {
                    "creator": "John",
                    "title": "Finish Project",
                    "description": "Complete the final tasks for the project."
                  },
                  {
                    "creator": "Alice",
                    "title": "Prepare Presentation",
                    "description": "Create a compelling presentation for the team."
                  },
                  {
                    "creator": "Bob",
                    "title": "Review Code",
                    "description": "Go through the codebase and provide feedback."
                  }
                ]""";

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

    @Test
    void fromJsonFile()
    {
        String filename = "test.json";

        DataContainer<User, POJOTest> container = JsonServices.fromJsonFile(filename, User.class, POJOTest.class);

        assert container != null;
        List<POJOTest> tasks = container.getObjects();

        assertEquals("userLocal", container.getObject().getUsername());
        assertTrue(tasks.containsAll(container.getObjects()));
    }

    @Test
    void toJsonFile()
    {
        String filename = "test.json";
        String user = "userLocal";
        List<POJOTest> pojos = new ArrayList<>(Arrays.asList(
                new POJOTest("user", "desc", "format"),
                new POJOTest("user", "desc", "format"),
                new POJOTest("user", "desc", "format"),
                new POJOTest()
        ));

        JsonServices.toJsonFile(filename, user, pojos);

        assertEquals(user, Objects.requireNonNull(JsonServices.fromJsonFile(filename, User.class, POJOTest.class))
                .getObject().getUsername());
    }
}