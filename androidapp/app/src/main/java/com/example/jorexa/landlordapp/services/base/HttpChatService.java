package com.example.jorexa.landlordapp.services.base;

import com.example.jorexa.landlordapp.models.ChatMessage;
import com.example.jorexa.landlordapp.models.LoginUser;
import com.example.jorexa.landlordapp.models.Property;
import com.example.jorexa.landlordapp.repositories.base.Repository;

import java.io.IOException;
import java.util.List;

public class HttpChatService implements LoginService {

    public final Repository<ChatMessage> mChatMessageRepository;

    public HttpChatService(Repository<ChatMessage> repository) {
        mChatMessageRepository = repository;
    }

    @Override
    public List<Property> getAllProperties(int userType, int propertyID) throws IOException {
        return null;
    }

    @Override
    public LoginUser signIn(LoginUser sentUser) throws IOException {
        return null;
    }

    @Override
    public LoginUser getUser(int id) throws IOException {
        return null;
    }

    @Override
    public Object create(Object mUser) throws IOException {
        return null;
    }
}
