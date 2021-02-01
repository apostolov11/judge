package com.softuni.model.biding;

import org.hibernate.validator.constraints.Length;

public class UserLoginBidingModel {

    private String username;

    private String password;

    public UserLoginBidingModel() {
    }

    @Length(min = 2,message = "Username length minimum two characters!")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Length(min = 3,message = "Password length minimum three characters!")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
