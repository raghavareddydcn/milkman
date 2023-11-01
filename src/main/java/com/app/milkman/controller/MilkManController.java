package com.app.milkman.controller;

import com.app.milkman.model.db.User;
import com.app.milkman.repository.AdminLoginRepository;
import com.app.milkman.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MilkManController {


    @Autowired
    AdminLoginRepository adminLoginRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/hello")
    public String test() {
        return "Hi";
    }


    @GetMapping("/getUserName")
    public ResponseEntity<User> getUserByName(@RequestParam(required = false) String name) {
        System.out.println("In getAllUsers");
        User user = userRepository.findUserByName("reddy");

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/getAllUsersDetails")
    public ResponseEntity<List<User>> getAllUsers() {
        System.out.println("In getAllUsersDetails");
        List<User> users = userRepository.findAll();
        for (User user : users) {
            System.out.println("In getAllUsersDetails Name" + user);
        }

        System.out.println("In getAllUsersDetails");
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/createUser")
    public ResponseEntity<User> createTutorial() {
        System.out.println("In createUser");
        try {
            User user = userRepository
                    .save(new User("reddy", "9566085621"));
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
