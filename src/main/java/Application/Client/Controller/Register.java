package Application.Client.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class Register implements IMain
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
        checkInfo();
    }

    public void backToLogin(ActionEvent event) throws IOException
    {
        main.changeScene("LoginView.fxml");
    }

    private void checkInfo() throws IOException
    {
        if(usernameTextF.getText().trim().isEmpty()
                || emailTextF.getText().trim().isEmpty()
                || passwordField.getText().trim().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter required data.", ButtonType.OK);
            alert.show();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Welcome " + usernameTextF.getText(), ButtonType.OK);
            alert.show();
            main.changeScene("MainView.fxml");
        }
    }
}
