package com.example.jorexa.landlordapp.singup;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.jorexa.landlordapp.Login.LoginContracts;
import com.example.jorexa.landlordapp.R;
import com.example.jorexa.landlordapp.models.LoginUser;
import com.example.jorexa.landlordapp.userprofile.UserProfileActivity;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class SignUpActivity extends DaggerAppCompatActivity implements LoginContracts.Navigator{

    @Inject
    RegisterFormFragment mRegisterFormFragment;

    @Inject
    SignUpContracts.Presenter mSignUpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        mRegisterFormFragment.setPresenter(mSignUpPresenter);
        mRegisterFormFragment.setNavigator(this);

        FragmentTransaction transaction = getFragmentManager()
                .beginTransaction();

        transaction.replace(R.id.sign_up_content, mRegisterFormFragment);
        transaction.commit();
    }

    public void onRadioButtonClicked(View view){
        mRegisterFormFragment.onRadioButtonClicked(view);
    }

    @Override
    public void navigateWith(LoginUser loggedUser) {
        Intent intent = new Intent(
                this,
                UserProfileActivity.class
        );

        intent.putExtra(UserProfileActivity.EXTRA_KEY, loggedUser);
        startActivity(intent);
        finish();
    }
}
