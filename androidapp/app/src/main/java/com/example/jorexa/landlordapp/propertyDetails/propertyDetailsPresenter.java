package com.example.jorexa.landlordapp.propertyDetails;

import android.content.Intent;

import com.example.jorexa.landlordapp.async.AsyncRunner;
import com.example.jorexa.landlordapp.chat.chatActivity;
import com.example.jorexa.landlordapp.createProperty.CreatePropertyActivity;
import com.example.jorexa.landlordapp.models.LoginUser;
import com.example.jorexa.landlordapp.models.Property;
import com.example.jorexa.landlordapp.services.base.LoginService;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;

public class propertyDetailsPresenter implements propertyDetailsContracts.Presenter {

    private LoginService mService;
    private final AsyncRunner mAsyncRunner;

    private Property mPropertyDetails;

    private propertyDetailsContracts.View mView;
    private LoginUser mUser;

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
    public void loadProperty(LoginUser userlogin, Property property)
    {
        mPropertyDetails = property;

        mAsyncRunner.runInBackground(() -> {
            try {
                LoginUser user = new LoginUser();
                if (userlogin.getUserType() == 1) {
                    user = mService.getUser(property.getTenantID());
                } else {
                    user = mService.getUser(property.getLandlordID());
                }

                mUser = user;
                int t = 45;
                mView.setTenantOrLandlord(user);
            } catch (IOException e) {
                e.printStackTrace();
                mView.showError(e);
            }
        });

    }

    @Override
    public void signInChat() {
        mView.openChatActivity(mUser);
    }

    @Override
    public void getProperty() {
        mView.setPropertyInformation(mPropertyDetails);
    }


}
