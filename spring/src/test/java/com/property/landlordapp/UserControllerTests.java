package com.property.landlordapp;

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

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTests {

    private ModelsInitialization data = new ModelsInitialization();

    @Mock
    ServiceBase mockService;

    @InjectMocks
    UserController controller;


    @Test
    public void loginAttempt_ShouldReturnResponseEntityWithBodyTrue(){
        User user = data.userMapId.get(1);
        Mockito.when(mockService.loginAttempt(user)).
                thenReturn(new ResponseEntity<> (true, HttpStatus.OK));

        ResponseEntity response = controller.loginAttempt(user);
        boolean isValid = (boolean) response.getBody();

        Assert.assertTrue(isValid);
    }

    @Test
    public void loginAttempt_ShouldReturnResponseEntityWithBodyFalse(){
        User user = data.userMapId.get(1);
        Mockito.when(mockService.loginAttempt(user)).
                thenReturn(new ResponseEntity<> (false, HttpStatus.OK));

        ResponseEntity response = controller.loginAttempt(user);
        boolean isValid = (boolean) response.getBody();

        Assert.assertFalse(isValid);
    }

    @Test
    public void newUserRegistration_ShouldReturnResponseEntityWithBodyTrue(){
        User user = data.userMapId.get(2);
        Mockito.when(mockService.registerNewUser(user))
                .thenReturn(new ResponseEntity<> (true, HttpStatus.OK));


        ResponseEntity response1 = controller.registerNewUser(user);

        Mockito.when(mockService.registerNewUser(null))
                .thenReturn(new ResponseEntity<> (false, HttpStatus.BAD_REQUEST));
        ResponseEntity response2 = controller.registerNewUser(null);
        boolean isValid1 = (boolean) response1.getBody();
        boolean isValid2 = (boolean) response2.getBody();

        Assert.assertTrue(isValid1);
        Assert.assertFalse(isValid2);
    }

    @Test
    public void newPropertyCreate_ShouldReturnTrueIfNotNull(){
        Property property = data.propertyMap.get(1);
        Mockito.when(mockService.createNewProperty(property))
                .thenReturn(new ResponseEntity<>(true, HttpStatus.OK));
        boolean isValid = (boolean) controller.createNewProperty(property).getBody();
        Assert.assertTrue(isValid);
        Mockito.when(mockService.createNewProperty(null))
                .thenReturn(new ResponseEntity<>(false, HttpStatus.BAD_REQUEST));
        isValid = (boolean) controller.createNewProperty(null).getBody();
        Assert.assertFalse(isValid);
    }

    @Test
    public void getPropertiesByLandlordID_ShouldReturnListIfNotNull(){
        Mockito.when(mockService.getPropertiesByLandlordID(1))
                .thenReturn(new ResponseEntity<> (data.landlordProperties.get(1), HttpStatus.OK));
        List<Property> list = (List<Property>) controller.getPropertiesByLandlordID(1).getBody();
        Assert.assertEquals(list, data.landlordProperties.get(1));
    }

    @Test
    public void getPropertiesByTenantID_ShouldReturnList(){
        Mockito.when(mockService.getPropertiesByTenantID(2))
                .thenReturn(new ResponseEntity<> (data.tenantsProperties.get(2), HttpStatus.OK));
        List<Property> list = (List<Property>) controller.getPropertiesByTenantID(2).getBody();
        Assert.assertEquals(list, data.tenantsProperties.get(2));
    }

    @Test
    public void getUserById_ShouldReturnUserIfExists(){
        Mockito.when(mockService.getUserByID(3))
                .thenReturn(new ResponseEntity<>(data.userMapId.get(3), HttpStatus.OK));
        User user = (User) controller.getUserByID(3).getBody();
        Assert.assertEquals(user, data.userMapId.get(3));
        Mockito.when(mockService.getUserByID(7))
                .thenReturn(new ResponseEntity<> (null, HttpStatus.NOT_FOUND));
        user = (User) controller.getUserByID(7).getBody();
        Assert.assertEquals(null, user);
    }

    @Test
    public void getChatMessagesByPropertyID_ShouldReturnListIfPropertyExists(){
        Mockito.when(mockService.getChatMessagesByPropertyID(1))
                .thenReturn(new ResponseEntity<> (data.chatMessagesByPropertyID.get(1), HttpStatus.OK));
        List list = (List) controller.getChatMessagesByPropertyID(1).getBody();
        Assert.assertEquals(data.chatMessagesByPropertyID.get(1), list);
        Mockito.when(mockService.getChatMessagesByPropertyID(10))
                .thenReturn(new ResponseEntity<> (null, HttpStatus.NOT_FOUND));
        list = (List) controller.getChatMessagesByPropertyID(10).getBody();
        Assert.assertNull(list);
    }

    @Test
    public void sendMessage_ShouldReturnSuccessIfNotNull() {
        List<ChatMessage> messages = data.chatMessagesByPropertyID.get(1);
        Mockito.when(mockService.sendMessage(messages.get(1)))
                .thenReturn(new ResponseEntity<> ("Success", HttpStatus.OK));
        String response = controller.sendMessage(messages.get(1)).getBody().toString();
        Assert.assertEquals("Success", response);
        Mockito.when(mockService.sendMessage(null))
                .thenReturn(new ResponseEntity<> ("Fail", HttpStatus.BAD_REQUEST));
        response = controller.sendMessage(null).getBody().toString();
        Assert.assertEquals("Fail", response);
    }

    @Test
    public void getNewMessages_ShouldReturnMessages(){
        Mockito.when(mockService.getNewMessages(1, 400))
                .thenReturn(new ResponseEntity<> (data.chatMessagesByPropertyID.get(1), HttpStatus.OK));
        List list = (List) controller.getNewMessages(1, 400).getBody();
        Assert.assertEquals(data.chatMessagesByPropertyID.get(1), list);
        Mockito.when(mockService.getNewMessages(8, 500))
                .thenReturn(new ResponseEntity<> (data.chatMessagesByPropertyID.get(8), HttpStatus.OK));
        list = (List) controller.getNewMessages(8, 500).getBody();
        Assert.assertNull(list);
    }

}
