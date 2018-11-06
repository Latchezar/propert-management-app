package com.example.jorexa.landlordapp.propertyDetails;

import com.example.jorexa.landlordapp.models.LoginUser;
import com.example.jorexa.landlordapp.models.Property;
import com.example.jorexa.landlordapp.userprofile.UserProfileContracts;

import java.io.IOException;
import java.util.List;

public interface propertyDetailsContracts {
    interface View {
        void setPresenter(propertyDetailsContracts.Presenter presenter);

        //void setTitle(String title);
        //void showCustomException(String text);

        void onResume();

        //void showProperties(List<Property> properties);
        //void showError(Exception e);

        //void showPropertyDetails(Property property);

        //Activity getActivity();

        //void startActivity(Intent intent);
    }

    interface Presenter {
        void subscribe(propertyDetailsContracts.View view);

        void loadUser();

    }
}
