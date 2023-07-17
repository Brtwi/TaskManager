package Application.Client.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class TaskDetails implements Initializable
{
    @FXML
    private TextField creatorTextF;
    @FXML
    private TextField titleTextF;
    @FXML
    private TextArea descriptionTextF;
    @FXML
    private TextField stateTextF;
    @FXML
    private TextField receiverTextF;
    @FXML
    private Label filesLabel;
    @FXML
    private Button editAddButton;
    @FXML
    private Button cancelButton;

    public void edit(ActionEvent event)
    {

    }

    public void cancel(ActionEvent event)
    {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        loadTask();

        enableFields();
    }

    private void enableFields()
    {
        creatorTextF.setEditable(false);
        titleTextF.setEditable(false);
        descriptionTextF.setEditable(false);
        stateTextF.setEditable(false);
        receiverTextF.setEditable(false);
    }

    private void loadTask()
    {

    }
}
