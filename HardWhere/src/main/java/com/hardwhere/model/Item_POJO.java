package com.hardwhere.model;

/**
 * Created by Ehelepola on 23/08/2015.
 */
public class Item_POJO {

    private String item_ID;
    private String item_Name;
    private String item_Description;
    private String item_Price;
    private String item_Image;
    private String user;
    private String company_id;
    private String item_Type;
    private String item_Model;
    private String item_Brand;
    private String item_Size;
    private String item_Thickness;

    public String getItem_Model() {
        return item_Model;
    }

    public void setItem_Model(String item_Model) {
        this.item_Model = item_Model;
    }

    public String getItem_Brand() {
        return item_Brand;
    }

    public void setItem_Brand(String item_Brand) {
        this.item_Brand= item_Brand;
    }

    public String getItem_Size() {
        return item_Size;
    }

    public void setItem_Size(String item_Size) {
        this.item_Size = item_Size;
    }

    public String getItem_Thickness() {
        return item_Thickness;
    }

    public void setItem_Thickness(String item_Thickness) {
        this.item_Thickness = item_Thickness;
    }

    public String getItem_Type() {
        return item_Type;
    }

    public void setItem_Type(String item_Type) {
        this.item_Type = item_Type;
    }

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getItem_ID() {
        return item_ID;
    }

    public void setItem_ID(String item_ID) {
        this.item_ID = item_ID;
    }

    public String getItem_Name() {
        return item_Name;
    }

    public void setItem_Name(String item_Name) {
        this.item_Name = item_Name;
    }

    public String getItem_Description() {
        return item_Description;
    }

    public void setItem_Description(String item_Description) {
        this.item_Description = item_Description;
    }

    public String getItem_Price() {
        return item_Price;
    }

    public void setItem_Price(String item_Price) {
        this.item_Price = item_Price;
    }

    public String getItem_Image() {
        return item_Image;
    }

    public void setItem_Image(String item_Image) {
        this.item_Image = item_Image;
    }

    public String toString(){
        return "Item Name: " + this.getItem_Name()+
                "Item Description: " + this.getItem_Description()+
                "Price: " + this.getItem_Price();
    }

}