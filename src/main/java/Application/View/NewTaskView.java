package Application.View;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class NewTaskView implements Initializable
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }
    private void setAmountLabel(int amount)
    {
        this.fileAmountLabel.setText(String.valueOf(amount));
    }

    private void clearFields()
    {
        this.titleTextField.setText("");
        this.descriptionTextField.setText("");
    }

    private void setupButtons()
    {

    }
}
