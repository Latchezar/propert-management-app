package com.property.landlordapp.repositories;

import com.property.landlordapp.models.Login;
import com.property.landlordapp.models.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceException;
import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.*;

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

    public String sha1(String input) {
        String sha1 = null;
        try {
            MessageDigest msdDigest = MessageDigest.getInstance("SHA-1");
            msdDigest.update(input.getBytes("UTF-8"), 0, input.length());
            sha1 = DatatypeConverter.printHexBinary(msdDigest.digest());
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            return "false";
        }
        return sha1;
    }

    @Override
    public ResponseEntity loginAttempt(Login login) {
        User user = null;
        String shaPassword = sha1(login.getPassword()).toLowerCase();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            user = session.get(User.class, login.getUsername());
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            return new ResponseEntity<>("Database Error", HttpStatus.NOT_FOUND);
        }
        try {
            if (user.getPassword().equals(shaPassword)) {
                user.setPassword("");
                return new ResponseEntity<>(user, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Invalid Data", HttpStatus.NOT_FOUND);
            }
        } catch (NullPointerException e){
            return new ResponseEntity<>("Invalid Data", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity registerNewUser(User user) {
        user.setPassword(sha1(user.getPassword()).toLowerCase());
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            session.close();
            return new ResponseEntity<> ("Success", HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<> ("User already exists", HttpStatus.BAD_REQUEST);
        }
    }
}
