package com.example.jorexa.landlordapp.chat;

import com.example.jorexa.landlordapp.createProperty.CreatePropertyContracts;

public class chatPresenter implements chatContracts.Presenter {

    private chatContracts.View mView;

    @Override
    public void subscribe(chatContracts.View view) {
        mView = view;
    }

    @Override
    public void loadChat(int propertyID) {

    }
}
