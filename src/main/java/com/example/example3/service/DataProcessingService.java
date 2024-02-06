package com.example.example3.service;


import com.example.example3.other.User;
import com.example.example3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {

    @Autowired
    private UserRepository userRepository;

    public UserRepository getRepository(){
        return userRepository;
    }

    public List<User> getSortedUserList(List<User> users){
        Collections.sort(users);
        return users;
    }

    /**
     * Filter users by Age above
     * @param users List of users
     * @param filterAboveAge The threshold, where users will be filtered
     * @return filtered list of users
     */
    public List<User> getFilteregUserList(List<User> users, int filterAboveAge){
        return users.stream().filter(u -> u.getAge() >= filterAboveAge).collect(Collectors.toList());
    }

    public double getAverageAge(List<User> users){
        return users.stream().collect(Collectors.averagingDouble(User::getAge));
    }

    public User addUserToList(User user){
        return userRepository.save(user);
    }
}