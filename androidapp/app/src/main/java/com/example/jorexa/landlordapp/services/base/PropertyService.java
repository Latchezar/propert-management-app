package com.example.jorexa.landlordapp.services.base;

import com.example.jorexa.landlordapp.models.Property;

import java.io.IOException;
import java.util.List;

public interface PropertyService {

    List<Property> getAllProperties(int userType, int propertyID) throws IOException;

    Object create(Object mUser) throws IOException;
}
