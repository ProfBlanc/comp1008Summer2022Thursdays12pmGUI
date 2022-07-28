package ca.georgiancollege.cppr.comp1008.comp1008summer2022thursdays12pmgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GradeController {


    /*
    outline all components that we will be interacting with
        sending data to
        for getting data from
     */
    @FXML
    TextField fieldScore;

    @FXML
    Label labelGrade;

    GradeModel model = new GradeModel();

    @FXML
    void onButtonClick(ActionEvent event){
        System.out.println("clicked!");
        //process the grade here
        try {
            model.process(fieldScore.getText());
            labelGrade.setText(model.getLetter());
        }
        catch (Exception e){
            //System.err.println(e.getMessage());
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Excuse Me");
            alert.setContentText(e.getMessage());
            alert.show();
        }
        finally {
            fieldScore.requestFocus();
        }

        /*
        once person clicked the button
        take the value of score and send a letter value
            create a letter grade based on the following criteria
            90-100      A+
            80-89       A
            70s         B
            60s         C
            50s         D
            < 50        F

            * assume user will input valid integer
         */
/*
        int score = Integer.parseInt(fieldScore.getText());
        String letter = "";

        if(score >=90 && score <=100)
            letter = "A+";
        else if(score >=80 && score <=89)
            letter = "A";
        else if(score >=70 && score <=79)
            letter = "B";
        else if(score >=60 && score <=69)
            letter = "C";
        else if(score >=50 && score <=59)
            letter = "D";
        else if (score < 50)
            letter = "F";

        labelGrade.setText(letter);

 */
    }

    //default constructor to do something. HOWEVER, the constructor is called BEFORE any JavaFX components are loaded
    public GradeController(){}

    @FXML
    void initialize(){
        System.out.println("loaded!");
        reset();
    }

    void reset(){

        String originalValue = labelGrade.getText();
        System.out.println("Original value was " + originalValue);
        labelGrade.setText("");
        fieldScore.setText("");
        /*
        labelGrade.setStyle("-fx-background-color: blue");
        labelGrade.setLayoutX(100);

         */
    }


}
