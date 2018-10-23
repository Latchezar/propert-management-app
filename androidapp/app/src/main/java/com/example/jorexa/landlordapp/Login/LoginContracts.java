package com.example.jorexa.landlordapp.Login;

import android.content.Intent;

import java.util.List;

public interface LoginContracts {
    interface View {
        void setPresenter(Presenter presenter);

        void showCustomException(String text);

        void showError(Exception e);

        void startNext(Intent intent);
    }

    interface Presenter {
        void subscribe(View view);

        void signIn(String email, String password);

        void signUp();

        void loadLogin();
    }
}
