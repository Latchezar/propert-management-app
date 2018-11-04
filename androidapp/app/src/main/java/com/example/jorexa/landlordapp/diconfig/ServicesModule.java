package com.example.jorexa.landlordapp.diconfig;

import com.example.jorexa.landlordapp.models.LoginUser;
import com.example.jorexa.landlordapp.models.Property;
import com.example.jorexa.landlordapp.repositories.base.Repository;
import com.example.jorexa.landlordapp.services.base.HttpLoginService;
import com.example.jorexa.landlordapp.services.base.HttpPropertyService;
import com.example.jorexa.landlordapp.services.base.LoginService;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class ServicesModule {
    @Provides
    @Named("login")
    public LoginService HttpLoginService(Repository<LoginUser> repository) {
        return new HttpLoginService(repository);
    }

    @Provides
    @Named("property")
    public LoginService httpPropertyService(Repository<Property> repository){
        return new HttpPropertyService(repository);
    }
}
