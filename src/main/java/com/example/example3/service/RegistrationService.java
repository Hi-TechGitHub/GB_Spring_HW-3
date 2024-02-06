package com.example.example3.service;


import com.example.example3.other.User;
import com.example.example3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Objects;
@Service
public class RegistrationService {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private DataProcessingService getDataProcessingService;

    public DataProcessingService getDataProcessingService(){
        return getDataProcessingService;
    }
    public User processRegistration(User user){
        User newUser = userService.createUser(user.getName(), user.getAge(), user.getEmail());
        userRepository.save(newUser);
        return newUser;
    }
    public User processRegistration(String userName, int userAge, String email){
        User newUser = userService.createUser(userName, userAge, email);
        userRepository.save(newUser);
        return newUser;
    }

}