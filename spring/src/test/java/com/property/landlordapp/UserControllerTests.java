package com.property.landlordapp;

import com.property.landlordapp.constants.ResponseText;
import com.property.landlordapp.controllers.UserController;
import com.property.landlordapp.models.ChatMessage;
import com.property.landlordapp.models.Property;
import com.property.landlordapp.models.User;
import com.property.landlordapp.services.ServiceBase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.Timestamp;
import java.util.*;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTests {

    @Mock
    ServiceBase mockService;

    @InjectMocks
    UserController controller;

    Map<String, User> userMapEmail = new HashMap<>();
    Map<Integer, User> userMapId = new HashMap<>();
    Map<Integer, Property> propertyMap = new HashMap<>();
    Map<Integer, List<Property>> landlordProperties = new HashMap<>();
    Map<Integer, List<Property>> tenantsProperties = new HashMap<>();
    Map<Integer, List<ChatMessage>> chatMessagesByPropertyID = new HashMap<>();

    {
        //fake users
        User u1 = new User("fname1", "lname1", "pass1", 1, "fname1@gmail.com");
        User u2 = new User("fname2", "lname2", "pass2", 2, "fname2@gmail.com");
        User u3 = new User("fname3", "lname3", "pass3", 1, "fname3@gmail.com");
        User u4 = new User("fname4", "lname4", "pass4", 2, "fname4@gmail.com");

        //fake properties
        Property p1 = new Property("property1", 100, 1, 2,"add1");
        Property p2 = new Property("property2", 100, 3, 4,"add2");

        //fake chat
        ChatMessage m1 = new ChatMessage(new Timestamp(new Date().getTime()), 1, 1, 1, "m1 text", 123123);
        ChatMessage m2 = new ChatMessage(new Timestamp(new Date().getTime()), 1, 1, 2, "m2 text", 123124);
        ChatMessage m3 = new ChatMessage(new Timestamp(new Date().getTime()), 1, 2, 3, "m3 text", 123125);
        ChatMessage m4 = new ChatMessage(new Timestamp(new Date().getTime()), 1, 2, 4, "m4 text", 123126);


        //fake lists
        List<Property> p1List = new ArrayList<>();
        p1List.add(p1);
        List<Property> p3List = new ArrayList<>();
        p1List.add(p2);
        List<ChatMessage> c1 = new ArrayList<>();
        c1.add(m1);
        c1.add(m2);
        List<ChatMessage> c2 = new ArrayList<>();
        c2.add(m3);
        c2.add(m4);

        userMapEmail.put(u1.getEmail(), u1);
        userMapEmail.put(u2.getEmail(), u2);
        userMapEmail.put(u3.getEmail(), u3);
        userMapEmail.put(u4.getEmail(), u4);

        userMapId.put(u1.getId(), u1);
        userMapId.put(u2.getId(), u2);
        userMapId.put(u3.getId(), u3);
        userMapId.put(u4.getId(), u4);

        propertyMap.put(p1.getPropertyID(), p1);
        propertyMap.put(p2.getPropertyID(), p2);

        landlordProperties.put(u1.getId(), p1List);
        landlordProperties.put(u3.getId(), p3List);

        tenantsProperties.put(u2.getId(), p1List);
        tenantsProperties.put(u4.getId(), p3List);

        chatMessagesByPropertyID.put(p1.getPropertyID(), c1);
        chatMessagesByPropertyID.put(p2.getPropertyID(), c2);
    }

    @Test
    public void loginAttempt_ShouldReturnResponseEntityWithBodyTrue(){
        User user = userMapId.get(1);
        Mockito.when(mockService.loginAttempt(user)).
                thenReturn(new ResponseEntity<> (true, HttpStatus.OK));

        ResponseEntity response = controller.loginAttempt(user);
        boolean isValid = (boolean) response.getBody();

        Assert.assertTrue(isValid);
    }

    @Test
    public void loginAttempt_ShouldReturnResponseEntityWithBodyFalse(){
        User user = userMapId.get(1);
        Mockito.when(mockService.loginAttempt(user)).
                thenReturn(new ResponseEntity<> (false, HttpStatus.OK));

        ResponseEntity response = controller.loginAttempt(user);
        boolean isValid = (boolean) response.getBody();

        Assert.assertFalse(isValid);
    }

    @Test
    public void newUserRegistration_ShouldReturnResponseEntityWithBodyTrue(){
        User user = userMapId.get(2);
        Mockito.when(mockService.registerNewUser(user))
                .thenReturn(new ResponseEntity<> (true, HttpStatus.OK));


        ResponseEntity response1 = mockService.registerNewUser(user);

        Mockito.when(mockService.registerNewUser(null))
                .thenReturn(new ResponseEntity<> (false, HttpStatus.BAD_REQUEST));
        ResponseEntity response2 = mockService.registerNewUser(null);
        boolean isValid1 = (boolean) response1.getBody();
        boolean isValid2 = (boolean) response2.getBody();

        Assert.assertTrue(isValid1);
        Assert.assertFalse(isValid2);
    }
}
