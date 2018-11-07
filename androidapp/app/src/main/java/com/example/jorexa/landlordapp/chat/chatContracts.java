package com.example.jorexa.landlordapp.chat;

import com.example.jorexa.landlordapp.models.LoginUser;
import com.example.jorexa.landlordapp.models.Property;
import com.example.jorexa.landlordapp.propertyDetails.propertyDetailsContracts;

public interface chatContracts {
    interface View {
        void setPresenter(chatContracts.Presenter presenter);

        //void showCustomException(String text);

        void onResume();

        //void showError(Exception e);

        //void
        //void showPropertyDetails(Property property);

        //Activity getActivity();

        //void startActivity(Intent intent);
    }

    interface Presenter {
        void subscribe(chatContracts.View view);

        void loadChat(int propertyID);

    }
}
