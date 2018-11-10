package com.example.jorexa.landlordapp.Login;

import android.app.Activity;
import android.content.Intent;

import com.example.jorexa.landlordapp.models.LoginUser;
import com.example.jorexa.landlordapp.models.Property;

public interface LoginContracts {
    interface View {
        void setPresenter(Presenter presenter);

        void showCustomException(String text);

        void showError(Exception e);

        void openUserProfileActivity(LoginUser loggedUser);

         Activity getActivity();

        void startActivity(Intent intent);
    }

    interface Presenter {
        void subscribe(View view);

        void signIn(String email, String password);

        void signUp();

        void testOpenChat();

        void loadLogin();
    }

    interface Navigator {
        void navigateWith(LoginUser loggedUser);
    }

}
