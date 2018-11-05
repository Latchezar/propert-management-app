package com.example.jorexa.landlordapp.userprofile;

import com.example.jorexa.landlordapp.Login.LoginContracts;

public class UserProfilePresenter implements UserProfileContracts.Presenter {

    private UserProfileContracts.View mView;

    @Override
    public void subscribe(UserProfileContracts.View view) {
        mView = view;
    }
}
