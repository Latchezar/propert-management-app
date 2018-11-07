package com.example.jorexa.landlordapp.userprofile;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jorexa.landlordapp.Login.LoginContracts;
import com.example.jorexa.landlordapp.Login.LoginFragment;
import com.example.jorexa.landlordapp.R;
import com.example.jorexa.landlordapp.diconfig.AppComponent;
import com.example.jorexa.landlordapp.models.LoginUser;
import com.example.jorexa.landlordapp.models.Property;
import com.example.jorexa.landlordapp.propertyDetails.propertyDetailsActivity;
import com.example.jorexa.landlordapp.singup.SignUpActivity;

import java.io.IOException;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class UserProfileActivity extends DaggerAppCompatActivity implements UserProfileContracts.Navigator {
    public static final String EXTRA_KEY = "USERPROFILE_EXTRA_KEY";

    @Inject
    TenantFragment mTenantFragment;

    @Inject
    LandlordFragment mLandlordFragment;

    @Inject
    UserProfileContracts.Presenter mUserProfilePresenter;

    public LoginUser mLoginUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        Intent intent = getIntent();
        LoginUser loginUser = (LoginUser) intent.getSerializableExtra(UserProfileActivity.EXTRA_KEY);
        mLoginUser = loginUser;
        //mTenantFragment.setPresenter(mUserProfilePresenter);
        //  mLandlordFragment.setPresenter(mUserProfilePresenter);

        try {
            mUserProfilePresenter.setUserProfile(loginUser);
        } catch (IOException e) {
            e.printStackTrace();
        }

        FragmentTransaction transaction = getFragmentManager()
                .beginTransaction();

        //transaction.replace(R.id.userProfile, mLandlordFragment);
        //transaction.commit();

        mLandlordFragment.setNavigator(this);

        if (loginUser.userType == 1) {
            mLandlordFragment.setPresenter(mUserProfilePresenter);
            transaction.replace(R.id.userProfile, mLandlordFragment);

        } else if (loginUser.userType == 2) {
            //mTenantFragment.setPresenter(mUserProfilePresenter);
            //transaction.replace(R.id.userProfile, mTenantFragment);
            mLandlordFragment.setPresenter(mUserProfilePresenter);
            transaction.replace(R.id.userProfile, mLandlordFragment);
        }
        transaction.commit();

    }

    @Override
    public void navigateWith(Property property) {
        Intent intent = new Intent(
                this,
               propertyDetailsActivity.class
        );

        intent.putExtra(propertyDetailsActivity.EXTRA_KEY, property);
        intent.putExtra(propertyDetailsActivity.EXTRA_LOGINUSER, mLoginUser);

        startActivity(intent);
    }
}
