package com.example.example3.controllers;



import com.example.example3.other.User;
import com.example.example3.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<User> getAll(){
        return service.getDataProcessingService().getRepository().findAll();
    }

    @PostMapping("/body")
    public ResponseEntity<String> addUser(@RequestBody User user){
        User newUser = service.processRegistration(user);
        return ResponseEntity.ok("User " + user.getName() + " created.");
    }

    @PostMapping("/body/user")
    public ResponseEntity<String> addUserFromHTTPRequest(@RequestParam("userName") String userName,
                                                         @RequestParam("userAge") int userAge,
                                                         @RequestParam("email") String email) {
        service.processRegistration(userName,userAge,email);
        return ResponseEntity.ok("User " + userName + " created.");
    }

    @GetMapping("/sort")
    public List<User> getSortedByAgeUserList(){
        return service.getDataProcessingService().getSortedUserList(service.getDataProcessingService().getRepository().findAll());
    }

    @GetMapping("/filter/{userAge}")
    public List<User> getUserByAge(@PathVariable("userAge") String userAge){
        return service.getDataProcessingService().getFilteregUserList(
                service.getDataProcessingService().getRepository().findAll(),
                Integer.parseInt(userAge));
    }

    @GetMapping("/calc")
    public ResponseEntity<String> getAverageUserAge(){
        double result = service.getDataProcessingService().getAverageAge(service.getDataProcessingService().getRepository().findAll());
        return new ResponseEntity<>("AverageAge = " + Double.toString(result), HttpStatus.OK);

    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") String id){
        System.out.println("NOTIFICATION: delete path..." + id);
        service.getDataProcessingService().getRepository().deleteById(Integer.parseInt(id));
        return ResponseEntity.ok("User " + id + " deleted successfully");
    }
}