package Application;

import Application.Model.ModelFactory;
import Application.ViewController.ViewHandler;
import Application.ViewModel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class TaskManager extends Application
{
    @Override
    public void start(Stage stage) throws Exception
    {
        ModelFactory modelFactory = new ModelFactory();
        ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
        ViewHandler viewHandler = new ViewHandler(stage, viewModelFactory);
        viewHandler.start();
    }
}
