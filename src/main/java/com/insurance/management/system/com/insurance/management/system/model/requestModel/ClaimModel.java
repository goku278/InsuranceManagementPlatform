package com.insurance.management.system.com.insurance.management.system.model.requestModel;

import javax.validation.constraints.NotBlank;

public class ClaimModel {
    @NotBlank(message = "Claim No. is mandatory")
    private String claimNumber;
    @NotBlank(message = "Description is mandatory")
    private String description;
    @NotBlank(message = "Claim Date is mandatory")
    private String claimDate;
    @NotBlank(message = "Claim Status is mandatory")
    private String claimStatus;

    public String getClaimNumber() {
        return claimNumber;
    }

    public void setClaimNumber(String claimNumber) {
        this.claimNumber = claimNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(String claimDate) {
        this.claimDate = claimDate;
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
    }
}