package com.example.jorexa.landlordapp.propertyDetails;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jorexa.landlordapp.R;
import com.example.jorexa.landlordapp.models.Property;
import com.example.jorexa.landlordapp.singup.RegisterFormFragment;
import com.example.jorexa.landlordapp.singup.SignUpContracts;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class propertyDetailsActivity extends DaggerAppCompatActivity {
    public static final String EXTRA_KEY = "PROPERTY_EXTRA_KEY";

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

        int f = 5;

        mPropertyDetailsFragment.setPresenter(mPropertyDetailsPresenter);

        FragmentTransaction transaction = getFragmentManager()
                .beginTransaction();

        transaction.replace(R.id.property_details_content, mPropertyDetailsFragment);
        transaction.commit();

    }
}
