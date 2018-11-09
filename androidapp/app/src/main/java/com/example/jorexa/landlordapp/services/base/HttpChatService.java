package com.example.jorexa.landlordapp.services.base;

import com.example.jorexa.landlordapp.models.ChatMessage;
import com.example.jorexa.landlordapp.models.LoginUser;
import com.example.jorexa.landlordapp.models.Property;
import com.example.jorexa.landlordapp.repositories.base.Repository;

import java.io.IOException;
import java.util.List;

public class HttpChatService implements ChatService {

    public final Repository<ChatMessage> mChatMessageRepository;

    public HttpChatService(Repository<ChatMessage> repository) {
        mChatMessageRepository = repository;
    }


    @Override
    public List<ChatMessage> getAllMessages() throws IOException {
        return mChatMessageRepository.getAllMessages();
    }

    @Override
    public List<ChatMessage> getNewMessages(long lastTimeStamp) throws IOException {
        return mChatMessageRepository.getNewMessages(lastTimeStamp);
    }

    @Override
    public Object sendNewMessage(Object newMessage) throws IOException {
        return mChatMessageRepository.sendNewMessage((ChatMessage)newMessage);
    }

}
