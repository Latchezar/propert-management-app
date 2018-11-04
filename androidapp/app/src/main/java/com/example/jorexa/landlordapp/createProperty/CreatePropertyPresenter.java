package com.example.jorexa.landlordapp.createProperty;

import com.example.jorexa.landlordapp.async.AsyncRunner;
import com.example.jorexa.landlordapp.models.LoginUser;
import com.example.jorexa.landlordapp.services.base.LoginService;

import javax.inject.Inject;
import javax.inject.Named;

public class CreatePropertyPresenter implements CreatePropertyContracts.Presenter {
    private LoginUser mUser;
    private CreatePropertyContracts.View mView;
    private AsyncRunner mAsyncRunner;
    private LoginService mService;

    @Inject
    public CreatePropertyPresenter(AsyncRunner asyncRunner,@Named("property") LoginService loginService){
        mAsyncRunner = asyncRunner;
        mService = loginService;
    }

    @Override
    public void subscribe(CreatePropertyContracts.View view) {
        mView = view;
    }

    @Override
    public void onSubmit(String firstName, String lastName, String email, String password, String confirmPassword, int typeSelection) {

    }

    @Override
    public void setUser(LoginUser user) {
        mUser = user;
    }
}
