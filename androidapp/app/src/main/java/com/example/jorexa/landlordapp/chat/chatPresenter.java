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
    private chatContracts.View mView;
    private int mStop = 0;
    private long mlastTimeStamp;
    private int mPropertyID;
    private int mSenderID;
    private LoginUser mMainUser;
    private LoginUser mOtherUser;

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
    public void stopChat() {
        mStop = 1;

    }

    @Override
    public void loadChat(Property property, LoginUser mainUser, LoginUser otherUser) {
        mMainUser = mainUser;
        mOtherUser = otherUser;
        mPropertyID = property.getPropertyID();
        mSenderID = mainUser.getId();

        //while (mView == null){ }
        mlastTimeStamp = 0;
        //mView.setChatTitle(mainUser);
        showMessages(mlastTimeStamp);
        int g = 5;
    }

    @Override
    public void sendMessage(String newMessage)  {
        ChatMessage newMessageObj = new ChatMessage();
        mStop = 1;
        mAsyncRunner.runInBackground(() -> {
                newMessageObj.setMessageText(newMessage);

                long datetime = System.currentTimeMillis();
                newMessageObj.setMessageID(null);
                newMessageObj.setMilliseconds(datetime);
                newMessageObj.setPropertyID(mPropertyID);
                newMessageObj.setMessageType(1);
                newMessageObj.setSenderID(mSenderID);

            try {
                Object response = mService.sendNewMessage(newMessageObj);
                mStop = 0;
                showMessages(mlastTimeStamp);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void showMessages(long lastTimeStamp) {
        ChatMessage chat = new ChatMessage();
        mlastTimeStamp = lastTimeStamp;

        mAsyncRunner.runInBackground(() -> {
            for(;;) {
                try {
                    List<ChatMessage> newMessages;
                    newMessages = mService.getNewMessages(mPropertyID, mlastTimeStamp);

                    if(newMessages != null) {
                        for (int a = 0; a < newMessages.size() ;a++) {
                           int CurrenrSenderID = newMessages.get(a).getSenderID();
                                if (CurrenrSenderID == mMainUser.getId()) {
                                    newMessages.get(a).setSenderName(mMainUser.getFirstName()+" "+mMainUser.getLastName());
                                } else if (CurrenrSenderID == mOtherUser.getId()) {
                                    newMessages.get(a).setSenderName(mOtherUser.getFirstName()+" "+mOtherUser.getLastName());
                                }
                        }
                        mView.setChatTitle(mOtherUser);
                        mView.showMessages(newMessages);
                        int count = newMessages.size();
                        mlastTimeStamp = newMessages.get(count - 1).getMilliseconds();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                    //mView.showError(e);
                }
                if(mStop == 1) {
                    break;
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
