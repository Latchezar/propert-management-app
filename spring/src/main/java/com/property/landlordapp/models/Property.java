package com.property.landlordapp.models;

import javax.persistence.*;

@Entity
@Table(name = "Properties", uniqueConstraints = {
        @UniqueConstraint(columnNames = "PropertyID")
})
public class Property {
    public Property(int propertyID, String propertyName, int propertyPrice, int landlordID, int tenantID, String address) {
        this.propertyID = propertyID;
        this.propertyName = propertyName;
        this.propertyPrice = propertyPrice;
        this.landlordID = landlordID;
        this.tenantID = tenantID;
        this.address = address;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PropertyID")
    private int propertyID;

    @Column(name = "PropertyName")
    private String propertyName;

    @Column(name = "PropertyPrice")
    private int propertyPrice;

    @Column(name = "LandlordID")
    private int landlordID;

    @Column(name = "TenantID")
    private int tenantID;

    @Column(name = "Address")
    private String address;

    public Property() {
    }

    public int getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(int propertyID) {
        this.propertyID = propertyID;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
