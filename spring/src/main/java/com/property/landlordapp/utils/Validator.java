package com.property.landlordapp.utils;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class Validator {

    public static boolean isValidEmailAddress(String email){
        boolean result = true;
        try {
            InternetAddress emailAddress = new InternetAddress(email);
            emailAddress.validate();
        } catch (AddressException e) {
            result = false;
        }
        if (!(email.contains(".") && email.contains("@"))){
            result = false;
        }
        return result;
    }

    public static boolean isValidName(String name){
        if (name == null){
            return false;
        }
        if (name.length() > 65 || name.length() < 3){
            return false;
        }
        if (!name.matches("^[a-zA-Z\\-]*$")){
            return false;
        }
        return true;
    }
}
