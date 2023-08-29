package Application.ViewController;


import Application.ViewModel.NewTaskViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class NewTask
{
    @FXML
    private TextField titleTextField;
    @FXML
    private TextArea descriptionTextField;
    @FXML
    private Button cancelButton;
    @FXML
    private Button saveButton;
    @FXML
    private Button sendButton;
    @FXML
    private Label fileAmountLabel;
    @FXML
    private Label receiverLabel;

    private NewTaskViewModel viewModel;
    private ViewHandler viewHandler;
    private List<File> files = new ArrayList<>();
    private Stage stage;

    public void init(NewTaskViewModel newTaskViewModel, ViewHandler viewHandler)
    {
        this.viewModel = newTaskViewModel;
        this.viewHandler = viewHandler;

        this.stage = (Stage) cancelButton.getScene().getWindow();

        this.viewModel.getTitle().bind(this.titleTextField.textProperty());
        this.viewModel.getDescription().bind(this.descriptionTextField.textProperty());
        this.files = this.viewModel.getFiles();

        this.sendButton.setDisable(!viewModel.isUserConnected());
    }

    public void cancel()
    {
        stage.close();
    }

    public void save()
    {
        if(checkFields())
        {
            viewModel.saveTask();
            stage.close();
        }
    }

    public void send()
    {
        viewHandler.openDialog(FXMLNames.ONLINE_USERS_VIEW, "Online users");
    }

    public void addFiles()
    {
        FileChooser fileChooser = new FileChooser();
        files.add(fileChooser.showOpenDialog(null));
    }

    private boolean checkFields()
    {
        return !titleTextField.getText().trim().isEmpty() &&
                !descriptionTextField.getText().trim().isEmpty();
    }

}
