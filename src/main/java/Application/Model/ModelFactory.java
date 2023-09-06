package Application.Model;

import Application.Model.Interfaces.IDataModel;
import Application.Model.Interfaces.ITaskModel;

public class ModelFactory
{
    private ITaskModel taskModel;
    private IDataModel dataModel;
    private UserModel userModel;

    public ITaskModel getTaskModel()
    {
        return taskModel == null ? taskModel = new TaskModel() : taskModel;
    }

    public UserModel getUserModel()
    {
        return userModel == null ? userModel = new UserModel() : userModel;
    }

    public IDataModel getDataModel()
    {
        return dataModel == null ? dataModel = new DataModel(getTaskModel().getTasks()) : dataModel;
    }
}
