package com.example.jorexa.landlordapp.diconfig;

import com.example.jorexa.landlordapp.http.HttpRequester;
import com.example.jorexa.landlordapp.models.SignInUser;
import com.example.jorexa.landlordapp.parsers.base.JsonParser;
import com.example.jorexa.landlordapp.repositories.HttpRepository;
import com.example.jorexa.landlordapp.repositories.base.Repository;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoriesModule {
    @Provides
    @Singleton
    public Repository<SignInUser> TestUserRepository(
            @Named("baseServerUrl") String baseServerUrl,
            HttpRequester httpRequester,
            JsonParser<SignInUser> jsonParser
    ) {
        String url = baseServerUrl + "/";
        return new HttpRepository<>(url, httpRequester, jsonParser);
    }
}
