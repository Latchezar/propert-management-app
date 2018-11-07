package com.example.jorexa.landlordapp.propertyDetails;

import com.example.jorexa.landlordapp.async.AsyncRunner;
import com.example.jorexa.landlordapp.models.LoginUser;
import com.example.jorexa.landlordapp.models.Property;
import com.example.jorexa.landlordapp.services.base.LoginService;
import com.example.jorexa.landlordapp.singup.SignUpContracts;
import com.example.jorexa.landlordapp.userprofile.UserProfileContracts;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

public class propertyDetailsPresenter implements propertyDetailsContracts.Presenter {

    private LoginService mService;
    private final AsyncRunner mAsyncRunner;

    private Property mPropertyDetails;

    private propertyDetailsContracts.View mView;

    @Inject
    public propertyDetailsPresenter(@Named("login")LoginService service, AsyncRunner asyncRunner) {
        mService = service;
        mAsyncRunner = asyncRunner;
    }

    @Override
    public void subscribe(propertyDetailsContracts.View view) {
      mView = view;
    }

    @Override
    public void loadProperty(Property property)
    {
        mPropertyDetails = property;

        mAsyncRunner.runInBackground(() -> {
            try {
                LoginUser user;
                user = mService.getUser(property.getTenantID());
                //mView.setTenantOrLandlord(user);
                int g = 5;
            } catch (IOException e) {
                e.printStackTrace();
                //mView.showError(e);
                int t = 3;
            }
        });

    }

    @Override
    public void getProperty() {
        mView.setPropertyInformation(mPropertyDetails);
    }


}
