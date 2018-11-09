package com.property.landlordapp;

import com.property.landlordapp.models.ChatMessage;
import com.property.landlordapp.models.Property;
import com.property.landlordapp.models.User;
import com.property.landlordapp.services.ServiceBase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public class FakeService implements ServiceBase {
    Map<String, User> userMapEmail;
    Map<Integer, User> userMapId;
    Map<Integer, Property> propertyMap;
    Map<Integer, List<Property>> landlordProperties;
    Map<Integer, List<Property>> tenantsProperties;
    Map<Integer, List<ChatMessage>> chatMessagesByPropertyID;

    public FakeService(Map<String, User> userMapEmail, Map<Integer, User> userMapId,
                       Map<Integer, Property> propertyMap, Map<Integer, List<Property>> landlordProperties,
                       Map<Integer, List<Property>> tenantsProperties,
                       Map<Integer, List<ChatMessage>> chatMessagesByPropertyID){
        this.userMapEmail = userMapEmail;
        this.userMapId = userMapId;
        this.propertyMap = propertyMap;
        this.landlordProperties = landlordProperties;
        this.tenantsProperties = tenantsProperties;
        this.chatMessagesByPropertyID = chatMessagesByPropertyID;
    }

    @Override
    public ResponseEntity loginAttempt(User login) {
        User user;
        user = userMapEmail.get(login.getEmail());
        if (user == null){
            return new ResponseEntity<>(false, HttpStatus.OK);
        }
        if (!user.getPassword().equals(login.getPassword())){
            return new ResponseEntity<>(false, HttpStatus.OK);
        }
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @Override
    public ResponseEntity registerNewUser(User user) {
        if (userMapEmail.containsKey(user.getEmail())){
            return new ResponseEntity<>(false, HttpStatus.OK);
        }
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @Override
    public ResponseEntity createNewProperty(Property property) {
        if (propertyMap.containsKey(property.getPropertyID())){
            return new ResponseEntity<>(false, HttpStatus.OK);
        }
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @Override
    public ResponseEntity getPropertiesByLandlordID(int id) {
        if (landlordProperties.containsKey(id)){
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.OK);
    }

    @Override
    public ResponseEntity getPropertiesByTenantID(int id) {
        if (tenantsProperties.containsKey(id)){
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.OK);
    }

    @Override
    public ResponseEntity getUserByID(int id) {
        if (userMapId.containsKey(id)){
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.OK);
    }

    @Override
    public ResponseEntity getChatMessagesByPropertyID(int id) {
        if (chatMessagesByPropertyID.containsKey(id)){
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.OK);
    }

    @Override
    public ResponseEntity sendMessage(ChatMessage chatMessage) {
        if (chatMessagesByPropertyID.containsKey(chatMessage.getPropertyID())){
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.OK);
    }

    @Override
    public ResponseEntity getNewMessages(int id, long miliseconds) {
        if (chatMessagesByPropertyID.containsKey(id)){
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.OK);
    }
}
