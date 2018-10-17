package com.property.landlordapp.services;

import com.property.landlordapp.models.Login;
import com.property.landlordapp.models.User;

public interface ServiceBase {

    User loginAttempt(Login login);
}
