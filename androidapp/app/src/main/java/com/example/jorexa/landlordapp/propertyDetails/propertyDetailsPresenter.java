package com.example.jorexa.landlordapp.propertyDetails;

import com.example.jorexa.landlordapp.models.Property;
import com.example.jorexa.landlordapp.singup.SignUpContracts;
import com.example.jorexa.landlordapp.userprofile.UserProfileContracts;

import javax.inject.Inject;

public class propertyDetailsPresenter implements propertyDetailsContracts.Presenter {

    private Property mPropertyDetails;

    private propertyDetailsContracts.View mView;

    @Inject
    public propertyDetailsPresenter( ) {

    }

    @Override
    public void subscribe(propertyDetailsContracts.View view) {
      mView = view;
    }

    @Override
    public void loadProperty(Property property) {
        mPropertyDetails = property;
    }

    @Override
    public void getProperty() {
        mView.setPropertyInformation(mPropertyDetails);
    }


}
