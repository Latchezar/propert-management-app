package com.example.jorexa.landlordapp.chat;

import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.example.jorexa.landlordapp.R;
import com.example.jorexa.landlordapp.createProperty.CreatePropertyContracts;
import com.example.jorexa.landlordapp.models.LoginUser;
import com.example.jorexa.landlordapp.propertyDetails.propertyDetailsActivity;
import com.example.jorexa.landlordapp.propertyDetails.propertyDetailsContracts;
import com.example.jorexa.landlordapp.propertyDetails.propertyDetailsFragment;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class chatActivity extends DaggerAppCompatActivity {
    public static final String EXTRA_KEY_MAINUSER = "MAINUSER_EXTRA_KEY";
    public static final String EXTRA_KEY_OTHERUSER = "OTHERUSER_EXTRA_KEY";

    @Inject
    chatFragment mChatFragment;

    @Inject
    chatContracts.Presenter mChatPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Intent intent = getIntent();
        LoginUser otherUser = (LoginUser) intent.getSerializableExtra(chatActivity.EXTRA_KEY_MAINUSER);
        //LoginUser mainUser = (LoginUser) intent.getSerializableExtra(chatActivity.EXTRA_MAIN_USER);

        int g = 4;

        mChatFragment.setPresenter(mChatPresenter);

        //PropertyID
        mChatPresenter.loadChat(1);

        FragmentTransaction transaction = getFragmentManager()
                .beginTransaction();

        transaction.replace(R.id.chat_content, mChatFragment);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        // Here you want to show the user a dialog box
        mChatFragment.stopChat();
        //int g = 5;
        super.onBackPressed();
    }
}
