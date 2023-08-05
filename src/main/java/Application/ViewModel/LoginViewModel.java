package Application.ViewModel;

import Application.Model.UserModel;
import javafx.beans.property.StringProperty;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lombok.Getter;

@Getter
public class LoginViewModel
{
    private final UserModel userModel;
    private StringProperty username;
    private StringProperty password;
    public LoginViewModel(UserModel userModel)
    {
        this.userModel = userModel;
    }

    public void login()
    {
        userModel.login(username.toString(), password.toString());
    }
}
