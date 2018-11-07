package com.property.landlordapp.services;

import com.property.landlordapp.models.ChatMessage;
import com.property.landlordapp.models.Property;
import com.property.landlordapp.models.User;
import org.springframework.http.ResponseEntity;

import java.sql.Timestamp;

public interface ServiceBase {

    ResponseEntity loginAttempt(User login);

    ResponseEntity registerNewUser(User user);

    ResponseEntity createNewProperty(Property property);

    ResponseEntity getPropertiesByLandlordID(int id);

    ResponseEntity getPropertiesByTenantID(int id);

    ResponseEntity getUserByID(int id);

    ResponseEntity getChatMessagesByPropertyID(int id);

    ResponseEntity sendMessage(ChatMessage chatMessage);

    ResponseEntity getNewMessages(int id, long miliseconds);
}
