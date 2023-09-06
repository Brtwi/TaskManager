package Application.ViewModel;

import Application.Model.Interfaces.ITaskModel;
import Application.Model.UserModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Getter;

@Getter
public class LoginViewModel
{
    private final UserModel userModel;
    private final ITaskModel taskModel;
    private final StringProperty username;
    private final StringProperty password;
    public LoginViewModel(UserModel userModel, ITaskModel taskModel)
    {
        this.userModel = userModel;
        this.taskModel = taskModel;
        this.username = new SimpleStringProperty();
        this.password = new SimpleStringProperty();
    }

    public void continueLocally()
    {
        userModel.locally();
    }

    public boolean login()
    {
        if(userModel.login(username.getValue(), password.getValue()))
        {
            pullTasks();
            return true;
        }
        return false;
    }


    @SuppressWarnings("BusyWait")
    public void pullTasks()
    {
        Thread requestThread = new Thread(() ->
        {
            if(UserModel.getUser() != null && !UserModel.getUser().getUsername().equals("localhost"))
            {
                while (!taskModel.pullTasksFromServer())
                {
                    try
                    {
                        Thread.sleep(1000);
                    } catch (InterruptedException e)
                    {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        requestThread.start();
    }
}
