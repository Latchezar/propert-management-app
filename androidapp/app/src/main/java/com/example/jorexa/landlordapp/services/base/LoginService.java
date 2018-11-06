package com.example.jorexa.landlordapp.services.base;

import com.example.jorexa.landlordapp.models.LoginUser;
import com.example.jorexa.landlordapp.models.Property;

import java.io.IOException;
import java.util.List;

public interface LoginService {

    List<Property> getAllProperties(int propertyID) throws IOException;

    LoginUser signIn(LoginUser sentUser) throws IOException;

    Object create(Object mUser) throws IOException;
}
