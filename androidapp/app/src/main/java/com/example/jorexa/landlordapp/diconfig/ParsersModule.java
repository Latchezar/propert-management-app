package com.example.jorexa.landlordapp.diconfig;

import com.example.jorexa.landlordapp.models.SignInUser;
import com.example.jorexa.landlordapp.parsers.GsonJsonParser;
import com.example.jorexa.landlordapp.parsers.base.JsonParser;

import dagger.Module;
import dagger.Provides;

@Module
public class ParsersModule {
    @Provides
    public JsonParser<SignInUser> loginJsonParser() {
        return new GsonJsonParser<>(SignInUser.class, SignInUser[].class);
    }
}
