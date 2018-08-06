package com.aptech.model;

public class LoginModel {
    private final String usernameAuth = "admin";
    private final String passwordAuth = "123456";

    public boolean authenticate(String username, String password) {
        if (passwordAuth.equals(password) && usernameAuth.equals(username)) {
            return true;
        } else {
            return false;
        }
    }
}
