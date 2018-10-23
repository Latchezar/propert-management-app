package com.example.jorexa.landlordapp.Login;

import android.widget.EditText;

import com.example.jorexa.landlordapp.async.AsyncRunner;
import com.example.jorexa.landlordapp.models.LoginUser;
import com.example.jorexa.landlordapp.models.SignInUser;
import com.example.jorexa.landlordapp.services.base.LoginService;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

public class LoginPresenter implements LoginContracts.Presenter {

    private LoginContracts.View mView;
    private LoginService mLoginService;
    private AsyncRunner mAsyncRunner;

    private EditText mLoginEmail;
    private EditText mLoginPassword;

    @Inject
    public LoginPresenter(LoginService loginService, AsyncRunner AsyncRunner) {
        mLoginService = loginService;
        mAsyncRunner = AsyncRunner;
    }

    @Override
    public void subscribe(LoginContracts.View view) {
        mView = view;
    }

    @Override
    public void signIn(final String email,final String password) {

        mAsyncRunner.runInBackground(() -> {
            try {

                SignInUser signInUser = new SignInUser();
                signInUser.setPassword(password);
                signInUser.setEmail(email);
                LoginUser loggedUser = mLoginService.signIn(signInUser);
                if (loggedUser != null) {
                    mView.showCustomException("OK!");
                } else {
                    mView.showCustomException("Invalid login. Please, enter valid name and password");
                }
            } catch (IOException e) {
                e.printStackTrace();
                mView.showError(e);
            }
        });

        //mView.loadLogin("123");

    }

    @Override
    public void loadLogin() {

    }
}
