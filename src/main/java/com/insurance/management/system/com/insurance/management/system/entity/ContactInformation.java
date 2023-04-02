package com.insurance.management.system.com.insurance.management.system.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
//@Table(name = "contact_information")
public class ContactInformation {
    @Id
    @SequenceGenerator(name="test_seq", sequenceName="test_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "test_seq")
    private Long contactInfoId;
    private String phNo;
    private String email;

    /*@OneToOne(mappedBy = "contactInfo")
    private Client client;*/

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    @JsonBackReference
    private Client client;

    public Long getContactInfoId() {
        return contactInfoId;
    }

    public void setContactInfoId(Long contactInfoId) {
        this.contactInfoId = contactInfoId;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "ContactInformation{" +
                "contactInfoId=" + contactInfoId +
                ", phNo='" + phNo + '\'' +
                ", email='" + email + '\'' +
                ", client=" + client +
                '}';
    }
}
