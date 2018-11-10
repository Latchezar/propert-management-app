package com.example.jorexa.landlordapp.propertyDetails;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jorexa.landlordapp.R;
import com.example.jorexa.landlordapp.chat.chatActivity;
import com.example.jorexa.landlordapp.models.LoginUser;
import com.example.jorexa.landlordapp.models.Property;
import com.example.jorexa.landlordapp.singup.RegisterFormFragment;
import com.example.jorexa.landlordapp.singup.SignUpContracts;
import com.example.jorexa.landlordapp.uiutils.Navigator;
import com.example.jorexa.landlordapp.userprofile.UserProfileContracts;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class propertyDetailsActivity extends DaggerAppCompatActivity implements propertyDetailsContracts.Navigator {
    public static final String EXTRA_KEY = "PROPERTY_EXTRA_KEY";
    public static final String EXTRA_LOGINUSER = "LOGINUSER_EXTRA_KEY";

    @Inject
    propertyDetailsFragment mPropertyDetailsFragment;

    @Inject
    propertyDetailsContracts.Presenter mPropertyDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_details);

        Intent intent = getIntent();
        Property property = (Property) intent.getSerializableExtra(propertyDetailsActivity.EXTRA_KEY);
        LoginUser user = (LoginUser) intent.getSerializableExtra(propertyDetailsActivity.EXTRA_LOGINUSER);

        int f = 5;

        mPropertyDetailsFragment.setPresenter(mPropertyDetailsPresenter);

        mPropertyDetailsPresenter.loadProperty(user, property);

        FragmentTransaction transaction = getFragmentManager()
                .beginTransaction();

        mPropertyDetailsFragment.setNavigator(this);

        transaction.replace(R.id.property_details_content, mPropertyDetailsFragment);
        transaction.commit();

    }

    @Override
    public void navigateWith(LoginUser user) {
        Intent intent = new Intent(
                this,
                chatActivity.class
        );

        intent.putExtra(chatActivity.EXTRA_UUSER, user);

        startActivity(intent);
    }

}
