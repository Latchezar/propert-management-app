package com.example.jorexa.landlordapp.Login;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

import com.example.jorexa.landlordapp.R;
import com.example.jorexa.landlordapp.models.LoginUser;
import com.example.jorexa.landlordapp.propertyDetails.propertyDetailsActivity;
import com.example.jorexa.landlordapp.singup.SignUpActivity;
import com.example.jorexa.landlordapp.userprofile.UserProfileActivity;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity implements LoginContracts.Navigator {

    @Inject
    LoginFragment mLoginFragment;

    @Inject
    LoginContracts.Presenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mLoginFragment.setPresenter(mLoginPresenter);

        FragmentTransaction transaction = getFragmentManager()
                .beginTransaction();

        mLoginFragment.setNavigator(this);

        transaction.replace(R.id.content, mLoginFragment);
        transaction.commit();
    }

    @Override
    public void navigateWith(LoginUser loggedUser) {

        //Intent intent = new Intent(mView.getActivity(), UserProfileActivity.class);
        //intent.putExtra(UserProfileActivity.EXTRA_KEY, loggedUser);

        Intent intent = new Intent(
                this,
                UserProfileActivity.class
        );

        intent.putExtra(UserProfileActivity.EXTRA_KEY, loggedUser);
        startActivity(intent);
    }
}
