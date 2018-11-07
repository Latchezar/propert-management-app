package com.example.jorexa.landlordapp.services.base;

import com.example.jorexa.landlordapp.models.LoginUser;
import com.example.jorexa.landlordapp.models.Property;
import com.example.jorexa.landlordapp.repositories.base.Repository;

import java.io.IOException;
import java.util.List;

public class HttpPropertyService implements LoginService {

    private final Repository<Property> mRepository;

    public HttpPropertyService(Repository<Property> repository){
        mRepository = repository;
    }

    @Override
    public List<Property> getAllProperties(int userType, int propertyID) throws IOException {
        return mRepository.getAll(userType, propertyID);
    }


    @Override
    public LoginUser signIn(LoginUser sentUser) throws IOException {
        return null;
    }

    @Override
    public LoginUser getUser(int id) throws IOException {
        return null;
    }

    @Override
    public Object create(Object mUser) throws IOException {
        return mRepository.create((Property)mUser);
    }
}
