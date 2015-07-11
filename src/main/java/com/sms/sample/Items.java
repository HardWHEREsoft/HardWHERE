package com.sms.sample;

/**
 * Created by Ehelepola on 09/07/2015.
 */
public class Items {


    private String name;
    private String description;
    private String image;
    private String shopName;
    private String price;
    private String contact;
    private String district;

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description=description;
    }

    public String getImage(){
        return this.image;
    }
    public void setImage(String image){
        this.image=image;
    }

    public String getShopName(){
        return this.shopName;
    }
    public void setShopName(String shopName){
        this.shopName=shopName;
    }

    public String getPrice(){
        return this.price;
    }
    public void setPrice(String price){
        this.price=price;
    }

    public String getContact(){
        return this.contact;
    }
    public void setContact(String contact){
        this.contact=contact;
    }

    public String getDistrict(){
        return this.district;
    }
    public void setDistrict(String district){
        this.district=district;
    }



}
