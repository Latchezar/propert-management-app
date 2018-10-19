package com.property.landlordapp.repositories;

import com.property.landlordapp.models.Login;
import com.property.landlordapp.models.User;
import org.springframework.http.ResponseEntity;

public interface RepositoryBase {
    ResponseEntity loginAttempt(Login login);

    ResponseEntity registerNewUser(User user);
}
