package com.property.landlordapp.services;

import com.property.landlordapp.models.User;
import org.springframework.http.ResponseEntity;

public interface ServiceBase {

    ResponseEntity loginAttempt(User login);

    ResponseEntity registerNewUser(User user);
}
