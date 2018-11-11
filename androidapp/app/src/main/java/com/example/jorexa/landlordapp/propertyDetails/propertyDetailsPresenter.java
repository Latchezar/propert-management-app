package com.example.jorexa.landlordapp.propertyDetails;

import com.example.jorexa.landlordapp.async.AsyncRunner;
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
    private LoginUser mMainUser;

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
        mMainUser = userlogin;

        //20
        mAsyncRunner.runInBackground(() -> {
            try {
                LoginUser user;
                if (userlogin.getUserType() == 1) {
                    user = mService.getUser(property.getTenantID());
                } else {
                    user = mService.getUser(property.getLandlordID());
                }

                mUser = user;

                while (mView == null){
                }
                if (property.getLandlordID() != property.getTenantID()) {
                    mView.setTenantOrLandlord(user);
                }
            } catch (IOException e) {
                e.printStackTrace();
                mView.showError(e);
            }
        });

    }

    @Override
    public void signInChat() {
        mView.openChatActivity(mMainUser, mUser, mPropertyDetails);
    }

    @Override
    public void getProperty() {
        mView.setPropertyInformation(mPropertyDetails);
    }

    @Override
    public void onDeleteButtonClick() {
        //delete button logic

      int g = 6;
        mAsyncRunner.runInBackground(() -> {
            try {

                int e = 4;
                String doDelete = mService.deleteProperty(mPropertyDetails.getPropertyID());
                if (doDelete.equals("Success")) {
                    while (mView == null){ }
                    mView.showCustomException("Successfully deleted property!");
                    //mView.onResume();
                    //...
                } else {
                    while (mView == null){ }
                    mView.showCustomException(doDelete);
                }

            } catch (IOException e) {
                e.printStackTrace();
                mView.showError(e);
            }
        });
    }

    @Override
    public void changeEmail(String email) {
        if (email.equals("")) {
            mView.showCustomException("Please, enter email address!");
        } else {
        mAsyncRunner.runInBackground(() -> {
            try {
                String changeTenant = mService.changeTenant(mPropertyDetails.getPropertyID(), email);
                if (changeTenant.equals("Success")) {
                    while (mView == null) {
                    }
                    mView.showCustomException("Successfully changed property!");
                    mView.onResume();
                    //...
                } else {
                    while (mView == null) {
                    }
                    mView.showCustomException(changeTenant);
                }

            } catch (IOException e) {
                e.printStackTrace();
                mView.showError(e);
            }
        });
      }
    }


}
