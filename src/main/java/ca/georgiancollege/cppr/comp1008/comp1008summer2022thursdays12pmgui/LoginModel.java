package ca.georgiancollege.cppr.comp1008.comp1008summer2022thursdays12pmgui;

public class LoginModel {

    private String username, password;
    private static final String allowedUsername = "admin", allowedPassword = "pass";

    void process(String username, String password){
        this.username = username;
        this.password = password;
    }
    boolean validate(){
        return username.equalsIgnoreCase(allowedUsername) && password.equalsIgnoreCase(allowedPassword);
    }

}
