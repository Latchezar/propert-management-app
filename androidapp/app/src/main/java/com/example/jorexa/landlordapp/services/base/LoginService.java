package com.example.jorexa.landlordapp.services.base;

import com.example.jorexa.landlordapp.models.LoginUser;

import java.io.IOException;

public interface LoginService {

    LoginUser signIn(LoginUser sentUser) throws IOException;

    LoginUser createUser(LoginUser mUser) throws IOException;
}
