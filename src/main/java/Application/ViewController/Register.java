package Application.ViewController;

import Application.ViewModel.RegisterViewModel;
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

    public void signUp()
    {
        if(checkInfo())
        {
            if(!viewModel.signup())
            {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Email is already registered", ButtonType.OK);
                alert.show();
            }
            viewHandler.changeScene(FXMLNames.LOGIN_VIEW);
        }
    }

    public void backToLogin(ActionEvent event)
    {
        viewHandler.changeScene(FXMLNames.LOGIN_VIEW);
    }

    private boolean checkInfo()
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
