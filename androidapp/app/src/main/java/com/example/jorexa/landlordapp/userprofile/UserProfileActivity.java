package com.example.jorexa.landlordapp.userprofile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jorexa.landlordapp.R;
import com.example.jorexa.landlordapp.models.LoginUser;

public class UserProfileActivity extends AppCompatActivity {
    public static final String EXTRA_KEY = "USERPROFILE_EXTRA_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        Intent intent = getIntent();
        LoginUser loginUser = (LoginUser) intent.getSerializableExtra(UserProfileActivity.EXTRA_KEY);
        int a = 5;

    }
}
