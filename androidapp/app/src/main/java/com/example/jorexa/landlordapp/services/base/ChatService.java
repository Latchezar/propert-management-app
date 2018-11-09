package com.example.jorexa.landlordapp.services.base;

import com.example.jorexa.landlordapp.models.ChatMessage;
import com.example.jorexa.landlordapp.models.Property;

import java.io.IOException;
import java.util.List;

public interface ChatService {

    List<ChatMessage> getAllMessages() throws IOException;

    Object sendNewMessage(Object newMessage) throws IOException;

    List<ChatMessage> getNewMessages(long lastTimeStamp) throws IOException;
}
