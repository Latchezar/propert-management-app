package com.example.jorexa.landlordapp.chat;

import com.example.jorexa.landlordapp.async.AsyncRunner;
import com.example.jorexa.landlordapp.createProperty.CreatePropertyContracts;
import com.example.jorexa.landlordapp.models.ChatMessage;
import com.example.jorexa.landlordapp.models.LoginUser;
import com.example.jorexa.landlordapp.models.Property;
import com.example.jorexa.landlordapp.services.base.HttpChatService;
import com.example.jorexa.landlordapp.services.base.LoginService;
import com.example.jorexa.landlordapp.userprofile.UserProfileContracts;

import java.io.IOException;
import java.security.Timestamp;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

public class chatPresenter implements chatContracts.Presenter {

    private HttpChatService mService;
    private LoginUser mUserProfile;
    private final AsyncRunner mAsyncRunner;
    private chatContracts.View mView;

    @Inject
    public chatPresenter(@Named("chatMessage")HttpChatService service, AsyncRunner asyncRunner) {
        mAsyncRunner = asyncRunner;
        mService = service;
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

        mAsyncRunner.runInBackground(() -> {
            try {
                List<ChatMessage> messages;
                messages = mService.getAllMessages();
                mView.showMessages(messages);
                int a = 5;
            } catch (IOException e) {
                e.printStackTrace();
                //mView.showError(e);
                int t = 3;
            }
        });

        //chat.setMessageText("Test Message 123");
        //mView.showMessages(chat);
    }
}
