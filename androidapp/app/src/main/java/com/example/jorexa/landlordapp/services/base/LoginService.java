package com.example.jorexa.landlordapp.services.base;

import com.example.jorexa.landlordapp.models.LoginUser;
import com.example.jorexa.landlordapp.models.Property;

import java.io.IOException;
import java.util.List;

public interface LoginService {

    List<Property> getAllProperties(int userType, int propertyID) throws IOException;

    LoginUser signIn(LoginUser sentUser) throws IOException;

    LoginUser getUser(int id) throws IOException;

    String deleteProperty(int propertyID) throws IOException;

    Object create(Object mUser) throws IOException;
}
