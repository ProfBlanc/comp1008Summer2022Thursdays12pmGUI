package ca.georgiancollege.cppr.comp1008.comp1008summer2022thursdays12pmgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterController {

    @FXML
    private TextField fieldUsername;

    @FXML
    private PasswordField fieldPassword, fieldPasswordConfirm;

    @FXML
    private Label labelError;

    RegisterModel model = new RegisterModel();

    @FXML
    void onCreate(ActionEvent event) {

        Alert alert;
        try{
            model.process(fieldUsername.getText(), fieldPassword.getText(), fieldPasswordConfirm.getText());
            alert = Utilities.createAlert("info", "Success", "You have successfully created a user");
            alert.show();
            resetFields();
        }
        catch (Exception e){
            alert = Utilities.createAlert("error","Registration Error", e.getMessage());
            alert.show();
        }

    }

    @FXML
    void onReset(ActionEvent event) {
        resetFields();

    }

    void resetFields(){
        labelError.setText("");
        fieldUsername.setText("");
        fieldPassword.setText("");
        fieldPasswordConfirm.setText("");
    }
    @FXML
    void initialize(){

        resetFields();
        labelError.setVisible(false);
    }

}
