package com.abhishek.hospital_management_system.controller;

import com.abhishek.hospital_management_system.dto.UserLoginRequest;
import com.abhishek.hospital_management_system.dto.UserLoginResponse;
import com.abhishek.hospital_management_system.modal.User;
import com.abhishek.hospital_management_system.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }
    @PostMapping("/login")
    public UserLoginResponse loginUser(@RequestBody UserLoginRequest userLoginRequest){
        return userService.loginUser(userLoginRequest);
    }
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable("id") ObjectId objectId){
        return userService.getUserById(objectId);
    }
    @PostMapping("/updateprofile/{id}")
    public Optional<User> updateUser(@RequestBody User user, @PathVariable("id") ObjectId id){
        return userService.updateUser(user,id);
    }
}
