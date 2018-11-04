package com.example.jorexa.landlordapp.createProperty;

import android.app.Activity;

import com.example.jorexa.landlordapp.models.LoginUser;

import java.io.IOException;

public interface CreatePropertyContracts {
    interface View {
        void onResume();

        void setPresenter(Presenter presenter);

        void showCustomException(String text);

        void showError(Exception e);

        Activity getActivity();

        void displayWrongInformation(String error);

        void setUser(int user);
    }

    interface Presenter {
        void subscribe(View view);

        void onSubmit(String name, int price, int LandlordID) throws IOException;

        void setUser(LoginUser user);
    }
}
