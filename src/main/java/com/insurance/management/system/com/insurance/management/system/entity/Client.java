package com.insurance.management.system.com.insurance.management.system.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
//@Table(name = "client")
public class Client {
    @Id
    @SequenceGenerator(name="test_seq", sequenceName="test_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "test_seq")
    private Long clientId;
    private String name;
    private String dob;
    @OneToOne(mappedBy = "client", cascade = CascadeType.MERGE)
    @JsonManagedReference
    private Address address;

    @OneToOne(mappedBy = "client", cascade = CascadeType.MERGE)
    @JsonManagedReference
    private ContactInformation contactInformation;

    @OneToOne(mappedBy = "client", cascade = CascadeType.MERGE)
    @JsonManagedReference
    private Insurance insurance;


    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ContactInformation getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(ContactInformation contactInformation) {
        this.contactInformation = contactInformation;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }
}
