package com.example.jorexa.landlordapp.diconfig;

import com.example.jorexa.landlordapp.Constants;
import com.example.jorexa.landlordapp.http.HttpRequester;
import com.example.jorexa.landlordapp.http.OkHttpHttpRequester;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class HttpModule {
    @Provides
    public HttpRequester httpRequester() {
        return new OkHttpHttpRequester();
    }

    @Provides
    @Named("baseServerUrl")
    public String baseServerUrl() {
        return Constants.BASE_SERVER_URL;
    }
}
