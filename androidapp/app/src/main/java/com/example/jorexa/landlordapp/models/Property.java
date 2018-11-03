package com.example.jorexa.landlordapp.models;

public class Property {
    public int PropertyID, PropertyPrice, LandlordID, TenantID;
    public String PropertyName;

    public Property() {
    }

    public Property(int propertyID, int propertyPrice, int landlordID, int tenantID, String propertyName) {
        PropertyID = propertyID;
        PropertyPrice = propertyPrice;
        LandlordID = landlordID;
        TenantID = tenantID;
        PropertyName = propertyName;
    }

    public int getPropertyID() {
        return PropertyID;
    }

    public void setPropertyID(int propertyID) {
        PropertyID = propertyID;
    }

    public int getPropertyPrice() {
        return PropertyPrice;
    }

    public void setPropertyPrice(int propertyPrice) {
        PropertyPrice = propertyPrice;
    }

    public int getLandlordID() {
        return LandlordID;
    }

    public void setLandlordID(int landlordID) {
        LandlordID = landlordID;
    }

    public int getTenantID() {
        return TenantID;
    }

    public void setTenantID(int tenantID) {
        TenantID = tenantID;
    }

    public String getPropertyName() {
        return PropertyName;
    }

    public void setPropertyName(String propertyName) {
        PropertyName = propertyName;
    }
}
