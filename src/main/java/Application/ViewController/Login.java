package Application.ViewController;

import Application.ViewModel.LoginViewModel;
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

public class Login
{
    @FXML
    private TextField usernameTextF;
    @FXML
    private PasswordField passwordTextF;
    @FXML
    private Button signInButton;
    @FXML
    private Label errorLabel;
    private ViewHandler viewHandler;
    private LoginViewModel viewModel;
    

    public void loginAction(ActionEvent event) throws IOException, InterruptedException
    {
        viewModel.login();
    }

    public void continueLocally(ActionEvent event) throws IOException
    {
        viewHandler.changeScene("MainView.fxml");
    }

    public void signUp(ActionEvent event) throws IOException
    {
        viewHandler.changeScene("RegisterView.fxml");
    }


    public void init(LoginViewModel loginViewModel, ViewHandler viewHandler)
    {
        this.viewModel = loginViewModel;
        this.viewHandler = viewHandler;

        usernameTextF.textProperty().bindBidirectional(loginViewModel.getUsername());
        passwordTextF.textProperty().bindBidirectional(loginViewModel.getPassword());
    }
}
