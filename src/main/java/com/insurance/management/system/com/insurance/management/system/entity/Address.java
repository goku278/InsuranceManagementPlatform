package com.insurance.management.system.com.insurance.management.system.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
//@Table(name = "address")
public class Address {
    @Id
    @SequenceGenerator(name="test_seq", sequenceName="test_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "test_seq")
    private Long addressId;
    private String street;
    private String city;
    private String district;
    private String zipCode;
    private String state;
    private String country;

    /*@OneToOne(mappedBy = "address")
    private Client client;*/

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    @JsonBackReference
    private Client client;

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", client=" + client +
                '}';
    }
}