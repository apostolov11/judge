package com.softuni.service;


import com.softuni.model.service.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);


    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void login(UserServiceModel user);


    void logout();
}
