package com.example.jorexa.landlordapp.repositories.base;

import com.example.jorexa.landlordapp.models.LoginUser;

import java.io.IOException;
import java.util.List;

public interface Repository<T> {
    //List<T> getAll() throws IOException;

    T login(T item) throws IOException;

    Object createUser(T mUser) throws IOException;

    //T getById(int id) throws IOException;
}
