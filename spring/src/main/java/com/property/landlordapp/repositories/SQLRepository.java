package com.property.landlordapp.repositories;

import com.property.landlordapp.constants.ResponseText;
import com.property.landlordapp.models.Login;
import com.property.landlordapp.models.User;
import com.property.landlordapp.utils.Validator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
        return sha1.toLowerCase();
    }

    @Override
    public ResponseEntity loginAttempt(Login login) {
        User user = null;
        String shaPassword = sha1(login.getPassword());
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            user = session.get(User.class, login.getEmail());
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            return new ResponseEntity<>(ResponseText.DATABASE_ERROR, HttpStatus.NOT_FOUND);
        }
        try {
            if (user.getPassword().equals(shaPassword)) {
                return new ResponseEntity<>(user, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(ResponseText.INVALID_DATA, HttpStatus.NOT_FOUND);
            }
        } catch (NullPointerException e){
            return new ResponseEntity<>(ResponseText.INVALID_DATA, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity registerNewUser(User user) {
        boolean isValidInformation = true;
        StringBuilder sb = new StringBuilder();
        sb.append(ResponseText.INVALID_REGISTER_TEXT_START);
        if (!Validator.isValidEmailAddress(user.getEmail())){
            isValidInformation = false;
            sb.append(ResponseText.EMAIL);
        }
        if (!Validator.isValidName(user.getFirstName())){
            isValidInformation = false;
            sb.append(ResponseText.FIRST_NAME);
        }
        if (!Validator.isValidName(user.getLastName())){
            isValidInformation = false;
            sb.append(ResponseText.LAST_NAME);
        }
        if (!Validator.isValidType(user.getUserType())){
            isValidInformation = false;
            sb.append(ResponseText.TYPE);
        }
        if (!Validator.isValidPassword(user.getPassword())){
            isValidInformation = false;
            sb.append(ResponseText.PASSWORD);
        }
        if (!isValidInformation){
            return new ResponseEntity<> (sb.toString(), HttpStatus.BAD_REQUEST);
        }
        user.setPassword(sha1(user.getPassword()));
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            session.close();
            return new ResponseEntity<> (ResponseText.SUCCESS, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<> (ResponseText.ALREADY_EXIST, HttpStatus.BAD_REQUEST);
        }
    }
}
