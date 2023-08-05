package Application.ViewModel;

import Application.Model.IDataModel;
import javafx.beans.property.StringProperty;

public class RegisterViewModel
{
    private StringProperty username;
    private StringProperty password;
    private StringProperty email;
    private IDataModel dataModel;

    public RegisterViewModel(IDataModel dataModel)
    {
        this.dataModel = dataModel;
    }
}
