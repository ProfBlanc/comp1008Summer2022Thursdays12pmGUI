package ca.georgiancollege.cppr.comp1008.comp1008summer2022thursdays12pmgui;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RegisterModel {

    private String username, password, confirmPassword, extension = ".txt";
    private final int minLength = 5;
    private Path path = Paths.get("src/main/resources/ca/georgiancollege/cppr/comp1008/comp1008summer2022thursdays12pmgui/data/");


    public void process(String username, String password, String confirmPassword) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        validate();
    }
    private void validate(){
        validateFieldLengths();
        validatePasswordMatch();
        createFile();
    }
    private void validateFieldLengths(){
        if(username.length() < minLength || password.length() < minLength || confirmPassword.length() < minLength)
            throw new IllegalArgumentException("Username and/or password is not at least 5 characters");
    }
    private void validatePasswordMatch(){
        if(!password.equals(confirmPassword))
            throw new IllegalArgumentException("Password do not match");
    }
    private void createFile(){

        Path toCreate = path.resolve(username + extension);

        try {
            Files.createFile(toCreate);
            Files.writeString(toCreate, password);
        }
        catch (Exception e){
            System.err.println(e);
        }
    }
}
