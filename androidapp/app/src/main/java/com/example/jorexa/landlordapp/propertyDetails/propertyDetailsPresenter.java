package com.example.jorexa.landlordapp.propertyDetails;

import com.example.jorexa.landlordapp.singup.SignUpContracts;
import com.example.jorexa.landlordapp.userprofile.UserProfileContracts;

import javax.inject.Inject;

public class propertyDetailsPresenter implements propertyDetailsContracts.Presenter {

    private propertyDetailsContracts.View mView;

    @Inject
    public propertyDetailsPresenter( ) {

    }

    @Override
    public void subscribe(propertyDetailsContracts.View view) {
      mView = view;
    }

    @Override
    public void loadUser() {

    }
}
