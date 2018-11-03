package com.example.jorexa.landlordapp.singup;

import android.app.Activity;

public interface SignUpContracts {
    interface View {
        void setPresenter(Presenter presenter);

        void showCustomException(String text);

        void showError(Exception e);

        Activity getActivity();

        void displayWrongInformation(String error);
    }

    interface Presenter {
        void subscribe(View view);

        void onSubmit(String firstName, String lastName, String email, String password, String confirmPassword, int typeSelection);

        void endActivity();
    }
}
