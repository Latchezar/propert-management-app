package com.example.jorexa.landlordapp.userprofile;

import android.content.Intent;
import android.view.View;

import com.example.jorexa.landlordapp.async.AsyncRunner;
import com.example.jorexa.landlordapp.createProperty.CreatePropertyActivity;
import com.example.jorexa.landlordapp.models.LoginUser;
import com.example.jorexa.landlordapp.models.Property;
import com.example.jorexa.landlordapp.services.base.LoginService;

import java.io.IOException;
import java.util.List;

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
    public void setUserProfile(LoginUser loginUser) {
        mUserProfile = loginUser;

        mAsyncRunner.runInBackground(() -> {
            try {
                List<Property> properties;
                    properties = mService.getAllProperties(loginUser.getUserType(), loginUser.getId());
                presentPropertiesToView(properties);
            } catch (IOException e) {
                e.printStackTrace();
                mView.showError(e);
            }
        });

    }

    @Override
    public void presentPropertiesToView(List<Property> properties) {
        String message;
        if (mUserProfile.getUserType() == 1){
            message = "You don't have any properties yet.";
        } else {
            message = "You don't rent any properties";
        }
        while (mView == null){
        }

        if (properties == null || properties.isEmpty()) {
            mView.showEmptyPropertiesList(message);
        } else {
            mView.showProperties(properties);
        }
    }

    @Override
    public void fabClick(UserProfileContracts.View view) {
        Intent intent = new Intent(view.getActivity(), CreatePropertyActivity.class);
        intent.putExtra(CreatePropertyActivity.EXTRA_KEY, mUserProfile.getId());
        mView.startActivity(intent);
    }

    @Override
    public void loadUser() {
        String title = "Hello " + mUserProfile.getFirstName() + ", you are logged in as ";
        if (mUserProfile.getUserType() == 1){
            mView.determineFloatButton(View.VISIBLE);
            title += "landlord";
        } else if (mUserProfile.getUserType() == 2){
            mView.determineFloatButton(View.GONE);
            title += "tenant";
        }
        mView.setTitle(title);
    }

    @Override
    public void selectProperty(Property property) {
        mView.showPropertyDetails(property);
    }

}
