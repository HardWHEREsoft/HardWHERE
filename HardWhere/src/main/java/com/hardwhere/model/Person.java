package com.hardwhere.model;

import java.util.List;

/**
 * Created by menaka on 8/24/15.
 */

/*
* Person class: the shop owner who can have one or more shops
* */
public class Person {

    private String name;
    private String address1;
    private String address2;
    private String address3;
    private String telephone;
    private String email;
    private String nic;
    private String userName;
    private String password;
    private String poastalCode;
    private String district;
    private List<Companies> companies;

    public void setName(String name) {
        this.name = name;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public void setCompanies(List<Companies> companies) {
        this.companies = companies;
    }

    public void setPoastalCode(String poastalCode) {
        this.poastalCode = poastalCode;
    }

    public void setDistrict(String district) {
        this.district = district;
    }


    //Getters
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }
}