package com.property.landlordapp.controllers;

import com.property.landlordapp.models.ChatMessage;
import com.property.landlordapp.models.Property;
import com.property.landlordapp.models.User;
import com.property.landlordapp.services.ServiceBase;
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
    public ResponseEntity loginAttempt(@RequestBody User login){
        return this.service.loginAttempt(login);
    }

    @PostMapping("/register")
    public ResponseEntity registerNewUser(@RequestBody User user){
        return this.service.registerNewUser(user);
    }

    @PostMapping("/property")
    public ResponseEntity createNewProperty(@RequestBody Property property) {
        return this.service.createNewProperty(property);
    }

    @GetMapping("landlord/{id}")
    public ResponseEntity getPropertiesByLandlordID(@PathVariable int id){
        return this.service.getPropertiesByLandlordID(id);
    }

    @GetMapping("tenant/{id}")
    public ResponseEntity getPropertiesByTenantID(@PathVariable int id){
        return this.service.getPropertiesByTenantID(id);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity getUserByID(@PathVariable int id){
        return this.service.getUserByID(id);
    }

    @GetMapping("chat/{id}")
    public ResponseEntity getChatMessagesByPropertyID(@PathVariable int id){
        return this.service.getChatMessagesByPropertyID(id);
    }

    @PostMapping("/chat")
    public ResponseEntity sendMessage(@RequestBody ChatMessage chatMessage){
        return this.service.sendMessage(chatMessage);
    }

    @GetMapping("/newchat/{id}/{miliseconds}")
    public ResponseEntity getNewMessages(@PathVariable int id, @PathVariable long miliseconds){
        return this.service.getNewMessages(id, miliseconds);
    }

    @DeleteMapping("property/{id}")
    public ResponseEntity deleteProperty(@PathVariable int id) {
        return this.service.deleteProperty(id);
    }
}