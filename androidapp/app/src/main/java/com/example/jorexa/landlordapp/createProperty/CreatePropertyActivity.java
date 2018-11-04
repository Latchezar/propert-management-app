package com.example.jorexa.landlordapp.createProperty;

import android.content.Intent;
import android.os.Bundle;

import com.example.jorexa.landlordapp.R;
import com.example.jorexa.landlordapp.models.LoginUser;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class CreatePropertyActivity extends DaggerAppCompatActivity {
    public static final String EXTRA_KEY = "CREATE_PROPERTY_EXTRA_KEY";
    private int mUserId;

    @Inject
    CreatePropertyFragment mFragment;

    @Inject
    CreatePropertyContracts.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_property);
        Intent intent = getIntent();
        mUserId = (int) intent.getSerializableExtra(EXTRA_KEY);

        mFragment.setPresenter(mPresenter);
        mFragment.setUser(mUserId);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.property_content, mFragment)
                .commit();
    }
}
