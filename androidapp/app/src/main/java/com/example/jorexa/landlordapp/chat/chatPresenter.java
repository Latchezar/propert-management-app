package com.example.jorexa.landlordapp.chat;

import com.example.jorexa.landlordapp.createProperty.CreatePropertyContracts;
import com.example.jorexa.landlordapp.models.ChatMessage;

import java.security.Timestamp;
import java.util.Date;

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

    @Override
    public void showMessages() {
        ChatMessage chat = new ChatMessage();
        //chat.setMessageID();
        chat.setMessageText("Test Message 123");
        mView.showMessages(chat);
    }
}
