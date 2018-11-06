package com.example.jorexa.landlordapp.userprofile;

import com.example.jorexa.landlordapp.Login.LoginContracts;
import com.example.jorexa.landlordapp.async.AsyncRunner;
import com.example.jorexa.landlordapp.models.LoginUser;
import com.example.jorexa.landlordapp.services.base.HttpPropertyService;
import com.example.jorexa.landlordapp.services.base.LoginService;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;

public class UserProfilePresenter implements UserProfileContracts.Presenter {

    private LoginService mService;
    private UserProfileContracts.View mView;
    private LoginUser mUserProfile;
    private final AsyncRunner mAsyncRunner;

    @Inject
    public UserProfilePresenter(@Named("property")LoginService service, AsyncRunner asyncRunner){
        mService = service;
        mAsyncRunner = asyncRunner;
    }

    @Override
    public void subscribe(UserProfileContracts.View view) {
        mView = view;
    }

    @Override
    public void setUserProfile(LoginUser loginUser) throws IOException {
        mUserProfile = loginUser;
        //mView.setTitle(test);

        mService.getAllProperties();

    }

    @Override
    public void loadUser() {
        mView.setTitle(mUserProfile.firstName);
    }


}
