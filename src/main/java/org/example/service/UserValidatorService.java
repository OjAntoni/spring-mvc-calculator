package org.example.service;

import java.util.regex.Pattern;

public class UserValidatorService {
    private static final Pattern usernamePattern = Pattern.compile("^[a-zA-Z0-9._-]{3,}$");
    private static final Pattern passwordPattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{4,}$");
    public static final String usernameDescription = "Username should contains at least 3 characters";
    public static final String passwordDescription = "Password must contains at least one digit, one lowercase character and one uppercase character";

    public static synchronized boolean validateUsername(String username){
        return usernamePattern.matcher(username).matches();
    }

    public static synchronized boolean validatePassword(String password){
        return passwordPattern.matcher(password).matches();
    }

}
