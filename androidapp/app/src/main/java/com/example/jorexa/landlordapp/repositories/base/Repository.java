package com.example.jorexa.landlordapp.repositories.base;

import com.example.jorexa.landlordapp.models.LoginUser;

import java.io.IOException;
import java.util.List;

public interface Repository<T> {
    List<T> getAll(int userType, int propertyID) throws IOException;

    List<T> getAllMessages() throws IOException;

    List<T> getNewMessages() throws IOException;

    T login(T item) throws IOException;

    Object create(T mUser) throws IOException;

    Object sendNewMessage(T newMessage) throws IOException;

    T getById(int id) throws IOException;
}
