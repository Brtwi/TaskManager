package Application.ViewController;

import Application.ViewModel.EditViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class Edit
{
    @FXML
    private TextField creatorTextF;
    @FXML
    private TextField titleTextF;
    @FXML
    private TextArea descriptionTextF;
    @FXML
    private TextField stateTextF;
    @FXML
    private TextField receiverTextF;
    @FXML
    private Label filesLabel;
    @FXML
    private Button cancelButton;
    @FXML
    private Button editSaveButton;
    private EditViewModel viewModel;

    public void init(EditViewModel editViewModel)
    {
        this.viewModel = editViewModel;
        bindFields();
        this.viewModel.loadTask();
        enableFields(false);
    }

    public void edit()
    {
        if(editSaveButton.getText().equals("Edit"))
        {
            enableFields(true);
            editSaveButton.setText("Update");
        }
        else
        {
            editSaveButton.setText("Edit");
            viewModel.updateTask();
            cancel();
        }
    }

    public void cancel()
    {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    private void enableFields(boolean enabled)
    {
        titleTextF.setEditable(enabled);
        descriptionTextF.setEditable(enabled);
        stateTextF.setEditable(enabled);
    }

    private void bindFields()
    {
        this.viewModel.getCreator().bindBidirectional(this.creatorTextF.textProperty());
        this.viewModel.getTitle().bindBidirectional(this.titleTextF.textProperty());
        this.viewModel.getDescription().bindBidirectional(this.descriptionTextF.textProperty());
        this.viewModel.getReceiver().bindBidirectional(this.receiverTextF.textProperty());
        this.viewModel.getState().bindBidirectional(this.stateTextF.textProperty());
        this.viewModel.getFilenames().bindBidirectional(this.filesLabel.textProperty());
    }
}
