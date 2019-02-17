package com.training.model;

public class UserAddress {
    private Integer index;
    private String city;
    private String street;
    private String houseNumber;
    private String flatNumber;
    private String fullAddress;
    private boolean useThisAddress;

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public boolean isUseThisAddress() {
        return useThisAddress;
    }

    public void setUseThisAddress(boolean useThisAddress) {
        this.useThisAddress = useThisAddress;
    }
}