package com.example.jorexa.landlordapp.chat;

import com.example.jorexa.landlordapp.async.AsyncRunner;
import com.example.jorexa.landlordapp.async.AsyncRunnerImpl;
import com.example.jorexa.landlordapp.createProperty.CreatePropertyContracts;
import com.example.jorexa.landlordapp.models.ChatMessage;
import com.example.jorexa.landlordapp.models.LoginUser;
import com.example.jorexa.landlordapp.models.Property;
import com.example.jorexa.landlordapp.services.base.HttpChatService;
import com.example.jorexa.landlordapp.services.base.LoginService;
import com.example.jorexa.landlordapp.userprofile.UserProfileContracts;

import java.io.IOException;
import java.security.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;
import javax.inject.Named;

import okhttp3.Response;

public class chatPresenter implements chatContracts.Presenter {

    private HttpChatService mService;
    private LoginUser mUserProfile;
    private final AsyncRunner mAsyncRunner;
    private final AsyncRunner mAsyncRunner2;
    private chatContracts.View mView;
    private int mStop = 0;

    @Inject
    public chatPresenter(@Named("chatMessage")HttpChatService service, AsyncRunner asyncRunner, AsyncRunner asyncRunner2) {
        mAsyncRunner = asyncRunner;
        mAsyncRunner2 = new AsyncRunnerImpl();
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
    public void sendMessage(String newMessage)  {
        ChatMessage newMessageObj = new ChatMessage();

        mStop = 1;
        //mAsyncRunner.

        mAsyncRunner2.runInBackground(() -> {
                //newMessage += "s";
                //"messageType":1,"propertyID":2,"senderID":1,"messageText":"Hello, I am Latcho","messageID":1541600377000
                newMessageObj.setMessageText(newMessage);

                long datetime = System.currentTimeMillis();
                newMessageObj.setMessageID(null);
                newMessageObj.setMilliseconds(datetime);
                newMessageObj.setPropertyID(2);
                newMessageObj.setMessageType(1);
                newMessageObj.setSenderID(1);

            try {
                Object response = mService.sendNewMessage(newMessageObj);
                int gg = 453;
                mStop = 0;
                showMessages(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
            int f = 63;

        });

        //mView.startAgain();
        int g = 5;
    }

    @Override
    public void showMessages(int stopValue) {
        ChatMessage chat = new ChatMessage();
        //chat.setMessageID();

        mAsyncRunner.runInBackground(() -> {
            for(;;) {
                if(mStop == 1) {
                    break;
                }
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    //List<ChatMessage> messages;
                    List<ChatMessage> newMessages;
                    //messages = mService.getAllMessages();
                    newMessages = mService.getNewMessages();
                    newMessages.get(0).setMessageText(new Random() + "");
                    mView.showMessages(newMessages);
                    int a = 5;
                } catch (IOException e) {
                    e.printStackTrace();
                    //mView.showError(e);
                    int t = 3;
                }
            }
            //if(mStop == 1) {
            //    sendMessage("Jorexa test");
            //}
        });

        //chat.setMessageText("Test Message 123");
        //mView.showMessages(chat);
    }

    @Override
    public void testFunc() {
        ChatMessage newMessageObj = new ChatMessage();

        mAsyncRunner2.runInBackground(() -> {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    //List<ChatMessage> messages;
                    List<ChatMessage> newMessages;
                    //messages = mService.getAllMessages();
                    newMessages = mService.getNewMessages();
                    newMessages.get(0).setMessageText(new Random() + "");
                    mView.showMessages(newMessages);
                    int a = 5;
                } catch (IOException e) {
                    e.printStackTrace();
                    //mView.showError(e);
                    int t = 3;
                }

        });

        int g = 5;
    }
}
