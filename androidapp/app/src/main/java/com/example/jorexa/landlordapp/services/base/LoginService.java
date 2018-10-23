package com.example.jorexa.landlordapp.services.base;

import com.example.jorexa.landlordapp.models.LoginUser;
import com.example.jorexa.landlordapp.models.SignInUser;

import junit.framework.Test;

import java.io.IOException;

public interface LoginService {

    LoginUser signIn(SignInUser sentUser) throws IOException;

}
