package ca.georgiancollege.cppr.comp1008.comp1008summer2022thursdays12pmgui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class Utilities {

    static Alert createAlert(String alertType, String alertTitle, String alertContent){
        Alert alert;
        alertType = alertType.toLowerCase();
        if(alertType.contains("error")){
            alert = new Alert(Alert.AlertType.ERROR);
        }
        else if(alertType.contains("info")){
            alert = new Alert(Alert.AlertType.INFORMATION);
        }
        else{
            alert = new Alert(Alert.AlertType.NONE);
        }

        alert.setTitle(alertTitle);
        alert.setContentText(alertContent);

        return alert;
    }
    static void openWindow(String fileName, String windowTitle) throws Exception{

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fileName + "-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle(windowTitle);
        stage.setScene(scene);
        stage.show();

    }
    static void closeWindow(){}

}
