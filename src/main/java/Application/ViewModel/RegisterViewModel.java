package Application.ViewModel;

import Application.Model.UserModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Data;

import java.io.IOException;
import java.net.URISyntaxException;

@Data
public class RegisterViewModel
{
    private StringProperty username;
    private StringProperty password;
    private StringProperty email;
    private UserModel userModel;

    public RegisterViewModel(UserModel userModel)
    {
        this.userModel = userModel;
        this.username = new SimpleStringProperty();
        this.password = new SimpleStringProperty();
        this.email = new SimpleStringProperty();
    }

    public boolean signup() throws URISyntaxException, IOException, InterruptedException
    {
        return userModel.register(username.getValue(), password.getValue(), email.getValue());
    }
}
