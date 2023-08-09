package Application.ViewController;

import Application.Model.UserModel;
import Application.ViewModel.RegisterViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URISyntaxException;

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

    private RegisterViewModel viewModel;
    private ViewHandler viewHandler;

    public void init(RegisterViewModel viewModel,ViewHandler viewHandler)
    {
        this.viewModel = viewModel;
        this.viewHandler = viewHandler;
        viewModel.getUsername().bind(this.usernameTextF.textProperty());
        viewModel.getEmail().bind(this.emailTextF.textProperty());
        viewModel.getPassword().bind(this.passwordField.textProperty());
    }

    public void signUp(ActionEvent event) throws IOException, URISyntaxException, InterruptedException
    {
        if(checkInfo())
        {
            if(!viewModel.signup())
            {
                //show error message
            }
            viewHandler.changeScene("LoginView.fxml");
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
