package Application.Client.Controller;

import Application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable
{
    @FXML
    private TextField usernameTextF;
    @FXML
    private PasswordField passwordTextF;
    @FXML
    private Button signInButton;
    @FXML
    private Label errorLabel;

    public void loginAction(ActionEvent event) throws IOException, InterruptedException
    {
        checkLogin();
    }

    private void checkLogin() throws IOException, InterruptedException
    {
        Main main = new Main();

        if(usernameTextF.getText().equals("admin") && passwordTextF.getText().equals("admin"))
        {
            main.changeScene("MainView.fxml");
        }
        else
        {
            errorLabel.setVisible(true);
            Thread.sleep(1000);
            errorLabel.setVisible(false);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }
}
