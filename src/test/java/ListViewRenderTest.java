import Application.Model.Entities.Task;
import Application.Model.Entities.User;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListViewRenderTest extends FXTest
{
    private ListView<Task> listView;
    private ObservableList<Task> items;
    @BeforeEach
    public void setup()
    {
        listView = new ListView<>();
        listView.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(Task task, boolean b) {
                super.updateItem(task, b);

                if (b || task == null) {
                    setText(null);
                } else {
                    setText(task.getTitle() + " " + task.getState());
                }
            }
        });

        items = FXCollections.observableArrayList();
        listView.setItems(items);
    }

    @Test
    public void testListViewRendering() {
        // Given
        User user = new User.UserBuilder("test").password("test").email("test@example.com").build();
        Task task = new Task.TaskBuilder(user, "title", "description")
                .build();

        // When
        Platform.runLater(() -> items.addAll(task));

        // Then
        Assertions.assertEquals(items.size(), listView.getItems().size());

        for (int i = 0; i < items.size(); i++) {
            Assertions.assertEquals(items.get(i), listView.getItems().get(i));
        }
    }
}