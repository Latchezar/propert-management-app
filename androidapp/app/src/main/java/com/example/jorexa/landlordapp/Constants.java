package com.example.jorexa.landlordapp;

public class Constants {
    public static final String BASE_SERVER_URL
            //= "http://echo.jsontest.com/email/value/password/two";
    = "http://78.90.64.155:8080/api";

    //Wrong registration texts
    public static final String WRONG_FIRST_NAME = "The First Name should be between 3 and 64 characters!";
    public static final String WRONG_LAST_NAME = "The Last Name should be between 3 and 64 characters!";
    public static final String WRONG_TYPE = "Please select account type = Landlord or Tenant!";
    public static final String WRONG_PASSWORD = "The Password should be between 3 and 64 characters!";
    public static final String WRONG_CONFIRM_PASSWORD = "The two passwords don't match";
    public static final String WRONG_EMAIL = "Please Enter a valid email!";
    public static final String WRONG_PROPERTY_NAME = "Property Name should be between 3 and 64 characters";
    public static final String WRONG_PROPERTY_ADDRESS = "Property Address should be between 3 and 255 characters";
    public static final String WRONG_PROPERTY_PRICE = "Property Price should be a valid number higher than 0";
    public static final String WRONG_LANDLORDID = "Application Error! Please restart the application!";
}
