package com.property.landlordapp.repositories;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

@Repository
public class SQLRepository implements RepositoryBase {
    private SessionFactory sessionFactory;
    private String dbURL, username, password;

    @Autowired
    public SQLRepository(Environment env, SessionFactory sessionFactory){
        dbURL = env.getProperty("database.url");
        username = env.getProperty("database.username");
        password = env.getProperty("database.password");
        this.sessionFactory = sessionFactory;
    }
}
