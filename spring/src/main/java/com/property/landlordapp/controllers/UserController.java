package com.property.landlordapp.controllers;

import com.property.landlordapp.services.ServiceBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    private ServiceBase service;

    public UserController(ServiceBase service){
        this.service = service;
    }

    @PostMapping
    public String loginAttempt(){
        return null;
    }
}