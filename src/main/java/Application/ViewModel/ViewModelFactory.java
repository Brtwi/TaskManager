package Application.ViewModel;

import Application.Model.ModelFactory;
import lombok.Getter;

@Getter
public class ViewModelFactory
{
    private final MainViewModel mainViewModel;
    private final LoginViewModel loginViewModel;
    private final RegisterViewModel registerViewModel;
    private final NewTaskViewModel newTaskViewModel;
    private final EditViewModel editViewModel;
    private final OnlineUsersViewModel onlineUsersViewModel;

    public ViewModelFactory(ModelFactory modelFactory)
    {
        this.mainViewModel = new MainViewModel(modelFactory.getTaskModel());
        this.loginViewModel = new LoginViewModel(modelFactory.getUserModel(), modelFactory.getTaskModel());
        this.registerViewModel = new RegisterViewModel(modelFactory.getUserModel());
        this.newTaskViewModel = new NewTaskViewModel(modelFactory.getTaskModel());
        this.editViewModel = new EditViewModel(modelFactory.getTaskModel());
        this.onlineUsersViewModel = new OnlineUsersViewModel(modelFactory.getUserModel());
    }
}
