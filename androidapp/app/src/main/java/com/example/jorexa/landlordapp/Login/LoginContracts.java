package com.example.jorexa.landlordapp.Login;

import android.app.Activity;
import android.content.Intent;

public interface LoginContracts {
    interface View {
        void setPresenter(Presenter presenter);

        void showCustomException(String text);

        void showError(Exception e);

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
}
