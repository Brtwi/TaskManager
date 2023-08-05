package Application.ViewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

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
    @FXML
    private Button signinButton;

    public void signUp(ActionEvent event) throws IOException
    {
        if(checkInfo())
        {

        }
    }

    public void backToLogin(ActionEvent event) throws IOException
    {
    }

    private boolean checkInfo() throws IOException
    {
        if(usernameTextF.getText().trim().isEmpty()
                || emailTextF.getText().trim().isEmpty()
                || passwordField.getText().trim().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter required data.", ButtonType.OK);
            alert.show();
            return false;
        }
        else
        {
            return true;
        }
    }
}
