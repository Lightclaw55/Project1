package com.revature.models;

public class LoginDTO {

    private String user_username;
    private String user_password;

    public LoginDTO(String username, String user_password) {
        this.user_username = username;
        this.user_password = user_password;
    }

    public String getUsername() {
        return user_username;
    }

    public void setUsername(String username) {
        this.user_username = username;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }
}

