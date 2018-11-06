package com.example.jorexa.landlordapp.propertyDetails;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jorexa.landlordapp.R;
import com.example.jorexa.landlordapp.singup.RegisterFormFragment;
import com.example.jorexa.landlordapp.singup.SignUpContracts;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class propertyDetailsActivity extends DaggerAppCompatActivity {

    @Inject
    propertyDetailsFragment mPropertyDetailsFragment;

    @Inject
    propertyDetailsContracts.Presenter mPropertyDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_details);

        mPropertyDetailsFragment.setPresenter(mPropertyDetailsPresenter);

        FragmentTransaction transaction = getFragmentManager()
                .beginTransaction();

        transaction.replace(R.id.property_details_content, mPropertyDetailsFragment);
        transaction.commit();

    }
}
