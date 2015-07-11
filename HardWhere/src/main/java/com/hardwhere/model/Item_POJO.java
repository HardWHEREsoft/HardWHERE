package com.hardwhere.model;

/**
 * Created by menaka on 7/11/15.
 */
/*
* This is the main structure of the item
* An Item has : ID, Name, Price, Description, Image.
* */

public class Item_POJO {

    private double item_ID;
    private String item_Name;
    private String item_Description;
    private String item_Price;
    private String item_Image;
    private String user;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public double getItem_ID() {
        return item_ID;
    }

    public void setItem_ID(double item_ID) {
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
}