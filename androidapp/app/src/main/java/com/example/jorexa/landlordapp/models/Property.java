package com.example.jorexa.landlordapp.models;

public class Property {
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
        propertyID = propertyID;
    }

    public int getPropertyPrice() {
        return propertyPrice;
    }

    public void setPropertyPrice(int propertyPrice) {
        propertyPrice = propertyPrice;
    }

    public int getLandlordID() {
        return landlordID;
    }

    public void setLandlordID(int landlordID) {
        landlordID = landlordID;
    }

    public int getTenantID() {
        return tenantID;
    }

    public void setTenantID(int tenantID) {
        tenantID = tenantID;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        propertyName = propertyName;
    }
}
