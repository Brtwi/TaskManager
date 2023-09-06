package Application.ViewController;

import Application.ViewModel.LoginViewModel;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.util.Duration;


public class Login
{
    @FXML
    private TextField usernameTextF;
    @FXML
    private PasswordField passwordTextF;
    @FXML
    private Label errorLabel;
    private ViewHandler viewHandler;
    private LoginViewModel viewModel;
    

    public void loginAction()
    {
        if(viewModel.login())
        {
            viewHandler.changeScene(FXMLNames.MAIN_VIEW);
        }
        else
        {
            errorLabel.setVisible(true);

            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(2), errorLabel);
            fadeTransition.setFromValue(1.0);
            fadeTransition.setToValue(0.0);
            fadeTransition.setOnFinished(event -> errorLabel.setVisible(false));
            fadeTransition.play();
        }
    }

    public void continueLocally()
    {
        viewModel.continueLocally();
        viewHandler.changeScene(FXMLNames.MAIN_VIEW);
    }

    public void signUp()
    {
        viewHandler.changeScene(FXMLNames.REGISTER_VIEW);
    }


    public void init(LoginViewModel loginViewModel, ViewHandler viewHandler)
    {
        this.viewModel = loginViewModel;
        this.viewHandler = viewHandler;

        loginViewModel.getUsername().bind(this.usernameTextF.textProperty());
        loginViewModel.getPassword().bind(this.passwordTextF.textProperty());
    }
}
