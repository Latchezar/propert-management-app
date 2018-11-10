package com.property.landlordapp;

import com.property.landlordapp.models.ChatMessage;
import com.property.landlordapp.models.Property;
import com.property.landlordapp.models.User;
import com.property.landlordapp.repositories.RepositoryBase;
import com.property.landlordapp.services.UserService;
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
public class UserServiceTests {

    private ModelsInitialization models = new ModelsInitialization();

    @Mock
    RepositoryBase mockRepository;

    @InjectMocks
    UserService service;


    @Test
    public void loginAttempt_ShouldReturnResponseEntityWithBodyTrue(){
        User user = models.userMapId.get(1);
        Mockito.when(mockRepository.loginAttempt(user)).
                thenReturn(new ResponseEntity<>(true, HttpStatus.OK));

        ResponseEntity response = service.loginAttempt(user);
        boolean isValid = (boolean) response.getBody();

        Assert.assertTrue(isValid);
    }

    @Test
    public void loginAttempt_ShouldReturnResponseEntityWithBodyFalse(){
        User user = models.userMapId.get(1);
        Mockito.when(mockRepository.loginAttempt(user)).
                thenReturn(new ResponseEntity<> (false, HttpStatus.OK));

        ResponseEntity response = service.loginAttempt(user);
        boolean isValid = (boolean) response.getBody();

        Assert.assertFalse(isValid);
    }

    @Test
    public void newUserRegistration_ShouldReturnResponseEntityWithBodyTrue(){
        User user = models.userMapId.get(2);
        Mockito.when(mockRepository.registerNewUser(user))
                .thenReturn(new ResponseEntity<> (true, HttpStatus.OK));


        ResponseEntity response1 = service.registerNewUser(user);

        Mockito.when(mockRepository.registerNewUser(null))
                .thenReturn(new ResponseEntity<> (false, HttpStatus.BAD_REQUEST));
        ResponseEntity response2 = service.registerNewUser(null);
        boolean isValid1 = (boolean) response1.getBody();
        boolean isValid2 = (boolean) response2.getBody();

        Assert.assertTrue(isValid1);
        Assert.assertFalse(isValid2);
    }

    @Test
    public void newPropertyCreate_ShouldReturnTrueIfNotNull(){
        Property property = models.propertyMap.get(1);
        Mockito.when(mockRepository.createNewProperty(property))
                .thenReturn(new ResponseEntity<>(true, HttpStatus.OK));
        boolean isValid = (boolean) service.createNewProperty(property).getBody();
        Assert.assertTrue(isValid);
        Mockito.when(mockRepository.createNewProperty(null))
                .thenReturn(new ResponseEntity<>(false, HttpStatus.BAD_REQUEST));
        isValid = (boolean) service.createNewProperty(null).getBody();
        Assert.assertFalse(isValid);
    }

    @Test
    public void getPropertiesByLandlordID_ShouldReturnListIfNotNull(){
        Mockito.when(mockRepository.getPropertiesByLandlordID(1))
                .thenReturn(new ResponseEntity<> (models.landlordProperties.get(1), HttpStatus.OK));
        List<Property> list = (List<Property>) service.getPropertiesByLandlordID(1).getBody();
        Assert.assertEquals(list, models.landlordProperties.get(1));
    }

    @Test
    public void getPropertiesByTenantID_ShouldReturnList(){
        Mockito.when(mockRepository.getPropertiesByTenantID(2))
                .thenReturn(new ResponseEntity<> (models.tenantsProperties.get(2), HttpStatus.OK));
        List<Property> list = (List<Property>) service.getPropertiesByTenantID(2).getBody();
        Assert.assertEquals(list, models.tenantsProperties.get(2));
    }

    @Test
    public void getUserById_ShouldReturnUserIfExists(){
        Mockito.when(mockRepository.getUserByID(3))
                .thenReturn(new ResponseEntity<>(models.userMapId.get(3), HttpStatus.OK));
        User user = (User) service.getUserByID(3).getBody();
        Assert.assertEquals(user, models.userMapId.get(3));
        Mockito.when(mockRepository.getUserByID(7))
                .thenReturn(new ResponseEntity<> (null, HttpStatus.NOT_FOUND));
        user = (User) service.getUserByID(7).getBody();
        Assert.assertEquals(null, user);
    }

    @Test
    public void getChatMessagesByPropertyID_ShouldReturnListIfPropertyExists(){
        Mockito.when(mockRepository.getChatMessagesByPropertyID(1))
                .thenReturn(new ResponseEntity<> (models.chatMessagesByPropertyID.get(1), HttpStatus.OK));
        List list = (List) service.getChatMessagesByPropertyID(1).getBody();
        Assert.assertEquals(models.chatMessagesByPropertyID.get(1), list);
        Mockito.when(mockRepository.getChatMessagesByPropertyID(10))
                .thenReturn(new ResponseEntity<> (null, HttpStatus.NOT_FOUND));
        list = (List) service.getChatMessagesByPropertyID(10).getBody();
        Assert.assertNull(list);
    }

    @Test
    public void sendMessage_ShouldReturnSuccessIfNotNull() {
        List<ChatMessage> messages = models.chatMessagesByPropertyID.get(1);
        Mockito.when(mockRepository.sendMessage(messages.get(1)))
                .thenReturn(new ResponseEntity<> ("Success", HttpStatus.OK));
        String response = service.sendMessage(messages.get(1)).getBody().toString();
        Assert.assertEquals("Success", response);
        Mockito.when(mockRepository.sendMessage(null))
                .thenReturn(new ResponseEntity<> ("Fail", HttpStatus.BAD_REQUEST));
        response = service.sendMessage(null).getBody().toString();
        Assert.assertEquals("Fail", response);
    }

    @Test
    public void getNewMessages_ShouldReturnMessages(){
        Mockito.when(mockRepository.getNewMessages(1, 400))
                .thenReturn(new ResponseEntity<> (models.chatMessagesByPropertyID.get(1), HttpStatus.OK));
        List list = (List) service.getNewMessages(1, 400).getBody();
        Assert.assertEquals(models.chatMessagesByPropertyID.get(1), list);
        Mockito.when(mockRepository.getNewMessages(8, 500))
                .thenReturn(new ResponseEntity<> (models.chatMessagesByPropertyID.get(8), HttpStatus.OK));
        list = (List) service.getNewMessages(8, 500).getBody();
        Assert.assertNull(list);
    }
}
