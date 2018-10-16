package com.property.landlordapp.services;

import com.property.landlordapp.repositories.RepositoryBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements ServiceBase{
    private RepositoryBase repository;

    @Autowired
    public UserService(RepositoryBase repository){
        this.repository = repository;
    }
}
