package com.example.jorexa.landlordapp.services.base;

import com.example.jorexa.landlordapp.models.LoginUser;
import com.example.jorexa.landlordapp.models.SignInUser;
import com.example.jorexa.landlordapp.repositories.base.Repository;

import java.io.IOException;

public class HttpLoginService implements LoginService {

    private final Repository<SignInUser> mTestUserRepository;

    public HttpLoginService(Repository<SignInUser> testUserRepository) {
        mTestUserRepository = testUserRepository;
    }

    @Override
    public LoginUser signIn(SignInUser sentUser) throws IOException {
        return mTestUserRepository.login(sentUser);
        //return null;
    }
}
