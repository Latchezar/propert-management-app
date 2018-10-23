package com.example.jorexa.landlordapp.models;

import java.io.Serializable;

import javax.inject.Inject;

public class SignInUser implements Serializable {
    public String email;

    public String password;

    @Inject
    public SignInUser() {

    }

    public SignInUser(String one, String key) {
        this.email = one;
        this.password = key;
    }

    public String getOne() {
        return email;
    }

    public String getKey() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
