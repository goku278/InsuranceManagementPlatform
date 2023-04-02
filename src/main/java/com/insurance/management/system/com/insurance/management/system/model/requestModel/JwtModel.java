package com.insurance.management.system.com.insurance.management.system.model.requestModel;

public class JwtModel {
    private String name;
    private String password;

    public JwtModel() {
    }

    public JwtModel(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "JwtModel{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
