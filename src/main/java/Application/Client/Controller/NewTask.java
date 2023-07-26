package Application.Client.Controller;

import Application.Client.Services.TaskServices;
import Application.Main;
import Application.Shared.Model.IUser;
import Application.Shared.Model.Task;
import Application.Shared.Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewTask implements IUser
{
    @FXML
    private TextField titleTextField;
    @FXML
    private TextArea descriptionTextField;
    @FXML
    private Button addFilesButton;
    @FXML
    private Button saveButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Button sendButton;
    @FXML
    private Label fileAmountLabel;
    private final TaskServices taskServices;
    private final Main main = new Main();

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
        if(checkFields())
        {
            takeTaskData();
            Task task = new Task.TaskBuilder(localUser, titleTextField.getText(), descriptionTextField.getText())
                    .build();
            //taskServices.saveTask();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Check if all fields are filled", ButtonType.OK);
            alert.show();
        }
    }

    private void takeTaskData()
    {

    }

    public void send(ActionEvent event) throws IOException
    {
        main.openDialog("OnlineUsersView.fxml", "Online Users");
    }

    public void addFiles(ActionEvent event)
    {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);

        taskServices.addFileToQueue(file);
    }

    private boolean checkFields()
    {
        return !titleTextField.getText().trim().isEmpty() &&
                !descriptionTextField.getText().trim().isEmpty();
    }

    private void setAmountLabel(int amount)
    {
        this.fileAmountLabel.setText(String.valueOf(amount));
    }


}
