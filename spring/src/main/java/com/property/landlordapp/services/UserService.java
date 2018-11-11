package com.property.landlordapp.services;

import com.property.landlordapp.models.ChatMessage;
import com.property.landlordapp.models.Property;
import com.property.landlordapp.models.User;
import com.property.landlordapp.repositories.RepositoryBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class UserService implements ServiceBase{
    private RepositoryBase repository;

    @Autowired
    public UserService(RepositoryBase repository){
        this.repository = repository;
    }

    @Override
    public ResponseEntity loginAttempt(User login) {
        return repository.loginAttempt(login);
    }

    @Override
    public ResponseEntity registerNewUser(User user) {
        return this.repository.registerNewUser(user);
    }

    @Override
    public ResponseEntity createNewProperty(Property property) {
        return this.repository.createNewProperty(property);
    }

    @Override
    public ResponseEntity getPropertiesByLandlordID(int id) {
        return this.repository.getPropertiesByLandlordID(id);
    }

    @Override
    public ResponseEntity getPropertiesByTenantID(int id) {
        return this.repository.getPropertiesByTenantID(id);
    }

    @Override
    public ResponseEntity getUserByID(int id) {
        return this.repository.getUserByID(id);
    }

    @Override
    public ResponseEntity getChatMessagesByPropertyID(int id) {
        return this.repository.getChatMessagesByPropertyID(id);
    }

    @Override
    public ResponseEntity sendMessage(ChatMessage chatMessage) {
        return this.repository.sendMessage(chatMessage);
    }

    @Override
    public ResponseEntity getNewMessages(int id, long miliseconds) {
        return this.repository.getNewMessages(id, miliseconds);
    }

    @Override
    public ResponseEntity deleteProperty(int id) {
        return this.repository.deleteProperty(id);
    }
}
