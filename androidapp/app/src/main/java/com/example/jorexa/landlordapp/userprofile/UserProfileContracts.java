package com.example.jorexa.landlordapp.userprofile;

import android.app.Activity;
import android.content.Intent;

import com.example.jorexa.landlordapp.Login.LoginContracts;

public interface UserProfileContracts {
    interface View {
        void setPresenter(UserProfileContracts.Presenter presenter);

        //void showCustomException(String text);

        //void showError(Exception e);

        //Activity getActivity();

        //void startActivity(Intent intent);
    }

    interface Presenter {
        void subscribe(UserProfileContracts.View view);
    }
}
