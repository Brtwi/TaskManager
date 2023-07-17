package Application.Client.Controller;

import Application.Client.Services.TaskServices;
import Application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewTask
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
            taskServices.saveTask();
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
