package com.example.jorexa.landlordapp.services.base;

import com.example.jorexa.landlordapp.models.LoginUser;
import com.example.jorexa.landlordapp.models.Property;
import com.example.jorexa.landlordapp.repositories.base.Repository;

import java.io.IOException;

public class HttpPropertyService implements LoginService {

    private final Repository<Property> mRepository;

    public HttpPropertyService(Repository<Property> repository){
        mRepository = repository;
    }

    @Override
    public LoginUser signIn(LoginUser sentUser) throws IOException {
        return null;
    }

    @Override
    public Object create(Object mUser) throws IOException {
        return mRepository.create((Property)mUser);
    }
}
