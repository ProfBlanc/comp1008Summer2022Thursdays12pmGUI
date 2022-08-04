package ca.georgiancollege.cppr.comp1008.comp1008summer2022thursdays12pmgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class WelcomeController {

    @FXML
    private ComboBox<String> favCourses;

    @FXML
    private ListView<String> favTeachers;

    @FXML
    private TextField username;

    @FXML
    private Label message;

    @FXML
    void limitText(KeyEvent event) {

    }

    @FXML
    void onHover(MouseEvent event) {

        message.setText(
                String.format("Hovering over co-ordinates %d,%d", (int)event.getSceneX(), (int)event.getSceneY())
        );

    }

    @FXML
    void onSubmitFavCourses(ActionEvent event) {

        message.setText(
                String.format("You selected FavCourse with the index of %s with a value of %s",
                        favCourses.getSelectionModel().getSelectedIndex(),
                        favCourses.getSelectionModel().getSelectedItem()
                        )
        );

    }

    @FXML
    void onSubmitFavTeachers(ActionEvent event) {


        message.setText(
                String.format("You selected FavTeacher with the index of %s with a value of %s",
                        favTeachers.getSelectionModel().getSelectedIndex(),
                        favTeachers.getSelectionModel().getSelectedItem()
                )
        );
    }

    @FXML
    void onSubmitUsername(ActionEvent event) {

    }
    void populateFavCourses(){
        favCourses.getItems().add("comp1008 - Intro to OOP");
        favCourses.getItems().add("comp1030 - Intro to Pramming");
        favCourses.getItems().add("comp1011 - Advanced OOP");

        favCourses.getSelectionModel().selectFirst();
    }
    void populateFavTeachers(){

        ArrayList<String> teachers = new ArrayList<>();
        teachers.add("Ben Blanc");
        teachers.add("Mr Blanc");
        teachers.add("B Blanc");

        favTeachers.getItems().addAll(teachers);
    }
    @FXML
    void initialize(){

        message.setText("");
        populateFavCourses();
        populateFavTeachers();

    }

    @FXML
    void openNewPage(MouseEvent event) {

        String fileName = "", fileTitle = "";


        try {
            ImageView clicked = (ImageView) event.getSource();

            String absolutePath = clicked.getImage().getUrl(); //C/something/..../filename.extension

            String[] components = absolutePath.split("/");
            String lastComponent = components[components.length - 1];
            fileName = lastComponent.split("\\.")[0];
            /*
            System.out.println(lastComponent);
            System.out.println(fileName);
             */

            fileTitle = fileName.toUpperCase() + " Example";

            Utilities.openWindow(fileName, fileTitle);
            message.setText("You've opened the page " + fileName);
        }
        catch (Exception e) {
            Utilities.createAlert("error", "Error!", e.getMessage()).show();
        }
    }

}
