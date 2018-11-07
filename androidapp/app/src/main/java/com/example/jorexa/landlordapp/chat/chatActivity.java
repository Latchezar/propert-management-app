package com.example.jorexa.landlordapp.chat;

import android.app.FragmentTransaction;
import android.os.Bundle;

import com.example.jorexa.landlordapp.R;
import com.example.jorexa.landlordapp.createProperty.CreatePropertyContracts;
import com.example.jorexa.landlordapp.propertyDetails.propertyDetailsContracts;
import com.example.jorexa.landlordapp.propertyDetails.propertyDetailsFragment;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class chatActivity extends DaggerAppCompatActivity {

    @Inject
    chatFragment mChatFragment;

    @Inject
    chatContracts.Presenter mChatPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        mChatFragment.setPresenter(mChatPresenter);

        //PropertyID
        mChatPresenter.loadChat(1);

        FragmentTransaction transaction = getFragmentManager()
                .beginTransaction();

        transaction.replace(R.id.chat_content, mChatFragment);
        transaction.commit();
    }
}
