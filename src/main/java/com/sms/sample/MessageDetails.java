package com.sms.sample;

import com.mongodb.BasicDBList;

/**
 * Created by Ehelepola on 08/07/2015.
 */
public class MessageDetails {

    private String name;
    private String address;
    private BasicDBList messageList;
    private String appID;

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getAppID(){
        return appID;
    }
    public void setAppID(String appID){
        this.appID=appID;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public BasicDBList getMessageList(){
        return messageList;
    }
    public void setMessageList(BasicDBList messageList){
        this.messageList=messageList;
    }

}
