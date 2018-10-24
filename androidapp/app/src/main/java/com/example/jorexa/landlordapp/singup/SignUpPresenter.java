package com.example.jorexa.landlordapp.singup;

import com.example.jorexa.landlordapp.async.AsyncRunner;

import javax.inject.Inject;

public class SignUpPresenter implements SignUpContracts.Presenter {

    private SignUpContracts.View mView;
    private AsyncRunner mAsyncRunner;

    @Inject
    public SignUpPresenter(AsyncRunner asyncRunner){
        mAsyncRunner = asyncRunner;
    }

    @Override
    public void subscribe(SignUpContracts.View view) {
        mView = view;
    }
}
