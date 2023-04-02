package com.insurance.management.system.com.insurance.management.system.model.requestModel;

import javax.validation.constraints.NotBlank;

public class ClientModel {
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Date of Birth is mandatory")
    private String dob;

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
}
