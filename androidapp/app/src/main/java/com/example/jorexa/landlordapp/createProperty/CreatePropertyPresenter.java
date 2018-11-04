package com.example.jorexa.landlordapp.createProperty;

import com.example.jorexa.landlordapp.models.LoginUser;

import javax.inject.Inject;

public class CreatePropertyPresenter implements CreatePropertyContracts.Presenter {
    private LoginUser mUser;
    private CreatePropertyContracts.View mView;

    @Inject
    public CreatePropertyPresenter(){

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
