package ca.georgiancollege.cppr.comp1008.comp1008summer2022thursdays12pmgui;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LoginModel {

    private String username, password;
    private static final String allowedUsername = "admin", allowedPassword = "pass", extension = ".txt";


    private Path path = Paths.get("src/main/resources/ca/georgiancollege/cppr/comp1008/comp1008summer2022thursdays12pmgui/data/");

    void process(String username, String password){
        this.username = username;
        this.password = password;
    }
    boolean validate() throws Exception{

        /*
            Given the username
                add .txt
                    see if FileExists
                        if yes, read from file
                            if password inputted matches file content
                        if no, throw exception
         */
        Path toCheck = path.resolve(username + extension );

        System.out.println(username + "--" + password);
        if(!toCheck.toFile().exists())
            throw new IllegalArgumentException(username + " not found");

            String content = Files.readString(toCheck);


        return password.equals(content);
    }

}
