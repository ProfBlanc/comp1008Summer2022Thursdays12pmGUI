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

        try{
            Utilities.openWindow("register", "Register Example");
        }
        catch (Exception e){
            Utilities.createAlert("error", "File Error", "Could not load Registration File").show();
        }
    }

    @FXML
    void onLoginClick(ActionEvent event) {

        model.process(fieldUsername.getText(), fieldPassword.getText());
        Alert alert;

        try {
            model.validate();
            alert = Utilities.createAlert("info", "Congrats", "Congrats! You may enter");
        }

        catch (Exception e){
            //System.err.println("Invalid Username");
            alert = Utilities.createAlert("error", "Uh-Oh", e.getMessage());
        }
        alert.show();
    }

}
