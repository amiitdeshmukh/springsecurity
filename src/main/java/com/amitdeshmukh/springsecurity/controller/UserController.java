package com.amitdeshmukh.springsecurity.controller;

import com.amitdeshmukh.springsecurity.Repository.UserRepo;
import com.amitdeshmukh.springsecurity.Service.UserService;
import com.amitdeshmukh.springsecurity.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public User createUser(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return userService.verify(user);
    }

}
