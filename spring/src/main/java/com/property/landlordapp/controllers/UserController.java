package com.property.landlordapp.controllers;

import com.property.landlordapp.models.Login;
import com.property.landlordapp.models.User;
import com.property.landlordapp.services.ServiceBase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    private ServiceBase service;

    public UserController(ServiceBase service){
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity loginAttempt(@RequestBody Login login){
        return this.service.loginAttempt(login);
    }

    @PostMapping("/register")
    public ResponseEntity registerNewUser(@RequestBody User user){
        return this.service.registerNewUser(user);
    }
}