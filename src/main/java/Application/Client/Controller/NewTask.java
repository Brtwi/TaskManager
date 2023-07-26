package Application.Client.Controller;

import Application.Client.Services.TaskServices;
import Application.Main;
import Application.Shared.Model.IUser;
import Application.Shared.Model.Task;
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
            Task task = new Task.TaskBuilder(localUser, titleTextField.getText(), descriptionTextField.getText())
                    .files(taskServices.getFileCache())
                    .receiver(taskServices.genereteReceiverUser(receiverLabel.getText()))
                    .build();

            taskServices.saveTask(task);
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Check if all fields are filled", ButtonType.OK);
            alert.show();
        }
    }

    public void send(ActionEvent event) throws IOException
    {
        main.openDialog("OnlineUsersView.fxml", "Online Users");
    }

    public void addFiles(ActionEvent event)
    {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);

        taskServices.addFileToCache(file);
        fileAmountLabel.setText(taskServices.getFileCache().size() + "");
        fileAmountLabel.setVisible(true);
    }

    private boolean checkFields()
    {
        return !titleTextField.getText().trim().isEmpty() &&
                !descriptionTextField.getText().trim().isEmpty();
    }

}
