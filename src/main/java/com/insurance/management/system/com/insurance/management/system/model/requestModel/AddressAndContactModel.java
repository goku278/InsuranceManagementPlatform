package com.insurance.management.system.com.insurance.management.system.model.requestModel;

import javax.validation.constraints.NotBlank;

public class AddressAndContactModel {
    // Address

    @NotBlank(message = "Street is mandatory")
    private String street;
    @NotBlank(message = "City is mandatory")
    private String city;
    @NotBlank(message = "District is mandatory")
    private String district;
    @NotBlank(message = "Zipcode is mandatory")
    private String zipCode;
    @NotBlank(message = "State is mandatory")
    private String state;
    @NotBlank(message = "Country is mandatory")
    private String country;

    // Contact Information
    @NotBlank(message = "Phone No. is mandatory")
    private String phNo;
    @NotBlank(message = "Email is mandatory")
    private String email;

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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhNo() {
        return phNo;
    }

    public void setPhNo(String phNo) {
        this.phNo = phNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
