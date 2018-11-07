package com.example.jorexa.landlordapp.chat;

import com.example.jorexa.landlordapp.createProperty.CreatePropertyContracts;

import javax.inject.Inject;

public class chatPresenter implements chatContracts.Presenter {

    private chatContracts.View mView;

    @Inject
    public chatPresenter() {

    }

    @Override
    public void subscribe(chatContracts.View view) {
        mView = view;
    }

    @Override
    public void loadChat(int propertyID) {

    }
}
