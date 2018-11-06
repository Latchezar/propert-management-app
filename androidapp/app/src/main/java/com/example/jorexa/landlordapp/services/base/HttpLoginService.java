package com.example.jorexa.landlordapp.services.base;

import com.example.jorexa.landlordapp.models.LoginUser;
import com.example.jorexa.landlordapp.models.Property;
import com.example.jorexa.landlordapp.repositories.base.Repository;

import java.io.IOException;
import java.util.List;

public class HttpLoginService implements LoginService {

    private final Repository<LoginUser> mTestUserRepository;

    public HttpLoginService(Repository<LoginUser> testUserRepository) {
        mTestUserRepository = testUserRepository;
    }

    @Override
    public LoginUser signIn(LoginUser sentUser) throws IOException {
        return mTestUserRepository.login(sentUser);
        //return null;
    }

    @Override
    public List<Property> getAllProperties() throws IOException {
        return null;
    }

    @Override
    public Object create(Object mUser) throws IOException {
        return mTestUserRepository.create((LoginUser)mUser);
    }
}
