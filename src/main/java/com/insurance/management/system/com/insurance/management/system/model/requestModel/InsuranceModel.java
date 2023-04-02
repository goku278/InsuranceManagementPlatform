package com.insurance.management.system.com.insurance.management.system.model.requestModel;

import javax.validation.constraints.NotBlank;

public class InsuranceModel {
    @NotBlank(message = "Policy No. is mandatory")
    private String policyNumber;
    @NotBlank(message = "Policy Type is mandatory")
    private String policyType;
    @NotBlank(message = "Coverage Amount is mandatory")
    private String coverageAmount;
    @NotBlank(message = "Premium is mandatory")
    private String premium;
    @NotBlank(message = "Start Date is mandatory")
    private String startDate;
    @NotBlank(message = "End Date is mandatory")
    private String endDate;

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
}
