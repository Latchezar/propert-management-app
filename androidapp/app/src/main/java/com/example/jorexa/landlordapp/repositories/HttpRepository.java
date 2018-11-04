package com.example.jorexa.landlordapp.repositories;

import com.example.jorexa.landlordapp.http.HttpRequester;
import com.example.jorexa.landlordapp.models.LoginUser;
import com.example.jorexa.landlordapp.models.Property;
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
    public T login(T item) throws IOException {
        String requestBody = mJsonParser.toJson(item);
        String url = mServerUrl;
        if (item instanceof LoginUser) {
            url += "login";
        } else if (item instanceof Property) {
            url += "property";
        }
        Response response = mHttpRequester.post(url, requestBody);
        int code = response.code();
        if (code == 200) {
            String responseBody = response.body().string();
            return mJsonParser.fromJson(responseBody);
        } else {
            return null;
        }
    }

    @Override
    public Object create(T mUser) throws IOException {
        String requestBody = mJsonParser.toJson(mUser);
        String url = mServerUrl;
        if (mUser instanceof LoginUser) {
            url += "register";
        } else if (mUser instanceof Property) {
            url += "property";
        }
        Response response = mHttpRequester.post(url, requestBody);
        int code = response.code();
        if (code == 201) {
            String responseBody = response.body().string();
            return mJsonParser.fromJson(responseBody);
        } else if (code == 400){
            return response.body().string();
        } else {
            return null;
        }
    }

}
