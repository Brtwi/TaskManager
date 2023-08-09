package Application.ViewModel;

import Application.Model.UserModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Getter;

@Getter
public class LoginViewModel
{
    private final UserModel userModel;
    private final StringProperty username;
    private final StringProperty password;
    public LoginViewModel(UserModel userModel)
    {
        this.userModel = userModel;
        this.username = new SimpleStringProperty();
        this.password = new SimpleStringProperty();
    }

    public void login()
    {
        userModel.login(username.toString(), password.toString());
    }
}
