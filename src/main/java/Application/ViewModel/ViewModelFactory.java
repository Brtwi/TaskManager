package Application.ViewModel;

import Application.Model.ModelFactory;

public class ViewModelFactory
{
    private MainViewModel mainViewModel;
    private LoginViewModel loginViewModel;
    public ViewModelFactory(ModelFactory modelFactory)
    {
        this.mainViewModel = new MainViewModel(modelFactory.getTaskModel());
        this.loginViewModel = new LoginViewModel(modelFactory.getUserModel());
    }

    public MainViewModel getMainViewModel()
    {
        return mainViewModel;
    }

    public LoginViewModel getLoginViewModel()
    {
        return loginViewModel;
    }
}
