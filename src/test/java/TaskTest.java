import Application.Model.Entities.Task;
import Application.Model.Entities.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

public class TaskTest
{
    @Test
    void taskBuilderTest()
    {
        //given
        String title = "title";
        String description = "description";
        User creator = new User.UserBuilder("creator").password("password").build();
        User receiver = new User.UserBuilder("receiver").password("password").build();
        ArrayList<File> files = new ArrayList<File>();

        //when
        Task task = new Task.TaskBuilder(creator,title,description)
                .receiver(receiver)
                .files(files)
                .build();

        //then
        Assertions.assertThat(task)
                .hasNoNullFieldsOrProperties();

    }
}
