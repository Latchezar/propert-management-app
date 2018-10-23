package com.example.jorexa.landlordapp.repositories;

import com.example.jorexa.landlordapp.http.HttpRequester;
import com.example.jorexa.landlordapp.models.LoginUser;
import com.example.jorexa.landlordapp.parsers.GsonJsonParser;
import com.example.jorexa.landlordapp.parsers.base.JsonParser;
import com.example.jorexa.landlordapp.repositories.base.Repository;

import java.io.IOException;

import okhttp3.Response;

public class HttpRepository<T> implements Repository<T> {
    private final HttpRequester mHttpRequester;
    private final String mServerUrl;
    private final JsonParser<T> mJsonParser;

    public HttpRepository(
            String serverUrl,
            HttpRequester httpRequester,
            JsonParser<T> jsonParser
    ) {
        mServerUrl = serverUrl;
        mHttpRequester = httpRequester;
        mJsonParser = jsonParser;
    }

    @Override
    public LoginUser login(T item) throws IOException {
        String requestBody = mJsonParser.toJson(item);
        Response response = mHttpRequester.post(mServerUrl, requestBody);
        int code = response.code();
        if (code == 200) {
            String responseBody = response.body().string();
            JsonParser<LoginUser> LoginUser = new GsonJsonParser<>(LoginUser.class, LoginUser[].class);
            return LoginUser.fromJson(responseBody);
        } else {
            return null;
        }
    }

}
