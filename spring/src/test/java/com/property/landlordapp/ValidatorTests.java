package com.property.landlordapp;

import com.property.landlordapp.utils.Validator;
import org.junit.Assert;
import org.junit.Test;

public class ValidatorTests {

    @Test
    public void validName1_ShouldReturnTrue() {
        String validName = "Ivan";
        boolean isValid = Validator.isValidName(validName);
        Assert.assertTrue(isValid);
    }
    @Test
    public void validName2_ShouldReturnTrue() {
        String validName = "Ivan-Petkan";
        boolean isValid = Validator.isValidName(validName);
        Assert.assertTrue(isValid);
    }
    @Test
    public void invalidName1_ShoudReturnFalse() {
        String invalidName = "Ivan123";
        boolean isValid = Validator.isValidName(invalidName);
        Assert.assertFalse(isValid);
    }
    @Test
    public void invalidName2_ShouldReturnFalse() {
        String invalidName = "Ivan - Petkan";
        boolean isValid = Validator.isValidName(invalidName);
        Assert.assertFalse(isValid);
    }
    @Test
    public void tooLongName_ShouldReturnFalse() {
        String invalidName = "IvanPetkanIvanPetkanIvanPetkanIvanPetkanIvanPetkanIvanPetkanIvanPetkanIvanPetkan";
        boolean isValid = Validator.isValidName(invalidName);
        Assert.assertFalse(isValid);
    }
    @Test
    public void tooShortName_ShouldReturnFalse() {
        String invalidName = "Iv";
        boolean isValid = Validator.isValidName(invalidName);
        Assert.assertFalse(isValid);
    }
    @Test
    public void nullName_ShouldReturnFalse() {
        String invalidName = null;
        boolean isValid = Validator.isValidName(invalidName);
        Assert.assertFalse(isValid);
    }

    @Test
    public void validEmail1_ShouldReturnTrue(){
        String validEmail = "ivan.ivanov@gmail.com";
        boolean isValid = Validator.isValidEmailAddress(validEmail);
        Assert.assertTrue(isValid);
    }
    @Test
    public void validEmail2_ShouldReturnTrue(){
        String validEmail = "ivan.ivanov.ivanov_ivanov@gmail.com";
        boolean isValid = Validator.isValidEmailAddress(validEmail);
        Assert.assertTrue(isValid);
    }
    @Test
    public void validEmail3_ShouldReturnTrue(){
        String validEmail = "ivanivanov@gmail.com";
        boolean isValid = Validator.isValidEmailAddress(validEmail);
        Assert.assertTrue(isValid);
    }

    @Test
    public void inValidEmail1_ShouldReturnFalse(){
        String invalidEmail = "@gmail.com";
        boolean isValid = Validator.isValidEmailAddress(invalidEmail);
        Assert.assertFalse(isValid);
    }
    @Test
    public void inValidEmail2_ShouldReturnFalse(){
        String invalidEmail = "ivangmail.com";
        boolean isValid = Validator.isValidEmailAddress(invalidEmail);
        Assert.assertFalse(isValid);
    }
    @Test
    public void inValidEmail3_ShouldReturnFalse(){
        String invalidEmail = "ivan@gmail";
        boolean isValid = Validator.isValidEmailAddress(invalidEmail);
        Assert.assertFalse(isValid);
    }
    @Test
    public void inValidEmail4_ShouldReturnFalse(){
        String invalidEmail = "ivan@gmail";
        boolean isValid = Validator.isValidEmailAddress(invalidEmail);
        Assert.assertFalse(isValid);
    }
    @Test
    public void inValidEmail5_ShouldReturnFalse(){
        String invalidEmail = "ivan@.com";
        boolean isValid = Validator.isValidEmailAddress(invalidEmail);
        Assert.assertFalse(isValid);
    }

    @Test
    public void validType1_ShouldReturnTrue(){
        int type = 1;
        boolean isValid = Validator.isValidType(type);
        Assert.assertTrue(isValid);
    }
    @Test
    public void validType2_ShouldReturnTrue(){
        int type = 2;
        boolean isValid = Validator.isValidType(type);
        Assert.assertTrue(isValid);
    }
    @Test
    public void invalidType1_ShouldReturnTrue(){
        boolean isValid = Validator.isValidType(0);
        Assert.assertFalse(isValid);
    }
    @Test
    public void invalidType2_ShouldReturnTrue(){
        int type = 3;
        boolean isValid = Validator.isValidType(type);
        Assert.assertFalse(isValid);
    }

    @Test
    public void validPassword_ShouldReturnTrue(){
        String password = "somepassword123";
        boolean isValid = Validator.isValidPassword(password);
        Assert.assertTrue(isValid);
    }

    @Test
    public void longPassword_ShouldReturnFalse(){
        String password = "someveryveryverylonglonglongpassssssssworddddddddddddddddddddddddddd";
        boolean isValid = Validator.isValidPassword(password);
        Assert.assertFalse(isValid);
    }
    @Test
    public void shortPassword_ShouldReturnFalse(){
        String password = "short";
        boolean isValid = Validator.isValidPassword(password);
        Assert.assertFalse(isValid);
    }
    @Test
    public void nullPassword_ShouldReturnFalse(){
        String password = null;
        boolean isValid = Validator.isValidPassword(password);
        Assert.assertFalse(isValid);
    }
}
