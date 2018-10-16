package com.property.landlordapp.repositories;

import com.property.landlordapp.models.Login;

public interface RepositoryBase {
    String loginAttempt(Login login);
}
