package com.example.jorexa.landlordapp.userprofile;

import android.app.Activity;
import android.content.Intent;

import com.example.jorexa.landlordapp.Login.LoginContracts;
import com.example.jorexa.landlordapp.models.LoginUser;
import com.example.jorexa.landlordapp.models.Property;

import java.io.IOException;
import java.util.List;

public interface UserProfileContracts {
    interface View {
        void setPresenter(UserProfileContracts.Presenter presenter);

        void setTitle(String title);

        void showCustomException(String text);

        void showProperties(List<Property> properties);

        void showError(Exception e);

        void showPropertyDetails(Property property);

        Activity getActivity();

        void startActivity(Intent intent);

        void showEmptyPropertiesList(String message);
    }

    interface Presenter {
        void subscribe(UserProfileContracts.View view);

        void setUserProfile(LoginUser loginUser) throws IOException;

        void loadUser();

        void selectProperty(Property property);

        void presentPropertiesToView(List<Property> properties);
    }

    interface Navigator {
        void navigateWith(Property property);
    }
}
