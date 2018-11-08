package com.example.jorexa.landlordapp.propertyDetails;

import android.app.Activity;
import android.content.Intent;

import com.example.jorexa.landlordapp.models.LoginUser;
import com.example.jorexa.landlordapp.models.Property;
import com.example.jorexa.landlordapp.userprofile.UserProfileContracts;

import java.io.IOException;
import java.util.List;

public interface propertyDetailsContracts {
    interface View {
        void setPresenter(propertyDetailsContracts.Presenter presenter);

        void showCustomException(String text);

        void onResume();

        void setPropertyInformation(Property property);

        void showError(Exception e);

        void setTenantOrLandlord(LoginUser user);;

        Activity getActivity();
    }

    interface Presenter {
        void subscribe(propertyDetailsContracts.View view);

        void loadProperty(LoginUser user, Property property);

        void getProperty();
    }
}
