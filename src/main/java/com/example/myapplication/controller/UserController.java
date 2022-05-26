package com.example.myapplication.controller;

import com.example.myapplication.model.User;
import com.example.myapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @GetMapping("/login/{email}/{password}")
    public List<User> findByEmailAndPassword(@PathVariable ("email") String email, @PathVariable ("password") String password){
        return userService.findByEmailAndPassword(email,password);
    }
}
