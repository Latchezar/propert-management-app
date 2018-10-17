package com.property.landlordapp.repositories;

import com.property.landlordapp.models.Login;
import com.property.landlordapp.models.User;

public interface RepositoryBase {
    User loginAttempt(Login login);
}
