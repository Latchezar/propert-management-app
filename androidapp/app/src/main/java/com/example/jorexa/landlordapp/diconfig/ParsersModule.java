package com.example.jorexa.landlordapp.diconfig;

import com.example.jorexa.landlordapp.models.LoginUser;
import com.example.jorexa.landlordapp.models.Property;
import com.example.jorexa.landlordapp.parsers.GsonJsonParser;
import com.example.jorexa.landlordapp.parsers.base.JsonParser;

import dagger.Module;
import dagger.Provides;

@Module
public class ParsersModule {
    @Provides
    public JsonParser<LoginUser> loginJsonParser() {
        return new GsonJsonParser<>(LoginUser.class, LoginUser[].class);
    }

    @Provides
    public JsonParser<Property> propertyJsonParser(){
        return new GsonJsonParser<>(Property.class, Property[].class);
    }
}
