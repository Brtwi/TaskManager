package Application.Model;

public class ModelFactory
{
    private ITaskModel taskModel;
    private UserModel userModel;
    private IDataModel dataModel;

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
        return dataModel == null ? dataModel = new DataModel() : dataModel;
    }
}
