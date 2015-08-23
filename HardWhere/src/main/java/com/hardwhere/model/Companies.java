package com.hardwhere.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by menaka on 7/11/15.
 */
public class Companies {
    private ArrayList<Item_POJO> items = new ArrayList<Item_POJO>();
    private String CpmpanyID;
    private String company_Name;
    private String company_Address_line1;
    private String company_Address_line2;
    private String company_Address_line3;
    private String district;
    private String postcode;
    private String telephone;
    private String email;
    private String userName;
    private String password;
    private List<String> messages;
    private Person owner;

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Item_POJO> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item_POJO> items) {
        this.items = items;
    }

    public String getCpmpanyID() {
        return CpmpanyID;
    }

    public void setCpmpanyID(String companyID) {
        CpmpanyID = companyID;
    }

    public String getCompany_Name() {
        return company_Name;
    }

    public void setCompany_Name(String company_Name) {
        this.company_Name = company_Name;
    }

    public String getCompany_Address_line1() {
        return company_Address_line1;
    }

    public void setCompany_Address_line1(String company_Address_line1) {
        this.company_Address_line1 = company_Address_line1;
    }

    public String getCompany_Address_line2() {
        return company_Address_line2;
    }

    public void setCompany_Address_line2(String company_Address_line2) {
        this.company_Address_line2 = company_Address_line2;
    }

    public String getCompany_Address_line3() {
        return company_Address_line3;
    }

    public void setCompany_Address_line3(String company_Address_line3) {
        this.company_Address_line3 = company_Address_line3;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }


    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Override
    public String toString(){
        return this.company_Name + "\n"
                +this.company_Address_line1 +", \n"
                +this.company_Address_line2 + ", \n"
                +this.company_Address_line3 + ", \n";
    }

}
