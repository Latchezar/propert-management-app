package com.example.jorexa.landlordapp.models;

import java.io.Serializable;

public class Property implements Serializable {
    public int propertyID, propertyPrice, landlordID, tenantID;
    public String propertyName;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String address;

    public Property() {
    }

    public Property(int propertyID, int propertyPrice, int landlordID, int tenantID, String propertyName, String address) {
        this.propertyID = propertyID;
        this.propertyPrice = propertyPrice;
        this.landlordID = landlordID;
        this.tenantID = tenantID;
        this.propertyName = propertyName;
        this.address = address;
    }

    public int getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(int propertyID) {
        this.propertyID = propertyID;
    }

    public int getPropertyPrice() {
        return propertyPrice;
    }

    public void setPropertyPrice(int propertyPrice) {
        this.propertyPrice = propertyPrice;
    }

    public int getLandlordID() {
        return landlordID;
    }

    public void setLandlordID(int landlordID) {
        this.landlordID = landlordID;
    }

    public int getTenantID() {
        return tenantID;
    }

    public void setTenantID(int tenantID) {
        this.tenantID = tenantID;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }
}
