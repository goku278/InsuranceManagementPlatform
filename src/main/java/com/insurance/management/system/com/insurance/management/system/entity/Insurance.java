package com.insurance.management.system.com.insurance.management.system.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
//@Table(name = "insurance")
public class Insurance {
    @Id
    @SequenceGenerator(name="test_seq", sequenceName="test_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "test_seq")
    private Long insuranceId;
    private String policyNumber;
    private String policyType;
    private String coverageAmount;
    private String premium;
    private String startDate;
    private String endDate;

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    @JsonBackReference
    private Client client;

    @OneToOne(mappedBy = "insurance", cascade = CascadeType.MERGE)
    @JsonManagedReference
    private Claim claim;

    public Long getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(Long insuranceId) {
        this.insuranceId = insuranceId;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public String getCoverageAmount() {
        return coverageAmount;
    }

    public void setCoverageAmount(String coverageAmount) {
        this.coverageAmount = coverageAmount;
    }

    public String getPremium() {
        return premium;
    }

    public void setPremium(String premium) {
        this.premium = premium;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Claim getClaim() {
        return claim;
    }

    public void setClaim(Claim claim) {
        this.claim = claim;
    }
}
