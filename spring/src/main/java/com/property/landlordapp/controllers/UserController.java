package com.property.landlordapp.controllers;

import com.property.landlordapp.models.Login;
import com.property.landlordapp.models.User;
import com.property.landlordapp.services.ServiceBase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    private ServiceBase service;

    public UserController(ServiceBase service){
        this.service = service;
    }

    @PostMapping("/login")
    public Object loginAttempt(@RequestBody Login login){
        User user = service.loginAttempt(login);
        if (user == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return user;
    }
}