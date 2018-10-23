package com.example.jorexa.landlordapp.Login;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jorexa.landlordapp.R;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {

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

        transaction.replace(R.id.content, mLoginFragment);
        transaction.commit();
    }
}
