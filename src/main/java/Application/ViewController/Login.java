package Application.ViewController;

import Application.ViewModel.LoginViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


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
            Thread errorLabelThread = new Thread(() ->
            {
                try
                {
                    for (int i = 255; i >= 0; i--)
                    {
                        errorLabel.setOpacity((float) i / 255);
                        Thread.sleep(5);
                    }
                    errorLabel.setVisible(false);
                }catch (InterruptedException ignored)
                {
                }
            });
            errorLabelThread.start();
        }
    }

    public void continueLocally()
    {
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
