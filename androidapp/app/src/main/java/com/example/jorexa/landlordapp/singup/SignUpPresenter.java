package com.example.jorexa.landlordapp.singup;

import com.example.jorexa.landlordapp.async.AsyncRunner;
import com.example.jorexa.landlordapp.models.LoginUser;
import com.example.jorexa.landlordapp.services.base.LoginService;

import java.io.IOException;

import javax.inject.Inject;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class SignUpPresenter implements SignUpContracts.Presenter {

    private LoginService mService;
    private SignUpContracts.View mView;
    private AsyncRunner mAsyncRunner;
    private LoginUser mUser;

    @Inject
    public SignUpPresenter(LoginService service, AsyncRunner asyncRunner){
        mService = service;
        mAsyncRunner = asyncRunner;
    }

    @Override
    public void subscribe(SignUpContracts.View view) {
        mView = view;
    }

    @Override
    public void onSubmit(String firstName, String lastName, String email, String password, String confirmPassword, int typeSelection) {
        boolean errorExists = false;
        if (firstName.length() < 3){
            errorExists = true;
            mView.displayWrongFirstName();
            //error
        } else if (lastName.length() < 3){
            errorExists = true;
            mView.displayWrongLastName();
            //error
        } else if (!isValidEmailAddress(email)){
            errorExists = true;
            mView.displayWrongEmail();
            //error
        } else if (password.length() < 3){
            errorExists = true;
            mView.displayWrongPassword();
            //error
        } else if (!password.equals(confirmPassword)){
            errorExists = true;
            mView.displayMissMatchPassword();
        } else if (typeSelection != 1 && typeSelection != 2) {
            errorExists = true;
            mView.displaySelectType();
            //error
        }
        if (errorExists){
            //handle error
        } else {
            mUser = new LoginUser();
            mUser.setFirstName(firstName);
            mUser.setLastName(lastName);
            mUser.setEmail(email);
            mUser.setPassword(password);
            mUser.setUserType(typeSelection);
            mAsyncRunner.runInBackground(() -> {
                try {
                    mUser = mService.createUser(mUser);

                } catch (IOException e) {
                    mView.showCustomException(e.getMessage());
                    e.printStackTrace();
                }
            });
            if (mUser != null) {
                mView.getActivity().finish();
            }
        }
    }


    public static boolean isValidEmailAddress(String email){
        boolean result = true;
        try {
            InternetAddress emailAddress = new InternetAddress(email);
            emailAddress.validate();
        } catch (AddressException e) {
            result = false;
        }
        if (!(email.contains(".") && email.contains("@"))){
            result = false;
        }
        return result;
    }
}
