package com.example.jorexa.landlordapp.repositories;

import com.example.jorexa.landlordapp.http.HttpRequester;
import com.example.jorexa.landlordapp.models.LoginUser;
import com.example.jorexa.landlordapp.models.Property;
import com.example.jorexa.landlordapp.parsers.GsonJsonParser;
import com.example.jorexa.landlordapp.parsers.base.JsonParser;
import com.example.jorexa.landlordapp.repositories.base.Repository;

import java.io.IOException;
import java.util.List;

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
    public List<T> getAll(int userType, int propertyID) throws IOException {
        String jsonArray = null;
        String url = mServerUrl;
        if (userType == 1) {
            url += "/landlord/";
        } else if ( userType == 2) {
            url += "/tenant/";
        }
        url += propertyID;
        jsonArray = mHttpRequester.get(url);
        return mJsonParser.fromJsonArray(jsonArray);
    }

    @Override
    public List<T> getAllMessages() throws IOException {
        String jsonArray = null;
        String url = mServerUrl;
            url += "/chat/2";
        //url += 2;
        jsonArray = mHttpRequester.get(url);
        return mJsonParser.fromJsonArray(jsonArray);
    }

    @Override
    public List<T> getNewMessages() throws IOException {
        String jsonArray = null;
        String url = mServerUrl;
        url += "/newchat/2/1541601918000";
        //url += 2;
        jsonArray = mHttpRequester.get(url);
        return mJsonParser.fromJsonArray(jsonArray);
    }

    @Override
    public T getById(int id) throws IOException {
        String url = mServerUrl + "/user/" + id;
        String json = mHttpRequester.get(url);
        return mJsonParser.fromJson(json);
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
            if (mUser instanceof LoginUser) {
                String responseBody = response.body().string();
                return mJsonParser.fromJson(responseBody);
            } else {
                return response.body().string();
            }
        } else if (code == 400){
            return response.body().string();
        } else {
            return null;
        }
    }

}
