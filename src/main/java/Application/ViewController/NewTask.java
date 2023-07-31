package Application.ViewController;

import Application.Model.Services.TaskServices;
import Application.Model.Entities.IUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class NewTask implements IUser
{
    @FXML
    private TextField titleTextField;
    @FXML
    private TextArea descriptionTextField;
    @FXML
    private Button cancelButton;
    @FXML
    private Label fileAmountLabel;
    @FXML
    private Label receiverLabel;
    private final TaskServices taskServices;

    public NewTask()
    {
        this.taskServices = new TaskServices();
    }

    public void cancel(ActionEvent event)
    {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void save(ActionEvent event)
    {

    }

    public void send(ActionEvent event) throws IOException
    {

    }

    public void addFiles(ActionEvent event)
    {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);

    }

    private boolean checkFields()
    {
        return !titleTextField.getText().trim().isEmpty() &&
                !descriptionTextField.getText().trim().isEmpty();
    }

}
