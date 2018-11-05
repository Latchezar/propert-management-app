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

import javax.inject.Inject;

public class UserProfileActivity extends Activity {
    public static final String EXTRA_KEY = "USERPROFILE_EXTRA_KEY";

    //@Inject
    //LoginFragment mTenantFragment;

    //@Inject
    //LoginFragment mLandlordFragment;

    //@Inject
    //LoginContracts.Presenter mUserProfilePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        Intent intent = getIntent();
        LoginUser loginUser = (LoginUser) intent.getSerializableExtra(UserProfileActivity.EXTRA_KEY);

        ///mTenantFragment.setPresenter(mUserProfilePresenter);

        //FragmentTransaction transaction = getFragmentManager()
        //        .beginTransaction();

        //transaction.replace(R.id.content, mTenantFragment);
        //transaction.commit();

        int a = 5;

    }
}
