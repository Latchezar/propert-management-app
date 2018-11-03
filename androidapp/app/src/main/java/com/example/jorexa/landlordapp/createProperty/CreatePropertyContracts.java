package com.example.jorexa.landlordapp.createProperty;

import android.app.Activity;

import com.example.jorexa.landlordapp.models.LoginUser;

public interface CreatePropertyContracts {
    interface View {
        void onResume();

        void setPresenter(Presenter presenter);

        void showCustomException(String text);

        void showError(Exception e);

        Activity getActivity();

        void displayWrongInformation(String error);

        void setUser(LoginUser user);
    }

    interface Presenter {
        void subscribe(View view);

        void onSubmit(String firstName, String lastName, String email, String password, String confirmPassword, int typeSelection);

        void setUser(LoginUser user);
    }
}
