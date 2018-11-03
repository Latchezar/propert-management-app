package com.example.jorexa.landlordapp.services.base;

import com.example.jorexa.landlordapp.models.LoginUser;

import java.io.IOException;

public interface LoginService {

    LoginUser signIn(LoginUser sentUser) throws IOException;

    Object createUser(LoginUser mUser) throws IOException;
}
