package com.example.jorexa.landlordapp.propertyDetails;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.example.jorexa.landlordapp.models.LoginUser;
import com.example.jorexa.landlordapp.models.Property;
import com.example.jorexa.landlordapp.userprofile.UserProfileContracts;

import java.io.IOException;
import java.util.List;

public interface propertyDetailsContracts {
    interface View {
        void setPresenter(propertyDetailsContracts.Presenter presenter);

        void openChatActivity(LoginUser mainUser, LoginUser otherUser, Property property);

        void showCustomException(String text);

        void onResume();

        void setPropertyInformation(Property property);

        void showError(Exception e);

        void setTenantOrLandlord(LoginUser user);;

        Activity getActivity();

        void setVisibility(int visibility);
    }

    interface Presenter {
        void subscribe(propertyDetailsContracts.View view);

        void loadProperty(LoginUser user, Property property);

        void signInChat();

        void getProperty();

        void onDeleteButtonClick();

        void changeEmail(String email);
    }

    interface Navigator {
        void navigateWith(LoginUser mainUser, LoginUser otherUser, Property property);
    }

}
