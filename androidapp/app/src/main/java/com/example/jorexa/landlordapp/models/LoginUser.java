package com.example.jorexa.landlordapp.models;

public class LoginUser {
        //"id": 1,
        //"firstName": "Latchezar",
        //"lastName": "Nikolov",
        //"userType": "1",
        //"email": "latcho.nikolov@gmail.com"

    public int id;
    public String firstName;
    public String lastName;
    public int userType;
    public String email;

    public LoginUser() {

    }

    public LoginUser(int id, String firstName, String lastName, int userType, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userType = userType;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
