package ca.georgiancollege.cppr.comp1008.comp1008summer2022thursdays12pmgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.nio.file.Paths;
import java.util.ArrayList;

public class GuessingGameController {

    @FXML
    private AnchorPane game;

    @FXML
    private Pane stats;

    @FXML
    private Label attempts;

    @FXML
    private Label correct;

    @FXML
    private Button check;

    @FXML
    private Label message;

    @FXML
    private GridPane grid;


    /*
        track the number of attempts
        track the number of correct guesses
     */

    private int trackUserAttempts = 0, trackUserCorrectGuesses = 0;

    //how many boxes are there in total?
    private int numberOfBoxes = 16;

    /*
        index the boxes
            16 boxes
                populate these boxes without duplicating
     */
    private String[] boxSlots = new String[numberOfBoxes];
    private ArrayList<String> boxColorList = new ArrayList<>();
    private ArrayList<ImageView> imageViewList = new ArrayList<>();

    private int userClickCount = 0;


    String imageDirectoryPath = String.valueOf(Paths.get("src/main/resources/ca/georgiancollege/cppr/comp1008/comp1008summer2022thursdays12pmgui/images/guessinggame/"));


    @FXML
    void trackUserClicks(){
        userClickCount++;

        if(userClickCount == 2){
            check.setDisable(false);
            grid.setDisable(true);
            grid.setStyle("-fx-background-color: rgba(0,0,0,0.5)");
            userClickCount = 0;
            incrementStat(attempts);
        }
    }
    @FXML
    void checkSolution(ActionEvent event) {

    }

    void incrementStat(Label label){

       String value =  label.getText();
       int number = Integer.parseInt(value);
       number++;
       label.setText(String.valueOf(number));
    }

    void resetStats(){

        message.setText("");
        trackUserAttempts = 0;
        trackUserCorrectGuesses = 0;
        attempts.setText(String.valueOf(trackUserAttempts));
        correct.setText(String.valueOf(trackUserCorrectGuesses));
        check.setDisable(true);
    }

    /**
     * iterate through the blank boxes and add the 8 colors randomly
     */
    void populateColors(){


        //create an empty string for all possible box slots instead of having NULL
        for(int i = 0 ; i < numberOfBoxes; i++){
            boxSlots[i] = "";
        }

    }
    @FXML
    void initialize(){
        populateColors();
        resetStats();
    }

}
