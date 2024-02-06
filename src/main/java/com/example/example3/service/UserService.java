package com.example.example3.service;
import com.example.example3.other.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class UserService {


    private final NotificationService notificationService;

    public UserService(){
        this.notificationService = new NotificationService();
    }
    public User createUser(String name, int age, String email){
        User newUser = new User( name, age, email);
        notificationService.callNotify(newUser.getName());
        return newUser;
    }

    //task01 with asterisk
//    public User addUserFromHTTPRequestParams(){
//        return createUser();
//    }



}