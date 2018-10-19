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

    public static boolean isValidType(String type){
        boolean result = false;
        if (type != null && (type.equals("1") || type.equals("2"))){
            result = true;
        }
        return result;
    }

    public static boolean isValidPassword(String password){
        if (password != null && password.length() < 65 && password.length() > 6) {
            return true;
        }
        return false;
    }
}
