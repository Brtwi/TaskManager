package Application.Model;

import Application.Model.Entities.User;

public class ModelFactory
{
    private ITaskModel taskModel;
    private UserModel userModel;

    public ITaskModel getTaskModel()
    {
        return taskModel == null ? new TaskModel() : taskModel;
    }

    public UserModel getUserModel()
    {
        return userModel == null ? new UserModel() : userModel;
    }
}
