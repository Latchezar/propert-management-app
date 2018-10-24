package com.example.jorexa.landlordapp.singup;

import android.app.FragmentTransaction;
import android.os.Bundle;

import com.example.jorexa.landlordapp.R;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class SignUpActivity extends DaggerAppCompatActivity {

    @Inject
    RegisterFormFragment mRegisterFormFragment;

    @Inject
    SignUpContracts.Presenter mSignUpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        mRegisterFormFragment.setPresenter(mSignUpPresenter);

        FragmentTransaction transaction = getFragmentManager()
                .beginTransaction();

        transaction.replace(R.id.sign_up_content, mRegisterFormFragment);
        transaction.commit();
    }
}
