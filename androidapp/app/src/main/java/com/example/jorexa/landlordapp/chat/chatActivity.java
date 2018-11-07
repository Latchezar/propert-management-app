package com.example.jorexa.landlordapp.chat;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jorexa.landlordapp.R;
import com.example.jorexa.landlordapp.propertyDetails.propertyDetailsContracts;
import com.example.jorexa.landlordapp.propertyDetails.propertyDetailsFragment;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class chatActivity extends DaggerAppCompatActivity {

    @Inject
    chatFragment mChatFragment;

    //@Inject
    //chatPresenter.Presenter mChatPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        //chatFragment.setPresenter(mChatPresenter);

        //PropertyID
        //chatPresenter.loadChat(1);

        FragmentTransaction transaction = getFragmentManager()
                .beginTransaction();

        transaction.replace(R.id.property_details_content, mChatFragment);
        transaction.commit();
    }
}
