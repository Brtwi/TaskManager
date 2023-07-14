package Application.Client.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Register
{
    @FXML
    private TextField usernameTextF;
    @FXML
    private TextField emailTextF;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button signUpButton;

    public void signUp(ActionEvent event)
    {
        checkInfo();
    }

    private void checkInfo()
    {
        if(usernameTextF.getText().trim().isEmpty()
                || emailTextF.getText().trim().isEmpty()
                || passwordField.getText().trim().isEmpty())
        {

        }
        else
        {

        }
    }
}
