package com.hardwhere.controller.javaclasses;

import com.google.gson.Gson;
import com.hardwhere.model.Companies;
import com.hardwhere.model.Item_POJO;
import com.hardwhere.model.Person;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * Created by menaka on 7/11/15.
 */
public class ConvertToPOJO {

    private BasicDBObject object;

    public ConvertToPOJO(BasicDBObject obj){
            this.object = obj;
    }

    public Item_POJO convert(){
        String json = this.object.toString();
        Gson gson = new Gson();

        Item_POJO pojo = gson.fromJson(json, Item_POJO.class);

        return pojo;
    }

    public Companies convertCom(){
        String json = this.object.toString();
        Gson gson = new Gson();
        Companies comp = gson.fromJson(json, Companies.class);
        return comp;
    }

    public Person convertPerson(){
        String json = this.object.toString();
        Gson gson = new Gson();
        Person person = gson.fromJson(json, Person.class);
        return person;
    }


}
