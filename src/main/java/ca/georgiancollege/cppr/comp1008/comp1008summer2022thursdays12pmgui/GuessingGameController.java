package ca.georgiancollege.cppr.comp1008.comp1008summer2022thursdays12pmgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.nio.file.Paths;
import java.security.SecureRandom;
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

    private String[] colors = {"red", "grey", "green", "blue", "orange", "pink", "brown", "purple" };

    private String imageExtension = ".png";
    String imageDirectoryPath = Paths.get("src/main/resources/ca/georgiancollege/cppr/comp1008/comp1008summer2022thursdays12pmgui/images/guessinggame/").toAbsolutePath() + "\\";
    String transparentBlackStyle = "-fx-background-color: rgba(0,0,0,0.5)";

    void showCard(MouseEvent e){
        ImageView clicked = ((ImageView)e.getSource());
        String clickedID = clicked.getId();
        int cardIndex = Integer.parseInt(clickedID.substring(5));
        //System.out.println(cardIndex);

        String whatImageToDisplay = boxSlots[cardIndex];
        //System.out.println(imageDirectoryPath + whatImageToDisplay);
        clicked.setImage(
                new Image(imageDirectoryPath + whatImageToDisplay)
        );

        boxColorList.add(whatImageToDisplay);
        imageViewList.add(clicked);

    }

    @FXML
    void trackUserClicks(MouseEvent e){

        message.setText("");
        showCard(e);

        userClickCount++;
        //System.out.println("clicked on ID of " + ((ImageView)e.getSource()).getId());

        if(userClickCount == 2){
            check.setDisable(false);
            grid.setDisable(true);
            grid.setStyle(transparentBlackStyle);
            userClickCount = 0;
            incrementStat(attempts);

        }
    }
    @FXML
    void checkSolution(ActionEvent event) {
        if(boxColorList.get(0).equals(boxColorList.get(1))){
            incrementStat(correct);

            for(ImageView current : imageViewList){
                current.setImage(new Image(imageDirectoryPath + "correct.png"));
                current.setDisable(true);
                current.setStyle(transparentBlackStyle);

            }
            message.setTextFill(Color.rgb(0, 255, 0));

        }
        else{

            for(ImageView current : imageViewList){
                current.setImage(new Image(imageDirectoryPath + "blank.png"));
            }


            message.setText("Incorrect Guess! Please try again");
            message.setTextFill(Color.rgb(255, 0, 0));

        }


        boxColorList.clear();
        imageViewList.clear();

        grid.setDisable(false);
        grid.setStyle("");
        check.setDisable(true);

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


        SecureRandom sran = new SecureRandom();
        for (String color : colors){
            int colorCount = 0;

            while(colorCount < 2){
                int randomIndex = sran.nextInt(numberOfBoxes);

                if(boxSlots[randomIndex].length() == 0){
                    boxSlots[randomIndex] = color + imageExtension;
                    colorCount++;
                }
            }
            
            
        }

        int counter = 0;
        for(Node element : grid.getChildren()){

            try {
                ImageView current = (ImageView) element;
                current.setId("card_" + counter);
                counter++;
                current.setOnMouseClicked(this::trackUserClicks);

            }
            catch (Exception e){
                System.err.println("Error in explicitly typecasting Node to Image View in populateColors");
            }
            
        }
        
    }
    @FXML
    void initialize(){
        populateColors();
        resetStats();
    }

}
