package com.property.landlordapp.services;

import com.property.landlordapp.models.Login;
import com.property.landlordapp.models.User;
import org.springframework.http.ResponseEntity;

public interface ServiceBase {

    ResponseEntity loginAttempt(Login login);

    ResponseEntity registerNewUser(User user);
}
