package com.example.jorexa.landlordapp.userprofile;

import com.example.jorexa.landlordapp.Login.LoginContracts;
import com.example.jorexa.landlordapp.async.AsyncRunner;
import com.example.jorexa.landlordapp.services.base.LoginService;

import javax.inject.Inject;
import javax.inject.Named;

public class UserProfilePresenter implements UserProfileContracts.Presenter {

    private UserProfileContracts.View mView;

    @Inject
    public UserProfilePresenter(){
        //mService = service;
        //mAsyncRunner = asyncRunner;
    }

    @Override
    public void subscribe(UserProfileContracts.View view) {
        mView = view;
    }
}
