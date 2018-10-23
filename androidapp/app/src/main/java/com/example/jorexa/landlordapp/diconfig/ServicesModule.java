package com.example.jorexa.landlordapp.diconfig;

import com.example.jorexa.landlordapp.models.SignInUser;
import com.example.jorexa.landlordapp.repositories.base.Repository;
import com.example.jorexa.landlordapp.services.base.HttpLoginService;
import com.example.jorexa.landlordapp.services.base.LoginService;

import dagger.Module;
import dagger.Provides;

@Module
public class ServicesModule {
    @Provides
    public LoginService HttpLoginService(Repository<SignInUser> repository) {
        return new HttpLoginService(repository);
    }
}
