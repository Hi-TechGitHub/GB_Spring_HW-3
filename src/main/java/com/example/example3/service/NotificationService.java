package com.example.example3.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public NotificationService(){
        System.out.println("INFO: Notification service created!?");
    }

    public void callNotify(String userId){
        System.out.println("NOTIFICATION: User " + userId + " created");
    }

}