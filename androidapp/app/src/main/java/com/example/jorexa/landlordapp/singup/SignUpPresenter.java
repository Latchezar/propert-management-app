package com.example.jorexa.landlordapp.singup;

import com.example.jorexa.landlordapp.Constants;
import com.example.jorexa.landlordapp.async.AsyncRunner;
import com.example.jorexa.landlordapp.models.LoginUser;
import com.example.jorexa.landlordapp.services.base.LoginService;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class SignUpPresenter implements SignUpContracts.Presenter {

    private LoginService mService;
    private SignUpContracts.View mView;
    private AsyncRunner mAsyncRunner;
    private LoginUser mUser;

    @Inject
    public SignUpPresenter(@Named("login")LoginService service, AsyncRunner asyncRunner){
        mService = service;
        mAsyncRunner = asyncRunner;
    }

    @Override
    public void subscribe(SignUpContracts.View view) {
        mView = view;
    }

    @Override
    public void onSubmit(String firstName, String lastName, String email, String password, String confirmPassword, int typeSelection) {
        String text;
        if (firstName.length() < 3){
            text = Constants.WRONG_FIRST_NAME;
            mView.displayWrongInformation(text);
            //error
        } else if (lastName.length() < 3){
            text = Constants.WRONG_LAST_NAME;
            mView.displayWrongInformation(text);
            //error
        } else if (!isValidEmailAddress(email)){
            text = Constants.WRONG_EMAIL;
            mView.displayWrongInformation(text);
            //error
        } else if (password.length() < 3){
            text = Constants.WRONG_PASSWORD;
            mView.displayWrongInformation(text);
            //error
        } else if (!password.equals(confirmPassword)){
            text = Constants.WRONG_CONFIRM_PASSWORD;
            mView.displayWrongInformation(text);
        } else if (typeSelection != 1 && typeSelection != 2) {
            text = Constants.WRONG_TYPE;
            mView.displayWrongInformation(text);
            //error
        } else {
            mUser = new LoginUser();
            mUser.setFirstName(firstName);
            mUser.setLastName(lastName);
            mUser.setEmail(email);
            mUser.setPassword(password);
            mUser.setUserType(typeSelection);
            mAsyncRunner.runInBackground(() -> {
                try {
                    Object response = mService.createUser(mUser);
                    if (response instanceof LoginUser){
                        mUser = (LoginUser) response;
                        endActivity();
                    } else {
                        mView.displayWrongInformation((String) response);
                    }

                } catch (IOException e) {
                    mView.showCustomException(e.getMessage());
                    e.printStackTrace();
                }
            });
        }
    }

    @Override
    public void endActivity() {
        mView.getActivity().finish();
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
