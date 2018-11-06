package com.example.jorexa.landlordapp.createProperty;

import com.example.jorexa.landlordapp.async.AsyncRunner;
import com.example.jorexa.landlordapp.models.LoginUser;
import com.example.jorexa.landlordapp.models.Property;
import com.example.jorexa.landlordapp.services.base.LoginService;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;

public class CreatePropertyPresenter implements CreatePropertyContracts.Presenter {
    private LoginUser mUser;
    private CreatePropertyContracts.View mView;
    private AsyncRunner mAsyncRunner;
    private LoginService mService;
    private Property mProperty;

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
    public void onSubmit(String name, String address, int price, int LandlordID) {
        mProperty = new Property();
        mProperty.setLandlordID(LandlordID);
        mProperty.setAddress(address);
        mProperty.setPropertyName(name);
        mProperty.setPropertyPrice(price);
        mAsyncRunner.runInBackground(() -> {
            try {
                String response = (String) mService.create(mProperty);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void setUser(LoginUser user) {
        mUser = user;
    }
}
