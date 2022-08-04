package ca.georgiancollege.cppr.comp1008.comp1008summer2022thursdays12pmgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField fieldUsername;

    @FXML
    private PasswordField fieldPassword;

    LoginModel model = new LoginModel();

    @FXML
    void OnRegisterClick(ActionEvent event) {

    }

    @FXML
    void onLoginClick(ActionEvent event) {

        model.process(fieldUsername.getText(), fieldPassword.getText());
        Alert alert;
        if(model.validate()){
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Congrats! You may enter");
            alert.setTitle("Congrats");
        }
        else{
            System.err.println("Invalid Username");
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Invalid Username or Password");
            alert.setTitle("Uh-Oh");
        }
        alert.show();
    }

}
