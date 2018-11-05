package com.example.jorexa.landlordapp.Login;

import android.content.Intent;
import android.widget.EditText;

import com.example.jorexa.landlordapp.async.AsyncRunner;
import com.example.jorexa.landlordapp.models.LoginUser;
import com.example.jorexa.landlordapp.services.base.LoginService;
import com.example.jorexa.landlordapp.singup.SignUpActivity;
import com.example.jorexa.landlordapp.userprofile.UserProfileActivity;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;

public class LoginPresenter implements LoginContracts.Presenter {

    private LoginContracts.View mView;
    private LoginService mLoginService;
    private AsyncRunner mAsyncRunner;

    private EditText mLoginEmail;
    private EditText mLoginPassword;

    @Inject
    public LoginPresenter(@Named("login") LoginService loginService, AsyncRunner AsyncRunner) {
        mLoginService = loginService;
        mAsyncRunner = AsyncRunner;
    }

    @Override
    public void subscribe(LoginContracts.View view) {
        mView = view;
    }

    @Override
    public void signIn(final String email,final String password) {

        if (email.matches("") || password.matches("")) {
            mView.showCustomException("Please, enter email and password");
        } else {
            mAsyncRunner.runInBackground(() -> {
                try {

                    LoginUser user = new LoginUser();
                    user.setPassword(password);
                    user.setEmail(email);
                    LoginUser loggedUser = mLoginService.signIn(user);
                    if (loggedUser != null) {
                        mView.showCustomException("OK!"+loggedUser.userType);
                        Intent intent = new Intent(mView.getActivity(), UserProfileActivity.class);
                        intent.putExtra(UserProfileActivity.EXTRA_KEY, loggedUser);
                        //intent.putExtra("userType", loggedUser.userType);
                        mView.startActivity(intent);
                        //create intent
                        //put extra object
                        //mView.startNext(intent);
                        //loggedUser.getUserType()
                    } else {
                        mView.showCustomException("Invalid login. Please, enter valid name and password");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    mView.showError(e);
                }
            });
        }
        //mView.loadLogin("123");
    }

    @Override
    public void signUp(){
        Intent intent = new Intent(mView.getActivity(), SignUpActivity.class);
        mView.startActivity(intent);
    }

    @Override
    public void loadLogin() {

    }
}
