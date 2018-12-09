package com.poto.anlab.model;

public class Customer {
    private int id;
    private String name;
    private String company;
    private String mobilePhone;
    private String deskPhone;
    private String email;

    public Customer() {
    }

    public Customer(int id, String name, String company, String mobilePhone, String deskPhone, String email) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.mobilePhone = mobilePhone;
        this.deskPhone = deskPhone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getDeskPhone() {
        return deskPhone;
    }

    public void setDeskPhone(String deskPhone) {
        this.deskPhone = deskPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
