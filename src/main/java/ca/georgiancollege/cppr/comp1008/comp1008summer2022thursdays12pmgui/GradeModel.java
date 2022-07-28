package ca.georgiancollege.cppr.comp1008.comp1008summer2022thursdays12pmgui;

public class GradeModel {

    //instance variables
    private int score;
    private String letter;
    private static final int SCORE_MIN = 0;
    private static final int SCORE_MAX = 100;

    //methods
    public GradeModel(){}

    public void process(String score) throws Exception{
        try{
            this.score = Integer.parseInt(score);
            setScore(this.score);
        }
        catch (NumberFormatException e){
            throw new NumberFormatException("Unable to convert value '" + score +"' to an integer");
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        if(score >= SCORE_MIN && score <=SCORE_MAX){
            if(score >= 90)
                setLetter("A+");
            else if (score >=80)
                setLetter("A");
            else if (score >=70)
                setLetter("B");
            else if (score >=60)
                setLetter("C");
            else if (score >=50)
                setLetter("D");
            else
                setLetter("F");

        }
        else{
            throw new IllegalArgumentException(String.format("Score of %d is invalid. " +
                    "Please choose a score within the range of %d and %d", score, SCORE_MIN, SCORE_MAX));
        }

    }

    public String getLetter() {
        return letter;
    }

    private void setLetter(String letter) {
        this.letter = letter;
    }
}
