package com.example.jorexa.landlordapp.http;

import java.io.IOException;

import okhttp3.Response;

public interface HttpRequester {
    String get(String url) throws IOException;

    String delete(String url) throws IOException;

    Response post(String url, String body) throws IOException;
}
